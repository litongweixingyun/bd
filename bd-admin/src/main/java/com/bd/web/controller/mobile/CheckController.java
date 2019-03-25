package com.bd.web.controller.mobile;

import com.bd.common.core.controller.BaseController;
import com.bd.common.core.domain.AjaxResult;
import com.bd.system.domain.CheckRecord;
import com.bd.system.domain.DeptShop;
import com.bd.system.service.ICheckRecordService;
import com.bd.system.service.IDeptShopService;
import com.bd.system.vo.CheckRecordVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author luxuewei
 * @since 2019/3/25
 */
@Slf4j
@RestController
@RequestMapping("/mobile/check")
public class CheckController extends BaseController {

    @Resource
    private ICheckRecordService checkRecordService;
    @Resource
    private IDeptShopService deptShopService ;

    @GetMapping("/index")
    public CheckRecord index(){
        List<CheckRecord> checkRecords = checkRecordService.selectCheckRecordList(null);
        return checkRecords.get(0);
    }

    @PostMapping("/config")
    public AjaxResult config(DeptShop deptShop){

        return toAjax(deptShopService.insertDeptShop(deptShop));
    }

    @GetMapping("/getCheckNum/{deptId}/{shopId}")
    public Integer getCheckNum(@PathVariable("deptId") Integer deptId,@PathVariable("shopId") Integer shopId){
        DeptShop deptShop = new DeptShop();
        deptShop.setDeptId(deptId);
        deptShop.setShopId(shopId);
        List<DeptShop> deptShops = deptShopService.selectDeptShopList(deptShop);

        if(CollectionUtils.isEmpty(deptShops)){
            return 0;
        }
        return deptShops.get(0).getCheckNum() ;

    }

    @PostMapping("/create")
    public AjaxResult create(CheckRecordVO vo){
        CheckRecord record = new CheckRecord();
        record.setDeptId(vo.getOrgId());
        record.setShopId(vo.getShopId());
        record.setCreateBy(vo.getCreator());
        record.setCreateTime(vo.getCreateTime());
        return toAjax(checkRecordService.insertCheckRecord(record));
    }


    @GetMapping("/history/{shopId}")
    public List<CheckRecord> history(@PathVariable("shopId") Integer shopId){

        CheckRecord record = new CheckRecord();
        record.setShopId(shopId);
        return checkRecordService.selectCheckRecordList(record);


    }

}
