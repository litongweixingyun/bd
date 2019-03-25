package com.bd.system.service;

import com.bd.system.domain.DeptShop;
import java.util.List;

/**
 * 巡店配置 服务层
 * 
 * @author luxuewei
 * @date 2019-03-25
 */
public interface IDeptShopService 
{
	/**
     * 查询巡店配置信息
     * 
     * @param deptId 巡店配置ID
     * @return 巡店配置信息
     */
	public DeptShop selectDeptShopById(Integer deptId);
	
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
     * 删除巡店配置信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteDeptShopByIds(String ids);
	
}
