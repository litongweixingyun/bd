package com.bd.web.controller.system;

import java.util.List;
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
import com.bd.system.domain.CheckDutyProblem;
import com.bd.system.service.ICheckDutyProblemService;
import com.bd.common.core.controller.BaseController;
import com.bd.common.core.page.TableDataInfo;
import com.bd.common.core.domain.AjaxResult;
import com.bd.common.utils.poi.ExcelUtil;

/**
 * 值班问题 信息操作处理
 * 
 * @author luxuewei
 * @date 2019-07-11
 */
@Controller
@RequestMapping("/system/checkDutyProblem")
public class CheckDutyProblemController extends BaseController
{
    private String prefix = "system/checkDutyProblem";
	
	@Autowired
	private ICheckDutyProblemService checkDutyProblemService;
	
	@RequiresPermissions("system:checkDutyProblem:view")
	@GetMapping()
	public String checkDutyProblem()
	{
	    return prefix + "/checkDutyProblem";
	}
	
	/**
	 * 查询值班问题列表
	 */
	@RequiresPermissions("system:checkDutyProblem:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(CheckDutyProblem checkDutyProblem)
	{
		startPage();
        List<CheckDutyProblem> list = checkDutyProblemService.selectCheckDutyProblemList(checkDutyProblem);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出值班问题列表
	 */
	@RequiresPermissions("system:checkDutyProblem:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CheckDutyProblem checkDutyProblem)
    {
    	List<CheckDutyProblem> list = checkDutyProblemService.selectCheckDutyProblemList(checkDutyProblem);
        ExcelUtil<CheckDutyProblem> util = new ExcelUtil<CheckDutyProblem>(CheckDutyProblem.class);
        return util.exportExcel(list, "checkDutyProblem");
    }
	
	/**
	 * 新增值班问题
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存值班问题
	 */
	@RequiresPermissions("system:checkDutyProblem:add")
	@Log(title = "值班问题", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(CheckDutyProblem checkDutyProblem)
	{		
		return toAjax(checkDutyProblemService.insertCheckDutyProblem(checkDutyProblem));
	}

	/**
	 * 修改值班问题
	 */
	@GetMapping("/edit/{problemId}")
	public String edit(@PathVariable("problemId") Integer problemId, ModelMap mmap)
	{
		CheckDutyProblem checkDutyProblem = checkDutyProblemService.selectCheckDutyProblemById(problemId);
		mmap.put("checkDutyProblem", checkDutyProblem);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存值班问题
	 */
	@RequiresPermissions("system:checkDutyProblem:edit")
	@Log(title = "值班问题", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(CheckDutyProblem checkDutyProblem)
	{		
		return toAjax(checkDutyProblemService.updateCheckDutyProblem(checkDutyProblem));
	}
	
	/**
	 * 删除值班问题
	 */
	@RequiresPermissions("system:checkDutyProblem:remove")
	@Log(title = "值班问题", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(checkDutyProblemService.deleteCheckDutyProblemByIds(ids));
	}
	
}
