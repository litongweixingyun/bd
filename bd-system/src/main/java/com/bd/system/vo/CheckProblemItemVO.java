package com.bd.system.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 巡店大项问题表 check_problem_Item
 * 
 * @author luxuewei
 * @date 2019-04-20
 */
@Data
public class CheckProblemItemVO
{
	private static final long serialVersionUID = 1L;
	
	private Integer problemItemId;
	@NotNull
	private Integer deptId;
	@NotNull
	private Integer shopId;
	@NotNull
	private Integer itemId;
	@NotNull
	private Integer subItemId;


	private Integer itemScore;
	private Integer score;

	@NotBlank
	private String picUrl;
	@NotBlank
	private String description;
	@NotNull
	private Integer checkRecordId;
	@NotNull
	private Integer problemConfigId;


}
