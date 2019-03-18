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
import com.bd.system.domain.Shop;
import com.bd.system.service.IShopService;
import com.bd.common.core.controller.BaseController;
import com.bd.common.core.page.TableDataInfo;
import com.bd.common.core.domain.AjaxResult;
import com.bd.common.utils.poi.ExcelUtil;

/**
 * 店铺 信息操作处理
 * 
 * @author luxuewei
 * @date 2019-03-18
 */
@Controller
@RequestMapping("/system/shop")
public class ShopController extends BaseController
{
    private String prefix = "system/shop";
	
	@Autowired
	private IShopService shopService;
	
	@RequiresPermissions("system:shop:view")
	@GetMapping()
	public String shop()
	{
	    return prefix + "/shop";
	}
	
	/**
	 * 查询店铺列表
	 */
	@RequiresPermissions("system:shop:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Shop shop)
	{
		startPage();
        List<Shop> list = shopService.selectShopList(shop);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出店铺列表
	 */
	@RequiresPermissions("system:shop:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Shop shop)
    {
    	List<Shop> list = shopService.selectShopList(shop);
        ExcelUtil<Shop> util = new ExcelUtil<Shop>(Shop.class);
        return util.exportExcel(list, "shop");
    }
	
	/**
	 * 新增店铺
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存店铺
	 */
	@RequiresPermissions("system:shop:add")
	@Log(title = "店铺", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Shop shop)
	{		
		return toAjax(shopService.insertShop(shop));
	}

	/**
	 * 修改店铺
	 */
	@GetMapping("/edit/{shopId}")
	public String edit(@PathVariable("shopId") Integer shopId, ModelMap mmap)
	{
		Shop shop = shopService.selectShopById(shopId);
		mmap.put("shop", shop);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存店铺
	 */
	@RequiresPermissions("system:shop:edit")
	@Log(title = "店铺", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Shop shop)
	{		
		return toAjax(shopService.updateShop(shop));
	}
	
	/**
	 * 删除店铺
	 */
	@RequiresPermissions("system:shop:remove")
	@Log(title = "店铺", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(shopService.deleteShopByIds(ids));
	}
	
}
