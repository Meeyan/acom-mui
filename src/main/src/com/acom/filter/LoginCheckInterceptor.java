package com.acom.filter;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;

/**
 *
 */
public class LoginCheckInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HandlerMethod handlerMethod = null;
        try {
            handlerMethod = (HandlerMethod) handler;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        if (handlerMethod == null) {
            return true;
        }

        LoginCheckAnnotation checkAnnotation = handlerMethod.getMethodAnnotation(LoginCheckAnnotation.class);
        if (checkAnnotation == null) {
            checkAnnotation = handlerMethod.getBeanType().getAnnotation(LoginCheckAnnotation.class);
        }

        if (checkAnnotation == null) {
            return true;
        }

        String type = checkAnnotation.type();


        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }
}

