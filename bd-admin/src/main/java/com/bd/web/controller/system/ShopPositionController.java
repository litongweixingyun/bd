package com.bd.web.controller.system;

import java.util.List;

import com.bd.system.domain.Shop;
import com.bd.system.service.IShopService;
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
import com.bd.system.domain.ShopPosition;
import com.bd.system.service.IShopPositionService;
import com.bd.common.core.controller.BaseController;
import com.bd.common.core.page.TableDataInfo;
import com.bd.common.core.domain.AjaxResult;
import com.bd.common.utils.poi.ExcelUtil;

import javax.annotation.Resource;

/**
 * 店铺岗位 信息操作处理
 * 
 * @author luxuewei
 * @date 2019-03-26
 */
@Controller
@RequestMapping("/system/shopPosition")
public class ShopPositionController extends BaseController
{
    private String prefix = "system/shopPosition";
	
	@Autowired
	private IShopPositionService shopPositionService;
	@Resource
	private IShopService shopService;
	
	@RequiresPermissions("system:shopPosition:view")
	@GetMapping()
	public String shopPosition()
	{
	    return prefix + "/shopPosition";
	}
	
	/**
	 * 查询店铺岗位列表
	 */
	@RequiresPermissions("system:shopPosition:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(ShopPosition shopPosition)
	{
		startPage();
        List<ShopPosition> list = shopPositionService.selectShopPositionList(shopPosition);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出店铺岗位列表
	 */
	@RequiresPermissions("system:shopPosition:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ShopPosition shopPosition)
    {
    	List<ShopPosition> list = shopPositionService.selectShopPositionList(shopPosition);
        ExcelUtil<ShopPosition> util = new ExcelUtil<ShopPosition>(ShopPosition.class);
        return util.exportExcel(list, "shopPosition");
    }
	
	/**
	 * 新增店铺岗位
	 */
	@GetMapping("/add")
	public String add(ModelMap mmap)
	{
		mmap.put("shops", shopService.selectShopList(new Shop()));
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存店铺岗位
	 */
	@RequiresPermissions("system:shopPosition:add")
	@Log(title = "店铺岗位", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(ShopPosition shopPosition)
	{		
		return toAjax(shopPositionService.insertShopPosition(shopPosition));
	}

	/**
	 * 修改店铺岗位
	 */
	@GetMapping("/edit/{positionId}")
	public String edit(@PathVariable("positionId") Integer positionId, ModelMap mmap)
	{
		ShopPosition shopPosition = shopPositionService.selectShopPositionById(positionId);
		mmap.put("shopPosition", shopPosition);
		mmap.put("shops", shopService.selectShopList(new Shop()));
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存店铺岗位
	 */
	@RequiresPermissions("system:shopPosition:edit")
	@Log(title = "店铺岗位", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(ShopPosition shopPosition)
	{		
		return toAjax(shopPositionService.updateShopPosition(shopPosition));
	}
	
	/**
	 * 删除店铺岗位
	 */
	@RequiresPermissions("system:shopPosition:remove")
	@Log(title = "店铺岗位", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(shopPositionService.deleteShopPositionByIds(ids));
	}
	
}
