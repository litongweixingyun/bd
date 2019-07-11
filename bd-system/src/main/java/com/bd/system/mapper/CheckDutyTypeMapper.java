package com.bd.system.mapper;

import com.bd.system.domain.CheckDutyType;
import java.util.List;	

/**
 * 值班类型 数据层
 * 
 * @author yuanqingjian
 * @date 2019-07-10
 */
public interface CheckDutyTypeMapper 
{
	/**
     * 查询值班类型信息
     * 
     * @param dctId 值班类型ID
     * @return 值班类型信息
     */
	public CheckDutyType selectCheckDutyTypeById(Integer dctId);
	
	/**
     * 查询值班类型列表
     * 
     * @param checkDutyType 值班类型信息
     * @return 值班类型集合
     */
	public List<CheckDutyType> selectCheckDutyTypeList(CheckDutyType checkDutyType);
	
	/**
     * 新增值班类型
     * 
     * @param checkDutyType 值班类型信息
     * @return 结果
     */
	public int insertCheckDutyType(CheckDutyType checkDutyType);
	
	/**
     * 修改值班类型
     * 
     * @param checkDutyType 值班类型信息
     * @return 结果
     */
	public int updateCheckDutyType(CheckDutyType checkDutyType);
	
	/**
     * 删除值班类型
     * 
     * @param dctId 值班类型ID
     * @return 结果
     */
	public int deleteCheckDutyTypeById(Integer dctId);
	
	/**
     * 批量删除值班类型
     * 
     * @param dctIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteCheckDutyTypeByIds(String[] dctIds);
	
}