package com.bd.system.domain;

import com.bd.common.annotation.Excel;
import com.bd.common.core.domain.BaseEntity;

/**
 * 值班类型表 check_duty_type
 *
 * @author yuanqingjian
 * @date 2019-07-10
 */
public class CheckDutyType extends BaseEntity
{
	private static final long serialVersionUID = 1L;

	@Excel(name = "负责序号", prompt = "负责编号")
	private Integer dctId;
    /*检查段*/
	private String problemName;
	private String dutyId;//检查负责人id
	/*检查段id*/
	private Integer problemId;
    private String dutyName;
    private String pictuer;
    private Integer score;
    private Integer dictCode;
    private Integer dictCode1;
    private  Integer dictCode2;
    private Integer getProblemId;
	public String getProblemName() {
		return problemName;
	}


	public void setProblemName(String problemName) {
		this.problemName = problemName;
	}



	//	检查项id（39-62表sys_dict_date）
	@Excel(name = "检查项")
	private String dictLabel;
	@Excel(name = "检测内容")
	private String dictLabel1;
	@Excel(name = "检测评价")
	private String dictLabel2;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Integer getDctId() {
		return dctId;
	}

	public void setDctId(Integer dctId) {
		this.dctId = dctId;
	}

	public String getDutyId() {
		return dutyId;
	}

	public void setDutyId(String dutyId) {
		this.dutyId = dutyId;
	}

	public String getDutyName() {
		return dutyName;
	}

	public void setDutyName(String dutyName) {
		this.dutyName = dutyName;
	}

	public String getPictuer() {
		return pictuer;
	}

	public void setPictuer(String pictuer) {
		this.pictuer = pictuer;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Integer getDictCode() {
		return dictCode;
	}

	public void setDictCode(Integer dictCode) {
		this.dictCode = dictCode;
	}

	public Integer getDictCode1() {
		return dictCode1;
	}

	public void setDictCode1(Integer dictCode1) {
		this.dictCode1 = dictCode1;
	}

	public Integer getDictCode2() {
		return dictCode2;
	}

	public void setDictCode2(Integer dictCode2) {
		this.dictCode2 = dictCode2;
	}

	public String getDictLabel() {
		return dictLabel;
	}

	public void setDictLabel(String dictLabel) {
		this.dictLabel = dictLabel;
	}

	public String getDictLabel1() {
		return dictLabel1;
	}

	public void setDictLabel1(String dictLabel1) {
		this.dictLabel1 = dictLabel1;
	}

	public String getDictLabel2() {
		return dictLabel2;
	}

	public void setDictLabel2(String dictLabel2) {
		this.dictLabel2 = dictLabel2;
	}

	@Override
	public String toString() {
		return "CheckDutyType{" +
				"dctId=" + dctId +
				", dutyId='" + dutyId + '\'' +
				", dutyName='" + dutyName + '\'' +
				", pictuer='" + pictuer + '\'' +
				", score=" + score +
				", dictCode=" + dictCode +
				", dictCode1=" + dictCode1 +
				", dictCode2=" + dictCode2 +
				", dictLabel='" + dictLabel + '\'' +
				", dictLabel1='" + dictLabel1 + '\'' +
				", dictLabel2='" + dictLabel2 + '\'' +
				'}';
	}
}
