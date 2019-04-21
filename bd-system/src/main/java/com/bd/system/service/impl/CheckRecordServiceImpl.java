package com.bd.system.service.impl;

import com.bd.common.core.text.Convert;
import com.bd.system.domain.CheckRecord;
import com.bd.system.mapper.CheckRecordMapper;
import com.bd.system.service.ICheckRecordService;
import com.bd.system.vo.CheckHistoryVO;
import com.bd.system.vo.CheckRecordResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 检查记录 服务层实现
 * 
 * @author luxuewei
 * @date 2019-04-21
 */
@Service
public class CheckRecordServiceImpl implements ICheckRecordService 
{
	@Autowired
	private CheckRecordMapper checkRecordMapper;

	/**
     * 查询检查记录信息
     * 
     * @param checkRecordId 检查记录ID
     * @return 检查记录信息
     */
    @Override
	public CheckRecord selectCheckRecordById(Integer checkRecordId)
	{
	    return checkRecordMapper.selectCheckRecordById(checkRecordId);
	}
	
	/**
     * 查询检查记录列表
     * 
     * @param checkRecord 检查记录信息
     * @return 检查记录集合
     */
	@Override
	public List<CheckRecord> selectCheckRecordList(CheckRecord checkRecord)
	{
	    return checkRecordMapper.selectCheckRecordList(checkRecord);
	}
	
    /**
     * 新增检查记录
     * 
     * @param checkRecord 检查记录信息
     * @return 结果
     */
	@Override
	public int insertCheckRecord(CheckRecord checkRecord)
	{
	    return checkRecordMapper.insertCheckRecord(checkRecord);
	}
	
	/**
     * 修改检查记录
     * 
     * @param checkRecord 检查记录信息
     * @return 结果
     */
	@Override
	public int updateCheckRecord(CheckRecord checkRecord)
	{
	    return checkRecordMapper.updateCheckRecord(checkRecord);
	}

	/**
     * 删除检查记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteCheckRecordByIds(String ids)
	{
		return checkRecordMapper.deleteCheckRecordByIds(Convert.toStrArray(ids));
	}

	@Override
	public int selectCount(Integer deptId,Integer shopId,String dateToStr) {
		return checkRecordMapper.selectCount(deptId,shopId,dateToStr);
	}

	@Override
	public CheckRecordResultVO selectCheckRecordByCheckRecordId(Integer checkRecordId) {
		return checkRecordMapper.selectCheckRecordByCheckRecordId(checkRecordId);
	}

	@Override
	public List<CheckRecord> selectCheckRecordHistory(CheckHistoryVO vo) {
		return checkRecordMapper.selectCheckRecordHistory(vo);
	}

}
