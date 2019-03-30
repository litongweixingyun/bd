package com.bd.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.bd.common.core.domain.BaseEntity;

/**
 * 检查问题表 sys_problem
 * 
 * @author luxuewei
 * @date 2019-03-30
 */
public class Problem extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 问题ID */
	private Integer problemId;
	/** 问题名字 */
	private String problemName;
	/** 备注 */
	private String remark;

	public void setProblemId(Integer problemId) 
	{
		this.problemId = problemId;
	}

	public Integer getProblemId() 
	{
		return problemId;
	}
	public void setProblemName(String problemName) 
	{
		this.problemName = problemName;
	}

	public String getProblemName() 
	{
		return problemName;
	}
	public void setRemark(String remark) 
	{
		this.remark = remark;
	}

	public String getRemark() 
	{
		return remark;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("problemId", getProblemId())
            .append("problemName", getProblemName())
            .append("remark", getRemark())
            .toString();
    }
}
