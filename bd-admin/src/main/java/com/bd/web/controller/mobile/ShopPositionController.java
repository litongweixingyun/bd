package com.bd.web.controller.mobile;

import com.bd.common.core.controller.BaseController;
import com.bd.common.core.domain.AjaxResult;
import com.bd.system.domain.ShopPosition;
import com.bd.system.service.IShopPositionService;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author luxuewei
 * @since 2019/3/25
 */
@Slf4j
@RestController
@RequestMapping("/mobile/shop/position")
public class ShopPositionController extends BaseController {

    @Resource
    private IShopPositionService shopPositionService ;

    /**
     * 分店店长细化岗位
     * @param shopPosition
     * @return
     */
    @PostMapping()
    public AjaxResult create(ShopPosition shopPosition){
        return toAjax(shopPositionService.insertShopPosition(shopPosition));
    }
}
