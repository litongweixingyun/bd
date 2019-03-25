package com.bd.web.controller.mobile;

import com.bd.common.annotation.Log;
import com.bd.common.core.controller.BaseController;
import com.bd.common.core.domain.AjaxResult;
import com.bd.common.core.page.TableDataInfo;
import com.bd.common.enums.BusinessType;
import com.bd.common.utils.poi.ExcelUtil;
import com.bd.system.domain.Schedule;
import com.bd.system.service.IScheduleService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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
		return scheduleService.selectScheduleByShopIdAndShopPositionId(shopId,shopPositionId);
	}

}
