package com.bd.web.controller.mobile;

import com.bd.common.core.controller.BaseController;
import com.bd.common.core.domain.AjaxResult;
import com.bd.common.exception.BusinessException;
import com.bd.system.domain.CheckRecord;
import com.bd.system.domain.DeptShop;
import com.bd.system.service.ICheckRecordService;
import com.bd.system.service.IDeptShopService;
import com.bd.system.vo.CheckChangedVO;
import com.bd.system.vo.CheckNumVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author luxuewei
 * @since 2019/3/25
 */
@Slf4j
@RestController
@RequestMapping("/mobile/check")
public class MCheckController extends BaseController {

    @Resource
    private ICheckRecordService checkRecordService;
    @Resource
    private IDeptShopService deptShopService ;

    @GetMapping("/index")
    public List<CheckRecord> index(){
        List<CheckRecord> checkRecords = checkRecordService.selectCheckRecordList(new  CheckRecord());
        if(CollectionUtils.isEmpty(checkRecords)){
            throw new BusinessException("暂无检查记录");
        }
        return checkRecords;
    }

    @GetMapping("/month")
    public List<CheckRecord> month(){



        List<CheckRecord> checkRecords = checkRecordService.selectCheckRecordList(new  CheckRecord());
        if(CollectionUtils.isEmpty(checkRecords)){
            throw new BusinessException("暂无检查记录");
        }
        return checkRecords;
    }

    @PostMapping("/config")
    public AjaxResult config(DeptShop deptShop){

        return toAjax(deptShopService.insertDeptShop(deptShop));
    }

    @GetMapping("/getCheckNum/{deptId}/{shopId}")
    public CheckNumVO getCheckNum(@PathVariable("deptId") Integer deptId, @PathVariable("shopId") Integer shopId){
        DeptShop deptShop = new DeptShop();
        deptShop.setDeptId(deptId);
        deptShop.setShopId(shopId);
        List<DeptShop> deptShops = deptShopService.selectDeptShopList(deptShop);
        CheckNumVO vo = new CheckNumVO();
        if(CollectionUtils.isEmpty(deptShops)){
            vo.setCheckNum(0);
        }else{
            vo.setCheckNum(deptShops.get(0).getCheckNum());
        }

        return vo ;
    }

    /*@PostMapping("/create")
    public AjaxResult create(CheckRecordVO vo){
        CheckRecord record = new CheckRecord();
        record.setDeptId(vo.getDeptId());
        record.setShopId(vo.getShopId());
        record.setCreateBy(vo.getCreator());
        record.setCreateTime(new Date());
        return toAjax(checkRecordService.insertCheckRecord(record));
    }*/


    @GetMapping("/history/{shopId}")
    public List<CheckRecord> history(@PathVariable("shopId") Integer shopId){

        CheckRecord record = new CheckRecord();
        record.setShopId(shopId);
        return checkRecordService.selectCheckRecordList(record);


    }

    /*@GetMapping("/changed")
    public List<CheckChangedVO> changed(){
        return checkRecordService.selectCheckChangedList();
    }
*/
}
