package com.bd.system.domain;

import com.bd.common.core.domain.BaseEntity;
import lombok.Data;

/**
 * 店铺岗位表 shop_position
 * 
 * @author luxuewei
 * @date 2019-03-26
 */
@Data
public class ShopPosition extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 岗位ID */
	private Integer positionId;
	/** 店铺ID */
	private Integer shopId;

	private String shopName;
	/**  */
	private String positionName;


}
