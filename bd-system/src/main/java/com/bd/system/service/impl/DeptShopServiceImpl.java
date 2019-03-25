package com.bd.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bd.system.mapper.DeptShopMapper;
import com.bd.system.domain.DeptShop;
import com.bd.system.service.IDeptShopService;
import com.bd.common.core.text.Convert;

/**
 * 巡店配置 服务层实现
 * 
 * @author luxuewei
 * @date 2019-03-25
 */
@Service
public class DeptShopServiceImpl implements IDeptShopService 
{
	@Autowired
	private DeptShopMapper deptShopMapper;

	/**
     * 查询巡店配置信息
     * 
     * @param deptId 巡店配置ID
     * @return 巡店配置信息
     */
    @Override
	public DeptShop selectDeptShopById(Integer deptId)
	{
	    return deptShopMapper.selectDeptShopById(deptId);
	}
	
	/**
     * 查询巡店配置列表
     * 
     * @param deptShop 巡店配置信息
     * @return 巡店配置集合
     */
	@Override
	public List<DeptShop> selectDeptShopList(DeptShop deptShop)
	{
	    return deptShopMapper.selectDeptShopList(deptShop);
	}
	
    /**
     * 新增巡店配置
     * 
     * @param deptShop 巡店配置信息
     * @return 结果
     */
	@Override
	public int insertDeptShop(DeptShop deptShop)
	{
	    return deptShopMapper.insertDeptShop(deptShop);
	}
	
	/**
     * 修改巡店配置
     * 
     * @param deptShop 巡店配置信息
     * @return 结果
     */
	@Override
	public int updateDeptShop(DeptShop deptShop)
	{
	    return deptShopMapper.updateDeptShop(deptShop);
	}

	/**
     * 删除巡店配置对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteDeptShopByIds(String ids)
	{
		return deptShopMapper.deleteDeptShopByIds(Convert.toStrArray(ids));
	}
	
}
