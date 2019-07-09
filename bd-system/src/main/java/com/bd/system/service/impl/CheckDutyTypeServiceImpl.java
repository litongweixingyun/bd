package com.bd.system.service.impl;

import com.bd.common.core.text.Convert;
import com.bd.system.domain.CheckDutyType;
import com.bd.system.mapper.CheckDutyTypeMapper;
import com.bd.system.service.ICheckDutyTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 值班类型 服务层实现
 * 
 * @author luxuewei
 * @date 2019-06-28
 */
@Service
public class CheckDutyTypeServiceImpl implements ICheckDutyTypeService 
{
	@Autowired
	private CheckDutyTypeMapper checkDutyTypeMapper;

	/**
     * 查询值班类型信息
     * 
     * @param dctId 值班类型ID
     * @return 值班类型信息
     */
    @Override
	public CheckDutyType selectCheckDutyTypeById(Integer dctId)
	{
	    return checkDutyTypeMapper.selectCheckDutyTypeById(dctId);
	}
	
	/**
     * 查询值班类型列表
     * 
     * @param checkDutyType 值班类型信息
     * @return 值班类型集合
     */
	@Override
	public List<CheckDutyType> selectCheckDutyTypeList(CheckDutyType checkDutyType)
	{
	    return checkDutyTypeMapper.selectCheckDutyTypeList(checkDutyType);
	}
	
    /**
     * 新增值班类型
     * 
     * @param checkDutyType 值班类型信息
     * @return 结果
     */
	@Override
	public int insertCheckDutyType(CheckDutyType checkDutyType)
	{
	    return checkDutyTypeMapper.insertCheckDutyType(checkDutyType);
	}
	
	/**
     * 修改值班类型
     * 
     * @param checkDutyType 值班类型信息
     * @return 结果
     */
	@Override
	public int updateCheckDutyType(CheckDutyType checkDutyType)
	{
	    return checkDutyTypeMapper.updateCheckDutyType(checkDutyType);
	}

	/**
     * 删除值班类型对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteCheckDutyTypeByIds(String ids)
	{
		return checkDutyTypeMapper.deleteCheckDutyTypeByIds(Convert.toStrArray(ids));
	}
	
}
