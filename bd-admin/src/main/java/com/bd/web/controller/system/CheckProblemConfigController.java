package com.bd.web.controller.system;

import java.util.List;

import com.bd.system.domain.CheckProblem;
import com.bd.system.domain.SysDept;
import com.bd.system.service.ICheckConfigService;
import com.bd.system.service.ICheckProblemService;
import com.bd.system.service.ISysDeptService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bd.common.annotation.Log;
import com.bd.common.enums.BusinessType;
import com.bd.system.domain.CheckProblemConfig;
import com.bd.system.service.ICheckProblemConfigService;
import com.bd.common.core.controller.BaseController;
import com.bd.common.core.page.TableDataInfo;
import com.bd.common.core.domain.AjaxResult;
import com.bd.common.utils.poi.ExcelUtil;

/**
 * 巡店问题配置 信息操作处理
 * 
 * @author luxuewei
 * @date 2019-04-20
 */
@Controller
@RequestMapping("/system/checkProblemConfig")
public class CheckProblemConfigController extends BaseController
{
    private String prefix = "system/checkProblemConfig";
	
	@Autowired
	private ICheckProblemConfigService checkProblemConfigService;
	@Autowired
	private ISysDeptService deptService;
	@Autowired
	private ICheckConfigService checkConfigService;
	@Autowired
	private ICheckProblemService checkProblemService;
	
	@RequiresPermissions("system:checkProblemConfig:view")
	@GetMapping()
	public String checkProblemConfig()
	{
	    return prefix + "/checkProblemConfig";
	}
	
	/**
	 * 查询巡店问题配置列表
	 */
	@RequiresPermissions("system:checkProblemConfig:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(CheckProblemConfig checkProblemConfig)
	{
		startPage();
        List<CheckProblemConfig> list = checkProblemConfigService.selectCheckProblemConfigList(checkProblemConfig);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出巡店问题配置列表
	 */
	@RequiresPermissions("system:checkProblemConfig:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CheckProblemConfig checkProblemConfig)
    {
    	List<CheckProblemConfig> list = checkProblemConfigService.selectCheckProblemConfigList(checkProblemConfig);
        ExcelUtil<CheckProblemConfig> util = new ExcelUtil<CheckProblemConfig>(CheckProblemConfig.class);
        return util.exportExcel(list, "checkProblemConfig");
    }
	
	/**
	 * 新增巡店问题配置
	 */
	@GetMapping("/add")
	public String add(ModelMap mmap)
	{
		mmap.put("depts", deptService.selectDeptList(new SysDept()));
		mmap.put("problems", checkProblemService.selectCheckProblemList(new CheckProblem()));
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存巡店问题配置
	 */
	@RequiresPermissions("system:checkProblemConfig:add")
	@Log(title = "巡店问题配置", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(CheckProblemConfig checkProblemConfig)
	{		
		return toAjax(checkProblemConfigService.insertCheckProblemConfig(checkProblemConfig));
	}

	/**
	 * 修改巡店问题配置
	 */
	@GetMapping("/edit/{problemConfigId}")
	public String edit(@PathVariable("problemConfigId") Integer problemConfigId, ModelMap mmap)
	{
		CheckProblemConfig checkProblemConfig = checkProblemConfigService.selectCheckProblemConfigById(problemConfigId);
		mmap.put("checkProblemConfig", checkProblemConfig);
		mmap.put("depts", deptService.selectDeptList(new SysDept()));
		mmap.put("problems", checkProblemService.selectCheckProblemList(new CheckProblem()));
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存巡店问题配置
	 */
	@RequiresPermissions("system:checkProblemConfig:edit")
	@Log(title = "巡店问题配置", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(CheckProblemConfig checkProblemConfig)
	{		
		return toAjax(checkProblemConfigService.updateCheckProblemConfig(checkProblemConfig));
	}
	
	/**
	 * 删除巡店问题配置
	 */
	@RequiresPermissions("system:checkProblemConfig:remove")
	@Log(title = "巡店问题配置", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(checkProblemConfigService.deleteCheckProblemConfigByIds(ids));
	}
	
}
