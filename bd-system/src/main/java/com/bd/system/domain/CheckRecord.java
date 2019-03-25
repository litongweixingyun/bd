package com.bd.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.bd.common.core.domain.BaseEntity;

import java.math.BigDecimal;

/**
 * 检查记录表 check_record
 * 
 * @author luxuewei
 * @date 2019-03-25
 */
public class CheckRecord extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Integer checkRecordId;
	/**  */
	private Integer deptId;
	private String deptName;
	/**  */
	private Integer shopId;
	private String shopName;
	/**  */
	private Integer problems;
	/**  */
	private Integer changed;
	/**  */
	private BigDecimal totalScore;
	/**  */
	private BigDecimal security;
	/**  */
	private BigDecimal service;
	/**  */
	private BigDecimal chupin;
	/**  */
	private BigDecimal environment;
	/**  */
	private BigDecimal finance;
	/**  */
	private BigDecimal personnal;
	/**  */
	private BigDecimal sanliulingDu;
	/**  */
	private BigDecimal execution;

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
	public void setSecurity(BigDecimal security) 
	{
		this.security = security;
	}

	public BigDecimal getSecurity() 
	{
		return security;
	}
	public void setService(BigDecimal service) 
	{
		this.service = service;
	}

	public BigDecimal getService() 
	{
		return service;
	}
	public void setChupin(BigDecimal chupin) 
	{
		this.chupin = chupin;
	}

	public BigDecimal getChupin() 
	{
		return chupin;
	}
	public void setEnvironment(BigDecimal environment) 
	{
		this.environment = environment;
	}

	public BigDecimal getEnvironment() 
	{
		return environment;
	}
	public void setFinance(BigDecimal finance) 
	{
		this.finance = finance;
	}

	public BigDecimal getFinance() 
	{
		return finance;
	}
	public void setPersonnal(BigDecimal personnal) 
	{
		this.personnal = personnal;
	}

	public BigDecimal getPersonnal() 
	{
		return personnal;
	}
	public void setSanliulingDu(BigDecimal sanliulingDu) 
	{
		this.sanliulingDu = sanliulingDu;
	}

	public BigDecimal getSanliulingDu() 
	{
		return sanliulingDu;
	}
	public void setExecution(BigDecimal execution) 
	{
		this.execution = execution;
	}

	public BigDecimal getExecution() 
	{
		return execution;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("checkRecordId", getCheckRecordId())
            .append("deptId", getDeptId())
            .append("shopId", getShopId())
            .append("problems", getProblems())
            .append("changed", getChanged())
            .append("totalScore", getTotalScore())
            .append("security", getSecurity())
            .append("service", getService())
            .append("chupin", getChupin())
            .append("environment", getEnvironment())
            .append("finance", getFinance())
            .append("personnal", getPersonnal())
            .append("sanliulingDu", getSanliulingDu())
            .append("execution", getExecution())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
