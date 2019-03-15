package com.bd.common.annotation;

import java.lang.annotation.*;

/**
 * 数据权限过滤注解
 *
 * @author luxuewei
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataScope {
    /**
     * 表的别名
     */
    String tableAlias() default "";
}
