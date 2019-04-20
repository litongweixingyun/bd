package com.bd.system.service;

import com.bd.system.domain.CheckProblem;
import java.util.List;

/**
 * 巡店问题 服务层
 * 
 * @author luxuewei
 * @date 2019-04-20
 */
public interface ICheckProblemService 
{
	/**
     * 查询巡店问题信息
     * 
     * @param problemId 巡店问题ID
     * @return 巡店问题信息
     */
	public CheckProblem selectCheckProblemById(Integer problemId);
	
	/**
     * 查询巡店问题列表
     * 
     * @param checkProblem 巡店问题信息
     * @return 巡店问题集合
     */
	public List<CheckProblem> selectCheckProblemList(CheckProblem checkProblem);
	
	/**
     * 新增巡店问题
     * 
     * @param checkProblem 巡店问题信息
     * @return 结果
     */
	public int insertCheckProblem(CheckProblem checkProblem);
	
	/**
     * 修改巡店问题
     * 
     * @param checkProblem 巡店问题信息
     * @return 结果
     */
	public int updateCheckProblem(CheckProblem checkProblem);
		
	/**
     * 删除巡店问题信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteCheckProblemByIds(String ids);
	
}
