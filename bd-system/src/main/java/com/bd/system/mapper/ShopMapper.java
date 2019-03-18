package com.bd.system.mapper;

import com.bd.system.domain.Shop;
import java.util.List;	

/**
 * 店铺 数据层
 * 
 * @author luxuewei
 * @date 2019-03-18
 */
public interface ShopMapper 
{
	/**
     * 查询店铺信息
     * 
     * @param shopId 店铺ID
     * @return 店铺信息
     */
	public Shop selectShopById(Integer shopId);
	
	/**
     * 查询店铺列表
     * 
     * @param shop 店铺信息
     * @return 店铺集合
     */
	public List<Shop> selectShopList(Shop shop);
	
	/**
     * 新增店铺
     * 
     * @param shop 店铺信息
     * @return 结果
     */
	public int insertShop(Shop shop);
	
	/**
     * 修改店铺
     * 
     * @param shop 店铺信息
     * @return 结果
     */
	public int updateShop(Shop shop);
	
	/**
     * 删除店铺
     * 
     * @param shopId 店铺ID
     * @return 结果
     */
	public int deleteShopById(Integer shopId);
	
	/**
     * 批量删除店铺
     * 
     * @param shopIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteShopByIds(String[] shopIds);
	
}