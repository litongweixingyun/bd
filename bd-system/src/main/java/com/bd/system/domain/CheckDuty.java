package com.bd.system.domain;

import com.bd.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 值班表 check_duty
 * 
 * @author luxuewei
 * @date 2019-06-27
 */
public class CheckDuty extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 值班id */
	private Integer dutyId;
	/** 检查人姓名 */
	private String dutyName;
	/** 检查时间 */
	private Date dutyTime;
	/** 负责人所属部门（sys_dept表） */
	private Integer deptId;

	private String deptName;

	@Override
	public String toString() {
		return "CheckDuty{" +
				"dutyId=" + dutyId +
				", dutyName='" + dutyName + '\'' +
				", dutyTime=" + dutyTime +
				", deptId=" + deptId +
				", deptName='" + deptName + '\'' +
				'}';
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public void setDutyId(Integer dutyId)
	{
		this.dutyId = dutyId;
	}

	public Integer getDutyId() 
	{
		return dutyId;
	}
	public void setDutyName(String dutyName) 
	{
		this.dutyName = dutyName;
	}

	public String getDutyName() 
	{
		return dutyName;
	}
	public void setDutyTime(Date dutyTime) 
	{
		this.dutyTime = dutyTime;
	}

	public Date getDutyTime() 
	{
		return dutyTime;
	}
	public void setDeptId(Integer deptId) 
	{
		this.deptId = deptId;
	}

	public Integer getDeptId() 
	{
		return deptId;
	}

}
