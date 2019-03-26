package com.bd.system.service;

import com.bd.system.domain.Schedule;
import java.util.List;

/**
 * 店内排班 服务层
 * 
 * @author luxuewei
 * @date 2019-03-26
 */
public interface IScheduleService 
{
	/**
     * 查询店内排班信息
     * 
     * @param scheduleId 店内排班ID
     * @return 店内排班信息
     */
	public Schedule selectScheduleById(Integer scheduleId);
	
	/**
     * 查询店内排班列表
     * 
     * @param schedule 店内排班信息
     * @return 店内排班集合
     */
	public List<Schedule> selectScheduleList(Schedule schedule);
	
	/**
     * 新增店内排班
     * 
     * @param schedule 店内排班信息
     * @return 结果
     */
	public int insertSchedule(Schedule schedule);
	
	/**
     * 修改店内排班
     * 
     * @param schedule 店内排班信息
     * @return 结果
     */
	public int updateSchedule(Schedule schedule);
		
	/**
     * 删除店内排班信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteScheduleByIds(String ids);
	
}
