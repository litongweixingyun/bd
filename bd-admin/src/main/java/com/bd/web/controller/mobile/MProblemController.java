package com.bd.web.controller.mobile;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.bd.system.domain.Problem;
import com.bd.system.service.IProblemService;
import com.bd.common.core.controller.BaseController;


/**
 * 检查问题 信息操作处理
 * 
 * @author luxuewei
 * @date 2019-03-30
 */
@RestController
@RequestMapping("/mobile/problem")
public class MProblemController extends BaseController
{
	@Autowired
	private IProblemService problemService;

	/**
	 * 查询检查问题列表
	 */
	@GetMapping("/list")
	public List<Problem> list()
	{
        List<Problem> list = problemService.selectProblemList(new Problem());
		return list;
	}
	

}
