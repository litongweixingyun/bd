package com.bd.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.bd.common.core.domain.BaseEntity;

/**
 * 巡店问题表 check_problem
 * 
 * @author luxuewei
 * @date 2019-04-20
 */
public class CheckProblem extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 问题ID */
	private Integer problemId;
	/** 问题名字 */
	private String problemName;

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

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("problemId", getProblemId())
            .append("problemName", getProblemName())
            .toString();
    }
}
