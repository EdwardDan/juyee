package com.justonetech.biz.controller.oa;

import java.sql.Timestamp;
import java.util.*;

import com.justonetech.biz.manager.MsgMessageManager;
import com.justonetech.biz.manager.OaTaskManager;
import com.justonetech.biz.utils.enums.OaCarStatus;
import com.justonetech.core.utils.*;
import com.justonetech.system.daoservice.SysDeptService;
import com.justonetech.system.daoservice.SysPersonService;
import com.justonetech.system.daoservice.SysUserService;
import com.justonetech.system.domain.SysDept;
import com.justonetech.system.domain.SysPerson;
import com.justonetech.system.domain.SysUser;

import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.OaCarService;
import com.justonetech.biz.domain.OaCar;

import com.justonetech.biz.manager.DocumentManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.biz.daoservice.DocDocumentService;
import com.justonetech.biz.manager.ConfigManager;
import com.justonetech.system.daoservice.SysCodeDetailService;
import com.justonetech.system.domain.SysCodeDetail;
import com.justonetech.system.manager.SysCodeManager;
import com.justonetech.system.manager.SysUserManager;
import com.justonetech.system.utils.PrivilegeCode;
import com.justonetech.system.manager.SimpleQueryManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * note:车辆申请
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class OaCarController extends BaseCRUDActionController<OaCar> {
    private Logger logger = LoggerFactory.getLogger(OaCarController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private SysCodeManager sysCodeManager;

    @Autowired
    private OaCarService oaCarService;

    @Autowired
    private SysDeptService sysDeptService;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysCodeDetailService sysCodeDetailService;

    @Autowired
    private OaTaskManager oaTaskManager;

    @Autowired
    private SysPersonService sysPersonService;

    @Autowired
    private MsgMessageManager msgMessageManager;

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {
        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.OA_CAR_EDIT));

        model.addAttribute("canKzAudit", sysUserManager.hasPrivilege(PrivilegeCode.OA_CAR_AUDIT_KZ));
        model.addAttribute("canZrAudit", sysUserManager.hasPrivilege(PrivilegeCode.OA_CAR_AUDIT_ZR));

        return "view/oa/oaCar/grid";
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
            Page pageModel = new Page(page, rows, true);
            String hql = "from OaCar order by id desc";
            //增加自定义查询条件

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            String query = queryTranslate.toString();
            session.setAttribute(Constants.GRID_SQL_KEY, query);
            pageModel = oaCarService.findByPage(pageModel, query);

            List<Map> gridValue = GridJq.getGridValue(pageModel.getRows(), columns);

            for (Map map : gridValue) {
                String beginTime = JspHelper.getString(map.get("beginTime"));
                String endTime = JspHelper.getString(map.get("endTime"));
                map.put("endTime", beginTime.substring(11, 16) + "-" + endTime.substring(11, 16));
            }
            //输出显示
            String json = GridJq.toJSON(gridValue, pageModel);
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
        OaCar oaCar = new OaCar();

        //取得可选择时间
        Calendar cal = Calendar.getInstance();
        model.addAttribute("startHour", DateTimeHelper.getHourSelectOptions(JspHelper.getString(cal.get(Calendar.HOUR))));
        model.addAttribute("startMinute", DateTimeHelper.getMinuteSelectOptions(JspHelper.getString(cal.get(Calendar.MINUTE))));
        model.addAttribute("endHour", DateTimeHelper.getHourSelectOptions(JspHelper.getString(cal.get(Calendar.HOUR))));
        model.addAttribute("endMinute", DateTimeHelper.getMinuteSelectOptions(JspHelper.getString(cal.get(Calendar.MINUTE))));

        //当前用户的部门/名字
        if (sysUserManager.getSysUser() != null && sysUserManager.getSysUser().getPerson() != null) {
            oaCar.setApplyDept(sysUserManager.getSysUser().getPerson().getDept());
        }
        oaCar.setApplyUser(sysUserManager.getSysUser());

        //选择车辆
        List<SysCodeDetail> carList = sysCodeManager.getCodeListByCode(Constants.OA_CAR_SELECT);

        modelStatus(model);
        model.addAttribute("carList", carList);

        //车辆使用日期默认当天
        oaCar.setBeginTime(new Timestamp(System.currentTimeMillis()));
        //如需增加其他默认值请在此添加
        model.addAttribute("bean", oaCar);

        return "view/oa/oaCar/input";
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
        OaCar oaCar = oaCarService.get(id);

        //处理其他业务逻辑
        modelInfo(model, oaCar);

        modelStatus(model);
        return "view/oa/oaCar/input";
    }

    /**
     * 修改显示页面
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String audit(Model model, Long id) {
        OaCar oaCar = oaCarService.get(id);

        modelStatus(model);
        //处理其他业务逻辑
        modelInfo(model, oaCar);
        //取得可选择时间
        String beginTime = JspHelper.getString(oaCar.getBeginTime());
        String endTime = JspHelper.getString(oaCar.getEndTime());
        model.addAttribute("startHour", beginTime.substring(11, 13));
        model.addAttribute("startMinute", beginTime.substring(14, 16));
        model.addAttribute("endHour", endTime.substring(11, 13));
        model.addAttribute("endMinute", endTime.substring(14, 16));
        return "view/oa/oaCar/audit";
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
        OaCar oaCar = oaCarService.get(id);
        //处理其他业务逻辑
        List<SysCodeDetail> carList = sysCodeManager.getCodeListByCode(Constants.OA_CAR_SELECT);

        modelStatus(model);
        model.addAttribute("carList", carList);
        model.addAttribute("bean", oaCar);
        String beginTime = JspHelper.getString(oaCar.getBeginTime());
        String endTime = JspHelper.getString(oaCar.getEndTime());
        //取得可选择时间
        model.addAttribute("startHour", beginTime.substring(11, 13));
        model.addAttribute("startMinute", beginTime.substring(14, 16));
        model.addAttribute("endHour", endTime.substring(11, 13));
        model.addAttribute("endMinute", endTime.substring(14, 16));

        return "view/oa/oaCar/view";
    }

    /**
     * 保存操作
     *
     * @param response .
     * @param entity   .
     * @param request  .
     * @throws Exception .
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void save(HttpServletResponse response, @ModelAttribute("bean") OaCar entity, HttpServletRequest request) throws Exception {
        try {
            OaCar target;
            if (entity.getId() != null) {
                target = oaCarService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "beginTime",
                        "endTime",
                        "personNum",
                        "useCause",
                        "address",
                        "driverMobile",
                        "status"
                });

            } else {
                target = entity;
            }
            //部门/申请人
            String applyDeptId = request.getParameter("applyDeptId");
            SysDept sysDept = sysDeptService.get(JspHelper.getLong(applyDeptId));

            String applyUserId = request.getParameter("applyUserId");
            SysUser sysUser = sysUserService.get(JspHelper.getLong(applyUserId));
            target.setApplyDept(sysDept);
            target.setApplyUser(sysUser);

            oaCarService.save(target);

            //创建提醒消息
            if (target.getStatus() == OaCarStatus.STATUS_SUBMIT.getCode()) {
                createOaTask(target);
            }
        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
            return;
        }
        if (entity.getStatus() == OaCarStatus.STATUS_SUBMIT.getCode()) {
            sendSuccessJSON(response, "提交成功");
        } else {
            sendSuccessJSON(response, "保存成功");
        }
    }

    /**
     * 保存操作
     *
     * @param response .
     * @param entity   .
     * @param request  .
     * @throws Exception .
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void auditSave(HttpServletResponse response, @ModelAttribute("bean") OaCar entity, HttpServletRequest request) throws Exception {
        try {
            OaCar target;
            if (entity.getId() != null) {
                target = oaCarService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "driverMobile",
                        "status"
                });
            } else {
                target = entity;
            }

            String kzAuditOpinion = request.getParameter("kzAuditOpinion");
            if (!StringHelper.isEmpty(kzAuditOpinion)) {
                target.setKzAuditOpinion(kzAuditOpinion);
            }
            String zrAuditOpinion = request.getParameter("zrAuditOpinion");
            if (!StringHelper.isEmpty(zrAuditOpinion)) {
                target.setZrAuditOpinion(zrAuditOpinion);
            }
            //拟派车辆
            String carId = request.getParameter("car");
            SysCodeDetail carDetail = null;
            if (carId != null && carId.length() > 0) {
                carDetail = sysCodeDetailService.get(JspHelper.getLong(carId));
            }

            //司机
            String driverPersonId = request.getParameter("driverPersonId");
            SysPerson sysPerson = null;
            if (driverPersonId != null && driverPersonId.length() > 0) {
                sysPerson = sysPersonService.get(JspHelper.getLong(driverPersonId));
            }
            target.setDriverPerson(sysPerson);
            target.setCar(carDetail);

            //保存审核人
            if (target.getStatus() == OaCarStatus.STATUS_BRANCH_PASS.getCode() || target.getStatus() == OaCarStatus.STATUS_BRANCH_BACK.getCode()) {
                target.setKzAuditUser(sysUserManager.getSysUser());
                target.setKzAuditTime(new Timestamp(System.currentTimeMillis()));
            } else if (target.getStatus() == OaCarStatus.STATUS_MAIN_PASS.getCode() || target.getStatus() == OaCarStatus.STATUS_MAIN_PASS.getCode()) {
                target.setZrAuditUser(sysUserManager.getSysUser());
                target.setZrAuditTime(new Timestamp(System.currentTimeMillis()));
            }

            oaCarService.save(target);

            //创建提醒消息
            if (target.getStatus() == OaCarStatus.STATUS_MAIN_BACK.getCode() ||
                    target.getStatus() == OaCarStatus.STATUS_BRANCH_BACK.getCode() || target.getStatus() == OaCarStatus.STATUS_MAIN_PASS.getCode()) {
                createOaTask(target);

                //发送信息提醒
                if (target.getStatus() == OaCarStatus.STATUS_MAIN_BACK.getCode() || target.getStatus() == OaCarStatus.STATUS_BRANCH_BACK.getCode()) {
                    msgMessageManager.sendSms(target.getApplyUser().getDisplayName() + "：你的车辆申请已被退回，请登录系统查看。", target.getApplyUser().getPerson().getMobile());
                }

                if (target.getStatus() == OaCarStatus.STATUS_MAIN_PASS.getCode()) {
                    String content = target.getApplyUser().getDisplayName() + "：你的车辆申请已通过。车牌：" + target.getCar().getName();
                    //判断司机是否存在
                    if (target.getDriverPerson() != null) {
                        content += "司机：" + target.getDriverPerson().getName();
                        msgMessageManager.sendSms(target.getApplyUser().getDisplayName() + "的车辆申请已通过，请" +
                                target.getDriverPerson().getName() + "在" + target.getBeginTime() + "为其司机。", target.getDriverMobile());
                    }
                    msgMessageManager.sendSms(content, target.getApplyUser().getPerson().getMobile());
                }
            }
        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
            return;
        }
        if (entity.getStatus() == OaCarStatus.STATUS_MAIN_PASS.getCode()) {
            sendSuccessJSON(response, "办公室主任审核通过");
        } else if (entity.getStatus() == OaCarStatus.STATUS_BRANCH_PASS.getCode()) {
            sendSuccessJSON(response, "科长审核通过");
        } else if (entity.getStatus() == OaCarStatus.STATUS_BRANCH_BACK.getCode()) {
            sendSuccessJSON(response, "科长审核退回");
        } else if (entity.getStatus() == OaCarStatus.STATUS_MAIN_BACK.getCode()) {
            sendSuccessJSON(response, "办公室主任审核退回");
        }
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
        oaCarService.delete(id);

        sendSuccessJSON(response, "删除成功");
    }

    /**
     * 整合传递数据
     *
     * @param model
     * @param oaCar
     */
    public void modelInfo(Model model, OaCar oaCar) {

        //处理其他业务逻辑
        List<SysCodeDetail> carList = sysCodeManager.getCodeListByCode(Constants.OA_CAR_SELECT);

        model.addAttribute("carList", carList);
        model.addAttribute("bean", oaCar);
        String beginTime = JspHelper.getString(oaCar.getBeginTime());
        String endTime = JspHelper.getString(oaCar.getEndTime());
        //取得可选择时间
        model.addAttribute("startHour", DateTimeHelper.getHourSelectOptions(beginTime.substring(11, 13)));
        model.addAttribute("startMinute", DateTimeHelper.getMinuteSelectOptions(beginTime.substring(14, 16)));
        model.addAttribute("endHour", DateTimeHelper.getHourSelectOptions(endTime.substring(11, 13)));
        model.addAttribute("endMinute", DateTimeHelper.getMinuteSelectOptions(endTime.substring(14, 16)));
    }

    /**
     * 权限控制
     *
     * @param model
     */
    public void modelStatus(Model model) {

        model.addAttribute("canKzAudit", sysUserManager.hasPrivilege(PrivilegeCode.OA_CAR_AUDIT_KZ));
        model.addAttribute("canZrAudit", sysUserManager.hasPrivilege(PrivilegeCode.OA_CAR_AUDIT_ZR));

        model.addAttribute("STATUS_EDIT", OaCarStatus.STATUS_EDIT.getCode());
        model.addAttribute("STATUS_SUBMIT", OaCarStatus.STATUS_SUBMIT.getCode());
        model.addAttribute("STATUS_BRANCH_PASS", OaCarStatus.STATUS_BRANCH_PASS.getCode());
        model.addAttribute("STATUS_BRANCH_BACK", OaCarStatus.STATUS_BRANCH_BACK.getCode());
        model.addAttribute("STATUS_MAIN_PASS", OaCarStatus.STATUS_MAIN_PASS.getCode());
        model.addAttribute("STATUS_MAIN_BACK", OaCarStatus.STATUS_MAIN_BACK.getCode());
    }

    /**
     * 创建系统任务
     *
     * @param data .
     * @throws Exception .
     */
    public void createOaTask(OaCar data) throws Exception {
        int Status = data.getStatus();
        //创建任务
        String title = oaTaskManager.getTaskTitle(data, OaCar.class.getSimpleName());
        Set<Long> managers = new HashSet<Long>();
        //科长和办公室主任在提交后收到待办提醒
        if (Status == OaCarStatus.STATUS_SUBMIT.getCode()) {
            //获取科长
            String privilegeCodeKZ = PrivilegeCode.OA_CAR_AUDIT_KZ;
            //获取办公室主任
            String privilegeCodeZR = PrivilegeCode.OA_CAR_AUDIT_ZR;
            Set<Long> managersKZ = sysUserManager.getUserIdsByPrivilegeCode(privilegeCodeKZ);
            Set<Long> managersZR = sysUserManager.getUserIdsByPrivilegeCode(privilegeCodeZR);

            managers.addAll(managersKZ);
            managers.addAll(managersZR);
            if (managers.size() > 0) {
                oaTaskManager.createTask(OaCar.class.getSimpleName(), data.getId(), title, managers, false, null, null);
            }
        }
        //退回修改，申请人收到待办提醒
        if (Status == OaCarStatus.STATUS_BRANCH_BACK.getCode() || Status == OaCarStatus.STATUS_MAIN_BACK.getCode()) {
            title = oaTaskManager.getTaskTitle(data, OaCar.class.getSimpleName() + "_Back");
            SysUser applyUser = data.getApplyUser();
            if (null != applyUser) {
                managers.add(applyUser.getId());
            }
            if (managers.size() > 0) {
                oaTaskManager.createTask(OaCar.class.getSimpleName(), data.getId(), title, managers, false, null, null);
            }
        }
        //主任审核通过后，发给办公室处理人员和申请人待办事项
        if (Status == OaCarStatus.STATUS_BRANCH_PASS.getCode() || Status == OaCarStatus.STATUS_MAIN_PASS.getCode()) {
            title = oaTaskManager.getTaskTitle(data, OaCar.class.getSimpleName() + "_Pass");
            SysUser applyUser = data.getApplyUser();
            SysPerson dealPerson = data.getDriverPerson();
            if (null != applyUser) {
                managers.add(applyUser.getId());
            }
            //司机发送信息
            if (dealPerson != null && dealPerson.getSysUsers() != null && dealPerson.getSysUsers().size() > 0) {
                dealPerson.getSysUsers();
                for (SysUser sysUser : dealPerson.getSysUsers()) {
                    managers.add(sysUser.getId());
                }
            }

            if (managers.size() > 0) {
                oaTaskManager.createTask(OaCar.class.getSimpleName(), data.getId(), title, managers, false, null, null);
            }
        }
    }

}