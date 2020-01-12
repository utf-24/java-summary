package com.yzy.demo.annotation;

import java.lang.annotation.*;

/** 定义注解 **/
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitProvider {

    /**供应商编号**/
    int id() default -1;

    /**供应商地址**/
    String address() default "";
}
