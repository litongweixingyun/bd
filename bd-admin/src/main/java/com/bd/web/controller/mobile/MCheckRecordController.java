package com.bd.web.controller.mobile;


import com.bd.common.core.controller.BaseController;
import com.bd.common.core.domain.AjaxResult;
import com.bd.common.utils.DateUtils;
import com.bd.common.utils.StringUtils;
import com.bd.system.domain.CheckRecord;
import com.bd.system.service.ICheckRecordService;
import com.bd.system.vo.CheckRecordVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 检查记录 信息操作处理
 * 
 * @author luxuewei
 * @date 2019-04-21
 */
@RestController
@RequestMapping("/mobile/check")
public class MCheckRecordController extends BaseController
{

	@Autowired
	private ICheckRecordService checkRecordService;

	/**
	 * {
	 *   "checkrecordid": "string",
	 *   "deptId": "string",
	 *   "shopId": "string",
	 *   "creator": "string",
	 *   "createTime": "string",
	 *   "status": "string",
	 *   "completeTime": "string",
	 *   "problems": 0,
	 *   "totalScore": 0,
	 *   "checkNum": 0
	 * }
	 * @return
	 */
	@PostMapping("/create")
	public AjaxResult create(CheckRecordVO vo){
		Integer deptId = vo.getDeptId();
		Integer shopId = vo.getShopId();
		String dateToStr = DateUtils.parseDateToStr("yyyy-MM", new Date());
		int count = checkRecordService.selectCount(deptId,shopId,dateToStr);

		CheckRecord record = new CheckRecord();
		record.setDeptId(vo.getDeptId());
		record.setShopId(vo.getShopId());
		record.setCreateBy(vo.getCreator());
		record.setCreateTime(new Date());

		record.setCheckNum(count + 1);

		checkRecordService.insertCheckRecord(record);

		return success().put("record",record);

	}

	@PostMapping("/complete")
	public AjaxResult complete( String checkRecordId){
		if(StringUtils.isBlank(checkRecordId)){
			return error(400,"参数错误");
		}
		CheckRecord record = checkRecordService.selectCheckRecordById(Integer.parseInt(checkRecordId));
		record.setStatus(2);
		record.setCompleteTime(new Date());
		int i = checkRecordService.updateCheckRecord(record);
		return toAjax(i);

	}

}
