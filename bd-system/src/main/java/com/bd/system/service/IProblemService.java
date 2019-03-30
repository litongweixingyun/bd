package com.bd.system.service;

import com.bd.system.domain.Problem;
import java.util.List;

/**
 * 检查问题 服务层
 * 
 * @author luxuewei
 * @date 2019-03-30
 */
public interface IProblemService 
{
	/**
     * 查询检查问题信息
     * 
     * @param problemId 检查问题ID
     * @return 检查问题信息
     */
	public Problem selectProblemById(Integer problemId);
	
	/**
     * 查询检查问题列表
     * 
     * @param problem 检查问题信息
     * @return 检查问题集合
     */
	public List<Problem> selectProblemList(Problem problem);
	
	/**
     * 新增检查问题
     * 
     * @param problem 检查问题信息
     * @return 结果
     */
	public int insertProblem(Problem problem);
	
	/**
     * 修改检查问题
     * 
     * @param problem 检查问题信息
     * @return 结果
     */
	public int updateProblem(Problem problem);
		
	/**
     * 删除检查问题信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteProblemByIds(String ids);
	
}
