package com.bd.system.mapper;

import com.bd.system.domain.DeptShop;
import java.util.List;	

/**
 * 部门和店铺关联 数据层
 * 
 * @author luxuewei
 * @date 2019-03-25
 */
public interface DeptShopMapper 
{
	/**
     * 查询部门和店铺关联信息
     * 
     * @param deptId 部门和店铺关联ID
     * @return 部门和店铺关联信息
     */
	public DeptShop selectDeptShopById(Integer deptId);
	
	/**
     * 查询部门和店铺关联列表
     * 
     * @param deptShop 部门和店铺关联信息
     * @return 部门和店铺关联集合
     */
	public List<DeptShop> selectDeptShopList(DeptShop deptShop);
	
	/**
     * 新增部门和店铺关联
     * 
     * @param deptShop 部门和店铺关联信息
     * @return 结果
     */
	public int insertDeptShop(DeptShop deptShop);
	
	/**
     * 修改部门和店铺关联
     * 
     * @param deptShop 部门和店铺关联信息
     * @return 结果
     */
	public int updateDeptShop(DeptShop deptShop);
	
	/**
     * 删除部门和店铺关联
     * 
     * @param deptId 部门和店铺关联ID
     * @return 结果
     */
	public int deleteDeptShopById(Integer deptId);
	
	/**
     * 批量删除部门和店铺关联
     * 
     * @param deptIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteDeptShopByIds(String[] deptIds);
	
}