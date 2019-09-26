package com.park.aoplog;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {

    /**
     * 要执行的操作类型  比如：增加操作
     **/
     String operationType() default "";

    /**
     * 要执行的具体操作  比如：添加用户
     **/
     String operationName() default "";

    /**
     * 要执行的具体操作  比如：系统管理
     **/

    String module() default "";

}
