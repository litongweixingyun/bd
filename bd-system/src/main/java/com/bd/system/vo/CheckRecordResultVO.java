package com.bd.system.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author luxuewei
 * @date 2019-04-21
 */
@Data
public class CheckRecordResultVO {

    private Integer checkRecordId ;
    private Integer deptId ;
    private String deptName ;
    private Integer shopId ;
    private String shopName ;
    private String createBy ;
    private String createTime ;

    private Integer problems;
    private Integer checkNum;
    private BigDecimal totalScore;


    private List<CheckRecordResultDetailVO> detailList = new ArrayList<>();
}
