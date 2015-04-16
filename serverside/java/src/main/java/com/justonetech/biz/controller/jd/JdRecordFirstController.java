package com.justonetech.biz.controller.jd;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.DocDocumentService;
import com.justonetech.biz.daoservice.JdRecordFirstService;
import com.justonetech.biz.daoservice.JdRecordPersonService;
import com.justonetech.biz.daoservice.JdRecordQuestionService;
import com.justonetech.biz.domain.*;
import com.justonetech.biz.manager.*;
import com.justonetech.biz.utils.Constants;
import com.justonetech.biz.utils.enums.JdRecordStatus;
import com.justonetech.biz.utils.enums.JdRecordType;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.DateTimeHelper;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.daoservice.SysPersonService;
import com.justonetech.system.domain.SysPerson;
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
import java.util.Calendar;
import java.util.List;
import java.util.Map;


/**
 * note:安全质量监督--首次监督
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class JdRecordFirstController extends BaseCRUDActionController<JdRecordFirst> {
    private Logger logger = LoggerFactory.getLogger(JdRecordFirstController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private DocDocumentService docDocumentService;

    @Autowired
    private SysCodeManager sysCodeManager;

    @Autowired
    private PlanMainInfoManager planMainInfoManager;

    @Autowired
    private ConfigManager configManager;

    @Autowired
    private JdRecordFirstService jdRecordFirstService;

    @Autowired
    private JdRecordManager jdRecordManager;

    @Autowired
    private DocumentManager documentManager;

    @Autowired
    private JdRecordQuestionService jdRecordQuestionService;

    @Autowired
    private SysPersonService sysPersonService;

    @Autowired
    private JdRecordPersonService jdRecordPersonService;

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model, String code) {
        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.JD_RECORD_FIRST_EDIT));
        model.addAttribute("jdTypeCode", JdRecordType.TYPE_FIRST.getCode());  //监督记录类别编码

        model.addAttribute("STATUS_EDIT_COLOR_NAME", JdRecordStatus.EDIT.getName());
        model.addAttribute("STATUS_SUBMIT_COLOR_NAME", JdRecordStatus.SUBMIT.getName());
        pushStaticValueToPage(model);
        model.addAttribute("code", code);
        return "view/jd/jdRecordFirst/grid";
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
    public void gridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows, String code) {
        try {
            Page pageModel = new Page(page, rows, true);
            String hql = "from JdRecordFirst where jdTypeCode='" + code + "' order by id desc";//
            //增加自定义查询条件

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            pageModel = jdRecordFirstService.findByPage(pageModel, queryTranslate.toString());

            List<Map> list = GridJq.getGridValue(pageModel.getRows(), columns);
            for (Map bean : list) {
                String status = (String) bean.get("status");
                bean.put("statusName", JdRecordStatus.getNameByCode(JspHelper.getInteger(status)));
            }


            //输出显示
            String json = GridJq.toJSON(list, pageModel);
            sendJSON(response, json);

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
        }
    }

    //各种状态的编码
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
    public String add(Model model, String jdcode,String jdTaskCode,String planDetailId) {

        JdRecordFirst jdRecordFirst = new JdRecordFirst();
        //附件保存
        model.addAttribute("uploadButton", documentManager.getUploadButton(documentManager.getDefaultXmlConfig(),
                "JdRecord", jdRecordFirst.getDocument(), null, null));
        jdRecordFirst.setStatus(JdRecordStatus.EDIT.getCode());
        //初始化监督日期
        Calendar calendar = Calendar.getInstance();
        jdRecordFirst.setJdDatetime(new Date(calendar.getTime().getTime()));


        String code = jdRecordManager.generateCode(JdRecordType.TYPE_FIRST.getCode(), null);
        jdRecordFirst.setCode(code);


        //如需增加其他默认值请在此添加

         /*获取监督人员：*/
        List<JdRecordPerson> jdRecordPersonList = jdRecordManager.getJdRecordPersons(JdRecordType.TYPE_FIRST.getCode(), null);
//        /*获取监督问题：*/
        List<JdRecordQuestion> jdRecordBehaviorQuestionList = jdRecordManager.getJdRecordQuestions(JdRecordType.TYPE_FIRST.getCode(), Constants.JD_RECORD_FIRST_CHECK_NORMAL, null);
         /*质量监督--问题类别--行为检查*/
        model.addAttribute("JD_RECORD_FIRST_CHECK_NORMAL", Constants.JD_RECORD_FIRST_CHECK_NORMAL);
        /*表单种类*/
        model.addAttribute("JD_RECORD_FIRST_CHECK_TYPE", JdRecordType.TYPE_FIRST.getCode());
        model.addAttribute("jdRecordPersonList", jdRecordPersonList);
        model.addAttribute("jdRecordBehaviorQuestionList", jdRecordBehaviorQuestionList);
        model.addAttribute("bean", jdRecordFirst);
        pushStaticValueToPage(model);
        model.addAttribute("jdDeptNameNew", configManager.getJdDeptName());
        model.addAttribute("jdcode", jdcode);
        model.addAttribute("jdTaskCode", jdTaskCode);
        model.addAttribute("planDetailId", planDetailId);
        return "view/jd/jdRecordFirst/input";
    }

    /**
     * 修改显示页面
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String modify(Model model, Long id, String jdcode) {
        JdRecordFirst jdRecordFirst = jdRecordFirstService.get(id);
        //附件保存
        model.addAttribute("uploadButton", documentManager.getUploadButton(documentManager.getDefaultXmlConfig(),
                "JdRecord", jdRecordFirst.getDocument(), null, null));
        //处理其他业务逻辑

         /*获取监督人员：*/
        List<JdRecordPerson> jdRecordPersonList = jdRecordManager.getJdRecordPersons(JdRecordType.TYPE_FIRST.getCode(), jdRecordFirst.getId());
        String[] jdRecordPersons = new String[jdRecordPersonList.size()];
        for (int i = 0; i < jdRecordPersonList.size(); i++) {
            jdRecordPersons[i] = jdRecordPersonList.get(i).getJdPersonDesc();
        }
        model.addAttribute("jdRecordPersons", StringHelper.join(jdRecordPersons, ","));
        /*获取监督问题：*/
        List<JdRecordQuestion> jdRecordBehaviorQuestionList = jdRecordManager.getJdRecordQuestions(JdRecordType.TYPE_FIRST.getCode(), Constants.JD_RECORD_FIRST_CHECK_NORMAL, jdRecordFirst.getId());
         /*质量监督--问题类别--行为检查*/
        model.addAttribute("JD_RECORD_FIRST_CHECK_NORMAL", Constants.JD_RECORD_FIRST_CHECK_NORMAL);
        /*表单种类*/
        model.addAttribute("JD_RECORD_QUALITY_CHECK_TYPE", JdRecordType.TYPE_FIRST.getCode());
        model.addAttribute("JD_RECORD_FIRST_CHECK_TYPE", JdRecordType.TYPE_FIRST.getCode());
        model.addAttribute("jdRecordPersonList", jdRecordPersonList);
        model.addAttribute("jdRecordBehaviorQuestionList", jdRecordBehaviorQuestionList);
        pushStaticValueToPage(model);
        Date jdDatetime = jdRecordFirst.getJdDatetime();
        model.addAttribute("weekCn", DateTimeHelper.getWeekCn(jdDatetime));
        model.addAttribute("bean", jdRecordFirst);
        model.addAttribute("jdDeptNameNew", configManager.getJdDeptName());
        model.addAttribute("jdcode", jdcode);
//            model.addAttribute("dwgc", jdRecordFirst.getDwgc().getId());
        return "view/jd/jdRecordFirst/input";
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
        JdRecordFirst jdRecordFirst = jdRecordFirstService.get(id);
        //显示附件
        model.addAttribute("docButton", documentManager.getDownloadButton(jdRecordFirst.getDocument()));
        model.addAttribute("weekCn", DateTimeHelper.getWeekCn(jdRecordFirst.getJdDatetime()));
        List<JdRecordPerson> jdRecordPersonList = jdRecordManager.getJdRecordPersons(JdRecordType.TYPE_FIRST.getCode(), jdRecordFirst.getId());
         /*获取监督问题：*/
        List<JdRecordQuestion> jdRecordBehaviorQuestionList = jdRecordManager.getJdRecordQuestions(JdRecordType.TYPE_FIRST.getCode(), Constants.JD_RECORD_FIRST_CHECK_NORMAL, jdRecordFirst.getId());

        /*表单种类*/
        model.addAttribute("JD_RECORD_QUALITY_CHECK_TYPE", JdRecordType.TYPE_FIRST.getCode());
        model.addAttribute("JD_RECORD_FIRST_CHECK_TYPE", JdRecordType.TYPE_FIRST.getCode());
        /*质量监督--问题类别--行为检查*/
        model.addAttribute("JD_RECORD_FIRST_CHECK_NORMAL", Constants.JD_RECORD_FIRST_CHECK_NORMAL);
        model.addAttribute("jdRecordPersonList", jdRecordPersonList);
        model.addAttribute("jdRecordBehaviorQuestionList", jdRecordBehaviorQuestionList);
        model.addAttribute("jdDeptNameNew", configManager.getJdDeptName());
        model.addAttribute("bean", jdRecordFirst);
        return "view/jd/jdRecordFirst/view";
    }

    /**
     * 判断是否为数字
     *
     * @return .
     */
    public static boolean isNum(String str) {
        return str.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
    }

    /**
     * /**
     * 保存操作
     *
     * @param response .
     * @param entity   .
     * @param request  .
     * @throws Exception .
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void save(HttpServletResponse response, @ModelAttribute("bean") JdRecordFirst entity, HttpServletRequest request, Integer status, String jdcode) throws Exception {
        try {
            JdRecordFirst target;
            if (entity.getId() != null) {
                target = jdRecordFirstService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "code",
                        "jdTaskCode",
                        "bjbh",
                        "weather",
                        "projectName",
                        "jdManagerName",
                        "attendPersons",
                        "dwgc",
                        "jsDept",
                        "kcDept",
                        "sjDept",
                        "sgDept",
                        "jlDept",
                        "jcDept",
                        "notifyContent",
                        "inspectionContent",
                        "dealOpinion",
                        "description",
                        "jdDatetime",
                        "status",
                        "createTime",
                        "createUser",
                        "updateTime",
                        "updateUser",
                        "auditTime",
                        "auditUser"
                });

            } else {
                target = entity;
                target.setStatus(status);
                target.setCode(jdRecordManager.generateCode(JdRecordType.TYPE_FIRST.getCode(), null));
            }
            target.setJdTypeCode(jdcode);
            //保存附件
            String docId = request.getParameter("docId");
            if (StringHelper.isNotEmpty(docId)) {
                DocDocument docDocument = docDocumentService.get(Long.valueOf(docId));
                target.setDocument(docDocument);
            }
            jdRecordFirstService.save(target);
            String planDetailId = request.getParameter("planDetailId");
            if(!StringHelper.isEmpty(planDetailId)){
                String cancelCode = sysCodeManager.getCodeDetailByCode(Constants.PLAN_DETAIL_STATUS, Constants.PLAN_DETAIL_STATUS_CHECKED).getCode();
                planMainInfoManager.setDetailStatus(Long.valueOf(planDetailId), cancelCode, java.sql.Date.valueOf(DateTimeHelper.getCurrentDate()));
            }
            String attendPersonIds = request.getParameter("attendPersonIds");
            List<JdRecordPerson> jdRecordPersonList = jdRecordManager.getJdRecordPersons(JdRecordType.TYPE_FIRST.getCode(), target.getId());
            for (JdRecordPerson jdRecordPerson : jdRecordPersonList) {
                jdRecordPersonService.delete(jdRecordPerson);
            }
            for (String attendPersonId : StringHelper.split(attendPersonIds, ",")) {
                JdRecordPerson jdRecordPerson = new JdRecordPerson();
                jdRecordPerson.setJdTypeCode(JdRecordType.TYPE_FIRST.getCode());
                SysPerson sysPerson = sysPersonService.get(Long.parseLong(attendPersonId));
                jdRecordPerson.setJdPerson(sysPerson);
                jdRecordPerson.setJdPersonDesc(sysPerson.getName());
                jdRecordPerson.setRecordId(target.getId());
                jdRecordPersonService.save(jdRecordPerson);
            }
            String jdManager = request.getParameter("jdManager");
            if (!"".equals(jdManager)) {
                SysPerson sysPerson = sysPersonService.get(Long.parseLong(jdManager));
                target.setJdManager(sysPerson);
            }
            jdRecordFirstService.save(target);
            // 删除
            List<JdRecordQuestion> jdRecordQItemBehavior = jdRecordManager.getJdRecordQuestions(JdRecordType.TYPE_FIRST.getCode(), Constants.JD_RECORD_FIRST_CHECK_NORMAL, target.getId());
            for (JdRecordQuestion jdRecordQuestion : jdRecordQItemBehavior) {
                jdRecordQuestionService.delete(jdRecordQuestion);
            }
            // 序号  行为抽查
            String[] orderNo = request.getParameterValues("orderNo" + Constants.JD_RECORD_FIRST_CHECK_NORMAL);
            // 问题 行为抽查
            String[] questionDesc = request.getParameterValues("questionDesc" + Constants.JD_RECORD_FIRST_CHECK_NORMAL);
            String[] questionIds = request.getParameterValues("questionDescId" + Constants.JD_RECORD_FIRST_CHECK_NORMAL);
            // 违反条约 行为抽查
            String[] unlawDescBehavior = request.getParameterValues("unlawDesc" + Constants.JD_RECORD_FIRST_CHECK_NORMAL);
            String[] unlawDescIds = request.getParameterValues("unlawDescId" + Constants.JD_RECORD_FIRST_CHECK_NORMAL);
            // 监督员 行为抽查
            String[] jdPersonDesc = request.getParameterValues("jdRecordQuestionPersonNames" + Constants.JD_RECORD_FIRST_CHECK_NORMAL);
            String[] jdPersonIds = request.getParameterValues("jdRecordQuestionPersonIds" + Constants.JD_RECORD_FIRST_CHECK_NORMAL);
            if (null != questionDesc && questionDesc.length != 0) {
                for (int id = 0; id < questionDesc.length; id++) {
                    JdRecordQuestion jdRecordQuestion = new JdRecordQuestion();
                    if (null != orderNo[id] && !"".equals(orderNo[id])) {
                        // 序号
                        jdRecordQuestion.setOrderNo(Integer.parseInt(orderNo[id]));

                        // 问题
                        jdRecordQuestion.setQuestionDesc(questionDesc[id]);
                        // 违反条约
                        jdRecordQuestion.setUnlawDesc(unlawDescBehavior[id]);
                        // 监督员
                        jdRecordQuestion.setJdPersonDesc(jdPersonDesc[id]);

                        if (null != jdPersonIds[id] && !"".equals(jdPersonIds[id]) && isNum(jdPersonIds[id])) {
                            jdRecordQuestion.setJdPersonId(Long.valueOf(jdPersonIds[id]));
                        }
                        jdRecordQuestion.setQuestionDesc(questionDesc[id]);
                        if (null != questionIds[id] && !"".equals(questionIds[id]) && isNum(questionIds[id])) {
                            jdRecordQuestion.setQuestionId(Long.valueOf(questionIds[id]));
                        }
                        // 违反条约
                        jdRecordQuestion.setUnlawDesc(unlawDescBehavior[id]);
                        if (null != unlawDescIds[id] && !"".equals(unlawDescIds[id]) && isNum(unlawDescIds[id])) {
                            jdRecordQuestion.setUnlawId(Long.valueOf(unlawDescIds[id]));
                        }
                        jdRecordQuestion.setRecordId(target.getId());
                        jdRecordQuestion.setJdTypeCode(JdRecordType.TYPE_FIRST.getCode());
                        jdRecordQuestion.setTypeCode(Constants.JD_RECORD_FIRST_CHECK_NORMAL);

                        jdRecordQuestionService.save(jdRecordQuestion);
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
        jdRecordFirstService.delete(id);
        List<JdRecordQuestion> jdRecordQItemBehavior = jdRecordManager.getJdRecordQuestions(JdRecordType.TYPE_FIRST.getCode(), Constants.JD_RECORD_FIRST_CHECK_NORMAL, id);
        for (JdRecordQuestion jdRecordQuestion : jdRecordQItemBehavior) {
            jdRecordQuestionService.delete(jdRecordQuestion);
        }
        sendSuccessJSON(response, "删除成功");
    }

}
