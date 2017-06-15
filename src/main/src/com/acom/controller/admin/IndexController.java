package com.acom.controller.admin;

import com.acom.entities.model.AdminUser;
import com.acom.filter.LoginCheckAnnotation;
import com.acom.services.sv.IAdminUserService;
import com.acom.util.CommonUtils;
import com.acom.util.Constants;
import com.acom.util.CryptUtil;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 首页
 */
@Controller("adminController")  // 必须加这个，否则会和web下的indexController出现冲突，如果没有重名的，可以忽略
@RequestMapping(value = "/admin")
@LoginCheckAnnotation(type = LoginCheckAnnotation.ADMIN)
public class IndexController {

    private Logger log = Logger.getLogger(IndexController.class);

    @Resource(name = "adminUserService")
    IAdminUserService userService;

    /**
     * 网站默认映射到该路径下，webapp下不能有index.jsp文件，或者在index.jsp中导向到'/'
     *
     * @return ModelAndView
     */
    @RequestMapping(value = "/")
    public ModelAndView index(HttpServletRequest request) {

        ModelMap model = new ModelMap();
        model.addAttribute("loginName", "wwang无");

        ModelAndView view = new ModelAndView("", model);
        view.setViewName("ftl/index");


        AdminUser user = new AdminUser();
        user.setNickName("李四1");
        user.setPhone("15210028606");

        view.addObject("user", user);
        return view;
    }

    /**
     * 登陆页面
     *
     * @return ModelAndView
     * @author zhaojy
     * @createTime 2017-06-15
     */
    @RequestMapping(value = "/login.html")
    @LoginCheckAnnotation(type = "")
    public ModelAndView login(HttpServletRequest request) {
        ModelAndView view = new ModelAndView();
        view.setViewName("jsp/admin/login");
        AdminUser adminUser = (AdminUser) request.getSession().getAttribute(Constants.AdminConstant.ADMIN_SESSION_USER);
        if (null != adminUser) {
            // 跳转到后台首页
            view.setViewName(("redirect:/admin/"));
        }
        return view;
    }

    /**
     * 登陆方法
     *
     * @return
     */
    @RequestMapping(value = "/checkUser.html")
    @ResponseBody
    @LoginCheckAnnotation(type = "")
    public JSONObject checkAdminUser(HttpServletRequest request, HttpServletResponse response) {

        String retCode = "success";
        String retMsg = "";
        // 已经登陆的-后台首页
        AdminUser adminUser = (AdminUser) request.getSession().getAttribute(Constants.AdminConstant.ADMIN_SESSION_USER);
        if (null != adminUser) {
            try {
                response.sendRedirect("/admin");
            } catch (IOException e) {

            }
        }

        String userName = request.getParameter("userName");
        String password = request.getParameter("password");


        // 数据为空，登陆页面
        if (CommonUtils.isEmpty(userName) || CommonUtils.isEmpty(password)) {
            retCode = "error";
            retMsg = "用户名或密码为空";
        } else {
            String enPwd = CryptUtil.sha1(password);
            adminUser = userService.getAdminUserByNameAndPwd(userName, enPwd);
            if (null != adminUser) {
                // 跳转到管理控制页面
                request.getSession().setAttribute(Constants.AdminConstant.ADMIN_SESSION_USER, adminUser);
            } else {
                retCode = "error";
                retMsg = "用户名或密码错误";
            }
        }

        Map<String, Object> retMap = new HashMap<>();
        retMap.put("retCode", retCode);
        retMap.put("retMsg", retMsg);
        List<AdminUser> list = new ArrayList();

        AdminUser adminUserById = userService.getAdminUserById(1);

        list.add(adminUserById);
        list.add(adminUserById);
        list.add(adminUserById);
        list.add(adminUserById);

        retMap.put("userList", 1);

        return JSONObject.fromObject(retMap);
    }

    /**
     * 登陆方法
     *
     * @return
     */
    @RequestMapping(value = "/doLogin.html")
    @LoginCheckAnnotation(type = "")
    public ModelAndView doLogin(HttpServletRequest request) {

        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        ModelAndView view = new ModelAndView();

        // 已经登陆的-后台首页
        AdminUser adminUser = (AdminUser) request.getSession().getAttribute(Constants.AdminConstant.ADMIN_SESSION_USER);
        if (null != adminUser) {
            // 跳转到后台首页
            view.setViewName(("redirect:/admin/"));
            return view;
        }

        // 数据为空，登陆页面
        if (CommonUtils.isEmpty(userName) || CommonUtils.isEmpty(password)) {
            view.setViewName("redirect:/admin/login.html");
            return view;
        } else {
            String enPwd = CryptUtil.sha1(password);
            adminUser = userService.getAdminUserByNameAndPwd(userName, enPwd);
            if (null != adminUser) {
                // 跳转到管理控制页面
                request.getSession().setAttribute(Constants.AdminConstant.ADMIN_SESSION_USER, adminUser);
                view.setViewName(("redirect:/admin/"));
            }
        }
        return view;
    }

    /**
     * 默认后台地址
     *
     * @return
     */
    @RequestMapping(value = "")
    public ModelAndView indexDef() {
        ModelAndView view = new ModelAndView();
        view.setViewName("ftl/index");
        return view;
    }
}
