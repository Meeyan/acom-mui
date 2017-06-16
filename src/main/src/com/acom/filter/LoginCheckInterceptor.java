package com.acom.filter;

import com.acom.cache.RedisCacheFactory;
import com.acom.cache.impl.PrivilegeCacheImpl;
import com.acom.entities.model.AdminUser;
import com.acom.util.Constants;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

/**
 * 登录拦截器，没有登录的用户，需要重定向到登录界面
 *
 * @author zhaojy
 * @createTime 2017-06-05
 */
public class LoginCheckInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String contextPath = request.getContextPath();
        String method = request.getMethod();
        String serverName = request.getServerName();
        String pathInfo = request.getPathInfo();
        String requestURI = request.getRequestURI();    // 去除host的url
        Enumeration headerNames = request.getHeaderNames();
        int serverPort = request.getServerPort();

        request.setAttribute("APP_OM_PATH", contextPath);   // 多部署时用

        HandlerMethod handlerMethod = null;
        try {
            handlerMethod = (HandlerMethod) handler;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // 如果没有注解，则视为不需要验证登陆信息
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

        // 开始校验登陆信息
        String type = checkAnnotation.type();

        boolean ret = true;
        if (type.equals(LoginCheckAnnotation.WEB)) {
            // todo 检查前端用户是否登陆
            System.out.println("准备验证前台登陆");
        } else if (type.equals(LoginCheckAnnotation.ADMIN)) {
            ret = checkAdminLogin(request, response);
        }
        return ret;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    /**
     * todo 检查后台用户是否登陆
     *
     * @param request
     * @param response
     * @return boolean
     */
    private boolean checkAdminLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String contextPath = request.getContextPath();
        String requestURI = request.getRequestURI();    // 去除host的url
        AdminUser adminUser = (AdminUser) request.getSession().getAttribute(Constants.AdminConstant.ADMIN_SESSION_USER);
        /*
         * 1. 验证是否登陆，没有登录的需要登录
         * 2. 验证权限，如果没有权限，则提示权限不足
         */
        if (null == adminUser) {
            // 跳转到登陆页面
            response.sendRedirect(contextPath + "/admin/login.html");
            return false;
        }

        Map map = RedisCacheFactory.getCacheWithClass(PrivilegeCacheImpl.class, requestURI);
        if (map.size() > 0) {
            Object obj = map.get(PrivilegeCacheImpl.IS_ACCESS); // 视情况决定之的类型
            Integer isAcc = Integer.valueOf(obj.toString());
            if (isAcc == 1) {
                System.out.println(isAcc);
            } else {
                // 导航到错误页面还是提示消息，待定
                response.sendRedirect(contextPath + "/admin/login.html");
            }
        }
        return true;
    }
}

