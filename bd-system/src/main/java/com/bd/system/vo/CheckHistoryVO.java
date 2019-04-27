package com.bd.system.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author luxuewei
 * @date 2019-04-21
 */
@Data
public class CheckHistoryVO {
    private Integer  deptId ;
    private Integer  shopId ;

    @NotBlank
    private String  checkDate ;
}
