package com.acom.controller.web;

import com.acom.entities.model.AdminUser;
import com.acom.services.sv.IUserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * 首页
 */
@Controller("indexController")
@RequestMapping(value = "")
public class IndexController {

    private Logger log = Logger.getLogger(IndexController.class);

    @Resource(name = "userService")
    IUserService userService;

    /**
     * 网站默认映射到该路径下，webapp下不能有index.jsp文件，或者在index.jsp中导向到'/'
     *
     * @return ModelAndView
     */
    @RequestMapping(value = "/")
    public ModelAndView index() {
        ModelAndView view = new ModelAndView();
        view.setViewName("jsp/index");
        AdminUser adminUserById = userService.getAdminUserById(1);
        System.out.println(adminUserById.getNickName());
        return view;
    }

    @RequestMapping(value = "/login.html")
    public ModelAndView login() {
        ModelAndView view = new ModelAndView();
        view.setViewName("jsp/login");
        return view;
    }
}