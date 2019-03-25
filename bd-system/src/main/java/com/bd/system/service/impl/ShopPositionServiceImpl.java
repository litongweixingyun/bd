package com.bd.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bd.system.mapper.ShopPositionMapper;
import com.bd.system.domain.ShopPosition;
import com.bd.system.service.IShopPositionService;
import com.bd.common.core.text.Convert;

/**
 * 店铺岗位关系 服务层实现
 * 
 * @author luxuewei
 * @date 2019-03-25
 */
@Service
public class ShopPositionServiceImpl implements IShopPositionService 
{
	@Autowired
	private ShopPositionMapper shopPositionMapper;

	/**
     * 查询店铺岗位关系信息
     * 
     * @param shopId 店铺岗位关系ID
     * @return 店铺岗位关系信息
     */
    @Override
	public ShopPosition selectShopPositionById(Integer shopId)
	{
	    return shopPositionMapper.selectShopPositionById(shopId);
	}
	
	/**
     * 查询店铺岗位关系列表
     * 
     * @param shopPosition 店铺岗位关系信息
     * @return 店铺岗位关系集合
     */
	@Override
	public List<ShopPosition> selectShopPositionList(ShopPosition shopPosition)
	{
	    return shopPositionMapper.selectShopPositionList(shopPosition);
	}
	
    /**
     * 新增店铺岗位关系
     * 
     * @param shopPosition 店铺岗位关系信息
     * @return 结果
     */
	@Override
	public int insertShopPosition(ShopPosition shopPosition)
	{
	    return shopPositionMapper.insertShopPosition(shopPosition);
	}
	
	/**
     * 修改店铺岗位关系
     * 
     * @param shopPosition 店铺岗位关系信息
     * @return 结果
     */
	@Override
	public int updateShopPosition(ShopPosition shopPosition)
	{
	    return shopPositionMapper.updateShopPosition(shopPosition);
	}

	/**
     * 删除店铺岗位关系对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteShopPositionByIds(String ids)
	{
		return shopPositionMapper.deleteShopPositionByIds(Convert.toStrArray(ids));
	}
	
}
