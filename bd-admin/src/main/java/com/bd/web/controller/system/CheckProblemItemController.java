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
import com.bd.system.domain.CheckProblemItem;
import com.bd.system.service.ICheckProblemItemService;
import com.bd.common.core.controller.BaseController;
import com.bd.common.core.page.TableDataInfo;
import com.bd.common.core.domain.AjaxResult;
import com.bd.common.utils.poi.ExcelUtil;

/**
 * 巡店大项问题 信息操作处理
 * 
 * @author luxuewei
 * @date 2019-04-20
 */
@Controller
@RequestMapping("/system/checkProblemItem")
public class CheckProblemItemController extends BaseController
{
    private String prefix = "system/checkProblemItem";
	
	@Autowired
	private ICheckProblemItemService checkProblemItemService;
	
	@RequiresPermissions("system:checkProblemItem:view")
	@GetMapping()
	public String checkProblemItem()
	{
	    return prefix + "/checkProblemItem";
	}
	
	/**
	 * 查询巡店大项问题列表
	 */
	@RequiresPermissions("system:checkProblemItem:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(CheckProblemItem checkProblemItem)
	{
		startPage();
        List<CheckProblemItem> list = checkProblemItemService.selectCheckProblemItemList(checkProblemItem);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出巡店大项问题列表
	 */
	@RequiresPermissions("system:checkProblemItem:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CheckProblemItem checkProblemItem)
    {
    	List<CheckProblemItem> list = checkProblemItemService.selectCheckProblemItemList(checkProblemItem);
        ExcelUtil<CheckProblemItem> util = new ExcelUtil<CheckProblemItem>(CheckProblemItem.class);
        return util.exportExcel(list, "checkProblemItem");
    }
	
	/**
	 * 新增巡店大项问题
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存巡店大项问题
	 */
	@RequiresPermissions("system:checkProblemItem:add")
	@Log(title = "巡店大项问题", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(CheckProblemItem checkProblemItem)
	{		
		return toAjax(checkProblemItemService.insertCheckProblemItem(checkProblemItem));
	}

	/**
	 * 修改巡店大项问题
	 */
	@GetMapping("/edit/{problemItemId}")
	public String edit(@PathVariable("problemItemId") Integer problemItemId, ModelMap mmap)
	{
		CheckProblemItem checkProblemItem = checkProblemItemService.selectCheckProblemItemById(problemItemId);
		mmap.put("checkProblemItem", checkProblemItem);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存巡店大项问题
	 */
	@RequiresPermissions("system:checkProblemItem:edit")
	@Log(title = "巡店大项问题", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(CheckProblemItem checkProblemItem)
	{		
		return toAjax(checkProblemItemService.updateCheckProblemItem(checkProblemItem));
	}
	
	/**
	 * 删除巡店大项问题
	 */
	@RequiresPermissions("system:checkProblemItem:remove")
	@Log(title = "巡店大项问题", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(checkProblemItemService.deleteCheckProblemItemByIds(ids));
	}
	
}
