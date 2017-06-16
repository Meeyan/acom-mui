package com.acom.controller;

import org.springframework.web.servlet.ModelAndView;

/**
 * 专用的解析视图的方法 <p />
 *
 * @author zhaojy
 * @createTime 2017-06-16
 */
public class BaseController {

    /**
     * controller专用
     * freemarker模板位置 - 对应-ftl/fadmin
     *
     * @param path 模板名称
     * @return ModelAndView
     */
    protected final ModelAndView getFtlAdminMV(String path) {
        ModelAndView view = new ModelAndView();
        view.setViewName("fadmin/" + path);
        return view;
    }

    /**
     * controller专用
     * freemarker模板位置 - 对应-ftl/fweb
     *
     * @param path 模板名称
     * @return ModelAndView
     */
    protected final ModelAndView getFtlWebMV(String path) {
        ModelAndView view = new ModelAndView();
        view.setViewName("fweb/" + path);
        return view;
    }

    /**
     * controller专用
     * freemarker模板位置 - 对应--ftl/fadmin
     *
     * @param view ModelAndView
     * @param path 模板名称
     */
    protected final void setFtlAdminViewName(ModelAndView view, String path) {
        view.setViewName("fadmin/" + path);
    }

    /**
     * controller专用
     * freemarker模板位置 - 对应--ftl/fweb
     *
     * @param view ModelAndView
     * @param path 模板名称
     */
    public final void setFtlWebViewName(ModelAndView view, String path) {
        view.setViewName("fweb/" + path);
    }

    /**
     * controller专用
     * jsp模板位置 - 对应--jsp/jadmin目录
     *
     * @param path 模板名称
     * @return ModelAndView
     */
    public final ModelAndView getJspAdminMV(String path) {
        ModelAndView view = new ModelAndView();
        view.setViewName("jadmin/" + path);
        return view;
    }

    /**
     * controller专用
     * jsp模板位置 - 对应--jsp/jweb 目录
     *
     * @param path 模板名称
     * @return ModelAndView
     */
    public final ModelAndView getJspWebMV(String path) {
        ModelAndView view = new ModelAndView();
        view.setViewName("jweb/" + path);
        return view;
    }

    /**
     * jsp模板位置 - 对应--jsp/jweb 目录
     *
     * @param view ModelAndView
     * @param path 模板名称
     */
    public final void setJspWebViewName(ModelAndView view, String path) {
        view.setViewName("jweb/" + path);
    }

    /**
     * jsp模板位置 - 对应--jsp/jadmin 目录
     *
     * @param view ModelAndView
     * @param path 模板名称
     */
    public final void setJspAdminViewName(ModelAndView view, String path) {
        view.setViewName("jadmin/" + path);
    }

}
