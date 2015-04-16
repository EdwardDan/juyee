package com.justonetech.system.controller;

import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.daoservice.SysPushDefineService;
import com.justonetech.system.daoservice.SysPushUserService;
import com.justonetech.system.domain.SysPushDefine;
import com.justonetech.system.domain.SysPushUser;
import com.justonetech.system.domain.SysUser;
import com.justonetech.system.manager.SysUserManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;


/**
 * note:系统首页推送用户设置
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class SysPushUserController extends BaseCRUDActionController<SysPushUser> {
    private Logger logger = LoggerFactory.getLogger(SysPushUserController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private SysPushDefineService sysPushDefineService;

    @Autowired
    private SysPushUserService sysPushUserService;

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {
        //获取权限
        SysUser sysUser = sysUserManager.getSysUser();
        Long sysUserId = sysUser.getId();
        Set<String> privileges = sysUserManager.getUserPrivilegeCodesCache(sysUserId);

        //获取已设定的推送列表
        Map<Long, SysPushUser> existMap = new HashMap<Long, SysPushUser>();
        String userHql = "from SysPushUser where userName=?";
        List<SysPushUser> pushUsers = sysPushUserService.findByQuery(userHql, sysUser.getLoginName());
        for (SysPushUser pushUser : pushUsers) {
            existMap.put(pushUser.getPushDefine().getId(), pushUser);
        }

        //获取系统预定义的推送列表
        List<Map<String, Object>> retList = new ArrayList<Map<String, Object>>();
        String defineHql = "from SysPushDefine where isValid=1 order by orderNo asc,id asc";
        List<SysPushDefine> list = sysPushDefineService.findByQuery(defineHql);
        for (SysPushDefine sysPushDefine : list) {
            if (privileges.contains(sysPushDefine.getMenu().getPrivilege())) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("define", sysPushDefine);
                map.put("user", existMap.get(sysPushDefine.getId()));
                retList.add(map);
            }
        }
        model.addAttribute("list", retList);

        return "view/system/sysPushUser/grid";
    }

    /**
     * 移动顺序
     *
     * @param response .
     * @param request  .
     * @throws Exception
     */
    @RequestMapping
    public void move(HttpServletResponse response, HttpServletRequest request) throws Exception {
        try {

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
            return;
        }
        sendSuccessJSON(response, "移动成功");
    }

    /**
     * 保存操作
     *
     * @param response .
     * @param request  .
     * @throws Exception .
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void save(HttpServletResponse response, HttpServletRequest request) throws Exception {
        try {
            //先删除
            SysUser sysUser = sysUserManager.getSysUser();
            String loginName = sysUser.getLoginName();
            List<SysPushUser> list = sysPushUserService.findByQuery("from SysPushUser where userName=?", loginName);
            for (SysPushUser sysPushUser : list) {
                sysPushUserService.delete(sysPushUser);
            }

            //再添加
            String[] defineIds = request.getParameterValues("checkbox");
            if (defineIds != null) {
                for (String defineId : defineIds) {
                    SysPushDefine sysPushDefine = sysPushDefineService.get(Long.valueOf(defineId));
                    String orderNo = request.getParameter("orderNo_" + defineId);
                    SysPushUser data = new SysPushUser();
                    data.setPushDefine(sysPushDefine);
                    data.setUserName(loginName);
                    if (!StringHelper.isEmpty(orderNo)) {
                        data.setOrderNo(Integer.parseInt(orderNo));
                    } else {
                        data.setOrderNo(sysPushDefine.getOrderNo());
                    }
                    sysPushUserService.save(data);
                }
            }
        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
            return;
        }
        sendSuccessJSON(response, "保存成功");
    }
}