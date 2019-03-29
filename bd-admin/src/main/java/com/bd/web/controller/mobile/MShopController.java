package com.bd.web.controller.mobile;

import com.bd.common.core.controller.BaseController;
import com.bd.common.core.page.TableDataInfo;
import com.bd.system.domain.Shop;
import com.bd.system.service.IShopService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 店铺 信息操作处理
 * 
 * @author luxuewei
 * @date 2019-03-18
 */
@RestController
@RequestMapping("/mobile/shop")
public class MShopController extends BaseController
{

	@Resource
	private IShopService shopService;
	
	/**
	 * 店铺详细信息
	 */
	@GetMapping("/info/{shopId}")
	public Shop info(@PathVariable("shopId") Integer shopId) {
		Shop shop = shopService.selectShopById(shopId);
	    return shop;
	}

	/**
	 * 查询店铺列表
	 */
	@GetMapping("/list")
	public List<Shop> list(Shop shop) {
		List<Shop> shopList = shopService.selectShopList(shop);
		return shopList;
	}

}
