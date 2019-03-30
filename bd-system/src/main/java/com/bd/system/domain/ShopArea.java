package com.bd.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.bd.common.core.domain.BaseEntity;

/**
 * 店铺区域表 shop_area
 * 
 * @author luxuewei
 * @date 2019-03-30
 */
public class ShopArea extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 店内区域ID */
	private Integer areaId;
	/** 区域名称 */
	private String areaName;
	/** 上级区域ID */
	private Integer parentId;

	public void setAreaId(Integer areaId) 
	{
		this.areaId = areaId;
	}

	public Integer getAreaId() 
	{
		return areaId;
	}
	public void setAreaName(String areaName) 
	{
		this.areaName = areaName;
	}

	public String getAreaName() 
	{
		return areaName;
	}
	public void setParentId(Integer parentId) 
	{
		this.parentId = parentId;
	}

	public Integer getParentId() 
	{
		return parentId;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("areaId", getAreaId())
            .append("areaName", getAreaName())
            .append("parentId", getParentId())
            .toString();
    }
}
