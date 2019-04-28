package com.bd.system.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.bd.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 巡店明细问题表 check_problem_sub_Item
 * 
 * @author luxuewei
 * @date 2019-04-20
 */
@Data
public class CheckProblemSubItem extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 巡店问题详情ID */
	private Integer problemSubItemId;
	/** 大项问题表id */
	private Integer problemItemId;
	/** 店铺id */
	private Integer score;
	/** 图片地址 */
	private String picUrl;
	/** 问题描述 */
	private String description;
	/** 创建时间 */
	private Date createTime;

	private String problemName ;

	private Integer status;

	private Date changedTime;

	private String changedPicUrl;


}
