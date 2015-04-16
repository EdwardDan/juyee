package com.justonetech.biz.controller.jd;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.JdRecordQuestionService;
import com.justonetech.biz.daoservice.JdRecoverFormService;
import com.justonetech.biz.daoservice.JdStopOrderQuestionService;
import com.justonetech.biz.daoservice.JdStopOrderService;
import com.justonetech.biz.domain.JdRecordQuestion;
import com.justonetech.biz.domain.JdRecoverForm;
import com.justonetech.biz.domain.JdStopOrder;
import com.justonetech.biz.domain.JdStopOrderQuestion;
import com.justonetech.biz.manager.*;
import com.justonetech.biz.utils.enums.*;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.DateTimeHelper;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.daoservice.SysUserService;
import com.justonetech.system.domain.SysRegPerson;
import com.justonetech.system.domain.SysUser;
import com.justonetech.system.manager.SimpleQueryManager;
import com.justonetech.system.manager.SysUserManager;
import com.justonetech.system.tree.ZTreeBranch;
import com.justonetech.system.tree.ZTreeNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.sql.Date;
import java.util.*;


/**
 * note:安全质量监督--整改/暂缓施工/停工单
 * author: wangfei
 * create date:
 * modify date:
 */
@Controller
public class JdStopOrderController extends BaseCRUDActionController<JdStopOrder> {
    private Logger logger = LoggerFactory.getLogger(JdStopOrderController.class);

    @Autowired
    private SysUserManager sysUserManager;


    @Autowired
    private ConfigManager configManager;


    @Autowired
    private SimpleQueryManager simpleQueryManager;


    @Autowired
    private JdStopOrderService jdStopOrderService;

    @Autowired
    private JdRecordQuestionService jdRecordQuestionService;

    @Autowired
    private JdStopOrderQuestionService jdStopOrderQuestionService;

    @Autowired
    private JdRecoverFormService jdRecoverFormService;

    @Autowired
    private JdRecordManager jdRecordManager;

    @Autowired
    private JdStopOrderManager jdStopOrderManager;

    @Autowired
    private RegPersonManager regPersonManager;

    @Autowired
    private OaTaskManager oaTaskManager;

    @Autowired
    private MsgMessageManager msgMessageManager;

    @Autowired
    private OaFgldManager oaFgldManager;
    @Autowired
    private RegPersonManager RegPersonManager;
    @Autowired
    private SysUserService SysUserService;


    /**
     * tab显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String init(Model model, String code) {
        model.addAttribute("TYPE_REFORM", JdStopOrderType.TYPE_REFORM.getCode());
        model.addAttribute("TYPE_SUSPEND", JdStopOrderType.TYPE_SUSPEND.getCode());
        model.addAttribute("TYPE_STOP", JdStopOrderType.TYPE_STOP.getCode());
        model.addAttribute("code", code);//判断是安全监督还是质量监督
        return "view/jd/jdStopOrder/init";
    }

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model, String formCode, String code) {
        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(JdStopOrder.class.getSimpleName() + "_" + formCode + "_edit"));
//        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.JD_RECORD_EDIT));

        model.addAttribute("formCode", formCode);
        model.addAttribute("formName", JdStopOrderType.getNameByCode(formCode));
        if (StringHelper.equals(formCode, JdStopOrderType.TYPE_REFORM.getCode())) {
            model.addAttribute("tableNo", "tab1");
        } else if (StringHelper.equals(formCode, JdStopOrderType.TYPE_SUSPEND.getCode())) {
            model.addAttribute("tableNo", "tab2");
        } else if (StringHelper.equals(formCode, JdStopOrderType.TYPE_STOP.getCode())) {
            model.addAttribute("tableNo", "tab3");
        }

        pushStaticValueToPage(model);
        setStatus(model);
        model.addAttribute("code", code);

        return "view/jd/jdStopOrder/grid";
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
    public void gridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows, String formCode, String code) {
        try {
            Page<JdStopOrder> pageModel = new Page<JdStopOrder>(page, rows, true);
            String hql = "from JdStopOrder where formCode='" + formCode + "' and jdAttributeCode='"+code+"' ";
            if (sysUserManager.getSysUser().getRegPerson() != null) {    //外网用户过滤
                String bjbhCondition = regPersonManager.getJdBjbhCondition();
                hql += " and bjbh in (" + bjbhCondition + ")";
            }
            hql += " order by id desc";

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            pageModel = jdStopOrderService.findByPage(pageModel, queryTranslate.toString());
            List<Map<String, Object>> retList = new ArrayList<Map<String, Object>>();
            for (JdStopOrder jdStopOrder : pageModel.getRows()) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("id", jdStopOrder.getId());
                map.put("dutyDept", jdStopOrder.getDutyDept());
                map.put("projectName", jdStopOrder.getProjectName());
                map.put("recheckDept", jdStopOrder.getRecheckDept());
                map.put("signDate", jdStopOrder.getSignDate() + "");
                map.put("formCode", jdStopOrder.getFormCode());
                map.put("status", jdStopOrder.getStatus());
                map.put("statusName", JdStopOrderStatus.getNameByCode(jdStopOrder.getStatus()));
                int days = DateTimeHelper.getDays(new java.util.Date(), jdStopOrder.getReformLimit());
                if (days >= 0) {
                    map.put("reformLimit", "<font color='red'>" + jdStopOrder.getReformLimit() + "</font>");
                } else {
                    map.put("reformLimit", jdStopOrder.getReformLimit() + "");
                }
                if (null != jdStopOrder.getJdReformReplies() && jdStopOrder.getJdReformReplies().size() != 0) {
                    map.put("replyStatus", jdStopOrder.getJdReformReplies().iterator().next().getStatus());
                    map.put("replyStatusName", JdReformReplyStatus.getColorNameByCode(jdStopOrder.getJdReformReplies().iterator().next().getStatus()));
                } else {
                    map.put("replyStatus", JdReformReplyStatus.STATUS_EDIT.getCode());
                    map.put("replyStatusName", JdReformReplyStatus.getColorNameByCode(JdReformReplyStatus.STATUS_EDIT.getCode()));
                }
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
     * 新增录入页面--仅从监督记录中添加，暂不考虑单独添加指令单情况
     *
     * @param model      .
     * @param formCode   指令单类别编码
     * @param jdTypeCode 监督表单类别编码
     * @param recordId   监督表单ID
     * @return .
     */
    @RequestMapping
    public String add(Model model, String formCode, String jdTypeCode, Long recordId,String jdAttributeCode) throws Exception {
        pushStaticValueToPage(model);

        JdStopOrder jdStopOrder = new JdStopOrder();
        jdStopOrder.setSignDept(configManager.getJdDeptName());
        SysUser user = sysUserManager.getSysUser();
        jdStopOrder.setRecordId(recordId);
        jdStopOrder.setSignPerson(user.getDisplayName());
        jdStopOrder.setFormCode(formCode);
        jdStopOrder.setJdTypeCode(jdTypeCode);
        jdStopOrder.setJdAttributeCode(jdAttributeCode);
        jdStopOrder.setRecheckDept(JdCheckDeptType.TYPE_JLDW.getName());
        jdStopOrder.setOrderNo(jdStopOrderManager.getStopOrderOrderNo(jdStopOrder.getFormCode()));
        jdStopOrder.setProjectName(getProjectNameByRecordId(jdTypeCode, "" + recordId));      //项目名称暂无
        jdStopOrder.setBjbh(getBjbhByRecordId(jdTypeCode, "" + recordId));      //项目名称暂无
        Calendar calendar = Calendar.getInstance();
        jdStopOrder.setSignDate(new Date(calendar.getTime().getTime()));
        jdStopOrder.setReformBeginDate(DateTimeHelper.getTimestamp());
        calendar.add(Calendar.DATE, +10);
        jdStopOrder.setYear(calendar.get(Calendar.YEAR));
        jdStopOrder.setReformLimit(new Date(calendar.getTime().getTime()));   /*默认整改日期为当前日期退后十天*/

        List<JdRecordQuestion> jdRecordQuestionList = jdRecordManager.getJdRecordQuestions(jdTypeCode, null, recordId);
        List<Map<String, Serializable>> jdRecordQuestionMapList = new ArrayList<Map<String, Serializable>>();
        for (JdRecordQuestion jdRecordQuestion : jdRecordQuestionList) {
            Map<String, Serializable> jdRecordQuestionListMap = new HashMap<String, Serializable>();
            jdRecordQuestionListMap.put("id", jdRecordQuestion.getId());
            jdRecordQuestionListMap.put("questionDesc", jdRecordQuestion.getQuestionDesc());
            jdRecordQuestionListMap.put("unlawDesc", jdRecordQuestion.getUnlawDesc());
            jdRecordQuestionListMap.put("jdPersonDesc", jdRecordQuestion.getJdPersonDesc());
            jdRecordQuestionListMap.put("checkId", "id" + jdRecordQuestion.getId());
            jdRecordQuestionMapList.add(jdRecordQuestionListMap);
        }

        /*停工时间-时*/
        if (StringHelper.equals(jdStopOrder.getFormCode(), JdStopOrderType.TYPE_STOP.getCode())) {

            model.addAttribute("hourSelect", DateTimeHelper.getHourSelectOptions("1"));

        }
        //如需增加其他默认值请在此添加
        model.addAttribute("recheckDepts", JdCheckDeptType.getNames());
        model.addAttribute("jdRecordQuestionMapList", jdRecordQuestionMapList);
        model.addAttribute("bean", jdStopOrder);
        model.addAttribute("jdTypeCode", jdTypeCode);
        model.addAttribute("recordId", recordId);

        return "view/jd/jdStopOrder/input" + JdStopOrderType.getFileName(jdStopOrder.getFormCode());
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
        JdStopOrder jdStopOrder = jdStopOrderService.get(id);

        List<JdRecordQuestion> jdRecordQuestionList = jdRecordManager.getJdRecordQuestions(jdStopOrder.getJdTypeCode(), null, jdStopOrder.getRecordId());
        List<Map<String, Serializable>> jdRecordQuestionMapList = new ArrayList<Map<String, Serializable>>();
        for (JdRecordQuestion jdRecordQuestion : jdRecordQuestionList) {
            Map<String, Serializable> jdRecordQuestionListMap = new HashMap<String, Serializable>();
            jdRecordQuestionListMap.put("id", jdRecordQuestion.getId());
            jdRecordQuestionListMap.put("questionDesc", jdRecordQuestion.getQuestionDesc());
            jdRecordQuestionListMap.put("unlawDesc", jdRecordQuestion.getUnlawDesc());
            jdRecordQuestionListMap.put("jdPersonDesc", jdRecordQuestion.getJdPersonDesc());
            jdRecordQuestionListMap.put("checkId", "id" + jdRecordQuestion.getId());
            jdRecordQuestionMapList.add(jdRecordQuestionListMap);
        }
        Map<String, String> questionCheck = new HashMap<String, String>();
        for (JdStopOrderQuestion jdStopOrderQuestion : jdStopOrder.getJdStopOrderQuestions()) {
            questionCheck.put("id" + jdStopOrderQuestion.getRecordQuestion().getId(), "checked='checked'");
        }
        if (StringHelper.equals(jdStopOrder.getFormCode(), JdStopOrderType.TYPE_STOP.getCode())) {

            model.addAttribute("hourSelect", DateTimeHelper.getHourSelectOptions(jdStopOrder.getReformBeginDate().getHours() + ""));

        }
        //处理其他业务逻辑
        pushStaticValueToPage(model);

        model.addAttribute("recheckDepts", JdCheckDeptType.getNames());

        model.addAttribute("bean", jdStopOrder);
        model.addAttribute("jdRecordQuestionMapList", jdRecordQuestionMapList);
        model.addAttribute("questionCheck", questionCheck);
        return "view/jd/jdStopOrder/input" + JdStopOrderType.getFileName(jdStopOrder.getFormCode());
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
        JdStopOrder jdStopOrder = jdStopOrderService.get(id);
        model.addAttribute("bean", jdStopOrder);
        if (StringHelper.equals(jdStopOrder.getRecheckDept(), JdCheckDeptType.TYPE_OTHER.getName())) {
            model.addAttribute("recheckDept", jdStopOrder.getRecheckOther());
        } else {
            model.addAttribute("recheckDept", jdStopOrder.getRecheckDept());
        }
        //处理其他业务逻辑
        model.addAttribute("recheckDepts", JdCheckDeptType.getNames());

        List<Map<String, Serializable>> jdRecordQuestionMapList = new ArrayList<Map<String, Serializable>>();
        for (JdStopOrderQuestion jdStopOrderQuestion : jdStopOrder.getJdStopOrderQuestions()) {
            JdRecordQuestion jdRecordQuestion = jdStopOrderQuestion.getRecordQuestion();
            Map<String, Serializable> jdRecordQuestionListMap = new HashMap<String, Serializable>();
            jdRecordQuestionListMap.put("id", jdRecordQuestion.getId());
            jdRecordQuestionListMap.put("questionDesc", jdRecordQuestion.getQuestionDesc());
            jdRecordQuestionListMap.put("unlawDesc", jdRecordQuestion.getUnlawDesc());
            jdRecordQuestionListMap.put("jdPersonDesc", jdRecordQuestion.getJdPersonDesc());
            jdRecordQuestionMapList.add(jdRecordQuestionListMap);
        }
        model.addAttribute("jdRecordQuestionMapList", jdRecordQuestionMapList);
        if (StringHelper.equals(jdStopOrder.getFormCode(), JdStopOrderType.TYPE_STOP.getCode())) {

            model.addAttribute("hour", jdStopOrder.getReformBeginDate().getHours() + "");
        }
        return "view/jd/jdStopOrder/view" + JdStopOrderType.getFileName(jdStopOrder.getFormCode());
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
    public void save(HttpServletResponse response, @ModelAttribute("bean") JdStopOrder entity, HttpServletRequest request) throws Exception {
        String[] jdRecordQuestionIds = request.getParameterValues("jdRecordQuestionIds");

        try {
            JdStopOrder target;
            if (entity.getId() != null) {
                target = jdStopOrderService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "formCode",
                        "jdTypeCode",
                        "jdAttributeCode",
                        "recordId",
                        "year",
                        "dutyDept",
                        "projectName",
                        "bjbh",
//                        "recheckDept",
                        "recheckOther",
                        "reformArea",
                        "reformBeginDate",
                        "reformLimit",
                        "signDept",
                        "signPerson",
                        "signDate",
                        "description",
                        "status"
                });

            } else {
                target = entity;
                target.setOrderNo(jdStopOrderManager.getStopOrderOrderNo(target.getFormCode()));
            }
            String checkBoxRecheckDept = request.getParameter("checkBoxRecheckDept");
            target.setRecheckDept(checkBoxRecheckDept);
            jdStopOrderService.save(target);
            for (JdStopOrderQuestion jdStopOrderQuestion : target.getJdStopOrderQuestions()) {
                jdStopOrderQuestionService.delete(jdStopOrderQuestion);
            }
            if (jdRecordQuestionIds != null) {
                for (String jdRecordQuestionId : jdRecordQuestionIds) {
                    JdStopOrderQuestion jdStopOrderQuestion = new JdStopOrderQuestion();
                    JdRecordQuestion jdRecordQuestion = jdRecordQuestionService.get(Long.parseLong(jdRecordQuestionId));
                    jdStopOrderQuestion.setRecordQuestion(jdRecordQuestion);
                    jdStopOrderQuestion.setReformOrder(target);
                    jdStopOrderQuestionService.save(jdStopOrderQuestion);
                }
            }

            if (target.getStatus() != JdStopOrderStatus.STATUS_EDIT.getCode()) {
                createOaTask(target);
            }
        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
            return;
        }
        sendSuccessJSON(response, "保存成功");
    }


    /**
     * 创建系统任务
     *
     * @param data .
     * @throws Exception .
     */
    public void createOaTask(JdStopOrder data) throws Exception {
        //创建任务
        int Status = data.getStatus();
        if (Status == JdStopOrderStatus.STATUS_UNREFORMED.getCode()) {//整改中
            SysRegPerson dutyUser = null;
            Set<Long> managers = new HashSet<Long>();
            //获取单位负责人
            if (null != RegPersonManager.getSysRegPersonByBjbh(data.getBjbh())) {
                dutyUser = RegPersonManager.getSysRegPersonByBjbh(data.getBjbh());
                String hql = "from SysUser where regPerson='" + dutyUser.getId() + "'";
                List<SysUser> list = SysUserService.findByQuery(hql);
                SysUser sysUser=null;
                sysUser = list.iterator().next();
                managers.add(sysUser.getId());
            }

            String title = "";
            if (data.getFormCode().equals("reform")) {
                title = oaTaskManager.getTaskTitle(data, JdStopOrder.class.getSimpleName() + "_Reform");
            } else if (data.getFormCode().equals("stop")) {
                title = oaTaskManager.getTaskTitle(data, JdStopOrder.class.getSimpleName() + "_Stop");

            } else {
                title = oaTaskManager.getTaskTitle(data, JdStopOrder.class.getSimpleName() + "_Suspend");
            }
            if (managers.size() > 0) {
                oaTaskManager.createTask(JdStopOrder.class.getSimpleName(), data.getId(), title, managers, false, null, null);
            }

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
        JdStopOrder jdStopOrder = jdStopOrderService.get(id);
        for (JdStopOrderQuestion jdStopOrderQuestion : jdStopOrder.getJdStopOrderQuestions()) {
            jdStopOrderQuestionService.delete(jdStopOrderQuestion);
        }
        for (JdRecoverForm jdRecoverForm : jdStopOrder.getJdRecoverForms()) {
            jdRecoverFormService.delete(jdRecoverForm);
        }
        oaTaskManager.removeTask(JdStopOrder.class.getSimpleName(), id);//删除任务

        jdStopOrderService.delete(id);
        sendSuccessJSON(response, "删除成功");
    }

    /**
     * 获取责任主体
     *
     * @param recordId .
     * @throws Exception .
     */
    @RequestMapping
    public String dutyDeptForSelect(Model model, String jdTypeCode, String recordId, String icon) throws Exception {
        String sql = "select JS_DEPT,SJ_DEPT,SG_DEPT,JL_DEPT,JC_DEPT,kc_dept from " + JdRecordType.getTableNameByCode(jdTypeCode) + " where id = " + recordId;
        String[] ret = simpleQueryManager.getStringArrayBySql(sql);
        ZTreeBranch treeBranch = new ZTreeBranch();
        treeBranch.setIcons(icon.split(","));
        for (String s : ret) {
            if (!StringHelper.equals(s, "无")) {
                ZTreeNode treeNode = new ZTreeNode();
                treeNode.setIsLeaf(true);
                treeNode.setIcon("1");
                treeNode.setType("data");
                treeNode.setName(s);
                treeBranch.addTreeNode(treeNode);
            }
        }
        model.addAttribute("msg", treeBranch.toJsonString(true));
        return "common/msg";
    }

    /**
     * 获取项目名称
     *
     * @param jdTypeCode .
     * @param recordId   .
     * @throws Exception
     */
    public String getProjectNameByRecordId(String jdTypeCode, String recordId) throws Exception {
        String sql = "select PROJECT_NAME from " + JdRecordType.getTableNameByCode(jdTypeCode) + " where id = " + recordId;
        return simpleQueryManager.getStringBySql(sql);
    }

    /**
     * 获取报建编号
     *
     * @param jdTypeCode .
     * @param recordId   .
     * @throws Exception
     */
    public String getBjbhByRecordId(String jdTypeCode, String recordId) throws Exception {
        String sql = "select BJBH from " + JdRecordType.getTableNameByCode(jdTypeCode) + " where id = " + recordId;
        return simpleQueryManager.getStringBySql(sql);
    }

    /**
     * 各种状态的编码
     *
     * @param model .
     */
    private void pushStaticValueToPage(Model model) {
        model.addAttribute("UNREFORMED", JdStopOrderStatus.STATUS_UNREFORMED.getCode());
        model.addAttribute("REFORMED", JdStopOrderStatus.STATUS_REFORMED.getCode());
        model.addAttribute("EDIT", JdStopOrderStatus.STATUS_EDIT.getCode());
    }


    /**
     * 设置状态
     *
     * @param model .
     */
    public void setStatus(Model model) {

        // 判断是否有编辑和审核权限
//        SysUser user = sysUserManager.getSysUser();
        String bjbh = regPersonManager.getBjbh();
        // 判断是否有施工单位用户权限--用于编辑
        Boolean isSGUser = regPersonManager.isSGUser(bjbh);
        // 判断是否有监理单位用户权限--用于审核
        Boolean isJLUser = regPersonManager.isJLUser(bjbh);
        // 判断是否有编辑权限
        model.addAttribute("isSGUser", isSGUser);
        // 判断是否有审核权限
        model.addAttribute("isJLUser", isJLUser);
        // 填写
        model.addAttribute("STATUS_EDIT", JdReformReplyStatus.STATUS_EDIT.getCode());
        // 提交
        model.addAttribute("STATUS_SUBMIT", JdReformReplyStatus.STATUS_SUBMIT.getCode());
        // 预审通过
        model.addAttribute("STATUS_FIRST_PASS", JdReformReplyStatus.STATUS_FIRST_PASS.getCode());
        // 预审退回
        model.addAttribute("STATUS_FIRST_BACK", JdReformReplyStatus.STATUS_FIRST_BACK.getCode());
        // 复核通过
        model.addAttribute("STATUS_BACK", JdReformReplyStatus.STATUS_BACK.getCode());
    }
}