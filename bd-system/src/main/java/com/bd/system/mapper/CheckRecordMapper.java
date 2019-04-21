package com.bd.system.mapper;

import com.bd.system.domain.CheckRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;	

/**
 * 检查记录 数据层
 * 
 * @author luxuewei
 * @date 2019-04-21
 */
public interface CheckRecordMapper 
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
     * 删除检查记录
     * 
     * @param checkRecordId 检查记录ID
     * @return 结果
     */
	public int deleteCheckRecordById(Integer checkRecordId);
	
	/**
     * 批量删除检查记录
     * 
     * @param checkRecordIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteCheckRecordByIds(String[] checkRecordIds);

    int selectCount(@Param("deptId")Integer deptId,@Param("shopId")Integer shopId, @Param("dateToStr") String dateToStr);
    
}