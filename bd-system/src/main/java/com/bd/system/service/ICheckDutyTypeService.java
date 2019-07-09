package com.bd.system.service;

import com.bd.system.domain.CheckDutyType;
import java.util.List;

/**
 * 值班类型 服务层
 * 
 * @author luxuewei
 * @date 2019-06-28
 */
public interface ICheckDutyTypeService 
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
     * 删除值班类型信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteCheckDutyTypeByIds(String ids);
	
}
