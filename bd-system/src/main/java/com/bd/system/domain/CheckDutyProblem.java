package com.bd.system.domain;

import com.bd.common.core.domain.BaseEntity;

/**
 * 值班问题表 check_duty_problem
 * 
 * @author luxuewei
 * @date 2019-07-11
 */
public class CheckDutyProblem extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 问题ID */
	private Integer problemId;
	/** 问题名字 */
	private String problemName;
    /*状态 完成或者未完成*/
	private String starts;
    /*得分*/
	private String zScore;

	public String getStarts() {
		return starts;
	}

	public void setStarts(String starts) {
		this.starts = starts;
	}

	public String getzScore() {
		return zScore;
	}

	public void setzScore(String zScore) {
		this.zScore = zScore;
	}

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

	@Override
	public String toString() {
		return "CheckDutyProblem{" +
				"problemId=" + problemId +
				", problemName='" + problemName + '\'' +
				", starts='" + starts + '\'' +
				", zScore='" + zScore + '\'' +
				'}';
	}
}
