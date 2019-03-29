package com.bd.web.controller.mobile;

import com.bd.common.annotation.Log;
import com.bd.common.core.controller.BaseController;
import com.bd.common.core.domain.AjaxResult;
import com.bd.common.core.domain.Ztree;
import com.bd.common.enums.BusinessType;
import com.bd.common.utils.StringUtils;
import com.bd.framework.util.ShiroUtils;
import com.bd.system.domain.Shop;
import com.bd.system.domain.SysDept;
import com.bd.system.domain.SysRole;
import com.bd.system.service.ISysDeptService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 部门信息
 * 
 * @author luxuewei
 */
@RestController
@RequestMapping("/mobile/dept")
public class MDeptController extends BaseController
{

    @Resource
    private ISysDeptService deptService;


    @GetMapping("/info/{deptId}")
    public SysDept info(@PathVariable("deptId") Long deptId)
    {
       SysDept dept = deptService.selectDeptById(deptId);
        return dept;
    }

    @GetMapping("/list")
    public List<SysDept> list(SysDept dept)
    {
        List<SysDept> deptList = deptService.selectDeptList(dept);
        return deptList;
    }

}
