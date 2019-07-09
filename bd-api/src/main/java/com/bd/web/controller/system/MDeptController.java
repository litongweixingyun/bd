package com.bd.web.controller.system;

import com.bd.common.core.controller.BaseController;
import com.bd.system.domain.SysDept;
import com.bd.system.service.ISysDeptService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 部门信息
 * 
 * @author luxuewei
 */
@RestController
@RequestMapping("/mobile/dept")
public class MDeptController extends BaseController {

    @Resource
    private ISysDeptService deptService;


    @GetMapping("/info/{deptId}")
    public SysDept info(@PathVariable("deptId") Long deptId) {
        return deptService.selectDeptById(deptId);
    }

    @GetMapping("/list")
    public List<SysDept> list() {
        return deptService.selectDeptList(new SysDept());
    }

}
