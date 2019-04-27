package com.bd.system.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author luxuewei
 * @date 2019-04-27
 */
@Data
public class CheckChangedVO {
    private Integer deptId;
    private String deptName;

    private Integer problems ;
    private Integer changed ;

    private Date createTime ;
}
