package com.acom.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 首页
 */
@Controller
@RequestMapping(value = "")
public class IndexController {

    private Logger log = Logger.getLogger(IndexController.class);

    public Object index() {
        return null;
    }

    @RequestMapping(value = "/test")
    public ModelAndView test() {
        ModelAndView view = new ModelAndView();
        view.setViewName("index");
        return view;
    }
}
