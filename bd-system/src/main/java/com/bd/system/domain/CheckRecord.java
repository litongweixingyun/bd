package com.bd.system.domain;

import com.bd.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 检查记录表 check_record
 * 
 * @author luxuewei
 * @date 2019-04-21
 */
public class CheckRecord extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Integer checkRecordId;
	/**  */
	private Integer deptId;
	/**  */
	private Integer shopId;
	/**  */
	private String createBy;
	/**  */
	private Date createTime;
	/**  */
	private Integer status;
	/**  */
	private Date completeTime;
	/**  */
	private Integer problems;
	/**  */
	private Integer changed;
	/**  */
	private BigDecimal totalScore;
	/**  */
	private Integer checkNum;

	public void setCheckRecordId(Integer checkRecordId) 
	{
		this.checkRecordId = checkRecordId;
	}

	public Integer getCheckRecordId() 
	{
		return checkRecordId;
	}
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
	public void setCreateBy(String createBy) 
	{
		this.createBy = createBy;
	}

	public String getCreateBy() 
	{
		return createBy;
	}
	public void setCreateTime(Date createTime) 
	{
		this.createTime = createTime;
	}

	public Date getCreateTime() 
	{
		return createTime;
	}
	public void setStatus(Integer status) 
	{
		this.status = status;
	}

	public Integer getStatus() 
	{
		return status;
	}
	public void setCompleteTime(Date completeTime) 
	{
		this.completeTime = completeTime;
	}

	public Date getCompleteTime() 
	{
		return completeTime;
	}
	public void setProblems(Integer problems) 
	{
		this.problems = problems;
	}

	public Integer getProblems() 
	{
		return problems;
	}
	public void setChanged(Integer changed) 
	{
		this.changed = changed;
	}

	public Integer getChanged() 
	{
		return changed;
	}
	public void setTotalScore(BigDecimal totalScore) 
	{
		this.totalScore = totalScore;
	}

	public BigDecimal getTotalScore() 
	{
		return totalScore;
	}
	public void setCheckNum(Integer checkNum) 
	{
		this.checkNum = checkNum;
	}

	public Integer getCheckNum() 
	{
		return checkNum;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("checkRecordId", getCheckRecordId())
            .append("deptId", getDeptId())
            .append("shopId", getShopId())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("status", getStatus())
            .append("completeTime", getCompleteTime())
            .append("problems", getProblems())
            .append("changed", getChanged())
            .append("totalScore", getTotalScore())
            .append("checkNum", getCheckNum())
            .toString();
    }
}
