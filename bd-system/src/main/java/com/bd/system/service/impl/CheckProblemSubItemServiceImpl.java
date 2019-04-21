package com.bd.system.service.impl;

import com.bd.common.core.text.Convert;
import com.bd.system.domain.CheckProblemConfig;
import com.bd.system.domain.CheckProblemItem;
import com.bd.system.domain.CheckProblemSubItem;
import com.bd.system.mapper.CheckProblemConfigMapper;
import com.bd.system.mapper.CheckProblemItemMapper;
import com.bd.system.mapper.CheckProblemSubItemMapper;
import com.bd.system.mapper.CheckRecordMapper;
import com.bd.system.service.ICheckProblemSubItemService;
import com.bd.system.vo.CheckProblemItemVO;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 巡店明细问题 服务层实现
 * 
 * @author luxuewei
 * @date 2019-04-20
 */
@Service
public class CheckProblemSubItemServiceImpl implements ICheckProblemSubItemService 
{
	@Resource
	private CheckProblemSubItemMapper checkProblemSubItemMapper;
	@Resource
	private CheckProblemItemMapper checkProblemItemMapper;
	@Resource
	private CheckProblemConfigMapper checkProblemConfigMapper;
	@Resource
	private CheckRecordMapper checkRecordMapper;

	/**
     * 查询巡店明细问题信息
     * 
     * @param problemSubItemId 巡店明细问题ID
     * @return 巡店明细问题信息
     */
    @Override
	public CheckProblemSubItem selectCheckProblemSubItemById(Integer problemSubItemId)
	{
	    return checkProblemSubItemMapper.selectCheckProblemSubItemById(problemSubItemId);
	}
	
	/**
     * 查询巡店明细问题列表
     * 
     * @param checkProblemSubItem 巡店明细问题信息
     * @return 巡店明细问题集合
     */
	@Override
	public List<CheckProblemSubItem> selectCheckProblemSubItemList(CheckProblemSubItem checkProblemSubItem)
	{
	    return checkProblemSubItemMapper.selectCheckProblemSubItemList(checkProblemSubItem);
	}
	
    /**
     * 新增巡店明细问题
     * 
     * @param checkProblemSubItem 巡店明细问题信息
     * @return 结果
     */
	@Override
	public int insertCheckProblemSubItem(CheckProblemSubItem checkProblemSubItem)
	{
	    return checkProblemSubItemMapper.insertCheckProblemSubItem(checkProblemSubItem);
	}
	
	/**
     * 修改巡店明细问题
     * 
     * @param checkProblemSubItem 巡店明细问题信息
     * @return 结果
     */
	@Override
	public int updateCheckProblemSubItem(CheckProblemSubItem checkProblemSubItem)
	{
	    return checkProblemSubItemMapper.updateCheckProblemSubItem(checkProblemSubItem);
	}

	/**
     * 删除巡店明细问题对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteCheckProblemSubItemByIds(String ids)
	{
		return checkProblemSubItemMapper.deleteCheckProblemSubItemByIds(Convert.toStrArray(ids));
	}

	@Override
	@Transactional
	public boolean insert(CheckProblemItemVO vo) {
		Integer problemConfigId = vo.getProblemConfigId();
		CheckProblemConfig checkProblemConfig = checkProblemConfigMapper.selectCheckProblemConfigById(problemConfigId);

		Integer raction = checkProblemConfig.getRaction();
		CheckProblemItem item = new CheckProblemItem();

		item.setSubItemId(vo.getSubItemId());
		item.setItemId(vo.getItemId());
		item.setCheckRecordId(vo.getCheckRecordId());

		List<CheckProblemItem> checkProblemItems = checkProblemItemMapper.selectCheckProblemItemList(item);
		item.setDeptId(vo.getDeptId());
		item.setShopId(vo.getShopId());
		Integer checkProblemItem = 0;
		if(CollectionUtils.isEmpty(checkProblemItems)){
			item.setItemScore(-raction);
			checkProblemItemMapper.insertCheckProblemItem(item);
			checkProblemItem = item.getProblemItemId();
		}else {
			item.setItemScore(checkProblemItems.get(0).getItemScore()-raction);
			item.setProblemItemId(checkProblemItems.get(0).getProblemItemId());
			checkProblemItemMapper.updateCheckProblemItem(item);
			checkProblemItem = checkProblemItems.get(0).getProblemItemId();
		}

		checkRecordMapper.updateCheckRecordById(vo.getCheckRecordId(),-raction);

		CheckProblemSubItem  subItem = new CheckProblemSubItem();
		subItem.setDescription(vo.getDescription());
		subItem.setPicUrl(vo.getPicUrl());
		subItem.setProblemItemId(checkProblemItem);
		subItem.setScore(-raction);
		subItem.setCreateTime(new Date());
		return checkProblemSubItemMapper.insertCheckProblemSubItem(subItem) > 0;
	}


}
