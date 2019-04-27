package com.bd.system.vo;

import lombok.Data;

import java.util.List;


/**
 * @author luxuewei
 * @date 2019-04-21
 */
@Data
public class ProblemVO {
     private String problemItemId ;
     private String problemName ;
     private Long percent ;
     private Long raction ;
     private Long problemConfigId ;

     private List<ProblemDetailVO> voList;

}
