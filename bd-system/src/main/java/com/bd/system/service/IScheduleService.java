package com.bd.system.service;

import com.bd.system.domain.Schedule;
import java.util.List;

/**
 * 排班 服务层
 * 
 * @author luxuewei
 * @date 2019-03-25
 */
public interface IScheduleService 
{
	/**
     * 查询排班信息
     * 
     * @param scheduleId 排班ID
     * @return 排班信息
     */
	public Schedule selectScheduleById(Integer scheduleId);
	
	/**
     * 查询排班列表
     * 
     * @param schedule 排班信息
     * @return 排班集合
     */
	public List<Schedule> selectScheduleList(Schedule schedule);
	
	/**
     * 新增排班
     * 
     * @param schedule 排班信息
     * @return 结果
     */
	public int insertSchedule(Schedule schedule);
	
	/**
     * 修改排班
     * 
     * @param schedule 排班信息
     * @return 结果
     */
	public int updateSchedule(Schedule schedule);
		
	/**
     * 删除排班信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteScheduleByIds(String ids);

	Schedule selectScheduleByShopIdAndShopPositionId(Long shopId, Long shopPositionId);
}
