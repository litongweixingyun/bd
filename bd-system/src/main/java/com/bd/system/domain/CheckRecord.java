package com.bd.system.domain;

import com.bd.common.core.domain.BaseEntity;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 检查记录表 check_record
 *
 * @author yuanqingjian
 * @date 2019-07-05
 */
@Data
public class CheckRecord extends BaseEntity
{
	private static final long serialVersionUID = 1L;

	/** 检查记录ID */
	private Integer checkRecordId;
	/** 部门ID */
	private Integer deptId;
	/** 店铺ID */
	private Integer shopId;
	/** 检查者 */
	private String createBy;
	/** 检查时间 */
	private Date createTime;
	/** 状态 */
	private Integer status;
	/** 时间 */
	private Date completeTime;
	/** 问题 */
	private Integer problems;
	/** 整改后 */
	private Integer changed;
	/** 总分 */
	private BigDecimal totalScore;
	/** 检查次数 */
	private Integer checkNum;

	private String deptName ;

	private String shopName ;

	private List<CheckProblemItem> itemList = new ArrayList<>();


	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Integer getCheckRecordId() {
		return checkRecordId;
	}

	public void setCheckRecordId(Integer checkRecordId) {
		this.checkRecordId = checkRecordId;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public Integer getShopId() {
		return shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCompleteTime() {
		return completeTime;
	}

	public void setCompleteTime(Date completeTime) {
		this.completeTime = completeTime;
	}

	public Integer getProblems() {
		return problems;
	}

	public void setProblems(Integer problems) {
		this.problems = problems;
	}

	public Integer getChanged() {
		return changed;
	}

	public void setChanged(Integer changed) {
		this.changed = changed;
	}

	public BigDecimal getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(BigDecimal totalScore) {
		this.totalScore = totalScore;
	}

	public Integer getCheckNum() {
		return checkNum;
	}

	public void setCheckNum(Integer checkNum) {
		this.checkNum = checkNum;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public List<CheckProblemItem> getItemList() {
		return itemList;
	}

	public void setItemList(List<CheckProblemItem> itemList) {
		this.itemList = itemList;
	}

	@Override
	public String toString() {
		return "CheckRecord{" +
				"checkRecordId=" + checkRecordId +
				", deptId=" + deptId +
				", shopId=" + shopId +
				", createBy='" + createBy + '\'' +
				", createTime=" + createTime +
				", status=" + status +
				", completeTime=" + completeTime +
				", problems=" + problems +
				", changed=" + changed +
				", totalScore=" + totalScore +
				", checkNum=" + checkNum +
				", deptName='" + deptName + '\'' +
				", shopName='" + shopName + '\'' +
				", itemList=" + itemList +
				'}';
	}
}
