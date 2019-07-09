package com.bd.web.controller.system;

import com.bd.common.core.controller.BaseController;
import com.bd.system.domain.Shop;
import com.bd.system.service.IShopService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
		return shopService.selectShopById(shopId);
	}

	/**
	 * 查询店铺列表
	 */
	@GetMapping("/list")
	public List<Shop> list() {
		return shopService.selectShopList(new Shop());
	}

}
