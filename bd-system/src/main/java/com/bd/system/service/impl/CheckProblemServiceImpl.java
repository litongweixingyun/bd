package com.bd.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bd.system.mapper.CheckProblemMapper;
import com.bd.system.domain.CheckProblem;
import com.bd.system.service.ICheckProblemService;
import com.bd.common.core.text.Convert;

/**
 * 巡店问题 服务层实现
 * 
 * @author luxuewei
 * @date 2019-04-20
 */
@Service
public class CheckProblemServiceImpl implements ICheckProblemService 
{
	@Autowired
	private CheckProblemMapper checkProblemMapper;

	/**
     * 查询巡店问题信息
     * 
     * @param problemId 巡店问题ID
     * @return 巡店问题信息
     */
    @Override
	public CheckProblem selectCheckProblemById(Integer problemId)
	{
	    return checkProblemMapper.selectCheckProblemById(problemId);
	}
	
	/**
     * 查询巡店问题列表
     * 
     * @param checkProblem 巡店问题信息
     * @return 巡店问题集合
     */
	@Override
	public List<CheckProblem> selectCheckProblemList(CheckProblem checkProblem)
	{
	    return checkProblemMapper.selectCheckProblemList(checkProblem);
	}
	
    /**
     * 新增巡店问题
     * 
     * @param checkProblem 巡店问题信息
     * @return 结果
     */
	@Override
	public int insertCheckProblem(CheckProblem checkProblem)
	{
	    return checkProblemMapper.insertCheckProblem(checkProblem);
	}
	
	/**
     * 修改巡店问题
     * 
     * @param checkProblem 巡店问题信息
     * @return 结果
     */
	@Override
	public int updateCheckProblem(CheckProblem checkProblem)
	{
	    return checkProblemMapper.updateCheckProblem(checkProblem);
	}

	/**
     * 删除巡店问题对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteCheckProblemByIds(String ids)
	{
		return checkProblemMapper.deleteCheckProblemByIds(Convert.toStrArray(ids));
	}
	
}
