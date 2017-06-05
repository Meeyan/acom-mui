package com.acom.controller.admin;

import com.acom.entities.model.AdminUser;
import com.acom.filter.LoginCheckAnnotation;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 首页
 */
@Controller("adminController")  // 必须加这个，否则会和web下的indexController出现冲突，如果没有重名的，可以忽略
@RequestMapping(value = "/admin")
@LoginCheckAnnotation(type = LoginCheckAnnotation.ADMIN)
public class IndexController {

    private Logger log = Logger.getLogger(IndexController.class);

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
     * @return
     */
    @RequestMapping(value = "/login.html")
    public ModelAndView login() {
        ModelAndView view = new ModelAndView();
        view.setViewName("/admin/login");
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
        view.setViewName("admin/index");
        return view;
    }
}
