package com.bd.system.service.impl;

import com.bd.common.core.text.Convert;
import com.bd.system.domain.Problem;
import com.bd.system.mapper.ProblemMapper;
import com.bd.system.service.IProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 检查问题 服务层实现
 * 
 * @author luxuewei
 * @date 2019-03-30
 */
@Service
public class ProblemServiceImpl implements IProblemService 
{
	@Autowired
	private ProblemMapper problemMapper;

	/**
     * 查询检查问题信息
     * 
     * @param problemId 检查问题ID
     * @return 检查问题信息
     */
    @Override
	public Problem selectProblemById(Integer problemId)
	{
	    return problemMapper.selectProblemById(problemId);
	}
	
	/**
     * 查询检查问题列表
     * 
     * @param problem 检查问题信息
     * @return 检查问题集合
     */
	@Override
	public List<Problem> selectProblemList(Problem problem)
	{
	    return problemMapper.selectProblemList(problem);
	}
	
    /**
     * 新增检查问题
     * 
     * @param problem 检查问题信息
     * @return 结果
     */
	@Override
	public int insertProblem(Problem problem)
	{
	    return problemMapper.insertProblem(problem);
	}
	
	/**
     * 修改检查问题
     * 
     * @param problem 检查问题信息
     * @return 结果
     */
	@Override
	public int updateProblem(Problem problem)
	{
	    return problemMapper.updateProblem(problem);
	}

	/**
     * 删除检查问题对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteProblemByIds(String ids)
	{
		return problemMapper.deleteProblemByIds(Convert.toStrArray(ids));
	}
	
}
