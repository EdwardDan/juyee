package com.justonetech.system.controller;

import com.justonetech.biz.manager.CustomGridManager;
import com.justonetech.biz.manager.indexGrid.CustomGridData;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.system.daoservice.SysCustomGridService;
import com.justonetech.system.daoservice.SysCustomGridUserService;
import com.justonetech.system.domain.SysCustomGrid;
import com.justonetech.system.domain.SysCustomGridUser;
import com.justonetech.system.domain.SysUser;
import com.justonetech.system.manager.SysUserManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * note:系统首页用户订制
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class SysCustomGridUserController extends BaseCRUDActionController<SysCustomGridUser> {
    private Logger logger = LoggerFactory.getLogger(SysCustomGridUserController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private SysCustomGridService sysCustomGridService;

    @Autowired
    private SysCustomGridUserService sysCustomGridUserService;

    @Autowired
    private CustomGridManager customGridManager;

    /**
     * 选择版块页面
     *
     * @param orderNo .
     * @param model   .
     * @return .
     */
    @RequestMapping
    public String select(Model model, int orderNo) {
        String hql = "from SysCustomGrid where isValid=1 order by orderNo asc";
        List<SysCustomGrid> list = sysCustomGridService.findByQuery(hql);
        List<Map<String, Object>> ret = new ArrayList<Map<String, Object>>();
        for (SysCustomGrid sysCustomGrid : list) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("grid", sysCustomGrid);
            map.put("privilege", sysUserManager.hasPrivilege(sysCustomGrid.getPrivilege().getCode()));
            ret.add(map);
        }
        model.addAttribute("list", ret);
        model.addAttribute("orderNo", orderNo);

        //选中的版块序号
        CustomGridData gridData = customGridManager.getGridData(orderNo);
        model.addAttribute("checkedNo", gridData != null ? gridData.getCheckedNo() : "");

        return "view/system/sysCustomGridUser/select";
    }

    /**
     * 保存操作
     *
     * @param response     .
     * @param customGridId .
     * @throws Exception .
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void save(HttpServletResponse response, Long customGridId, int orderNo) throws Exception {
        try {
            SysCustomGrid sysCustomGrid = sysCustomGridService.get(customGridId);
            SysUser sysUser = sysUserManager.getSysUser();
            if (sysUser != null) {
                SysCustomGridUser data;
                List<SysCustomGridUser> list = sysCustomGridUserService.findByQuery("from SysCustomGridUser where userName=? and orderNo=?", sysUser.getLoginName(), orderNo);
                if (list.size() > 0) {
                    data = list.iterator().next();
                } else {
                    data = new SysCustomGridUser();
                }
                data.setUserName(sysUser.getLoginName());
                data.setCustomGrid(sysCustomGrid);
                data.setOrderNo(orderNo);
                sysCustomGridUserService.save(data);
            }

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
            return;
        }
        sendSuccessJSON(response, "设置成功");
    }
}