package com.bd.system.mapper;

import com.bd.system.domain.CheckProblemSubItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 巡店明细问题 数据层
 * 
 * @author luxuewei
 * @date 2019-04-20
 */
public interface CheckProblemSubItemMapper 
{
	/**
     * 查询巡店明细问题信息
     * 
     * @param problemSubItemId 巡店明细问题ID
     * @return 巡店明细问题信息
     */
	public CheckProblemSubItem selectCheckProblemSubItemById(Integer problemSubItemId);
	
	/**
     * 查询巡店明细问题列表
     * 
     * @param checkProblemSubItem 巡店明细问题信息
     * @return 巡店明细问题集合
     */
	public List<CheckProblemSubItem> selectCheckProblemSubItemList(CheckProblemSubItem checkProblemSubItem);
	
	/**
     * 新增巡店明细问题
     * 
     * @param checkProblemSubItem 巡店明细问题信息
     * @return 结果
     */
	public int insertCheckProblemSubItem(CheckProblemSubItem checkProblemSubItem);
	
	/**
     * 修改巡店明细问题
     * 
     * @param checkProblemSubItem 巡店明细问题信息
     * @return 结果
     */
	public int updateCheckProblemSubItem(CheckProblemSubItem checkProblemSubItem);
	
	/**
     * 删除巡店明细问题
     * 
     * @param problemSubItemId 巡店明细问题ID
     * @return 结果
     */
	public int deleteCheckProblemSubItemById(Integer problemSubItemId);
	
	/**
     * 批量删除巡店明细问题
     * 
     * @param problemSubItemIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteCheckProblemSubItemByIds(String[] problemSubItemIds);

    List selectChangedList(@Param("deptId") Integer deptId, @Param("shopId")Integer shopId, @Param("status")Integer status, @Param("checkDate")String checkDate);
}