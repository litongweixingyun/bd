package com.bd.system.service.impl;

import com.bd.common.core.text.Convert;
import com.bd.system.domain.CheckDuty;
import com.bd.system.mapper.CheckDutyMapper;
import com.bd.system.service.ICheckDutyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 值班 服务层实现
 * 
 * @author luxuewei
 * @date 2019-06-27
 */
@Service
public class CheckDutyServiceImpl implements ICheckDutyService 
{
	@Autowired
	private CheckDutyMapper checkDutyMapper;

	/**
     * 查询值班信息
     * 
     * @param dutyId 值班ID
     * @return 值班信息
     */
    @Override
	public CheckDuty selectCheckDutyById(Integer dutyId)
	{
	    return checkDutyMapper.selectCheckDutyById(dutyId);
	}
	
	/**
     * 查询值班列表
     * 
     * @param checkDuty 值班信息
     * @return 值班集合
     */
	@Override
	public List<CheckDuty> selectCheckDutyList(CheckDuty checkDuty)
	{
	    return checkDutyMapper.selectCheckDutyList(checkDuty);
	}
	
    /**
     * 新增值班
     * 
     * @param checkDuty 值班信息
     * @return 结果
     */
	@Override
	public int insertCheckDuty(CheckDuty checkDuty)
	{
	    return checkDutyMapper.insertCheckDuty(checkDuty);
	}
	
	/**
     * 修改值班
     * 
     * @param checkDuty 值班信息
     * @return 结果
     */
	@Override
	public int updateCheckDuty(CheckDuty checkDuty)
	{
	    return checkDutyMapper.updateCheckDuty(checkDuty);
	}

	/**
     * 删除值班对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteCheckDutyByIds(String ids)
	{
		return checkDutyMapper.deleteCheckDutyByIds(Convert.toStrArray(ids));
	}
	
}
