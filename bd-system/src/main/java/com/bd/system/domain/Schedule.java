package com.bd.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.bd.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 排班表 schedule
 * 
 * @author luxuewei
 * @date 2019-03-25
 */
public class Schedule extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 排班ID */
	private Integer scheduleId;
	/**  */
	private Integer shopId;
	private String shopName;
	/**  */
	private Integer shopPositionId;

	private String shopPositionName;
	/**  */
	private String charger;
	/**  */
	private String scheduleName;
	/**  */
	private String scheduleArea;
	/**  */
	private Date startTime;
	/**  */
	private Date endTime;

	public void setScheduleId(Integer scheduleId) 
	{
		this.scheduleId = scheduleId;
	}

	public Integer getScheduleId() 
	{
		return scheduleId;
	}
	public void setShopId(Integer shopId) 
	{
		this.shopId = shopId;
	}

	public Integer getShopId() 
	{
		return shopId;
	}
	public void setShopPositionId(Integer shopPositionId) 
	{
		this.shopPositionId = shopPositionId;
	}

	public Integer getShopPositionId() 
	{
		return shopPositionId;
	}
	public void setCharger(String charger) 
	{
		this.charger = charger;
	}

	public String getCharger() 
	{
		return charger;
	}
	public void setScheduleName(String scheduleName) 
	{
		this.scheduleName = scheduleName;
	}

	public String getScheduleName() 
	{
		return scheduleName;
	}
	public void setScheduleArea(String scheduleArea) 
	{
		this.scheduleArea = scheduleArea;
	}

	public String getScheduleArea() 
	{
		return scheduleArea;
	}
	public void setStartTime(Date startTime) 
	{
		this.startTime = startTime;
	}

	public Date getStartTime() 
	{
		return startTime;
	}
	public void setEndTime(Date endTime) 
	{
		this.endTime = endTime;
	}

	public Date getEndTime() 
	{
		return endTime;
	}

	@Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("scheduleId", getScheduleId())
            .append("shopId", getShopId())
            .append("shopPositionId", getShopPositionId())
            .append("charger", getCharger())
            .append("scheduleName", getScheduleName())
            .append("scheduleArea", getScheduleArea())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
