package com.bd.web.controller.system;

import com.bd.common.core.controller.BaseController;
import com.bd.system.domain.ShopArea;
import com.bd.system.service.IShopAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
