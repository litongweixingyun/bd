package com.bd.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.bd.common.core.domain.BaseEntity;
	
/**
 * 店铺岗位关系表 shop_position
 * 
 * @author luxuewei
 * @date 2019-03-25
 */
public class ShopPosition extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Integer shopId;
	/**  */
	private Integer positionId;
	/**  */
	private String shopPositionName;
	/**  */
	private Integer sort;

	public void setShopId(Integer shopId) 
	{
		this.shopId = shopId;
	}

	public Integer getShopId() 
	{
		return shopId;
	}
	public void setPositionId(Integer positionId) 
	{
		this.positionId = positionId;
	}

	public Integer getPositionId() 
	{
		return positionId;
	}
	public void setShopPositionName(String shopPositionName) 
	{
		this.shopPositionName = shopPositionName;
	}

	public String getShopPositionName() 
	{
		return shopPositionName;
	}
	public void setSort(Integer sort) 
	{
		this.sort = sort;
	}

	public Integer getSort() 
	{
		return sort;
	}

	@Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("shopId", getShopId())
            .append("positionId", getPositionId())
            .append("shopPositionName", getShopPositionName())
            .append("sort", getSort())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
