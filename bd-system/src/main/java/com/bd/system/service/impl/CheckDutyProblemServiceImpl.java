package com.bd.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bd.system.mapper.CheckDutyProblemMapper;
import com.bd.system.domain.CheckDutyProblem;
import com.bd.system.service.ICheckDutyProblemService;
import com.bd.common.core.text.Convert;

/**
 * 值班问题 服务层实现
 * 
 * @author luxuewei
 * @date 2019-07-11
 */
@Service
public class CheckDutyProblemServiceImpl implements ICheckDutyProblemService 
{
	@Autowired
	private CheckDutyProblemMapper checkDutyProblemMapper;

	/**
     * 查询值班问题信息
     * 
     * @param problemId 值班问题ID
     * @return 值班问题信息
     */
    @Override
	public CheckDutyProblem selectCheckDutyProblemById(Integer problemId)
	{
	    return checkDutyProblemMapper.selectCheckDutyProblemById(problemId);
	}
	
	/**
     * 查询值班问题列表
     * 
     * @param checkDutyProblem 值班问题信息
     * @return 值班问题集合
     */
	@Override
	public List<CheckDutyProblem> selectCheckDutyProblemList(CheckDutyProblem checkDutyProblem)
	{
	    return checkDutyProblemMapper.selectCheckDutyProblemList(checkDutyProblem);
	}
	
    /**
     * 新增值班问题
     * 
     * @param checkDutyProblem 值班问题信息
     * @return 结果
     */
	@Override
	public int insertCheckDutyProblem(CheckDutyProblem checkDutyProblem)
	{
	    return checkDutyProblemMapper.insertCheckDutyProblem(checkDutyProblem);
	}
	
	/**
     * 修改值班问题
     * 
     * @param checkDutyProblem 值班问题信息
     * @return 结果
     */
	@Override
	public int updateCheckDutyProblem(CheckDutyProblem checkDutyProblem)
	{
	    return checkDutyProblemMapper.updateCheckDutyProblem(checkDutyProblem);
	}

	/**
     * 删除值班问题对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteCheckDutyProblemByIds(String ids)
	{
		return checkDutyProblemMapper.deleteCheckDutyProblemByIds(Convert.toStrArray(ids));
	}
	
}
