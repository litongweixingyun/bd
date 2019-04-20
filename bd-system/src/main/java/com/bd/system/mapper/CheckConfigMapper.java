package com.bd.system.mapper;

import com.bd.system.domain.CheckConfig;
import java.util.List;	

/**
 * 检查项配置 数据层
 * 
 * @author luxuewei
 * @date 2019-04-20
 */
public interface CheckConfigMapper 
{
	/**
     * 查询检查项配置信息
     * 
     * @param checkConfigId 检查项配置ID
     * @return 检查项配置信息
     */
	public CheckConfig selectCheckConfigById(Integer checkConfigId);
	
	/**
     * 查询检查项配置列表
     * 
     * @param checkConfig 检查项配置信息
     * @return 检查项配置集合
     */
	public List<CheckConfig> selectCheckConfigList(CheckConfig checkConfig);
	
	/**
     * 新增检查项配置
     * 
     * @param checkConfig 检查项配置信息
     * @return 结果
     */
	public int insertCheckConfig(CheckConfig checkConfig);
	
	/**
     * 修改检查项配置
     * 
     * @param checkConfig 检查项配置信息
     * @return 结果
     */
	public int updateCheckConfig(CheckConfig checkConfig);
	
	/**
     * 删除检查项配置
     * 
     * @param checkConfigId 检查项配置ID
     * @return 结果
     */
	public int deleteCheckConfigById(Integer checkConfigId);
	
	/**
     * 批量删除检查项配置
     * 
     * @param checkConfigIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteCheckConfigByIds(String[] checkConfigIds);
	
}