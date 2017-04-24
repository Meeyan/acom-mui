package com.acom.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 首页
 */
@Controller
@RequestMapping(value = "/test")
public class TestController {

    private Logger log = Logger.getLogger(TestController.class);

    /**
     * 网站默认映射到该路径下，webapp下不能有index.jsp文件，或者在index.jsp中导向到'/'
     *
     * @return ModelAndView
     */
    @RequestMapping(value = "/")
    public ModelAndView index() {
        ModelAndView view = new ModelAndView();
        view.setViewName("index");
        return view;
    }

    @RequestMapping(value = "/test")
    public ModelAndView test() {
        ModelAndView view = new ModelAndView();
        view.setViewName("test");
        return view;
    }
}
