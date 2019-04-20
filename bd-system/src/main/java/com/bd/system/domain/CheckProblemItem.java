package com.bd.system.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.bd.common.core.domain.BaseEntity;

/**
 * 巡店大项问题表 check_problem_Item
 * 
 * @author luxuewei
 * @date 2019-04-20
 */
@Data
public class CheckProblemItem extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 巡店问题详情ID */
	private Integer problemItemId;
	/** 部门id */
	private Integer deptId;
	/** 店铺id */
	private Integer shopId;
	/** 大项id */
	private Integer itemId;
	private Integer subItemId;
	/** 大项总份 */
	private Integer itemScore;
	/** 巡店记录Id */
	private Integer checkRecordId;

}
