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
import com.bd.system.domain.ShopArea;
import com.bd.system.service.IShopAreaService;
import com.bd.common.core.controller.BaseController;
import com.bd.common.core.page.TableDataInfo;
import com.bd.common.core.domain.AjaxResult;
import com.bd.common.utils.poi.ExcelUtil;

/**
 * 店铺区域 信息操作处理
 * 
 * @author luxuewei
 * @date 2019-03-30
 */
@Controller
@RequestMapping("/system/shopArea")
public class ShopAreaController extends BaseController
{
    private String prefix = "system/shopArea";
	
	@Autowired
	private IShopAreaService shopAreaService;
	
	@RequiresPermissions("system:shopArea:view")
	@GetMapping()
	public String shopArea()
	{
	    return prefix + "/shopArea";
	}
	
	/**
	 * 查询店铺区域列表
	 */
	@RequiresPermissions("system:shopArea:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(ShopArea shopArea)
	{
		startPage();
        List<ShopArea> list = shopAreaService.selectShopAreaList(shopArea);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出店铺区域列表
	 */
	@RequiresPermissions("system:shopArea:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ShopArea shopArea)
    {
    	List<ShopArea> list = shopAreaService.selectShopAreaList(shopArea);
        ExcelUtil<ShopArea> util = new ExcelUtil<ShopArea>(ShopArea.class);
        return util.exportExcel(list, "shopArea");
    }
	
	/**
	 * 新增店铺区域
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存店铺区域
	 */
	@RequiresPermissions("system:shopArea:add")
	@Log(title = "店铺区域", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(ShopArea shopArea)
	{		
		return toAjax(shopAreaService.insertShopArea(shopArea));
	}

	/**
	 * 修改店铺区域
	 */
	@GetMapping("/edit/{areaId}")
	public String edit(@PathVariable("areaId") Integer areaId, ModelMap mmap)
	{
		ShopArea shopArea = shopAreaService.selectShopAreaById(areaId);
		mmap.put("shopArea", shopArea);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存店铺区域
	 */
	@RequiresPermissions("system:shopArea:edit")
	@Log(title = "店铺区域", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(ShopArea shopArea)
	{		
		return toAjax(shopAreaService.updateShopArea(shopArea));
	}
	
	/**
	 * 删除店铺区域
	 */
	@RequiresPermissions("system:shopArea:remove")
	@Log(title = "店铺区域", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(shopAreaService.deleteShopAreaByIds(ids));
	}
	
}
