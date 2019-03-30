package com.bd.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bd.system.mapper.ShopAreaMapper;
import com.bd.system.domain.ShopArea;
import com.bd.system.service.IShopAreaService;
import com.bd.common.core.text.Convert;

/**
 * 店铺区域 服务层实现
 * 
 * @author luxuewei
 * @date 2019-03-30
 */
@Service
public class ShopAreaServiceImpl implements IShopAreaService 
{
	@Autowired
	private ShopAreaMapper shopAreaMapper;

	/**
     * 查询店铺区域信息
     * 
     * @param areaId 店铺区域ID
     * @return 店铺区域信息
     */
    @Override
	public ShopArea selectShopAreaById(Integer areaId)
	{
	    return shopAreaMapper.selectShopAreaById(areaId);
	}
	
	/**
     * 查询店铺区域列表
     * 
     * @param shopArea 店铺区域信息
     * @return 店铺区域集合
     */
	@Override
	public List<ShopArea> selectShopAreaList(ShopArea shopArea)
	{
	    return shopAreaMapper.selectShopAreaList(shopArea);
	}
	
    /**
     * 新增店铺区域
     * 
     * @param shopArea 店铺区域信息
     * @return 结果
     */
	@Override
	public int insertShopArea(ShopArea shopArea)
	{
	    return shopAreaMapper.insertShopArea(shopArea);
	}
	
	/**
     * 修改店铺区域
     * 
     * @param shopArea 店铺区域信息
     * @return 结果
     */
	@Override
	public int updateShopArea(ShopArea shopArea)
	{
	    return shopAreaMapper.updateShopArea(shopArea);
	}

	/**
     * 删除店铺区域对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteShopAreaByIds(String ids)
	{
		return shopAreaMapper.deleteShopAreaByIds(Convert.toStrArray(ids));
	}
	
}
