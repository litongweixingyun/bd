package com.bd.system.mapper;

import com.bd.system.domain.DeptShop;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 巡店配置 数据层
 * 
 * @author luxuewei
 * @date 2019-03-25
 */
public interface DeptShopMapper 
{
	/**
     * 查询巡店配置信息
     * 
     * @param dsId 巡店配置ID
     * @return 巡店配置信息
     */
	public DeptShop selectDeptShopById(Integer dsId);
	
	/**
     * 查询巡店配置列表
     * 
     * @param deptShop 巡店配置信息
     * @return 巡店配置集合
     */
	public List<DeptShop> selectDeptShopList(DeptShop deptShop);
	
	/**
     * 新增巡店配置
     * 
     * @param deptShop 巡店配置信息
     * @return 结果
     */
	public int insertDeptShop(DeptShop deptShop);
	
	/**
     * 修改巡店配置
     * 
     * @param deptShop 巡店配置信息
     * @return 结果
     */
	public int updateDeptShop(DeptShop deptShop);
	
	/**
     * 删除巡店配置
     * 
     * @param deptId 巡店配置ID
     * @return 结果
     */
	public int deleteDeptShopById(Integer deptId);
	
	/**
     * 批量删除巡店配置
     * 
     * @param deptIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteDeptShopByIds(String[] deptIds);

	int updateCheckNum(@Param("deptId") Integer deptId, @Param("shopId")Integer shopId);
}