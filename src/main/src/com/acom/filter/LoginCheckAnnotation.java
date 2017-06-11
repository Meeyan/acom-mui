package com.acom.filter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解：配合LoginCheckInterceptor使用，拦截需要登录的资源
 *
 * @author zhaojy
 * @createTime 2017-06-06
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.METHOD, ElementType.TYPE})
public @interface LoginCheckAnnotation {

    /**
     * web:前端网站
     * admin:后台
     */
    static final String WEB = "web";
    static final String ADMIN = "admin";

    /**
     * 根据类型区分
     *
     * @return
     */
    public String type() default WEB;
}