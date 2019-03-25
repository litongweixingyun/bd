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
import com.bd.system.domain.DeptShop;
import com.bd.system.service.IDeptShopService;
import com.bd.common.core.controller.BaseController;
import com.bd.common.core.page.TableDataInfo;
import com.bd.common.core.domain.AjaxResult;
import com.bd.common.utils.poi.ExcelUtil;

/**
 * 部门和店铺关联 信息操作处理
 * 
 * @author luxuewei
 * @date 2019-03-25
 */
@Controller
@RequestMapping("/system/deptShop")
public class DeptShopController extends BaseController
{
    private String prefix = "system/deptShop";
	
	@Autowired
	private IDeptShopService deptShopService;
	
	@RequiresPermissions("system:deptShop:view")
	@GetMapping()
	public String deptShop()
	{
	    return prefix + "/deptShop";
	}
	
	/**
	 * 查询部门和店铺关联列表
	 */
	@RequiresPermissions("system:deptShop:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(DeptShop deptShop)
	{
		startPage();
        List<DeptShop> list = deptShopService.selectDeptShopList(deptShop);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出部门和店铺关联列表
	 */
	@RequiresPermissions("system:deptShop:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(DeptShop deptShop)
    {
    	List<DeptShop> list = deptShopService.selectDeptShopList(deptShop);
        ExcelUtil<DeptShop> util = new ExcelUtil<DeptShop>(DeptShop.class);
        return util.exportExcel(list, "deptShop");
    }
	
	/**
	 * 新增部门和店铺关联
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存部门和店铺关联
	 */
	@RequiresPermissions("system:deptShop:add")
	@Log(title = "部门和店铺关联", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(DeptShop deptShop)
	{		
		return toAjax(deptShopService.insertDeptShop(deptShop));
	}

	/**
	 * 修改部门和店铺关联
	 */
	@GetMapping("/edit/{deptId}")
	public String edit(@PathVariable("deptId") Integer deptId, ModelMap mmap)
	{
		DeptShop deptShop = deptShopService.selectDeptShopById(deptId);
		mmap.put("deptShop", deptShop);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存部门和店铺关联
	 */
	@RequiresPermissions("system:deptShop:edit")
	@Log(title = "部门和店铺关联", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(DeptShop deptShop)
	{		
		return toAjax(deptShopService.updateDeptShop(deptShop));
	}
	
	/**
	 * 删除部门和店铺关联
	 */
	@RequiresPermissions("system:deptShop:remove")
	@Log(title = "部门和店铺关联", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(deptShopService.deleteDeptShopByIds(ids));
	}
	
}
