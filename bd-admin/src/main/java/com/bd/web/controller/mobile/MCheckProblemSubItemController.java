package com.bd.web.controller.mobile;

import com.bd.common.core.controller.BaseController;
import com.bd.common.core.domain.AjaxResult;
import com.bd.system.domain.CheckProblemSubItem;
import com.bd.system.service.ICheckProblemItemService;
import com.bd.system.service.ICheckProblemSubItemService;
import com.bd.system.vo.CheckProblemItemVO;
import com.bd.system.vo.ProblemDetailVO;
import com.google.common.collect.Lists;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * 巡店明细问题 信息操作处理
 * 
 * @author luxuewei
 * @date 2019-04-20
 */
@RestController
@RequestMapping("/mobile/check")
public class MCheckProblemSubItemController extends BaseController
{

	@Autowired
	private ICheckProblemSubItemService checkProblemSubItemService;
	@Autowired
	private ICheckProblemItemService checkProblemItemService;






	@PostMapping("/addProblems")
	public AjaxResult save(@Valid CheckProblemItemVO vo){

		boolean flag = checkProblemSubItemService.insert(vo);

		return toAjax(flag);
	}


	/**
	 * Controls Accept header.
	 * Example Value
	 * Schema
	 * [
	 *   {
	 *     "problemSubItemId": "string",
	 *     "problemItemId": "string",
	 *     "score": 0,
	 *     "picUrl": "string",
	 *     "description": "string"
	 *   }
	 * ]
	 */
	@GetMapping("/problem/{problemItemId}")
	public List<ProblemDetailVO> problem(@PathVariable("problemItemId") Integer problemItemId){
		CheckProblemSubItem subItem = new CheckProblemSubItem();
		subItem.setProblemItemId(problemItemId);
		List<CheckProblemSubItem> checkProblemSubItems = checkProblemSubItemService.selectCheckProblemSubItemList(subItem);
		List<ProblemDetailVO> vos = Lists.newArrayList();
		for (CheckProblemSubItem checkProblemSubItem : checkProblemSubItems) {
			ProblemDetailVO vo = new ProblemDetailVO();
			BeanUtils.copyProperties(checkProblemSubItem,vo);
			vos.add(vo);
		}
		return vos;

	}
}
