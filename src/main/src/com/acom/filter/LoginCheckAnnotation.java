package com.acom.filter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by zhaojy on 2017/6/5.
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

    public String type() default WEB;
}
