package com.bd.web.controller.system;

import com.bd.common.annotation.Log;
import com.bd.common.core.controller.BaseController;
import com.bd.common.core.domain.AjaxResult;
import com.bd.common.core.page.TableDataInfo;
import com.bd.common.enums.BusinessType;
import com.bd.common.utils.poi.ExcelUtil;
import com.bd.system.domain.CheckDuty;
import com.bd.system.domain.CheckDutyType;
import com.bd.system.domain.SysDictData;
import com.bd.system.service.ICheckDutyService;
import com.bd.system.service.ICheckDutyTypeService;
import com.bd.system.service.ISysDictDataService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 值班类型 信息操作处理
 * 
 * @author luxuewei
 * @date 2019-06-28
 */
@Controller
@RequestMapping("/system/checkDutyType")
public class CheckDutyTypeController extends BaseController
{
    private String prefix = "system/checkDutyType";



    //大萨达多
	@Autowired
	private ICheckDutyTypeService checkDutyTypeService;
	@Autowired
	private ICheckDutyService checkDutyService;
	@Autowired
	private ISysDictDataService dictDateService;
	@Autowired
	private ISysDictDataService dictDataService;
	
	@RequiresPermissions("system:checkDutyType:view")
	@GetMapping()
	public String checkDutyType()
	{
	    return prefix + "/checkDutyType";
	}
	
	/**
	 * 查询值班类型列表
	 */
	@RequiresPermissions("system:checkDutyType:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(CheckDutyType checkDutyType)
	{
		startPage();
        List<CheckDutyType> list = checkDutyTypeService.selectCheckDutyTypeList(checkDutyType);

        return getDataTable(list);
	}

	@PostMapping("/list1")
	@RequiresPermissions("system:checkDutyType:list1")
	@ResponseBody
	public TableDataInfo list(SysDictData dictData)
	{
		startPage();
		List<SysDictData> list = dictDataService.selectDictDataList1(dictData);

		return getDataTable(list);
	}
	/**
	 * 导出值班类型列表
	 */
	@RequiresPermissions("system:checkDutyType:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CheckDutyType checkDutyType)
    {
    	List<CheckDutyType> list = checkDutyTypeService.selectCheckDutyTypeList(checkDutyType);
        ExcelUtil<CheckDutyType> util = new ExcelUtil<CheckDutyType>(CheckDutyType.class);
        return util.exportExcel(list, "checkDutyType");
    }
	
	/**
	 * 新增值班类型
	 */
	@GetMapping("/add")
	public String add(ModelMap map)
	{
		map.put("dutys", checkDutyService.selectCheckDutyList(new CheckDuty()));
        map.put("dicts",dictDateService.selectDictDataList(new SysDictData()));
		return prefix + "/add";
	}
	
	/**
	 * 新增保存值班类型
	 */
	@RequiresPermissions("system:checkDutyType:add")
	@Log(title = "值班类型", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(CheckDutyType checkDutyType)
	{		
		return toAjax(checkDutyTypeService.insertCheckDutyType(checkDutyType));
	}

	/**
	 * 修改值班类型
	 */
	@GetMapping("/edit/{dctId}")
	public String edit(@PathVariable("dctId") Integer dctId, ModelMap mmap)
	{
		CheckDutyType checkDutyType = checkDutyTypeService.selectCheckDutyTypeById(dctId);
		mmap.put("checkDutyType", checkDutyType);
		mmap.put("dutys", checkDutyService.selectCheckDutyList(new CheckDuty()));
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存值班类型
	 */
	@RequiresPermissions("system:checkDutyType:edit")
	@Log(title = "值班类型", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(CheckDutyType checkDutyType)
	{		
		return toAjax(checkDutyTypeService.updateCheckDutyType(checkDutyType));
	}
	
	/**
	 * 删除值班类型
	 */
	@RequiresPermissions("system:checkDutyType:remove")
	@Log(title = "值班类型", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(checkDutyTypeService.deleteCheckDutyTypeByIds(ids));
	}
	
}
