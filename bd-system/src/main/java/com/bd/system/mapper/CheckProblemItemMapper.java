package com.bd.system.mapper;

import com.bd.system.domain.CheckProblemItem;
import com.bd.system.vo.BigitemVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 巡店大项问题 数据层
 * 
 * @author luxuewei
 * @date 2019-04-20
 */
public interface CheckProblemItemMapper 
{
	/**
     * 查询巡店大项问题信息
     * 
     * @param problemItemId 巡店大项问题ID
     * @return 巡店大项问题信息
     */
	public CheckProblemItem selectCheckProblemItemById(Integer problemItemId);
	
	/**
     * 查询巡店大项问题列表
     * 
     * @param checkProblemItem 巡店大项问题信息
     * @return 巡店大项问题集合
     */
	public List<CheckProblemItem> selectCheckProblemItemList(CheckProblemItem checkProblemItem);
	
	/**
     * 新增巡店大项问题
     * 
     * @param checkProblemItem 巡店大项问题信息
     * @return 结果
     */
	public int insertCheckProblemItem(CheckProblemItem checkProblemItem);
	
	/**
     * 修改巡店大项问题
     * 
     * @param checkProblemItem 巡店大项问题信息
     * @return 结果
     */
	public int updateCheckProblemItem(CheckProblemItem checkProblemItem);
	
	/**
     * 删除巡店大项问题
     * 
     * @param problemItemId 巡店大项问题ID
     * @return 结果
     */
	public int deleteCheckProblemItemById(Integer problemItemId);
	
	/**
     * 批量删除巡店大项问题
     * 
     * @param problemItemIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteCheckProblemItemByIds(String[] problemItemIds);

    BigitemVO selectBigitemList(@Param("deptId") Long deptId);
}