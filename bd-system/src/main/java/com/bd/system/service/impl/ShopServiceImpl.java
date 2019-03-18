package com.bd.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bd.system.mapper.ShopMapper;
import com.bd.system.domain.Shop;
import com.bd.system.service.IShopService;
import com.bd.common.core.text.Convert;

/**
 * 店铺 服务层实现
 * 
 * @author luxuewei
 * @date 2019-03-18
 */
@Service
public class ShopServiceImpl implements IShopService 
{
	@Autowired
	private ShopMapper shopMapper;

	/**
     * 查询店铺信息
     * 
     * @param shopId 店铺ID
     * @return 店铺信息
     */
    @Override
	public Shop selectShopById(Integer shopId)
	{
	    return shopMapper.selectShopById(shopId);
	}
	
	/**
     * 查询店铺列表
     * 
     * @param shop 店铺信息
     * @return 店铺集合
     */
	@Override
	public List<Shop> selectShopList(Shop shop)
	{
	    return shopMapper.selectShopList(shop);
	}
	
    /**
     * 新增店铺
     * 
     * @param shop 店铺信息
     * @return 结果
     */
	@Override
	public int insertShop(Shop shop)
	{
	    return shopMapper.insertShop(shop);
	}
	
	/**
     * 修改店铺
     * 
     * @param shop 店铺信息
     * @return 结果
     */
	@Override
	public int updateShop(Shop shop)
	{
	    return shopMapper.updateShop(shop);
	}

	/**
     * 删除店铺对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteShopByIds(String ids)
	{
		return shopMapper.deleteShopByIds(Convert.toStrArray(ids));
	}
	
}
