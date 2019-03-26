package com.bd.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.bd.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 店内排班表 schedule
 * 
 * @author luxuewei
 * @date 2019-03-26
 */
@Data
public class Schedule extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 排班ID */
	private Integer scheduleId;
	/** 店铺ID */
	private Integer shopId;

	/** 岗位ID */
	private Integer positionId;
	/** 用户ID */
	private Integer userId;
	/** 负责区域 */
	private String scheduleArea;
	/** 开始时间 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date startTime;
	/** 结束时间 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date endTime;


	private String shopName;
	private String positionName;
	private String userName;



}
