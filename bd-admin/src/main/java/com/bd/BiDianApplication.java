package com.bd;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * 启动程序
 *
 * @author luxuewei
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@MapperScan("com.bd.*.mapper")
@ServletComponentScan
public class BiDianApplication {
          public static void main(String[] args) {
              System.out.println(" ------------------------------------------------------------------------------必点海鲜程序正在启动------------------------------------------------------------------------------");
        SpringApplication.run(BiDianApplication.class, args);
    }
}