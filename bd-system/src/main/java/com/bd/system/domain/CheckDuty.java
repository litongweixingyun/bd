package com.bd.system.domain;

import com.bd.common.annotation.Excel;
import com.bd.common.annotation.Excel.Type;
import com.bd.common.core.domain.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 值班表   check_duty
 *
 * @author yuanqingjian
 * @date 2019-07-09
 *
 */
public class CheckDuty extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Excel(name = "值班序号", prompt = "值班编号")
	private Integer dutyId;//值班id

	@Excel(name = "检查人姓名")
	private String dutyName;//检查人姓名
	@Excel(name = "检查时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss", type = Type.EXPORT)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dutyTime;//检查时间
	@Excel(name = "部门ID")
	private Integer deptId;//部门ID
	@Excel(name = "部门名称")
	private String deptName;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Integer getDutyId() {
		return dutyId;
	}

	public void setDutyId(Integer dutyId) {
		this.dutyId = dutyId;
	}

	public String getDutyName() {
		return dutyName;
	}

	public void setDutyName(String dutyName) {
		this.dutyName = dutyName;
	}

	public Date getDutyTime() {
		return dutyTime;
	}

	public void setDutyTime(Date dutyTime) {
		this.dutyTime = dutyTime;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

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
}
