package com.bd.system.mapper;

import com.bd.system.domain.CheckDuty;
import java.util.List;	

/**
 * 值班 数据层
 * 
 * @author luxuewei
 * @date 2019-06-27
 */
public interface CheckDutyMapper 
{
	/**
     * 查询值班信息
     * 
     * @param dutyId 值班ID
     * @return 值班信息
     */
	public CheckDuty selectCheckDutyById(Integer dutyId);
	
	/**
     * 查询值班列表
     * 
     * @param checkDuty 值班信息
     * @return 值班集合
     */
	public List<CheckDuty> selectCheckDutyList(CheckDuty checkDuty);
	
	/**
     * 新增值班
     * 
     * @param checkDuty 值班信息
     * @return 结果
     */
	public int insertCheckDuty(CheckDuty checkDuty);
	
	/**
     * 修改值班
     * 
     * @param checkDuty 值班信息
     * @return 结果
     */
	public int updateCheckDuty(CheckDuty checkDuty);
	
	/**
     * 删除值班
     * 
     * @param dutyId 值班ID
     * @return 结果
     */
	public int deleteCheckDutyById(Integer dutyId);
	
	/**
     * 批量删除值班
     * 
     * @param dutyIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteCheckDutyByIds(String[] dutyIds);
	
}