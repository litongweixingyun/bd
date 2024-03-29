package com.bd.web.controller.system;

import com.bd.common.annotation.Log;
import com.bd.common.core.controller.BaseController;
import com.bd.common.core.domain.AjaxResult;
import com.bd.common.core.page.TableDataInfo;
import com.bd.common.enums.BusinessType;
import com.bd.common.utils.poi.ExcelUtil;
import com.bd.system.domain.*;
import com.bd.system.service.ICheckDutyService;
import com.bd.system.service.ISysDeptService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 值班 信息操作处理
 *
 * @author yuanqingjian
 * @date 2019-07-09
 */
@Controller
@RequestMapping("/system/checkDuty")
public class CheckDutyController extends BaseController {
	private String prefix = "system/checkDuty";

	@Autowired
	private ICheckDutyService checkDutyService;
	@Autowired
	private ISysDeptService deptService;

	@RequiresPermissions("system:checkDuty:view")
	@GetMapping()
	public String checkDuty()
	{
		return prefix + "/checkDuty";
	}

	/**
	 * 根据条件分页查询值班列表
	 *
	 */
	@RequiresPermissions("system:checkDuty:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(CheckDuty checkDuty) {
		startPage();
		List<CheckDuty> list = checkDutyService.selectCheckDutyList(checkDuty);
		return getDataTable(list);
	}

	/**
	 * 导出值班数据列表
	 */
	@Log(title = "值班管理", businessType = BusinessType.EXPORT)
	@RequiresPermissions("system:checkDuty:export")
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(CheckDuty checkDuty)
	{
		List<CheckDuty> list = checkDutyService.selectCheckDutyList(checkDuty);
		ExcelUtil<CheckDuty> util = new ExcelUtil<CheckDuty>(CheckDuty.class);
		return util.exportExcel(list, "值班数据");
	}

	/**
	 * 新增值班
	 *
	 */

	@GetMapping("/add")
	public String add(ModelMap mmap){
		mmap.put("depts",deptService.selectDeptList(new SysDept()));
		return prefix + "/add";
	}


	/**
	 * 新增保存值班
	 *
	 */
	@RequiresPermissions("system:checkDuty:add")
	@Log(title = "值班", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(CheckDuty checkDuty)
	{
		return toAjax(checkDutyService.insertCheckDuty(checkDuty));
	}

	/**
	 * 修改值班
	 *
	 */
	@GetMapping("/edit/{dutyId}")
	public String edit(@PathVariable("dutyId") Integer dutyId, ModelMap mmap)
	{
		CheckDuty checkDuty = checkDutyService.selectCheckDutyById(dutyId);
		mmap.put("checkDuty", checkDuty);
		mmap.put("depts",deptService.selectDeptList(new SysDept()));
		return prefix + "/edit";
	}

	/**
	 * 修改保存值班信息
	 */
	@RequiresPermissions("system:checkDuty:edit")
	@Log(title = "值班", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(CheckDuty checkDuty)
	{
		return toAjax(checkDutyService.updateCheckDuty(checkDuty));
	}

	/**
	 * 删除值班
	 */
	@RequiresPermissions("system:checkDuty:remove")
	@Log(title = "值班", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{
		return toAjax(checkDutyService.deleteCheckDutyByIds(ids));
	}

}
