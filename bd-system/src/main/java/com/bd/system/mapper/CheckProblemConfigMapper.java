package com.bd.system.mapper;

import com.bd.system.domain.CheckProblemConfig;
import com.bd.system.vo.ProblemVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 巡店问题配置 数据层
 * 
 * @author luxuewei
 * @date 2019-04-20
 */
public interface CheckProblemConfigMapper 
{
	/**
     * 查询巡店问题配置信息
     * 
     * @param problemConfigId 巡店问题配置ID
     * @return 巡店问题配置信息
     */
	public CheckProblemConfig selectCheckProblemConfigById(Integer problemConfigId);
	public CheckProblemConfig selectCheckProblemConfigById2(Integer problemConfigId);

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
     * 删除巡店问题配置
     * 
     * @param problemConfigId 巡店问题配置ID
     * @return 结果
     */
	public int deleteCheckProblemConfigById(Integer problemConfigId);
	
	/**
     * 批量删除巡店问题配置
     * 
     * @param problemConfigIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteCheckProblemConfigByIds(String[] problemConfigIds);

	List<ProblemVO> selectCheckProblemConfig(@Param("deptId") Long deptId, @Param("itemId") Long itemId, @Param("subItemId")Long subItemId);
}