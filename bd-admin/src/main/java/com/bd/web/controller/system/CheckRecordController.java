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
import com.bd.system.domain.CheckRecord;
import com.bd.system.service.ICheckRecordService;
import com.bd.common.core.controller.BaseController;
import com.bd.common.core.page.TableDataInfo;
import com.bd.common.core.domain.AjaxResult;
import com.bd.common.utils.poi.ExcelUtil;

/**
 * 检查记录 信息操作处理
 * 
 * @author luxuewei
 * @date 2019-04-21
 */
@Controller
@RequestMapping("/system/checkRecord")
public class CheckRecordController extends BaseController
{
    private String prefix = "system/checkRecord";
	
	@Autowired
	private ICheckRecordService checkRecordService;
	
	@RequiresPermissions("system:checkRecord:view")
	@GetMapping()
	public String checkRecord()
	{
	    return prefix + "/checkRecord";
	}
	
	/**
	 * 查询检查记录列表
	 */
	@RequiresPermissions("system:checkRecord:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(CheckRecord checkRecord)
	{
		startPage();
        List<CheckRecord> list = checkRecordService.selectCheckRecordList(checkRecord);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出检查记录列表
	 */
	@RequiresPermissions("system:checkRecord:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CheckRecord checkRecord)
    {
    	List<CheckRecord> list = checkRecordService.selectCheckRecordList(checkRecord);
        ExcelUtil<CheckRecord> util = new ExcelUtil<CheckRecord>(CheckRecord.class);
        return util.exportExcel(list, "checkRecord");
    }
	
	/**
	 * 新增检查记录
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存检查记录
	 */
	@RequiresPermissions("system:checkRecord:add")
	@Log(title = "检查记录", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(CheckRecord checkRecord)
	{		
		return toAjax(checkRecordService.insertCheckRecord(checkRecord));
	}

	/**
	 * 修改检查记录
	 */
	@GetMapping("/edit/{checkRecordId}")
	public String edit(@PathVariable("checkRecordId") Integer checkRecordId, ModelMap mmap)
	{
		CheckRecord checkRecord = checkRecordService.selectCheckRecordById(checkRecordId);
		mmap.put("checkRecord", checkRecord);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存检查记录
	 */
	@RequiresPermissions("system:checkRecord:edit")
	@Log(title = "检查记录", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(CheckRecord checkRecord)
	{		
		return toAjax(checkRecordService.updateCheckRecord(checkRecord));
	}
	
	/**
	 * 删除检查记录
	 */
	@RequiresPermissions("system:checkRecord:remove")
	@Log(title = "检查记录", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(checkRecordService.deleteCheckRecordByIds(ids));
	}
	
}
