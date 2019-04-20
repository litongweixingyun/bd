package com.bd.web.controller.system;

import java.util.List;

import com.bd.system.domain.CheckProblem;
import com.bd.system.domain.Shop;
import com.bd.system.domain.SysDept;
import com.bd.system.service.ICheckProblemService;
import com.bd.system.service.ISysDeptService;
import org.apache.commons.collections.CollectionUtils;
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
import com.bd.system.domain.CheckConfig;
import com.bd.system.service.ICheckConfigService;
import com.bd.common.core.controller.BaseController;
import com.bd.common.core.page.TableDataInfo;
import com.bd.common.core.domain.AjaxResult;
import com.bd.common.utils.poi.ExcelUtil;

/**
 * 检查项配置 信息操作处理
 * 
 * @author luxuewei
 * @date 2019-04-20
 */
@Controller
@RequestMapping("/system/checkConfig")
public class CheckConfigController extends BaseController
{
    private String prefix = "system/checkConfig";
	
	@Autowired
	private ICheckConfigService checkConfigService;
	@Autowired
	private ISysDeptService deptService;

	
	@RequiresPermissions("system:checkConfig:view")
	@GetMapping()
	public String checkConfig()
	{
	    return prefix + "/checkConfig";
	}
	
	/**
	 * 查询检查项配置列表
	 */
	@RequiresPermissions("system:checkConfig:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(CheckConfig checkConfig)
	{
		startPage();
        List<CheckConfig> list = checkConfigService.selectCheckConfigList(checkConfig);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出检查项配置列表
	 */
	@RequiresPermissions("system:checkConfig:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CheckConfig checkConfig)
    {
    	List<CheckConfig> list = checkConfigService.selectCheckConfigList(checkConfig);
        ExcelUtil<CheckConfig> util = new ExcelUtil<CheckConfig>(CheckConfig.class);
        return util.exportExcel(list, "checkConfig");
    }
	
	/**
	 * 新增检查项配置
	 */
	@GetMapping("/add")
	public String add(ModelMap mmap)
	{
		mmap.put("depts", deptService.selectDeptList(new SysDept()));

	    return prefix + "/add";
	}
	
	/**
	 * 新增保存检查项配置
	 */
	@RequiresPermissions("system:checkConfig:add")
	@Log(title = "检查项配置", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(CheckConfig checkConfig)
	{		
		return toAjax(checkConfigService.insertCheckConfig(checkConfig));
	}

	/**
	 * 修改检查项配置
	 */
	@GetMapping("/edit/{checkConfigId}")
	public String edit(@PathVariable("checkConfigId") Integer checkConfigId, ModelMap mmap)
	{
		CheckConfig checkConfig = checkConfigService.selectCheckConfigById(checkConfigId);
		mmap.put("checkConfig", checkConfig);
		mmap.put("depts", deptService.selectDeptList(new SysDept()));
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存检查项配置
	 */
	@RequiresPermissions("system:checkConfig:edit")
	@Log(title = "检查项配置", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(CheckConfig checkConfig)
	{		
		return toAjax(checkConfigService.updateCheckConfig(checkConfig));
	}
	
	/**
	 * 删除检查项配置
	 */
	@RequiresPermissions("system:checkConfig:remove")
	@Log(title = "检查项配置", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(checkConfigService.deleteCheckConfigByIds(ids));
	}



	@GetMapping("/itemlist/{deptId}")
	@ResponseBody
	public List<CheckConfig> itemlist(@PathVariable("deptId") Integer deptId)
	{
		CheckConfig checkConfig =  new CheckConfig();
		checkConfig.setDeptId(deptId);
		return checkConfigService.selectCheckConfigList(checkConfig);
	}

	@GetMapping("/itemlist/{deptId}/{itemId}")
	@ResponseBody
	public CheckConfig itemlist(@PathVariable("deptId") Integer deptId,@PathVariable("itemId") Integer itemId)
	{
		CheckConfig checkConfig =  new CheckConfig();
		checkConfig.setDeptId(deptId);
		checkConfig.setItemId(itemId);
		List<CheckConfig> checkConfigs = checkConfigService.selectCheckConfigList(checkConfig);
		if(CollectionUtils.isNotEmpty(checkConfigs)){
			return checkConfigs.get(0);
		}
		return null;
	}
	
}
