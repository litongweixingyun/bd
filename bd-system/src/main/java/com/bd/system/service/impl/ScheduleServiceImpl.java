package com.bd.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bd.system.mapper.ScheduleMapper;
import com.bd.system.domain.Schedule;
import com.bd.system.service.IScheduleService;
import com.bd.common.core.text.Convert;

/**
 * 排班 服务层实现
 * 
 * @author luxuewei
 * @date 2019-03-25
 */
@Service
public class ScheduleServiceImpl implements IScheduleService 
{
	@Autowired
	private ScheduleMapper scheduleMapper;

	/**
     * 查询排班信息
     * 
     * @param scheduleId 排班ID
     * @return 排班信息
     */
    @Override
	public Schedule selectScheduleById(Integer scheduleId)
	{
	    return scheduleMapper.selectScheduleById(scheduleId);
	}
	
	/**
     * 查询排班列表
     * 
     * @param schedule 排班信息
     * @return 排班集合
     */
	@Override
	public List<Schedule> selectScheduleList(Schedule schedule)
	{
	    return scheduleMapper.selectScheduleList(schedule);
	}
	
    /**
     * 新增排班
     * 
     * @param schedule 排班信息
     * @return 结果
     */
	@Override
	public int insertSchedule(Schedule schedule)
	{
	    return scheduleMapper.insertSchedule(schedule);
	}
	
	/**
     * 修改排班
     * 
     * @param schedule 排班信息
     * @return 结果
     */
	@Override
	public int updateSchedule(Schedule schedule)
	{
	    return scheduleMapper.updateSchedule(schedule);
	}

	/**
     * 删除排班对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteScheduleByIds(String ids)
	{
		return scheduleMapper.deleteScheduleByIds(Convert.toStrArray(ids));
	}

	@Override
	public Schedule selectScheduleByShopIdAndShopPositionId(Long shopId, Long shopPositionId) {
		return scheduleMapper.selectScheduleByShopIdAndShopPositionId(shopId,shopPositionId);
	}

}
