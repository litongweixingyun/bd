package com.bd.system.service.impl;

import com.bd.common.core.text.Convert;
import com.bd.system.domain.CheckProblemItem;
import com.bd.system.mapper.CheckProblemItemMapper;
import com.bd.system.service.ICheckProblemItemService;
import com.bd.system.vo.BigitemVO;
import com.bd.system.vo.CheckRecordResultDetailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 巡店大项问题 服务层实现
 * 
 * @author luxuewei
 * @date 2019-04-20
 */
@Service
public class CheckProblemItemServiceImpl implements ICheckProblemItemService 
{
	@Autowired
	private CheckProblemItemMapper checkProblemItemMapper;

	/**
     * 查询巡店大项问题信息
     * 
     * @param problemItemId 巡店大项问题ID
     * @return 巡店大项问题信息
     */
    @Override
	public CheckProblemItem selectCheckProblemItemById(Integer problemItemId)
	{
	    return checkProblemItemMapper.selectCheckProblemItemById(problemItemId);
	}
	
	/**
     * 查询巡店大项问题列表
     * 
     * @param checkProblemItem 巡店大项问题信息
     * @return 巡店大项问题集合
     */
	@Override
	public List<CheckProblemItem> selectCheckProblemItemList(CheckProblemItem checkProblemItem)
	{
	    return checkProblemItemMapper.selectCheckProblemItemList(checkProblemItem);
	}
	
    /**
     * 新增巡店大项问题
     * 
     * @param checkProblemItem 巡店大项问题信息
     * @return 结果
     */
	@Override
	public int insertCheckProblemItem(CheckProblemItem checkProblemItem)
	{
	    return checkProblemItemMapper.insertCheckProblemItem(checkProblemItem);
	}
	
	/**
     * 修改巡店大项问题
     * 
     * @param checkProblemItem 巡店大项问题信息
     * @return 结果
     */
	@Override
	public int updateCheckProblemItem(CheckProblemItem checkProblemItem)
	{
	    return checkProblemItemMapper.updateCheckProblemItem(checkProblemItem);
	}

	/**
     * 删除巡店大项问题对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteCheckProblemItemByIds(String ids)
	{
		return checkProblemItemMapper.deleteCheckProblemItemByIds(Convert.toStrArray(ids));
	}

	@Override
	public BigitemVO selectBigitemList(Long deptId) {
		return checkProblemItemMapper.selectBigitemList(deptId);
	}

	@Override
	public List<CheckRecordResultDetailVO> selectCheckProblemItemByCheckRecordId(Integer checkRecordId) {
		return checkProblemItemMapper.selectCheckProblemItemByCheckRecordId(checkRecordId);
	}

}
