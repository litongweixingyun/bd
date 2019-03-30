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
import com.bd.system.domain.Problem;
import com.bd.system.service.IProblemService;
import com.bd.common.core.controller.BaseController;
import com.bd.common.core.page.TableDataInfo;
import com.bd.common.core.domain.AjaxResult;
import com.bd.common.utils.poi.ExcelUtil;

/**
 * 检查问题 信息操作处理
 * 
 * @author luxuewei
 * @date 2019-03-30
 */
@Controller
@RequestMapping("/system/problem")
public class ProblemController extends BaseController
{
    private String prefix = "system/problem";
	
	@Autowired
	private IProblemService problemService;
	
	@RequiresPermissions("system:problem:view")
	@GetMapping()
	public String problem()
	{
	    return prefix + "/problem";
	}
	
	/**
	 * 查询检查问题列表
	 */
	@RequiresPermissions("system:problem:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Problem problem)
	{
		startPage();
        List<Problem> list = problemService.selectProblemList(problem);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出检查问题列表
	 */
	@RequiresPermissions("system:problem:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Problem problem)
    {
    	List<Problem> list = problemService.selectProblemList(problem);
        ExcelUtil<Problem> util = new ExcelUtil<Problem>(Problem.class);
        return util.exportExcel(list, "problem");
    }
	
	/**
	 * 新增检查问题
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存检查问题
	 */
	@RequiresPermissions("system:problem:add")
	@Log(title = "检查问题", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Problem problem)
	{		
		return toAjax(problemService.insertProblem(problem));
	}

	/**
	 * 修改检查问题
	 */
	@GetMapping("/edit/{problemId}")
	public String edit(@PathVariable("problemId") Integer problemId, ModelMap mmap)
	{
		Problem problem = problemService.selectProblemById(problemId);
		mmap.put("problem", problem);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存检查问题
	 */
	@RequiresPermissions("system:problem:edit")
	@Log(title = "检查问题", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Problem problem)
	{		
		return toAjax(problemService.updateProblem(problem));
	}
	
	/**
	 * 删除检查问题
	 */
	@RequiresPermissions("system:problem:remove")
	@Log(title = "检查问题", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(problemService.deleteProblemByIds(ids));
	}
	
}
