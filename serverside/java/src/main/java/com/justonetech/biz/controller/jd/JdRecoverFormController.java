package com.justonetech.biz.controller.jd;

import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.DocDocumentService;
import com.justonetech.biz.daoservice.JdRecoverFormService;
import com.justonetech.biz.daoservice.JdStopOrderService;
import com.justonetech.biz.domain.JdRecoverForm;
import com.justonetech.biz.domain.JdStopOrder;
import com.justonetech.biz.manager.*;
import com.justonetech.biz.utils.enums.JdRecordStatus;
import com.justonetech.biz.utils.enums.JdStopOrderType;
import com.justonetech.system.domain.SysUser;
import com.justonetech.system.manager.SimpleQueryManager;
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
import java.sql.Date;
import java.util.*;


/**
 * note:安全质量监督--复工通知单
 * author: guoqiong
 * create date:
 * modify date:
 */
@Controller
public class JdRecoverFormController extends BaseCRUDActionController<JdRecoverForm> {
    private Logger logger = LoggerFactory.getLogger(JdRecoverFormController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private SysCodeManager sysCodeManager;

    @Autowired
    private RelateManager relateManager;

    @Autowired
    private ProjectManager projectManager;

    @Autowired
    private ConfigManager configManager;

    @Autowired
    private DocumentManager documentManager;

    @Autowired
    private SimpleQueryManager simpleQueryManager;

    @Autowired
    private DocDocumentService docDocumentService;

    @Autowired
    private JdRecoverFormService jdRecoverFormService;

    @Autowired
    private JdStopOrderService jdStopOrderService;

    @Autowired
    private JdStopOrderManager jdStopOrderManager;

    @Autowired
    private OaTaskManager oaTaskManager;

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model, Long stopId) {
        JdStopOrder jdStopOrder = jdStopOrderService.get(stopId);
        model.addAttribute("fromCode", jdStopOrder.getFormCode());
        model.addAttribute("formName", JdStopOrderType.getNameByCode(jdStopOrder.getFormCode()));

        //判断是否有编辑权限
        model.addAttribute("stopId", stopId);
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.JD_RECORD_EDIT));

        pushStaticValueToPage(model);

        return "view/jd/jdRecoverForm/grid";
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
    public void gridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows, Long stopId) {
        try {
            Page pageModel = new Page(page, rows, true);
            String hql = "from JdRecoverForm where 1=1 ";
            if (StringHelper.isNotEmpty(String.valueOf(stopId))) {
                JdStopOrder jdStopOrder = jdStopOrderService.get(stopId);
                hql += " and stopForm.formCode='" + jdStopOrder.getFormCode() + "'";
            }
            hql += " order by orderNo asc";
            //增加自定义查询条件

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            pageModel = jdRecoverFormService.findByPage(pageModel, queryTranslate.toString());
            List<JdRecoverForm> list = pageModel.getRows();
            List<Map<String, Object>> retList = new ArrayList<Map<String, Object>>();
            for (JdRecoverForm jdRecoverForm : list) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("id", jdRecoverForm.getId());
                map.put("orderNo", jdRecoverForm.getOrderNo());
                map.put("year", jdRecoverForm.getYear() + "年");
                map.put("dutyDept", jdRecoverForm.getDutyDept());
                map.put("projectName", jdRecoverForm.getProjectName());
                map.put("reformBeginDate", jdRecoverForm.getReformBeginDate());
                map.put("recoverDate", jdRecoverForm.getRecoverDate());
                map.put("status", jdRecoverForm.getStatus());
                map.put("statusName", JdRecordStatus.getNameByCode(jdRecoverForm.getStatus()));
                retList.add(map);
            }
            //输出显示
            String json = GridJq.toJSON(retList, pageModel);
            sendJSON(response, json);

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
        }
    }

    /**
     * 各种状态的编码
     *
     * @param model
     */
    private void pushStaticValueToPage(Model model) {
        model.addAttribute("STATUS_EDIT", JdRecordStatus.EDIT.getCode()); //正在填写
        model.addAttribute("STATUS_SUBMIT", JdRecordStatus.SUBMIT.getCode());//已提交
    }

    /**
     * 新增录入页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String add(Model model, Long stopId) {
        JdRecoverForm jdRecoverForm = new JdRecoverForm();
        jdRecoverForm.setOrderNo(jdStopOrderManager.getRecoverFormOrderNo());
        Date date = new Date(System.currentTimeMillis());
        jdRecoverForm.setReformBeginDate(date);
        jdRecoverForm.setRecoverDate(date);

        JdStopOrder jdStopOrder = jdStopOrderService.get(stopId);
        jdRecoverForm.setProjectName(jdStopOrder.getProjectName());
        jdRecoverForm.setDutyDept(jdStopOrder.getDutyDept());
        jdRecoverForm.setSignDept(jdStopOrder.getSignDept());
        jdRecoverForm.setSignPerson(jdStopOrder.getSignPerson());
        jdRecoverForm.setSignDate(jdStopOrder.getSignDate());
        jdRecoverForm.setStatus(JdRecordStatus.EDIT.getCode());

        //如需增加其他默认值请在此添加
        model.addAttribute("bean", jdRecoverForm);
        model.addAttribute("year", Calendar.getInstance().get(Calendar.YEAR));
        model.addAttribute("stopId", stopId);
        pushStaticValueToPage(model);

        return "view/jd/jdRecoverForm/input";
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
        JdRecoverForm jdRecoverForm = jdRecoverFormService.get(id);

        //处理其他业务逻辑
        model.addAttribute("bean", jdRecoverForm);
        if (jdRecoverForm.getYear() == null) {
            model.addAttribute("year", Calendar.getInstance().get(Calendar.YEAR));
        } else {
            model.addAttribute("year", jdRecoverForm.getYear());
        }
        model.addAttribute("stopId", jdRecoverForm.getStopForm().getId());
        pushStaticValueToPage(model);

        return "view/jd/jdRecoverForm/input";
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
        JdRecoverForm jdRecoverForm = jdRecoverFormService.get(id);

        model.addAttribute("bean", jdRecoverForm);
        return "view/jd/jdRecoverForm/view";
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
    public void save(HttpServletResponse response, @ModelAttribute("bean") JdRecoverForm entity, HttpServletRequest request, Long stopId, Integer status, Integer year) throws Exception {
        try {
            JdRecoverForm target;
            if (entity.getId() != null) {
                target = jdRecoverFormService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
//                        "year",
//                        "orderNo",
                        "dutyDept",
                        "projectName",
                        "reformBeginDate",
                        "recoverDate",
                        "signDept",
                        "signPerson",
                        "signDate",
//                        "description",
                });

            } else {
                target = entity;
                target.setOrderNo(jdStopOrderManager.getRecoverFormOrderNo());
            }
            target.setStopForm(jdStopOrderService.get(stopId));
            target.setYear(year);
            target.setStatus(status);
            jdRecoverFormService.save(target);

//            createOaTask(target);


        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
            return;
        }
        sendSuccessJSON(response, "保存成功");
    }


//    /**
//     * 创建系统任务
//     *
//     * @param data .
//     * @throws Exception .
//     */
//    public void createOaTask(JdRecoverForm data) throws Exception {
//        if (data.getStatus() == JdRecordStatus.SUBMIT.getCode()) {//已经提交
//            Set<Long> managers = new HashSet<Long>();
//            SysUser sysUser = sysUserManager.getSysUser();
//            managers.add(sysUser.getId());
//            String msgTemp = oaTaskManager.getTaskTitle(data, JdRecoverForm.class.getSimpleName());
//            if (managers.size() > 0) {
//                oaTaskManager.createTask(JdRecoverForm.class.getSimpleName(), data.getId(), msgTemp, managers, false, null, null);
//            }
//        }
//    }


    /**
     * 删除操作
     *
     * @param response .
     * @param id       .
     * @throws Exception .
     */
    @RequestMapping
    public void delete(HttpServletResponse response, Long id) throws Exception {
        jdRecoverFormService.delete(id);

        sendSuccessJSON(response, "删除成功");
    }

}