package com.bd.web.controller.mobile;

import com.bd.common.core.controller.BaseController;
import com.bd.system.domain.CheckProblemConfig;
import com.bd.system.service.ICheckConfigService;
import com.bd.system.service.ICheckProblemConfigService;
import com.bd.system.service.ICheckProblemService;
import com.bd.system.service.ISysDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * 巡店问题配置 信息操作处理
 * 
 * @author luxuewei
 * @date 2019-04-20
 */
@RestController
@RequestMapping("/mobile/check")
public class MCheckProblemConfigController extends BaseController
{

	@Autowired
	private ICheckProblemConfigService checkProblemConfigService;
	@Autowired
	private ISysDeptService deptService;
	@Autowired
	private ICheckConfigService checkConfigService;
	@Autowired
	private ICheckProblemService checkProblemService;


	@GetMapping("/problem/{deptId}/{itemId}/{subItemId}")
	public List<CheckProblemConfig> problem(@PathVariable("deptId") Long deptId,
											@PathVariable("itemId") Long itemId,
											@PathVariable("subItemId") Long subItemId){
		List<CheckProblemConfig> problemConfig = checkProblemConfigService.selectCheckProblemConfig(deptId,itemId,subItemId);
		return  problemConfig ;
	}
}
