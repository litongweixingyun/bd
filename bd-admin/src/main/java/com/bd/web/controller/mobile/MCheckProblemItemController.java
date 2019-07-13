package com.bd.web.controller.mobile;

import com.bd.common.core.controller.BaseController;
import com.bd.system.service.ICheckProblemItemService;
import com.bd.system.vo.BigitemVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 巡店大项问题 信息操作处理
 * 
 * @author luxuewei
 * @date 2019-04-20
 */
@RestController
@RequestMapping("/mobile/check")
public class MCheckProblemItemController extends BaseController
{

	@Autowired
	private ICheckProblemItemService checkProblemItemService;

	@GetMapping("/bigitem/{deptId}")
	public BigitemVO bigitem(@PathVariable("deptId") Long deptId){
		BigitemVO bigitemVO = checkProblemItemService.selectBigitemList(deptId);
		if(bigitemVO == null){
			bigitemVO = new BigitemVO();
			bigitemVO.setDeptId(deptId);

		}
		return bigitemVO;
	}

}
