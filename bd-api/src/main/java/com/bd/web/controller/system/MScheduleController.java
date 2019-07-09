package com.bd.web.controller.system;

import com.bd.common.core.controller.BaseController;
import com.bd.common.core.domain.AjaxResult;
import com.bd.system.domain.Schedule;
import com.bd.system.service.IScheduleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 排班 信息操作处理
 * 
 * @author luxuewei
 * @date 2019-03-25
 */
@Slf4j
@RestController
@RequestMapping("/mobile/shop")
public class MScheduleController extends BaseController
{

	@Resource
	private IScheduleService scheduleService;
	
	@PostMapping("/scheduleConfig")
	public AjaxResult schedule(Schedule schedule) {
		return toAjax(scheduleService.insertSchedule(schedule));
	}

	@GetMapping("/getSchedule/{shopId}/{shopPositionId}")
	public Schedule getSchedule(@PathVariable("shopId") Long shopId,@PathVariable("shopPositionId") Long shopPositionId){
		//return scheduleService.selectScheduleByShopIdAndShopPositionId(shopId,shopPositionId);
		return null ;
	}

}
