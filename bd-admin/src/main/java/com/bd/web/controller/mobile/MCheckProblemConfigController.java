package com.bd.web.controller.mobile;

import com.bd.common.core.controller.BaseController;
import com.bd.system.domain.CheckProblemConfig;
import com.bd.system.domain.CheckProblemSubItem;
import com.bd.system.service.*;
import com.bd.system.service.impl.CheckProblemSubItemServiceImpl;
import com.bd.system.vo.ProblemDetailVO;
import com.bd.system.vo.ProblemVO;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;


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
	@Autowired
	private ICheckProblemSubItemService checkProblemSubItemService;


	@GetMapping("/problem/{deptId}/{itemId}/{subItemId}")
	public List<ProblemVO> problem(@PathVariable("deptId") Long deptId,
											@PathVariable("itemId") Long itemId,
											@PathVariable("subItemId") Long subItemId){
		List<ProblemVO> problemConfig = checkProblemConfigService.selectCheckProblemConfig(deptId,itemId,subItemId);

		List<CheckProblemSubItem> checkProblemSubItems =
				checkProblemSubItemService.selectCheckProblemSubItemList(new CheckProblemSubItem());
		Multimap<String,ProblemDetailVO> multimap = ArrayListMultimap.create();
		for (CheckProblemSubItem checkProblemSubItem : checkProblemSubItems) {
			ProblemDetailVO vo = new ProblemDetailVO();
			BeanUtils.copyProperties(checkProblemSubItem,vo);
			multimap.put(vo.getProblemItemId().toString() , vo);
		}


		if(CollectionUtils.isNotEmpty(problemConfig)){
			for (ProblemVO config : problemConfig) {
                String problemItemId = config.getProblemItemId();
                List<ProblemDetailVO> problemDetailVOS = (List<ProblemDetailVO>) multimap.get(problemItemId);
                config.setVoList(problemDetailVOS);
            }
		}

		return  problemConfig ;
	}
}
