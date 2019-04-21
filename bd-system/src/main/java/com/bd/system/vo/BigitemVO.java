package com.bd.system.vo;

import lombok.Data;

import java.util.List;

/**
 * @author luxuewei
 * @date 2019-04-21
 */
@Data
public class BigitemVO {

    private Long deptId;
    private String deptName;
    private List<ItemScoreVO> itemScores;

}
