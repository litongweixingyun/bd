package com.bd.system.mapper;

import com.bd.system.domain.CheckDutyProblem;
import java.util.List;	

/**
 * 值班问题 数据层
 * 
 * @author luxuewei
 * @date 2019-07-11
 */
public interface CheckDutyProblemMapper 
{
	/**
     * 查询值班问题信息
     * 
     * @param problemId 值班问题ID
     * @return 值班问题信息
     */
	public CheckDutyProblem selectCheckDutyProblemById(Integer problemId);
	
	/**
     * 查询值班问题列表
     * 
     * @param checkDutyProblem 值班问题信息
     * @return 值班问题集合
     */
	public List<CheckDutyProblem> selectCheckDutyProblemList(CheckDutyProblem checkDutyProblem);
	
	/**
     * 新增值班问题
     * 
     * @param checkDutyProblem 值班问题信息
     * @return 结果
     */
	public int insertCheckDutyProblem(CheckDutyProblem checkDutyProblem);
	
	/**
     * 修改值班问题
     * 
     * @param checkDutyProblem 值班问题信息
     * @return 结果
     */
	public int updateCheckDutyProblem(CheckDutyProblem checkDutyProblem);
	
	/**
     * 删除值班问题
     * 
     * @param problemId 值班问题ID
     * @return 结果
     */
	public int deleteCheckDutyProblemById(Integer problemId);
	
	/**
     * 批量删除值班问题
     * 
     * @param problemIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteCheckDutyProblemByIds(String[] problemIds);
	
}