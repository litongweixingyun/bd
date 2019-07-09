package com.bd.system.domain;

import com.bd.common.core.domain.BaseEntity;
import com.bd.system.vo.CheckDutyTypeVo;

import java.util.List;

/**
 * 值班类型表 check_duty_type
 * 
 * @author luxuewei
 * @date 2019-06-28
 */
public class CheckDutyType extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Integer dctId;
	/** 检查负责人id */
	private String dutyId;
	private String dutyName;
	/** 检查图片 */
	private String pictuer;
	/** 检查得分 */
	private Integer score;
	/** 检查项id（39-62表sys_dict_date） */
	private String dictLabel;
	private String dictLabel1;
	private String dictLabel2;

	private String dictCode;
	/** 检测评价 */
	private String dictCode1;
	private String dictCode2;



	@Override
	public String toString() {
		return "CheckDutyType{" +
				"dctId=" + dctId +
				", dutyId='" + dutyId + '\'' +
				", dutyName='" + dutyName + '\'' +
				", pictuer='" + pictuer + '\'' +
				", score=" + score +
				", dictLabel='" + dictLabel + '\'' +
				", dictLabel1='" + dictLabel1 + '\'' +
				", dictLabel2='" + dictLabel2 + '\'' +
				", dictCode='" + dictCode + '\'' +
				", dictCode1='" + dictCode1 + '\'' +
				", dictCode2='" + dictCode2 + '\'' +

				'}';
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

	public String getDictLabel() {
		return dictLabel;
	}

	public void setDictLabel(String dictLabel) {
		this.dictLabel = dictLabel;
	}


	public String getDictCode() {
		return dictCode;
	}

	public void setDictCode(String dictCode) {
		this.dictCode = dictCode;
	}

	public String getDictCode1() {
		return dictCode1;
	}

	public void setDictCode1(String dictCode1) {
		this.dictCode1 = dictCode1;
	}

	public String getDictCode2() {
		return dictCode2;
	}

	public void setDictCode2(String dictCode2) {
		this.dictCode2 = dictCode2;
	}



	public void setVoList(List<CheckDutyTypeVo> voList) {
		this.voList = voList;
	}

	private List<CheckDutyTypeVo> voList;

}
