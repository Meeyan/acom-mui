package com.acom.controller.admin;

import com.acom.controller.BaseController;
import com.acom.entities.model.AdminModule;
import com.acom.filter.LoginCheckAnnotation;
import com.acom.services.sv.IAdminUserService;
import com.acom.util.LogFactory;
import com.acom.util.TimeUtil;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 系统
 */
@Controller("systemController")
@RequestMapping(value = "/admin/system")
@LoginCheckAnnotation(type = LoginCheckAnnotation.ADMIN)
public class SystemController extends BaseController {

    private Logger log = LogFactory.getLogger(SystemController.class);

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
     * @param request
     * @return
     */
    @RequestMapping(value = "/saveModule.html")
    @ResponseBody
    public JSONObject saveModule(HttpServletRequest request) {
        String moduleName = request.getParameter("moduleName");
        String moduleDesc = request.getParameter("moduleDesc");
        AdminModule module = new AdminModule();
        module.setName(moduleName);
        module.setCreateTime(TimeUtil.getStandardTimestamp());
        module.setRemarks(moduleDesc);
        userService.saveAdminModule(module);
        Map<String, Objects> retMap = new HashMap<>();
        return JSONObject.fromObject(retMap);
    }
}
