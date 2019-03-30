package com.bd.web.controller.mobile;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
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
@RestController
@RequestMapping("/mobile/shopArea")
public class MShopAreaController extends BaseController
{
	
	@Autowired
	private IShopAreaService shopAreaService;

	@GetMapping("/list")
	public List<ShopArea> list()
	{
		ShopArea shopArea = new ShopArea();
		shopArea.setParentId(0);
        List<ShopArea> list = shopAreaService.selectShopAreaList(shopArea);
		return list;
	}
	@GetMapping("/list/{parentId}")
	public List<ShopArea> list(@PathVariable("parentId") Integer parentId)
	{
		ShopArea shopArea = new ShopArea();
		shopArea.setParentId(parentId);
		List<ShopArea> list = shopAreaService.selectShopAreaList(shopArea);
		return list;
	}

}
