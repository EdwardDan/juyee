package com.justonetech.biz.controller.net;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.*;
import com.justonetech.biz.domain.*;
import com.justonetech.biz.manager.NetAcceptManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.biz.utils.enums.NetMatterDefine;
import com.justonetech.biz.utils.operationMsg.OperationMsgManager;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.DateTimeHelper;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.daoservice.SysCodeDetailService;
import com.justonetech.system.domain.SysCodeDetail;
import com.justonetech.system.manager.SysCodeManager;
import com.justonetech.system.manager.SysUserManager;
import com.justonetech.system.utils.PrivilegeCode;
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
 * note:项目报建
 * author: guoqiong
 * modify date: 2014-06-23
 */
@Controller
public class NetApplyController extends BaseCRUDActionController<NetApply> {
    private Logger logger = LoggerFactory.getLogger(NetApplyController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private SysCodeManager sysCodeManager;

    @Autowired
    private NetApplyService netApplyService;

    @Autowired
    private NetOpLogService netOpLogService;

    @Autowired
    private NetAcceptStepService netAcceptStepService;

    @Autowired
    private NetAcceptStatusService netAcceptStatusService;

    @Autowired
    private NetAcceptManager netAcceptManager;

    @Autowired
    private NetApplyFbTypeService netApplyFbTypeService;

    @Autowired
    private SysCodeDetailService sysCodeDetailService;

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {
        //判断是否有编辑权限
        model.addAttribute("canForceDelete", sysUserManager.hasPrivilege(PrivilegeCode.NET_APPLY_FORCE_DELETE));
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.NET_APPLY_EDIT));
        model.addAttribute("matterCode", NetMatterDefine.MATTER_APPLY.getCode());
        model.addAttribute("bizClass", NetApply.class.getSimpleName());

        return "view/net/netApply/grid";
    }

    /**
     * 获取列表数据
     *
     * @param response .
     * @param filters  .
     * @param columns  .
     * @param page     .
     * @param rows     .
     * @param setCode  .
     */
    @RequestMapping
    public void gridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows, HttpSession session, String setCode) {
        try {
            Page pageModel = new Page(page, rows, true);
            String hql = "from NetApply where 1=1";
            if (!StringHelper.isEmpty(setCode)) {
                hql += " and acceptStatus.name='" + setCode + "' ";
            }
            hql += " order by id desc";

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            String query = queryTranslate.toString();
            session.setAttribute(Constants.GRID_SQL_KEY, query);
            pageModel = netApplyService.findByPage(pageModel, query);

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
        NetApply netApply = new NetApply();
        //获取项目报建初始状态
        NetAcceptStatus firstStatus = netAcceptManager.getFirstStatus(NetMatterDefine.MATTER_APPLY.getCode());
        netApply.setAcceptStatus(firstStatus);
        model.addAttribute("bean", netApply);
        //操作人和时间
        model.addAttribute("opPerson", sysUserManager.getSysUser().getDisplayName());
        model.addAttribute("opDate", DateTimeHelper.getCurrentDate());

        return "view/net/netApply/input";
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
        NetApply netApply = netApplyService.get(id);

        model.addAttribute("bean", netApply);
        //操作人和时间
        model.addAttribute("opPerson", sysUserManager.getSysUser().getDisplayName());
        model.addAttribute("opDate", DateTimeHelper.getCurrentDate());

        return "view/net/netApply/input";
    }

    /**
     * 受理页面
     *
     * @param model          .
     * @param matterCode     .
     * @param bizClass       .
     * @param bizId          .
     * @param acceptStatusId .
     * @return .
     */
    @RequestMapping
    public String audit(Model model, String matterCode, String bizClass, Long bizId, Long acceptStatusId) {
        NetApply netApply = netApplyService.get(bizId);
        //施工图审查
        model.addAttribute("isCheckDraw", netApply.getIsCheckDraw());
        model.addAttribute("bean", netApply);

        //用于页面判断状态（通过或退回）
        NetAcceptStatus statusType2 = netAcceptStatusService.findUnique("from NetAcceptStatus where acceptStep.matterCode=? and isPass=1", matterCode);
        NetAcceptStatus statusType3 = netAcceptStatusService.findUnique("from NetAcceptStatus where acceptStep.matterCode=? and isPass=0 and isEnd=0 and isStart=0", matterCode);
        model.addAttribute("statusId2", statusType2.getId());
        model.addAttribute("statusId3", statusType3.getId());

        //发包方式
        Map<Long, NetApplyFbType> existHM = new HashMap<Long, NetApplyFbType>();
        Set<NetApplyFbType> fbTypes = netApply.getNetApplyFbTypes();
        for (NetApplyFbType fbType : fbTypes) {
            existHM.put(fbType.getFbTypeId().getId(), fbType);
        }
        List<Map<String, Object>> fbList = new ArrayList<Map<String, Object>>();
        List<SysCodeDetail> typeList = sysCodeManager.getCodeListByCode(Constants.NET_APPLY_FB_TYPE);
        for (SysCodeDetail fbType : typeList) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("fb", fbType);
            map.put("isChecked", false);
            map.put("isBid", false);

            NetApplyFbType netApplyFbType = existHM.get(fbType.getId());
            if (netApplyFbType != null) {
                map.put("isChecked", true);
                map.put("isBid", netApplyFbType.getIsBid());
            }
            fbList.add(map);
        }
        model.addAttribute("fbList", fbList);
        //当前状态
        NetAcceptStatus acceptStatus = netAcceptStatusService.get(acceptStatusId);
        NetAcceptStep nextStep = acceptStatus.getAcceptStep();

        //后续步骤
        if (acceptStatus.getIsPass()) {
            List<NetAcceptStep> list = netAcceptStepService.findByQuery("from NetAcceptStep where matterCode=? and no>? order by no asc", matterCode, nextStep.getNo());
            if (list.size() > 0) {
                nextStep = list.iterator().next();
            }
        }
        if (nextStep == null) {
            return OperationMsgManager.errorMsg(model, null, "无法受理，未找到后续步骤！");
        }
        Set<NetAcceptStatus> netAcceptStatus = nextStep.getNetAcceptStatus();
        if (netAcceptStatus.size() == 0) {
            return OperationMsgManager.errorMsg(model, null, "无法受理，未找到后续步骤！");
        }
        List<NetAcceptStatus> nextList = new ArrayList<NetAcceptStatus>();
        for (NetAcceptStatus status : netAcceptStatus) {
            if (status.getIsStart() != null && status.getIsStart()) {
                continue;
            }
            nextList.add(status);
        }
        acceptStatus = netAcceptStatus.iterator().next();
        model.addAttribute("acceptStatus", acceptStatus);
        model.addAttribute("nextStep", nextStep);
        model.addAttribute("nextList", nextList);

        //操作人和时间
        model.addAttribute("opPerson", sysUserManager.getSysUser().getDisplayName());
        model.addAttribute("opDate", DateTimeHelper.getCurrentDate());

        //接收参数
        model.addAttribute("matterCode", matterCode);
        model.addAttribute("bizClass", bizClass);
        model.addAttribute("bizId", bizId);
        model.addAttribute("acceptDate", DateTimeHelper.getCurrentDate());

        return "view/net/netApply/audit";
    }

    /**
     * 受理保存操作
     *
     * @param response .
     * @param entity   .
     * @param request  .
     * @throws Exception .
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void auditSave(HttpServletResponse response, @ModelAttribute("bean") NetApply entity, HttpServletRequest request) throws Exception {
        String bizClass = request.getParameter("bizClass");
        String acceptDate = request.getParameter("acceptDate");
        String backCause = request.getParameter("backCause");
        String bjbh = request.getParameter("bjbh");
        String hql = "from NetApply where bjbh=?";
        List<NetApply> list = netApplyService.findByQuery(hql, bjbh);
        if (null != list && list.size() > 0) {
            sendFailureJSON(response, "报建编号不能重复，请重新输入！");
        } else {
            try {
                NetApply target;
                if (entity.getId() != null) {
                    target = netApplyService.get(entity.getId());
                    ReflectionUtils.copyBean(entity, target, new String[]{
                            "bjbh",
                    });
                } else {
                    target = entity;
                }
                //保存当前选中状态
                String acceptStatusId = request.getParameter("acceptStatusId");
                target.setAcceptStatus(netAcceptStatusService.get(Long.valueOf(acceptStatusId)));
                //是否需要施工图审查
                String isCheckDraw = request.getParameter("isCheckDraw");
                if (StringHelper.isEmpty(isCheckDraw)) {
                    target.setIsCheckDraw(false);
                } else {
                    target.setIsCheckDraw(true);
                }
                if(null==target.getNetDate()){
                   target.setNetDate(JspHelper.getDate(acceptDate));
                }
                netApplyService.save(target);

                //保存发包方式和类型 (先删除后保存)
                String[] typeIds = request.getParameterValues("typeId");
                Set<NetApplyFbType> netApplyFbTypes = target.getNetApplyFbTypes();
                for (NetApplyFbType type : netApplyFbTypes) {
                    netApplyFbTypeService.delete(type);
                }
                netApplyFbTypeService.getSession().flush();

                if (typeIds != null && typeIds.length > 0) {
                    for (String typeId : typeIds) {
                        SysCodeDetail detail = sysCodeDetailService.get(Long.valueOf(typeId));
                        NetApplyFbType netApplyFbType = new NetApplyFbType();
                        netApplyFbType.setApply(target);
                        netApplyFbType.setFbTypeId(detail);
                        String isBid = request.getParameter("isBid" + detail.getId());
                        if (StringHelper.isEmpty(isBid)) {
                            netApplyFbType.setIsBid(false);
                        } else {
                            netApplyFbType.setIsBid(true);
                        }
                        netApplyFbTypeService.save(netApplyFbType);
                    }
                }
//
//                String bizClass = request.getParameter("bizClass");
//                String acceptDate = request.getParameter("acceptDate");
//                String backCause = request.getParameter("backCause");

                //保存日志
                NetOpLog log = new NetOpLog();
                log.setBizClass(bizClass);
                log.setBizId(target.getId());
                log.setAcceptStatus(target.getAcceptStatus());
                log.setOpPerson(sysUserManager.getSysUser().getDisplayName());
                log.setAcceptDate(JspHelper.getDate(acceptDate));
                if (!StringHelper.isEmpty(backCause)) {
                    log.setBackCause(backCause);
                }
                netOpLogService.save(log);

            } catch (Exception e) {
                log.error("error", e);
                super.processException(response, e);
                return;
            }
            sendSuccessJSON(response, "操作成功");
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
    public void save(HttpServletResponse response, @ModelAttribute("bean") NetApply entity, HttpServletRequest request) throws Exception {
        String netCode = entity.getNetCode();
//        Date netDate = netAcceptManager.getDateFromCode(netCode);
//        if (netDate == null) {
//            sendFailureJSON(response, "网上受理编号不正确，请重新输入！");
//        } else {
            try {
                NetApply target;
                if (entity.getId() != null) {
                    target = netApplyService.get(entity.getId());
                    ReflectionUtils.copyBean(entity, target, new String[]{
                            "netCode",
//                            "netDate",
                            "projectName",
                            "buildUnitName",
                            "buildAddress",
                            "applyUnitName",
                            "isCheckDraw",
                            "isImportant"
                    });

                } else {
                    target = entity;
                }
                String statusId = request.getParameter("statusId");
                target.setAcceptStatus(netAcceptStatusService.get(Long.valueOf(statusId)));
//                target.setNetDate(netDate);
                target.setIsCheckDraw(false);
                target.setIsImportant(false);
                netApplyService.save(target);

            } catch (Exception e) {
                log.error("error", e);
                super.processException(response, e);
                return;
            }
            sendSuccessJSON(response, "保存成功");
//        }
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
        NetApply netApply = netApplyService.get(id);
        //先删除子表
        Set<NetApplyFbType> netApplyFbTypes = netApply.getNetApplyFbTypes();
        for (NetApplyFbType netApplyFbType : netApplyFbTypes) {
            netApplyFbTypeService.delete(netApplyFbType);
        }
        netApplyService.delete(netApply);

        sendSuccessJSON(response, "删除成功");
    }

    /**
     * 删除全部操作
     *
     * @param response .
     * @param id       .
     * @throws Exception .
     */
    @RequestMapping
    public void deleteAll(HttpServletResponse response, Long id) throws Exception {

        netAcceptManager.deleteAll(id);

        sendSuccessJSON(response, "删除成功");
    }
}