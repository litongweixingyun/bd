package com.bd.system.domain;

import com.bd.common.core.domain.BaseEntity;
import lombok.Data;

/**
 * 巡店配置表 sys_dept_shop
 * 
 * @author luxuewei
 * @date 2019-03-25
 */
@Data
public class DeptShop extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 部门ID */
	private Integer deptId;
	/** 店铺ID */
	private Integer shopId;
	/** 年月 */
	private String month;
	/** 可巡店次数 */
	private Integer checkNum;

	/** 自增id*/
    private Integer dsId;

	private String deptName;
	private String shopName;


}
