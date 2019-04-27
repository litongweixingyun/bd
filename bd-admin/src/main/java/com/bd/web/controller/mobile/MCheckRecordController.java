package com.bd.web.controller.mobile;


import com.bd.common.core.controller.BaseController;
import com.bd.common.core.domain.AjaxResult;
import com.bd.common.utils.DateUtils;
import com.bd.common.utils.StringUtils;
import com.bd.system.domain.CheckRecord;
import com.bd.system.domain.DeptShop;
import com.bd.system.service.ICheckProblemItemService;
import com.bd.system.service.ICheckRecordService;
import com.bd.system.service.IDeptShopService;
import com.bd.system.vo.CheckHistoryVO;
import com.bd.system.vo.CheckRecordResultDetailVO;
import com.bd.system.vo.CheckRecordResultVO;
import com.bd.system.vo.CheckRecordVO;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

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
	@Autowired
	private ICheckProblemItemService checkProblemItemService;
	@Autowired
	private IDeptShopService deptShopService;

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

		if(deptId == null || shopId == null){
			return error(500,"请求参数错误");
		}

		DeptShop deptShop = new DeptShop();
		deptShop.setDeptId(deptId);
		deptShop.setShopId(shopId);
		List<DeptShop> deptShops = deptShopService.selectDeptShopList(deptShop);
		if(CollectionUtils.isEmpty(deptShops)){
			return error(500,"无此配置,不允许巡店");
		}else if(deptShops.get(0).getCheckNum() == 0) {
			return error(500,"本月巡店次数已用完,不允许巡店");
		}

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

	/**
	 * {
	 *   "checkrecordid": "string",
	 *   "deptId": "string",
	 *   "deptName": "string",
	 *   "shopId": "string",
	 *   "shopName": "string",
	 *   "createTime": "string",
	 *   "createBy": "string",
	 *   "problems": 0,
	 *   "totalScore": 0,
	 *   "checkNum": 0,
	 *   "details": [
	 *     {
	 *       "itemName": "string",
	 *       "itemId": "string",
	 *       "problems": 0
	 *     }
	 *   ]
	 * }
	 * @param checkRecordId
	 * @return
	 */
	@GetMapping("/result/{checkRecordId}")
	public CheckRecordResultVO result(@PathVariable("checkRecordId") Integer checkRecordId){
		CheckRecordResultVO record = checkRecordService.selectCheckRecordByCheckRecordId(checkRecordId);

		if(record != null){
			List<CheckRecordResultDetailVO> checkProblemItems = checkProblemItemService.selectCheckProblemItemByCheckRecordId(checkRecordId);
			for (CheckRecordResultDetailVO checkProblemItem : checkProblemItems) {
				checkProblemItem.setItemScore(checkProblemItem.getItemScore() + 100);
			}
			record.setDetailList(checkProblemItems);
		}

		return record ;
	}


	/**
	 * deptId:            #  部门（非必填，如果没有，就是所有部门的数据）
	 * shopId:           # 门店（非必填，如果没有，就是所有门店的数据）
	 * checkDate:       # 查询日期
	 * @param vo
	 * @return
	 */

	/**
	 * [
	 *   {
	 *     "checkNum": 0,
	 *     "checkDate": "string",
	 *     "shopId": "string",
	 *     "totalScore": 0
	 *   }
	 * ]
	 */
	@PostMapping("/history")
	public List<CheckRecord> history(@Valid CheckHistoryVO vo){
		return checkRecordService.selectCheckRecordHistory(vo);
	}
}
