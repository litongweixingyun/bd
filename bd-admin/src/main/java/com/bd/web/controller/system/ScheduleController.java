package com.bd.web.controller.system;

import com.bd.common.annotation.Log;
import com.bd.common.core.controller.BaseController;
import com.bd.common.core.domain.AjaxResult;
import com.bd.common.core.page.TableDataInfo;
import com.bd.common.enums.BusinessType;
import com.bd.common.utils.poi.ExcelUtil;
import com.bd.system.domain.Schedule;
import com.bd.system.domain.Shop;
import com.bd.system.domain.ShopPosition;
import com.bd.system.domain.SysUser;
import com.bd.system.service.IScheduleService;
import com.bd.system.service.IShopPositionService;
import com.bd.system.service.IShopService;
import com.bd.system.service.ISysUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 店内排班 信息操作处理
 * 
 * @author luxuewei
 * @date 2019-03-26
 */
@Controller
@RequestMapping("/system/schedule")
public class ScheduleController extends BaseController
{
    private String prefix = "system/schedule";
	
	@Resource
	private IScheduleService scheduleService;
	@Resource
	private IShopService shopService;
	@Resource
	private ISysUserService userService;
	@Resource
	private IShopPositionService shopPositionService;
	
	@RequiresPermissions("system:schedule:view")
	@GetMapping()
	public String schedule()
	{
	    return prefix + "/schedule";
	}
	
	/**
	 * 查询店内排班列表
	 */
	@RequiresPermissions("system:schedule:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Schedule schedule)
	{
		startPage();
        List<Schedule> list = scheduleService.selectScheduleList(schedule);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出店内排班列表
	 */
	@RequiresPermissions("system:schedule:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Schedule schedule)
    {
    	List<Schedule> list = scheduleService.selectScheduleList(schedule);
        ExcelUtil<Schedule> util = new ExcelUtil<Schedule>(Schedule.class);
        return util.exportExcel(list, "schedule");
    }
	
	/**
	 * 新增店内排班
	 */
	@GetMapping("/add")
	public String add(ModelMap mmap)
	{
		mmap.put("users", userService.selectUserList(new SysUser()));
		mmap.put("shops", shopService.selectShopList(new Shop()));
		mmap.put("positions", shopPositionService.selectShopPositionList(new ShopPosition()));
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存店内排班
	 */
	@RequiresPermissions("system:schedule:add")
	@Log(title = "店内排班", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Schedule schedule)
	{		
		return toAjax(scheduleService.insertSchedule(schedule));
	}

	/**
	 * 修改店内排班
	 */
	@GetMapping("/edit/{scheduleId}")
	public String edit(@PathVariable("scheduleId") Integer scheduleId, ModelMap mmap)
	{
		Schedule schedule = scheduleService.selectScheduleById(scheduleId);
		mmap.put("schedule", schedule);
		mmap.put("users", userService.selectUserList(new SysUser()));
		mmap.put("shops", shopService.selectShopList(new Shop()));
		mmap.put("positions", shopPositionService.selectShopPositionList(new ShopPosition()));
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存店内排班
	 */
	@RequiresPermissions("system:schedule:edit")
	@Log(title = "店内排班", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Schedule schedule)
	{		
		return toAjax(scheduleService.updateSchedule(schedule));
	}
	
	/**
	 * 删除店内排班
	 */
	@RequiresPermissions("system:schedule:remove")
	@Log(title = "店内排班", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(scheduleService.deleteScheduleByIds(ids));
	}
	
}
