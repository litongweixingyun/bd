package com.bd.system.service;

import com.bd.system.domain.CheckDuty;
import java.util.List;

/**
 * 值班 服务层
 *
 * @author yuanqingjian
 * @date 2019-07-09
 */
public interface ICheckDutyService {

	/**
	 * 根据值班Id查询值班信息
	 *
	 * @param dutyId 值班ID
	 * @return 值班信息
	 */
	public CheckDuty selectCheckDutyById(Integer dutyId);

	/**
	 * 根据条件分页查询值班列表
	 *
	 * @param checkDuty 值班信息
	 * @return 值班集合
	 */
	public List<CheckDuty> selectCheckDutyList(CheckDuty checkDuty);

	/**
	 * 新增值班信息
	 *
	 * @param checkDuty 值班信息
	 * @return 结果
	 */
	public int insertCheckDuty(CheckDuty checkDuty);

	/**
	 * 修改值班信息
	 *
	 * @param checkDuty 值班信息
	 * @return 结果
	 */
	public int updateCheckDuty(CheckDuty checkDuty);

	/**
	 * 删除值班信息
	 *
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	public int deleteCheckDutyByIds(String ids);

}
