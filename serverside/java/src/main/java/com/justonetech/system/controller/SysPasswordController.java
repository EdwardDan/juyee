package com.justonetech.system.controller;

import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.utils.CryptUtil;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.system.daoservice.SysUserService;
import com.justonetech.system.domain.SysUser;
import com.justonetech.system.manager.UserSessionManager;
import com.justonetech.system.utils.Md5Utils;
import org.hibernate.util.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.List;

/**
 * 密码修改
 * User: Chen Junping
 * Date: 12-2-29
 */
@Controller
public class SysPasswordController extends BaseCRUDActionController {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private UserSessionManager userSessionManager;

    /**
     * 修改密码
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String changePass(Model model) {

        return "view/system/sysUser/pass_input";
    }

    /**
     * 保存密码
     *
     * @param model    .
     * @param response .
     * @param request  .
     */
    @RequestMapping
    public void savePass(Model model, HttpServletResponse response, HttpServletRequest request) {
        try {
            SysUser loginedUser = userSessionManager.getLoginedUser();
//            SysUser loginedUser = sysUserService.get(1L);
            if (loginedUser != null) {
                String oldPass = request.getParameter("oldPass");
                String savedPass = loginedUser.getPassword();
                if (!StringHelper.isEmpty(savedPass)) {
                    savedPass = CryptUtil.decrypt(savedPass);
                }
                if (StringHelper.isEmpty(oldPass) && !StringHelper.isEmpty(savedPass)) {
                    sendFailureJSON(response, "原密码输入不正确，请重新输入");
                    return;
                }
                if (!StringHelper.isEmpty(oldPass) && !StringHelper.isEmpty(savedPass)) {
                    if (!savedPass.equals(oldPass)) {
                        sendFailureJSON(response, "原密码输入不正确，请重新输入");
                        return;
                    }
                }

                String newPass = request.getParameter("newPass");
                if (!StringHelper.isEmpty(newPass)) {
                    if (newPass.length() >= 4) {
                        loginedUser.setPassword(CryptUtil.encrypt(newPass));
                        loginedUser.setMd5Pass(Md5Utils.md5(newPass));
                        loginedUser.setPasswordUpdateTime(new Timestamp(System.currentTimeMillis()));
                        sysUserService.save(loginedUser);

                    } else {
                        sendFailureJSON(response, "密码长度不能小于4位！");
                        return;
                    }
                } else {
                    sendFailureJSON(response, "密码不能为空！");
                    return;
                }

            } else {
                sendFailureJSON(response, "当前用户不存在");
                return;
            }

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
            return;
        }
        sendSuccessJSON(response, "保存成功");
    }

    /**
     * 批量更新md5密码
     *
     * @param response .
     */
    @RequestMapping
    public void updateMd5Pass(HttpServletResponse response) throws Exception {
        List<SysUser> list = sysUserService.findAll();
        for (SysUser user : list) {
            String password = JspHelper.getString(user.getPassword());
            if (password.length() > 20) {
                password = CryptUtil.decrypt(password);
            }
            if (!StringHelper.isEmpty(password)) {
                user.setMd5Pass(Md5Utils.md5(password));
                sysUserService.save(user);
            }
        }
        sendSuccessJSON(response, "批量设置成功");
    }
}
