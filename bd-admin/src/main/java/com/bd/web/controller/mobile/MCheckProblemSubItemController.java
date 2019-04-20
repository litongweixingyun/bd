package com.bd.web.controller.mobile;

import com.bd.common.core.controller.BaseController;
import com.bd.common.core.domain.AjaxResult;
import com.bd.system.service.ICheckProblemItemService;
import com.bd.system.service.ICheckProblemSubItemService;
import com.bd.system.vo.CheckProblemItemVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 巡店明细问题 信息操作处理
 * 
 * @author luxuewei
 * @date 2019-04-20
 */
@RestController
@RequestMapping("/mobile/check/addProblems")
public class MCheckProblemSubItemController extends BaseController
{

	@Autowired
	private ICheckProblemSubItemService checkProblemSubItemService;
	@Autowired
	private ICheckProblemItemService checkProblemItemService;


	@PostMapping
	public AjaxResult save(@Valid CheckProblemItemVO vo){

		boolean flag = checkProblemSubItemService.insert(vo);

		return toAjax(flag);
	}


}
