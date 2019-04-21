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
 * @author luxuewei
 * @date 2019-04-21
 */
@Data
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


	private String deptName ;

	private String shopName ;

	private List<CheckProblemItem> itemList = new ArrayList<>();

}
