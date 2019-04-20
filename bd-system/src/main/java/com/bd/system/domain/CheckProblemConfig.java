package com.bd.system.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.bd.common.core.domain.BaseEntity;

/**
 * 巡店问题配置表 check_problem_config
 * 
 * @author luxuewei
 * @date 2019-04-20
 */
@Data
public class CheckProblemConfig extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 问题配置ID */
	private Integer problemConfigId;
	/** 部门id */
	private Integer deptId;
	/** 条目名称 */
	private String itemName;
	/** 占比 */
	private Integer percent;
	/** 每项扣分 */
	private Integer raction;
	/** 条目小项 */
	private String subItemName;
	/** 问题ID */
	private Integer problemId;


	private String deptName;
	private String problemName;
	private String dictLabel;
}
