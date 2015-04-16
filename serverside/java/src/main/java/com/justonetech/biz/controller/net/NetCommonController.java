package com.justonetech.biz.controller.net;

import com.justonetech.biz.daoservice.NetAcceptStatusService;
import com.justonetech.biz.daoservice.NetAcceptStepService;
import com.justonetech.biz.daoservice.NetApplyService;
import com.justonetech.biz.daoservice.NetOpLogService;
import com.justonetech.biz.domain.*;
import com.justonetech.biz.utils.Constants;
import com.justonetech.biz.utils.operationMsg.OperationMsgManager;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.service.HibernateService;
import com.justonetech.core.utils.DateTimeHelper;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.domain.SysCodeDetail;
import com.justonetech.system.manager.SysCodeManager;
import com.justonetech.system.manager.SysUserManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.*;


/**
 * note:项目审批--公用页面
 * author: chenjp
 */
@Controller
public class NetCommonController extends BaseCRUDActionController<NetApply> {
    private Logger logger = LoggerFactory.getLogger(NetCommonController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private NetOpLogService netOpLogService;

    @Autowired
    private NetAcceptStepService netAcceptStepService;

    @Autowired
    private NetAcceptStatusService netAcceptStatusService;

    @Autowired
    private HibernateService hibernateService;

    @Autowired
    private SysCodeManager sysCodeManager;

    @Autowired
    private NetApplyService netApplyService;

    /**
     * 受理页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String audit(Model model, String matterCode, String bizClass, Long bizId, Long acceptStatusId) {
        //当前状态
        NetAcceptStatus acceptStatus = netAcceptStatusService.get(acceptStatusId);
        NetAcceptStep nextStep = acceptStatus.getAcceptStep();

        //后续步骤
        if (acceptStatus.getIsPass() !=null && acceptStatus.getIsPass()) {
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

        return "view/net/netCommon/audit";
    }

    /**
     * 受理保存操作
     *
     * @param response .
     * @param request  .
     * @throws Exception .
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void auditSave(HttpServletResponse response, HttpServletRequest request) throws Exception {
        try {
            String matterCode = request.getParameter("matterCode");
            String bizClass = request.getParameter("bizClass");
            String bizId = request.getParameter("bizId");
            String acceptStatusId = request.getParameter("acceptStatusId");
            String acceptDate = request.getParameter("acceptDate");
            String backCause = request.getParameter("backCause");

            //保存日志
            NetOpLog log = new NetOpLog();
            log.setBizClass(bizClass);
            log.setBizId(Long.valueOf(bizId));
            log.setAcceptStatus(netAcceptStatusService.get(Long.valueOf(acceptStatusId)));
            log.setOpPerson(sysUserManager.getSysUser().getDisplayName());
            log.setAcceptDate(JspHelper.getDate(acceptDate));
            if (!StringHelper.isEmpty(backCause)) {
                log.setBackCause(backCause);
            }
            netOpLogService.save(log);

            //更新业务记录的状态
            Serializable object = hibernateService.findUnique("from " + bizClass + " where id=?", Long.valueOf(bizId));
            if (object != null) {
                ReflectionUtils.setFieldValue(object, "acceptStatus", netAcceptStatusService.get(Long.valueOf(acceptStatusId)));
                //判断首次监督时间是否存在，若不存在，则赋值
                Object value = ReflectionUtils.getFieldValue(object, "netDate");
                if(null==value){
                   ReflectionUtils.setFieldValue(object, "netDate",log.getAcceptDate());
                }
                hibernateService.update(object);
            }

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
            return;
        }
        sendSuccessJSON(response, "操作成功");
    }

    /**
     * 查看单条记录的操作日志页面
     *
     * @param model    .
     * @param bizClass .
     * @param bizId    .
     * @return .
     */
    @RequestMapping
    public String view(Model model, String bizClass, Long bizId) {
        List<Map<String, Object>> ret = new ArrayList<Map<String, Object>>();
        Map<Long, List<NetOpLog>> logMap = new HashMap<Long, List<NetOpLog>>();
        String hql = "from NetOpLog where bizClass=? and bizId=? order by acceptStatus.acceptStep.no,id asc";
        List<NetOpLog> logs = netOpLogService.findByQuery(hql, bizClass, bizId);
        for (NetOpLog log : logs) {
            NetAcceptStep step = log.getAcceptStatus().getAcceptStep();
            Long key = step.getId();
            List<NetOpLog> list = logMap.get(key);
            if (list == null) {
                list = new ArrayList<NetOpLog>();
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("step", step);
                ret.add(map);
            }
            list.add(log);
            logMap.put(key, list);
        }

        for (Map<String, Object> map : ret) {
            NetAcceptStep step = (NetAcceptStep) map.get("step");
            map.put("logs", logMap.get(step.getId()));
        }
        model.addAttribute("list", ret);

        //项目报建模块特殊处理
        Boolean isNetApply = NetApply.class.getSimpleName().equals(bizClass);
        if (isNetApply) {
            //施工图审查
            NetApply netApply = netApplyService.get(bizId);
            model.addAttribute("isCheckDraw", netApply.getIsCheckDraw());

            //发包类型和发包方式
            Map<Long, NetApplyFbType> existHM = new HashMap<Long, NetApplyFbType>();
            Set<NetApplyFbType> netApplyFbTypes = netApply.getNetApplyFbTypes();
            for (NetApplyFbType fbType : netApplyFbTypes) {
                existHM.put(fbType.getFbTypeId().getId(), fbType);
            }

            List<Map<String, Object>> fbList = new ArrayList<Map<String, Object>>();
            List<SysCodeDetail> fbTypes = sysCodeManager.getCodeListByCode(Constants.NET_APPLY_FB_TYPE);
            for (SysCodeDetail fbType : fbTypes) {
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
        }
        model.addAttribute("isNetApply",isNetApply);

        return "view/net/netCommon/view";
    }
}