package com.bd.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bd.system.mapper.CheckConfigMapper;
import com.bd.system.domain.CheckConfig;
import com.bd.system.service.ICheckConfigService;
import com.bd.common.core.text.Convert;

/**
 * 检查项配置 服务层实现
 * 
 * @author luxuewei
 * @date 2019-04-20
 */
@Service
public class CheckConfigServiceImpl implements ICheckConfigService 
{
	@Autowired
	private CheckConfigMapper checkConfigMapper;

	/**
     * 查询检查项配置信息
     * 
     * @param checkConfigId 检查项配置ID
     * @return 检查项配置信息
     */
    @Override
	public CheckConfig selectCheckConfigById(Integer checkConfigId)
	{
	    return checkConfigMapper.selectCheckConfigById(checkConfigId);
	}
	
	/**
     * 查询检查项配置列表
     * 
     * @param checkConfig 检查项配置信息
     * @return 检查项配置集合
     */
	@Override
	public List<CheckConfig> selectCheckConfigList(CheckConfig checkConfig)
	{
	    return checkConfigMapper.selectCheckConfigList(checkConfig);
	}
	
    /**
     * 新增检查项配置
     * 
     * @param checkConfig 检查项配置信息
     * @return 结果
     */
	@Override
	public int insertCheckConfig(CheckConfig checkConfig)
	{
	    return checkConfigMapper.insertCheckConfig(checkConfig);
	}
	
	/**
     * 修改检查项配置
     * 
     * @param checkConfig 检查项配置信息
     * @return 结果
     */
	@Override
	public int updateCheckConfig(CheckConfig checkConfig)
	{
	    return checkConfigMapper.updateCheckConfig(checkConfig);
	}

	/**
     * 删除检查项配置对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteCheckConfigByIds(String ids)
	{
		return checkConfigMapper.deleteCheckConfigByIds(Convert.toStrArray(ids));
	}
	
}
