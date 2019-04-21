package com.bd.system.service;

import com.bd.system.domain.CheckProblemConfig;
import java.util.List;

/**
 * 巡店问题配置 服务层
 * 
 * @author luxuewei
 * @date 2019-04-20
 */
public interface ICheckProblemConfigService 
{
	/**
     * 查询巡店问题配置信息
     * 
     * @param problemConfigId 巡店问题配置ID
     * @return 巡店问题配置信息
     */
	public CheckProblemConfig selectCheckProblemConfigById(Integer problemConfigId);
	
	/**
     * 查询巡店问题配置列表
     * 
     * @param checkProblemConfig 巡店问题配置信息
     * @return 巡店问题配置集合
     */
	public List<CheckProblemConfig> selectCheckProblemConfigList(CheckProblemConfig checkProblemConfig);
	
	/**
     * 新增巡店问题配置
     * 
     * @param checkProblemConfig 巡店问题配置信息
     * @return 结果
     */
	public int insertCheckProblemConfig(CheckProblemConfig checkProblemConfig);
	
	/**
     * 修改巡店问题配置
     * 
     * @param checkProblemConfig 巡店问题配置信息
     * @return 结果
     */
	public int updateCheckProblemConfig(CheckProblemConfig checkProblemConfig);
		
	/**
     * 删除巡店问题配置信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteCheckProblemConfigByIds(String ids);

	List<CheckProblemConfig> selectCheckProblemConfig(Long deptId, Long itemId, Long subItemId);
    
}
