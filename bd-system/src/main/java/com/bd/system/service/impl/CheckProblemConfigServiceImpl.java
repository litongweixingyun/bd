package com.bd.system.service.impl;

import java.util.List;

import com.bd.system.vo.ProblemVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bd.system.mapper.CheckProblemConfigMapper;
import com.bd.system.domain.CheckProblemConfig;
import com.bd.system.service.ICheckProblemConfigService;
import com.bd.common.core.text.Convert;

/**
 * 巡店问题配置 服务层实现
 * 
 * @author luxuewei
 * @date 2019-04-20
 */
@Service
public class CheckProblemConfigServiceImpl implements ICheckProblemConfigService 
{
	@Autowired
	private CheckProblemConfigMapper checkProblemConfigMapper;

	/**
     * 查询巡店问题配置信息
     * 
     * @param problemConfigId 巡店问题配置ID
     * @return 巡店问题配置信息
     */
    @Override
	public CheckProblemConfig selectCheckProblemConfigById(Integer problemConfigId)
	{
	    return checkProblemConfigMapper.selectCheckProblemConfigById(problemConfigId);
	}
	
	/**
     * 查询巡店问题配置列表
     * 
     * @param checkProblemConfig 巡店问题配置信息
     * @return 巡店问题配置集合
     */
	@Override
	public List<CheckProblemConfig> selectCheckProblemConfigList(CheckProblemConfig checkProblemConfig)
	{
	    return checkProblemConfigMapper.selectCheckProblemConfigList(checkProblemConfig);
	}
	
    /**
     * 新增巡店问题配置
     * 
     * @param checkProblemConfig 巡店问题配置信息
     * @return 结果
     */
	@Override
	public int insertCheckProblemConfig(CheckProblemConfig checkProblemConfig)
	{
	    return checkProblemConfigMapper.insertCheckProblemConfig(checkProblemConfig);
	}
	
	/**
     * 修改巡店问题配置
     * 
     * @param checkProblemConfig 巡店问题配置信息
     * @return 结果
     */
	@Override
	public int updateCheckProblemConfig(CheckProblemConfig checkProblemConfig)
	{
	    return checkProblemConfigMapper.updateCheckProblemConfig(checkProblemConfig);
	}

	/**
     * 删除巡店问题配置对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteCheckProblemConfigByIds(String ids)
	{
		return checkProblemConfigMapper.deleteCheckProblemConfigByIds(Convert.toStrArray(ids));
	}

	@Override
	public List<ProblemVO> selectCheckProblemConfig(Long deptId, Long itemId, Long subItemId) {
		return checkProblemConfigMapper.selectCheckProblemConfig( deptId,  itemId,  subItemId);
	}

}
