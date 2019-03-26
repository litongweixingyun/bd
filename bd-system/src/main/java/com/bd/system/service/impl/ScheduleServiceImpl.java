package com.bd.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bd.system.mapper.ScheduleMapper;
import com.bd.system.domain.Schedule;
import com.bd.system.service.IScheduleService;
import com.bd.common.core.text.Convert;

/**
 * 店内排班 服务层实现
 * 
 * @author luxuewei
 * @date 2019-03-26
 */
@Service
public class ScheduleServiceImpl implements IScheduleService 
{
	@Autowired
	private ScheduleMapper scheduleMapper;

	/**
     * 查询店内排班信息
     * 
     * @param scheduleId 店内排班ID
     * @return 店内排班信息
     */
    @Override
	public Schedule selectScheduleById(Integer scheduleId)
	{
	    return scheduleMapper.selectScheduleById(scheduleId);
	}
	
	/**
     * 查询店内排班列表
     * 
     * @param schedule 店内排班信息
     * @return 店内排班集合
     */
	@Override
	public List<Schedule> selectScheduleList(Schedule schedule)
	{
	    return scheduleMapper.selectScheduleList(schedule);
	}
	
    /**
     * 新增店内排班
     * 
     * @param schedule 店内排班信息
     * @return 结果
     */
	@Override
	public int insertSchedule(Schedule schedule)
	{
	    return scheduleMapper.insertSchedule(schedule);
	}
	
	/**
     * 修改店内排班
     * 
     * @param schedule 店内排班信息
     * @return 结果
     */
	@Override
	public int updateSchedule(Schedule schedule)
	{
	    return scheduleMapper.updateSchedule(schedule);
	}

	/**
     * 删除店内排班对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteScheduleByIds(String ids)
	{
		return scheduleMapper.deleteScheduleByIds(Convert.toStrArray(ids));
	}
	
}
