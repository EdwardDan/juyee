package com.justonetech.biz.controller.polling;

import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.PollingBelongAreaService;
import com.justonetech.biz.daoservice.PollingGroupUserService;
import com.justonetech.biz.daoservice.PollingWorkGroupService;
import com.justonetech.biz.domain.PollingBelongArea;
import com.justonetech.biz.domain.PollingGroupUser;
import com.justonetech.biz.domain.PollingWorkGroup;
import com.justonetech.biz.utils.Constants;
import com.justonetech.system.daoservice.SysCodeDetailService;
import com.justonetech.system.daoservice.SysUserService;
import com.justonetech.system.domain.SysCodeDetail;
import com.justonetech.system.domain.SysUser;
import com.justonetech.system.manager.SysUserManager;
import com.justonetech.system.utils.PrivilegeCode;
import org.hibernate.util.StringHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;


/**
 * author:
 * create date:
 * modify date:
 */
@Controller
public class PollingWorkGroupController extends BaseCRUDActionController<PollingWorkGroup> {
    private Logger logger = LoggerFactory.getLogger(PollingWorkGroupController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private PollingWorkGroupService pollingWorkGroupService;

    @Autowired
    private PollingBelongAreaService pollingBelongAreaService;

    @Autowired
    private SysCodeDetailService sysCodeDetailService;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private PollingGroupUserService pollingGroupUserService;

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {
        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.POLLING_WORKGROUP_EDIT));

        return "view/polling/pollingWorkGroup/grid";
    }

    /**
     * 获取列表数据
     *
     * @param response .
     * @param filters  .
     * @param columns  .
     * @param page     .
     * @param rows     .
     */
    @RequestMapping
    public void gridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows, HttpSession session) {
        try {
            Page<PollingWorkGroup> pageModel = new Page<PollingWorkGroup>(page, rows, true);
            String hql = "from PollingWorkGroup order by id desc";
            //增加自定义查询条件

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            String query = queryTranslate.toString();
            pageModel = pollingWorkGroupService.findByPage(pageModel, query);
            session.setAttribute(Constants.GRID_SQL_KEY, query);

            //输出显示
            String json = GridJq.toJSON(columns, pageModel);
            sendJSON(response, json);

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
        }
    }

    /**
     * 新增录入页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String add(Model model) {
        PollingWorkGroup pollingWorkGroup = new PollingWorkGroup();

        //如需增加其他默认值请在此添加

        //责任区域
        model.addAttribute("zrqu", Constants.POLLING_WORK_GROUP_ZRQU);

        model.addAttribute("bean", pollingWorkGroup);

        return "view/polling/pollingWorkGroup/input";
    }

    /**
     * 新增工作组成员录入页面
     *
     * @param model  .
     * @param userId .
     * @return .
     */
    @RequestMapping
    public String getUserRow(Model model, String userId) {
        String rows = "";
        String name;
        String deptName;
        if (!StringHelper.isEmpty(userId)) {
            String[] userIds = userId.split(",");
            for (String id : userIds) {
                SysUser sysUser = sysUserService.get(Long.valueOf(id));
                name = sysUser.getDisplayName();
                deptName = sysUser.getPerson().getDeptName();

                rows += "<tr class=\"tr_dark\" id=\"" + id + "\">"
                        + "<td id=\"userName" + id + "\" name=\"userName" + id + "\" value=\"" + id + "\">" + name + "</td>"
                        + "<td>" + deptName + "</td>"
                        + "<td><select id=\"isCharge" + id + "\" name=\"isCharge" + id + "\" class=\"form_select\" style=\"width: 42px\"><option value=\"0\">否</option><option value=\"1\">是</option></select></td>" +
                        "<td><input type=\"button\" class=\"button_normal\" value=\"删除\" onClick=\"deleteAttachRow('" + id + "')\"></td></tr>";

            }
        }

        model.addAttribute("rows", rows);
        return "view/polling/pollingWorkGroup/getUserRow";
    }


    /**
     * 修改显示页面
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String modify(Model model, Long id) {
        PollingWorkGroup pollingWorkGroup = pollingWorkGroupService.get(id);

        //处理其他业务逻辑

        //取得相关巡查属地区域
        Set<PollingBelongArea> pollingBelongAreas = pollingWorkGroup.getPollingBelongAreas();
        String belongAreaOptions = "";
        SysCodeDetail sysCodeDetail;
        for (PollingBelongArea pollingBelongArea : pollingBelongAreas) {
            sysCodeDetail = pollingBelongArea.getBelongArea();
            belongAreaOptions += "<option value=\"" + sysCodeDetail.getId() + "\">" + sysCodeDetail.getName() + "</option>\n";
        }

        //取得相关工作组成员
        Set<PollingGroupUser> pollingGroupUsers = pollingWorkGroup.getPollingGroupUsers();
        if (pollingGroupUsers.size() != 0) {
            List<Map<String, Object>> userList = new ArrayList<Map<String, Object>>();
            SysUser sysUser;
            String userIds = "";
            Map<String, Object> map;
            for (PollingGroupUser pollingGroupUser : pollingGroupUsers) {
                map = new HashMap<String, Object>();
                sysUser = pollingGroupUser.getUser();
                userIds += sysUser.getId() + ",";
                map.put("sysUserId", sysUser.getId());
                map.put("userName", sysUser.getDisplayName());
                map.put("deptName", sysUser.getPerson().getDeptName());
                map.put("isCharge", pollingGroupUser.getIsCharge());

                userList.add(map);
            }
            userIds = userIds.substring(0, userIds.length() - 1);
            model.addAttribute("userList", userList);
            model.addAttribute("userIds", userIds);
        }

        //责任区域
        model.addAttribute("zrqu", Constants.POLLING_WORK_GROUP_ZRQU);
        model.addAttribute("bean", pollingWorkGroup);
        model.addAttribute("belongAreaOptions", belongAreaOptions);

        return "view/polling/pollingWorkGroup/input";
    }

    /**
     * 查看页面
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String view(Model model, Long id) {
        PollingWorkGroup pollingWorkGroup = pollingWorkGroupService.get(id);

        //取得相关巡查属地区域
        Set<PollingBelongArea> pollingBelongAreas = pollingWorkGroup.getPollingBelongAreas();
//        String belongAreaOptions = "";
        String belongAreaNames = "";
//        SysCodeDetail sysCodeDetail;
        if (pollingBelongAreas.size() != 0) {
            for (PollingBelongArea pollingBelongArea : pollingBelongAreas) {
//            sysCodeDetail = pollingBelongArea.getBelongArea();
//            belongAreaOptions += "<option value=\"" + sysCodeDetail.getId() + "\">" + sysCodeDetail.getName() + "</option>\n";
                belongAreaNames += pollingBelongArea.getBelongArea().getName() + "，";
            }
            belongAreaNames = belongAreaNames.substring(0, belongAreaNames.length() - 1);
        }
        //取得相关工作组成员
        Set<PollingGroupUser> pollingGroupUsers = pollingWorkGroup.getPollingGroupUsers();
        if (pollingGroupUsers.size() != 0) {
            List<Map<String, Object>> userList = new ArrayList<Map<String, Object>>();
            SysUser sysUser;
            Map<String, Object> map;
            for (PollingGroupUser pollingGroupUser : pollingGroupUsers) {
                map = new HashMap<String, Object>();
                sysUser = pollingGroupUser.getUser();
                map.put("sysUserId", sysUser.getId());
                map.put("userName", sysUser.getDisplayName());
                map.put("deptName", sysUser.getPerson().getDeptName());
                map.put("isCharge", pollingGroupUser.getIsCharge() ? "是" : "否");

                userList.add(map);
            }
            model.addAttribute("userList", userList);
        }
        //处理其他业务逻辑
        model.addAttribute("bean", pollingWorkGroup);
//        model.addAttribute("belongAreaOptions", belongAreaOptions);
        model.addAttribute("belongAreaNames", belongAreaNames);

        model.addAttribute("bean", pollingWorkGroup);
        return "view/polling/pollingWorkGroup/view";
    }

    /**
     * 保存操作
     *
     * @param response .
     * @param entity   .
     * @param request  .
     * @param userIds  .
     * @return .
     * @throws Exception .
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void save(HttpServletResponse response, @ModelAttribute("bean") PollingWorkGroup entity, HttpServletRequest request, String userIds) throws Exception {
        try {
            PollingWorkGroup target;
            if (entity.getId() != null) {
                target = pollingWorkGroupService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "name",
                        "memo",
                });

            } else {
                target = entity;
            }
            pollingWorkGroupService.save(target);

            //保存相关巡查属地区域
            //保存前先删除之前的相关记录
            Set<PollingBelongArea> pollingBelongAreas = target.getPollingBelongAreas();
            for (PollingBelongArea pollingBelongArea : pollingBelongAreas) {
                pollingBelongAreaService.delete(pollingBelongArea);
            }

            String sysCodeIdsString = request.getParameter("belongAreaId");
            if (!StringHelper.isEmpty(sysCodeIdsString)) {
                String[] sysCodeIds = sysCodeIdsString.split(",");
                for (String sysCodeId : sysCodeIds) {
                    SysCodeDetail sysCodeDetail = sysCodeDetailService.get(Long.valueOf(sysCodeId));
                    PollingBelongArea pollingBelongArea = new PollingBelongArea();
                    pollingBelongArea.setBelongArea(sysCodeDetail);
                    pollingBelongArea.setGroup(target);
                    pollingBelongAreaService.save(pollingBelongArea);
                }
            }

            //保存相关工作组成员
            //保存前先删除之前的相关记录
            Set<PollingGroupUser> pollingGroupUsers = target.getPollingGroupUsers();
            for (PollingGroupUser pollingGroupUser : pollingGroupUsers) {
                pollingGroupUserService.delete(pollingGroupUser);
            }
            if (!StringHelper.isEmpty(userIds)) {
                String[] ids = userIds.split(",");
                for (String id : ids) {
                    String isCharge = request.getParameter("isCharge" + id);
                    if (isCharge != null) {
                        PollingGroupUser pollingGroupUser = new PollingGroupUser();
                        SysUser sysUser = sysUserService.get(Long.valueOf(id));
                        pollingGroupUser.setGroup(target);
                        pollingGroupUser.setIsCharge(isCharge.equals("1"));
                        pollingGroupUser.setUser(sysUser);
                        pollingGroupUserService.save(pollingGroupUser);
                    }
                }
            }

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
            return;
        }

        sendSuccessJSON(response, "保存成功");
    }

    /**
     * 删除操作
     *
     * @param response .
     * @param id       .
     * @throws Exception .
     */
    @RequestMapping
    public void delete(HttpServletResponse response, Long id) throws Exception {
        PollingWorkGroup pollingWorkGroup = pollingWorkGroupService.get(id);
        //删除之前先删除子表的相关记录
        //删除巡查属地区域
        Set<PollingBelongArea> pollingBelongAreas = pollingWorkGroup.getPollingBelongAreas();
        for (PollingBelongArea pollingBelongArea : pollingBelongAreas) {
            pollingBelongAreaService.delete(pollingBelongArea);
        }
        //删除之前先删除子表的相关记录
        //删除工作组成员
        Set<PollingGroupUser> pollingGroupUsers = pollingWorkGroup.getPollingGroupUsers();
        for (PollingGroupUser pollingGroupUser : pollingGroupUsers) {
            pollingGroupUserService.delete(pollingGroupUser);
        }
        pollingWorkGroupService.delete(id);

        sendSuccessJSON(response, "删除成功");
    }

}