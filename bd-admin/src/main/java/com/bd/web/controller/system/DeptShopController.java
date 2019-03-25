package com.bd.web.controller.system;

import java.util.List;

import com.bd.common.exception.BusinessException;
import com.bd.system.domain.Shop;
import com.bd.system.domain.SysDept;
import com.bd.system.service.IShopService;
import com.bd.system.service.ISysDeptService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bd.common.annotation.Log;
import com.bd.common.enums.BusinessType;
import com.bd.system.domain.DeptShop;
import com.bd.system.service.IDeptShopService;
import com.bd.common.core.controller.BaseController;
import com.bd.common.core.page.TableDataInfo;
import com.bd.common.core.domain.AjaxResult;
import com.bd.common.utils.poi.ExcelUtil;

import javax.annotation.Resource;

/**
 * 巡店配置 信息操作处理
 * 
 * @author luxuewei
 * @date 2019-03-25
 */
@Controller
@RequestMapping("/system/deptShop")
public class DeptShopController extends BaseController
{
    private String prefix = "system/deptShop";
	
	@Resource
	private IDeptShopService deptShopService;
	@Resource
	private ISysDeptService deptService;
	@Resource
    private IShopService shopService;
	
	@RequiresPermissions("system:deptShop:view")
	@GetMapping()
	public String deptShop()
	{
	    return prefix + "/deptShop";
	}
	
	/**
	 * 查询巡店配置列表
	 */
	@RequiresPermissions("system:deptShop:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(DeptShop deptShop)
	{
		startPage();
        List<DeptShop> list = deptShopService.selectDeptShopList(deptShop);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出巡店配置列表
	 */
	@RequiresPermissions("system:deptShop:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(DeptShop deptShop)
    {
    	List<DeptShop> list = deptShopService.selectDeptShopList(deptShop);
        ExcelUtil<DeptShop> util = new ExcelUtil<DeptShop>(DeptShop.class);
        return util.exportExcel(list, "deptShop");
    }
	
	/**
	 * 新增巡店配置
	 */
	@GetMapping("/add")
	public String add(ModelMap mmap)
	{
        mmap.put("depts", deptService.selectDeptList(new SysDept()));
        mmap.put("shops", shopService.selectShopList(new Shop()));

        return prefix + "/add";
	}
	
	/**
	 * 新增保存巡店配置
	 */
	@RequiresPermissions("system:deptShop:add")
	@Log(title = "巡店配置", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(DeptShop deptShop)
	{
        DeptShop info = new DeptShop();
        BeanUtils.copyProperties(deptShop,info);
        info.setCheckNum(null);
        List<DeptShop> deptShops = deptShopService.selectDeptShopList(info);
        if(CollectionUtils.isNotEmpty(deptShops)){
            throw new BusinessException("该配置已存在");
        }

        return toAjax(deptShopService.insertDeptShop(deptShop));
	}

	/**
	 * 修改巡店配置
	 */
	@GetMapping("/edit/{deptId}")
	public String edit(@PathVariable("deptId") Integer deptId, ModelMap mmap)
	{
		DeptShop deptShop = deptShopService.selectDeptShopById(deptId);

		mmap.put("deptShop", deptShop);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存巡店配置
	 */
	@RequiresPermissions("system:deptShop:edit")
	@Log(title = "巡店配置", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(DeptShop deptShop)
	{		
		return toAjax(deptShopService.updateDeptShop(deptShop));
	}
	
	/**
	 * 删除巡店配置
	 */
	@RequiresPermissions("system:deptShop:remove")
	@Log(title = "巡店配置", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(deptShopService.deleteDeptShopByIds(ids));
	}
	
}
