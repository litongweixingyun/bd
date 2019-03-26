package com.bd.system.mapper;

import com.bd.system.domain.ShopPosition;
import java.util.List;	

/**
 * 店铺岗位 数据层
 * 
 * @author luxuewei
 * @date 2019-03-26
 */
public interface ShopPositionMapper 
{
	/**
     * 查询店铺岗位信息
     * 
     * @param positionId 店铺岗位ID
     * @return 店铺岗位信息
     */
	public ShopPosition selectShopPositionById(Integer positionId);
	
	/**
     * 查询店铺岗位列表
     * 
     * @param shopPosition 店铺岗位信息
     * @return 店铺岗位集合
     */
	public List<ShopPosition> selectShopPositionList(ShopPosition shopPosition);
	
	/**
     * 新增店铺岗位
     * 
     * @param shopPosition 店铺岗位信息
     * @return 结果
     */
	public int insertShopPosition(ShopPosition shopPosition);
	
	/**
     * 修改店铺岗位
     * 
     * @param shopPosition 店铺岗位信息
     * @return 结果
     */
	public int updateShopPosition(ShopPosition shopPosition);
	
	/**
     * 删除店铺岗位
     * 
     * @param positionId 店铺岗位ID
     * @return 结果
     */
	public int deleteShopPositionById(Integer positionId);
	
	/**
     * 批量删除店铺岗位
     * 
     * @param positionIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteShopPositionByIds(String[] positionIds);
	
}