package com.bd.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.bd.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 巡店明细问题表 check_problem_sub_Item
 * 
 * @author luxuewei
 * @date 2019-04-20
 */
public class CheckProblemSubItem extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 巡店问题详情ID */
	private Integer problemSubItemId;
	/** 大项问题表id */
	private Integer problemItemId;
	/** 店铺id */
	private Integer score;
	/** 图片地址 */
	private String picUrl;
	/** 问题描述 */
	private String description;
	/** 创建时间 */
	private Date createTime;

	public void setProblemSubItemId(Integer problemSubItemId) 
	{
		this.problemSubItemId = problemSubItemId;
	}

	public Integer getProblemSubItemId() 
	{
		return problemSubItemId;
	}
	public void setProblemItemId(Integer problemItemId) 
	{
		this.problemItemId = problemItemId;
	}

	public Integer getProblemItemId() 
	{
		return problemItemId;
	}
	public void setScore(Integer score) 
	{
		this.score = score;
	}

	public Integer getScore() 
	{
		return score;
	}
	public void setPicUrl(String picUrl) 
	{
		this.picUrl = picUrl;
	}

	public String getPicUrl() 
	{
		return picUrl;
	}
	public void setDescription(String description) 
	{
		this.description = description;
	}

	public String getDescription() 
	{
		return description;
	}
	public void setCreateTime(Date createTime) 
	{
		this.createTime = createTime;
	}

	public Date getCreateTime() 
	{
		return createTime;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("problemSubItemId", getProblemSubItemId())
            .append("problemItemId", getProblemItemId())
            .append("score", getScore())
            .append("picUrl", getPicUrl())
            .append("description", getDescription())
            .append("createTime", getCreateTime())
            .toString();
    }
}
