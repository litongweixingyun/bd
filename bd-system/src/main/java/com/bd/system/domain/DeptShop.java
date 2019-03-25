package com.bd.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.bd.common.core.domain.BaseEntity;

/**
 * 部门和店铺关联表 sys_dept_shop
 * 
 * @author luxuewei
 * @date 2019-03-25
 */
public class DeptShop extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 部门ID */
	private Integer deptId;
	/** 店铺ID */
	private Integer shopId;
	/** 已经巡店次数 */
	private Integer checkNum;

	public void setDeptId(Integer deptId) 
	{
		this.deptId = deptId;
	}

	public Integer getDeptId() 
	{
		return deptId;
	}
	public void setShopId(Integer shopId) 
	{
		this.shopId = shopId;
	}

	public Integer getShopId() 
	{
		return shopId;
	}
	public void setCheckNum(Integer checkNum)
	{
		this.checkNum = checkNum;
	}

	public Integer getCheckNum() 
	{
		return checkNum;
	}

	@Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("deptId", getDeptId())
            .append("shopId", getShopId())
            .append("checkNum", getCheckNum())
            .toString();
    }
}
