package com.bd.system.service;

import com.bd.system.domain.CheckRecord;
import java.util.List;

/**
 * 检查记录 服务层
 * 
 * @author luxuewei
 * @date 2019-03-25
 */
public interface ICheckRecordService 
{
	/**
     * 查询检查记录信息
     * 
     * @param checkRecordId 检查记录ID
     * @return 检查记录信息
     */
	public CheckRecord selectCheckRecordById(Integer checkRecordId);
	
	/**
     * 查询检查记录列表
     * 
     * @param checkRecord 检查记录信息
     * @return 检查记录集合
     */
	public List<CheckRecord> selectCheckRecordList(CheckRecord checkRecord);
	
	/**
     * 新增检查记录
     * 
     * @param checkRecord 检查记录信息
     * @return 结果
     */
	public int insertCheckRecord(CheckRecord checkRecord);
	
	/**
     * 修改检查记录
     * 
     * @param checkRecord 检查记录信息
     * @return 结果
     */
	public int updateCheckRecord(CheckRecord checkRecord);
		
	/**
     * 删除检查记录信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteCheckRecordByIds(String ids);
	
}
