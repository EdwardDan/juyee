package com.justonetech.biz.controller.android;

import com.justonetech.biz.utils.Constants;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.utils.CryptUtil;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.domain.SysUser;
import com.justonetech.system.manager.SysLogCustomManager;
import com.justonetech.system.manager.SysUserManager;
import flexjson.JSONSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 移动终端登陆验证
 * User: Chenjp
 * Date: 12-10-24 上午9:35
 */
@Controller
public class AndroidLoginController extends BaseCRUDActionController {
    private Logger logger = LoggerFactory.getLogger(AndroidLoginController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private SysLogCustomManager sysLogManager;

    /**
     * 获取最新版本信息
     *
     * @return .
     */
    @RequestMapping
    public String checkLogin(Model model, HttpServletRequest request,HttpServletResponse response) {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("success", false);

        if (!StringHelper.isEmpty(userName) && !StringHelper.isEmpty(password)) {
            userName = StringHelper.findAndReplace(userName, "'", "");
            SysUser sysUser = sysUserManager.getSysUser(userName);
            if (sysUser != null) {
                String ps = sysUser.getPassword();
                if (!StringHelper.isEmpty(ps)) {
                    try {
                        if (password.equals(CryptUtil.decrypt(ps))) {
                            map.put("success", true);
                            map.put("userId", sysUser.getId());
                            map.put("userName", sysUser.getLoginName());
                            map.put("displayName", sysUser.getDisplayName());
                            map.put("privilegeCodes", "");

                            //记录系统日志
                            sysLogManager.log(request, Constants.LOG_TYPE_LOGIN);
                        }
                    } catch (Exception e) {
                        logger.debug("Android user:" + userName + " check login fail!");
                    }
                }
            }
        }
        model.addAttribute("msg", new JSONSerializer().exclude("*.class").serialize(map));

        return "common/msg";
    }
}
