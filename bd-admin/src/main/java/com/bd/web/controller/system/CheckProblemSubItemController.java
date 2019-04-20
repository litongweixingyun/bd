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
import com.bd.system.domain.CheckProblemSubItem;
import com.bd.system.service.ICheckProblemSubItemService;
import com.bd.common.core.controller.BaseController;
import com.bd.common.core.page.TableDataInfo;
import com.bd.common.core.domain.AjaxResult;
import com.bd.common.utils.poi.ExcelUtil;

/**
 * 巡店明细问题 信息操作处理
 * 
 * @author luxuewei
 * @date 2019-04-20
 */
@Controller
@RequestMapping("/system/checkProblemSubItem")
public class CheckProblemSubItemController extends BaseController
{
    private String prefix = "system/checkProblemSubItem";
	
	@Autowired
	private ICheckProblemSubItemService checkProblemSubItemService;
	
	@RequiresPermissions("system:checkProblemSubItem:view")
	@GetMapping()
	public String checkProblemSubItem()
	{
	    return prefix + "/checkProblemSubItem";
	}
	
	/**
	 * 查询巡店明细问题列表
	 */
	@RequiresPermissions("system:checkProblemSubItem:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(CheckProblemSubItem checkProblemSubItem)
	{
		startPage();
        List<CheckProblemSubItem> list = checkProblemSubItemService.selectCheckProblemSubItemList(checkProblemSubItem);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出巡店明细问题列表
	 */
	@RequiresPermissions("system:checkProblemSubItem:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CheckProblemSubItem checkProblemSubItem)
    {
    	List<CheckProblemSubItem> list = checkProblemSubItemService.selectCheckProblemSubItemList(checkProblemSubItem);
        ExcelUtil<CheckProblemSubItem> util = new ExcelUtil<CheckProblemSubItem>(CheckProblemSubItem.class);
        return util.exportExcel(list, "checkProblemSubItem");
    }
	
	/**
	 * 新增巡店明细问题
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存巡店明细问题
	 */
	@RequiresPermissions("system:checkProblemSubItem:add")
	@Log(title = "巡店明细问题", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(CheckProblemSubItem checkProblemSubItem)
	{		
		return toAjax(checkProblemSubItemService.insertCheckProblemSubItem(checkProblemSubItem));
	}

	/**
	 * 修改巡店明细问题
	 */
	@GetMapping("/edit/{problemSubItemId}")
	public String edit(@PathVariable("problemSubItemId") Integer problemSubItemId, ModelMap mmap)
	{
		CheckProblemSubItem checkProblemSubItem = checkProblemSubItemService.selectCheckProblemSubItemById(problemSubItemId);
		mmap.put("checkProblemSubItem", checkProblemSubItem);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存巡店明细问题
	 */
	@RequiresPermissions("system:checkProblemSubItem:edit")
	@Log(title = "巡店明细问题", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(CheckProblemSubItem checkProblemSubItem)
	{		
		return toAjax(checkProblemSubItemService.updateCheckProblemSubItem(checkProblemSubItem));
	}
	
	/**
	 * 删除巡店明细问题
	 */
	@RequiresPermissions("system:checkProblemSubItem:remove")
	@Log(title = "巡店明细问题", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(checkProblemSubItemService.deleteCheckProblemSubItemByIds(ids));
	}
	
}
