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
import com.bd.system.domain.CheckProblem;
import com.bd.system.service.ICheckProblemService;
import com.bd.common.core.controller.BaseController;
import com.bd.common.core.page.TableDataInfo;
import com.bd.common.core.domain.AjaxResult;
import com.bd.common.utils.poi.ExcelUtil;

/**
 * 巡店问题 信息操作处理
 * 
 * @author luxuewei
 * @date 2019-04-20
 */
@Controller
@RequestMapping("/system/checkProblem")
public class CheckProblemController extends BaseController
{
    private String prefix = "system/checkProblem";
	
	@Autowired
	private ICheckProblemService checkProblemService;
	
	@RequiresPermissions("system:checkProblem:view")
	@GetMapping()
	public String checkProblem()
	{
	    return prefix + "/checkProblem";
	}
	
	/**
	 * 查询巡店问题列表
	 */
	@RequiresPermissions("system:checkProblem:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(CheckProblem checkProblem)
	{
		startPage();
        List<CheckProblem> list = checkProblemService.selectCheckProblemList(checkProblem);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出巡店问题列表
	 */
	@RequiresPermissions("system:checkProblem:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CheckProblem checkProblem)
    {
    	List<CheckProblem> list = checkProblemService.selectCheckProblemList(checkProblem);
        ExcelUtil<CheckProblem> util = new ExcelUtil<CheckProblem>(CheckProblem.class);
        return util.exportExcel(list, "checkProblem");
    }
	
	/**
	 * 新增巡店问题
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存巡店问题
	 */
	@RequiresPermissions("system:checkProblem:add")
	@Log(title = "巡店问题", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(CheckProblem checkProblem)
	{		
		return toAjax(checkProblemService.insertCheckProblem(checkProblem));
	}

	/**
	 * 修改巡店问题
	 */
	@GetMapping("/edit/{problemId}")
	public String edit(@PathVariable("problemId") Integer problemId, ModelMap mmap)
	{
		CheckProblem checkProblem = checkProblemService.selectCheckProblemById(problemId);
		mmap.put("checkProblem", checkProblem);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存巡店问题
	 */
	@RequiresPermissions("system:checkProblem:edit")
	@Log(title = "巡店问题", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(CheckProblem checkProblem)
	{		
		return toAjax(checkProblemService.updateCheckProblem(checkProblem));
	}
	
	/**
	 * 删除巡店问题
	 */
	@RequiresPermissions("system:checkProblem:remove")
	@Log(title = "巡店问题", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(checkProblemService.deleteCheckProblemByIds(ids));
	}
	
}
