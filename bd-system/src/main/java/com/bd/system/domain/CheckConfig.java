package com.bd.system.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.bd.common.core.domain.BaseEntity;

/**
 * 检查项配置表 check_config
 * 
 * @author luxuewei
 * @date 2019-04-20
 */
@Data
public class CheckConfig extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Integer checkConfigId;
	/** 部门id */
	private Integer deptId;
	/** 条目名称 */
	private Integer itemId;
	/** 占比 */
	private Integer percent;
	/** 每项扣分 */
	private Integer raction;


	private String deptName;

	private String itemName;



}
