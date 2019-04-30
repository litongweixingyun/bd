package com.bd.web.controller.system;

import com.bd.common.core.controller.BaseController;
import com.bd.common.core.domain.AjaxResult;
import com.bd.common.exception.base.BaseException;
import com.bd.system.domain.ShopPosition;
import com.bd.system.service.IShopPositionService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * @author luxuewei
 * @since 2019/3/25
 */
@Slf4j
@RestController
@RequestMapping("/mobile/shop/position")
public class MShopPositionController extends BaseController {

    @Resource
    private IShopPositionService shopPositionService ;

    /**
     * 分店店长细化岗位
     * @param shopPosition
     * @return
     */
    @PostMapping()
    public AjaxResult create(@Valid ShopPosition shopPosition){

        List<ShopPosition> shopPositions = shopPositionService.selectShopPositionList(shopPosition);
        if(CollectionUtils.isNotEmpty(shopPositions)){
            throw new BaseException("该配置已存在,请勿重复添加!");
        }

        return toAjax(shopPositionService.insertShopPosition(shopPosition));
    }
}
