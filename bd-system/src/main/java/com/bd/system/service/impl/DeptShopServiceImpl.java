package com.bd.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bd.system.mapper.DeptShopMapper;
import com.bd.system.domain.DeptShop;
import com.bd.system.service.IDeptShopService;
import com.bd.common.core.text.Convert;

/**
 * 部门和店铺关联 服务层实现
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
     * 查询部门和店铺关联信息
     * 
     * @param deptId 部门和店铺关联ID
     * @return 部门和店铺关联信息
     */
    @Override
	public DeptShop selectDeptShopById(Integer deptId)
	{
	    return deptShopMapper.selectDeptShopById(deptId);
	}
	
	/**
     * 查询部门和店铺关联列表
     * 
     * @param deptShop 部门和店铺关联信息
     * @return 部门和店铺关联集合
     */
	@Override
	public List<DeptShop> selectDeptShopList(DeptShop deptShop)
	{
	    return deptShopMapper.selectDeptShopList(deptShop);
	}
	
    /**
     * 新增部门和店铺关联
     * 
     * @param deptShop 部门和店铺关联信息
     * @return 结果
     */
	@Override
	public int insertDeptShop(DeptShop deptShop)
	{
	    return deptShopMapper.insertDeptShop(deptShop);
	}
	
	/**
     * 修改部门和店铺关联
     * 
     * @param deptShop 部门和店铺关联信息
     * @return 结果
     */
	@Override
	public int updateDeptShop(DeptShop deptShop)
	{
	    return deptShopMapper.updateDeptShop(deptShop);
	}

	/**
     * 删除部门和店铺关联对象
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
