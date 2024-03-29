package com.bd.web.controller.check;

import com.bd.common.core.controller.BaseController;
import com.bd.common.core.domain.AjaxResult;
import com.bd.common.utils.DateUtils;
import com.bd.system.domain.CheckProblemSubItem;
import com.bd.system.service.ICheckProblemItemService;
import com.bd.system.service.ICheckProblemSubItemService;
import com.bd.system.vo.CheckProblemItemVO;
import com.bd.system.vo.ProblemDetailVO;
import com.google.common.collect.Lists;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
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

        boolean flag = false;
        try {
            flag = checkProblemSubItemService.insert(vo);
        } catch (IOException e) {
            e.printStackTrace();
        }

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

	@GetMapping("/changed/list/{deptId}/{shopId}/{status}")
    public List changedList(@PathVariable("deptId")  Integer deptId ,@PathVariable("shopId")  Integer shopId,@PathVariable("status")  Integer status){
        String checkDate = DateUtils.dateTimeNow("yyyy-MM");
        return checkProblemSubItemService.selectChangedList(deptId,shopId,status,checkDate);
    }

}
