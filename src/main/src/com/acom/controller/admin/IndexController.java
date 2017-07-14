package com.acom.controller.admin;

import com.acom.controller.BaseController;
import com.acom.entities.model.AdminRole;
import com.acom.entities.model.AdminUser;
import com.acom.filter.LoginCheckAnnotation;
import com.acom.services.sv.IAdminUserService;
import com.acom.util.CommonUtils;
import com.acom.util.Constants;
import com.acom.util.CryptUtil;
import com.acom.util.RandomValidateCode;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
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
public class IndexController extends BaseController {

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
        return this.getFtlAdminMV("index");
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
        ModelAndView view = this.getFtlAdminMV("login");
        AdminUser adminUser = (AdminUser) request.getSession().getAttribute(Constants.AdminConstant.ADMIN_SESSION_USER);
        if (null != adminUser) {
            // 跳转到后台首页
            this.setFtlAdminViewName(view, "index");
        }
        return view;
    }

    /**
     * 登陆方法 - 验证名称是否正确
     * 1. 判断当前是否由用户登录，有登录的话，直接跳转到后台
     * 2. 验证密码和用户名
     *
     * @return JSONObject
     * @author zhaojy
     * @createTime 2017-06-15
     */
    @RequestMapping(value = "/checkUser.html")
    @ResponseBody
    @LoginCheckAnnotation(type = "")
    public JSONObject checkAdminUser(HttpServletRequest request, HttpServletResponse response) {
        String method = request.getMethod();
        String retCode = "success";
        String retMsg = "";
        if ("GET".equalsIgnoreCase(method)) {
            retCode = "error";
            retMsg = "异常登陆";
        } else {
            String contextPath = request.getContextPath();    // 去除host的url
            // 已经登陆的-后台首页
            AdminUser adminUser = (AdminUser) request.getSession().getAttribute(Constants.AdminConstant.ADMIN_SESSION_USER);
            if (null != adminUser) {
                try {
                    response.sendRedirect(contextPath + "/admin");
                } catch (IOException e) {
                    log.error("----登录验证跳转异常:" + e.getMessage());
                }
            }

            String userName = request.getParameter("userName");
            String password = request.getParameter("password");
            String imageCode = request.getParameter("imageCode");
            // 数据为空，登陆页面
            if (CommonUtils.isEmpty(userName) || CommonUtils.isEmpty(password)) {
                retCode = "error";
                retMsg = "用户名或密码为空";
            } else {
                String sessionId = request.getSession().getId();
                String sessionImgCode = (String) request.getSession().getAttribute(sessionId + Constants.AdminConstant.ADMIN_IMAGE_CODE_KEY);
                if (CommonUtils.isEmpty(imageCode) || CommonUtils.isEmpty(imageCode) || !imageCode.equalsIgnoreCase(sessionImgCode)) {
                    retCode = "error";
                    retMsg = "图片验证码不正确";
                } else {
                    String enPwd = CryptUtil.sha1(password);
                    adminUser = userService.getAdminUserByNameAndPwd(userName, enPwd);
                    if (null == adminUser) {
                        retCode = "error";
                        retMsg = "用户名或密码错误";
                    }
                }
            }
        }
        Map<String, Object> retMap = new HashMap<>();
        retMap.put("retCode", retCode);
        retMap.put("retMsg", retMsg);
        return JSONObject.fromObject(retMap);
    }

    /**
     * 登陆方法
     * 校验用户名和密码，设定session，跳转路径
     *
     * @return ModelAndView
     * @author zhaojy
     * @createTime 2017-06-15
     */
    @RequestMapping(value = "/doLogin.html")
    @LoginCheckAnnotation(type = "")
    public ModelAndView doLogin(HttpServletRequest request) {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        ModelAndView view = this.getFtlAdminMV("login");  // 初始化为登陆的视图

        String contextPath = request.getContextPath();
        // 已经登陆的-后台首页
        AdminUser adminUser = (AdminUser) request.getSession().getAttribute(Constants.AdminConstant.ADMIN_SESSION_USER);
        if (null != adminUser) {
            // 跳转到后台首页
            this.setFtlAdminViewName(view, "index");
            return view;
        }
        // 数据不为空，后台中心页面
        if (!CommonUtils.isEmpty(userName) && !CommonUtils.isEmpty(password)) {
            String enPwd = CryptUtil.sha1(password);
            adminUser = userService.getAdminUserByNameAndPwd(userName, enPwd);
            if (null != adminUser) {
                // 跳转到管理控制页面
                request.getSession().setAttribute(Constants.AdminConstant.ADMIN_SESSION_USER, adminUser);
                request.getSession().setAttribute(request.getSession().getId() + Constants.AdminConstant.ADMIN_IMAGE_CODE_KEY, null);
                this.setFtlAdminViewName(view, "index");
            }
        }

        return view;
    }

    /**
     * 生成图片验证码
     * todo 注意：生成图片验证码时，不需要返回值，如果单纯返回一个空置，会报错，view解析不到
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "getImageCode.html")
    @LoginCheckAnnotation(type = "")
    public void getImageCode(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("image/jpeg");          // 设置相应类型,告诉浏览器输出的内容为图片
        response.setHeader("Pragma", "No-cache");       // 设置响应头信息，告诉浏览器不要缓存此内容
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Set-Cookie", "name=value; HttpOnly");   //设置HttpOnly属性,防止Xss攻击
        response.setDateHeader("Expire", 0);
        RandomValidateCode randomValidateCode = new RandomValidateCode();
        try {
            randomValidateCode.getRandCode(request, response);// 输出图片方法
        } catch (Exception e) {
            log.error("----生成图片验证码错误:" + e.getMessage());
        }
    }

    /**
     * 注销登录方法
     *
     * @param request
     * @return ModelAndView
     */
    @RequestMapping(value = "logout.html")
    @LoginCheckAnnotation(type = "")
    public ModelAndView logout(HttpServletRequest request) {
        request.getSession().setAttribute(Constants.AdminConstant.ADMIN_SESSION_USER, null);
        request.getSession().setAttribute(request.getSession().getId() + Constants.AdminConstant.ADMIN_IMAGE_CODE_KEY, null);
        return this.getFtlAdminMV("login");  // 初始化为登陆的视图
    }

    /**
     * 角色列表-page
     *
     * @return ModelAndView
     * @author zhaojy
     * @createTime 2017-07-14
     */
    @RequestMapping(value = "/roles.html")
    public ModelAndView roleView() {
        List<AdminRole> roleList = userService.getRoleList();
        ModelAndView view = this.getJspAdminMV("roleList");
        view.addObject("roleList", roleList);
        return view;
    }

    /**
     * 角色列表-data
     *
     * @return ModelAndView
     * @author zhaojy
     * @createTime 2017-07-14
     */
    @RequestMapping(value = "/loadRoleData.html")
    @ResponseBody
    public JSONArray loadRoleData() {
        List<AdminRole> roleList = userService.getRoleList();
        List<Map> dataList = new ArrayList<>();
        // 树中的数据只能是字符串，不能为其他类型
        for (AdminRole role : roleList) {
            Map<String, Object> tmpMap = new HashMap<>();
            Integer id = role.getId();
            String name = role.getName();
            tmpMap.put("id", id + "");
            tmpMap.put("text", name);
            tmpMap.put("value", id + "");
            tmpMap.put("parentnodes", "0");
            tmpMap.put("showcheck", false);
            tmpMap.put("hasChildren", false);
            tmpMap.put("isexpand", false);
            tmpMap.put("complete", false);
            tmpMap.put("ChildNodes", new ArrayList<>());
            dataList.add(tmpMap);
        }
        return JSONArray.fromObject(dataList);
    }

    /**
     * 默认后台地址
     *
     * @return
     */
    @RequestMapping(value = "")
    public ModelAndView addModule() {
        return this.getFtlAdminMV("index");  // 初始化为登陆的视图
    }

    /**
     * 添加模块页面，添加之前不和权限关联，后面从新设置
     *
     * @return ModelAndView
     * @author zhaojy
     * @createTime 2017-07-14
     */
    @RequestMapping(value = "/addModule.html")
    public ModelAndView indexDef() {
        return this.getJspAdminMV("addModule");
    }
}
