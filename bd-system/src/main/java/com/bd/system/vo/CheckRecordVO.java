package com.bd.system.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author luxuewei
 * @since 2019/3/25
 */
@Data
public class CheckRecordVO {
    private Integer orgId;
    private Integer shopId;
    private String creator;
    private Date createTime;
}
