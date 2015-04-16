package com.justonetech.biz.controller.jd;


import com.justonetech.biz.daoservice.DocDocumentService;
import com.justonetech.biz.domain.DocDocument;
import com.justonetech.biz.manager.ConfigManager;
import com.justonetech.biz.manager.DocumentManager;
import com.justonetech.biz.manager.JdRecordManager;
import com.justonetech.biz.manager.PlanMainInfoManager;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.DateTimeHelper;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.JdRecordPersonService;
import com.justonetech.biz.daoservice.JdRecordQualityService;
import com.justonetech.biz.daoservice.JdRecordQuestionService;
import com.justonetech.biz.domain.JdRecordPerson;
import com.justonetech.biz.domain.JdRecordQuality;
import com.justonetech.biz.domain.JdRecordQuestion;
import com.justonetech.biz.utils.Constants;
import com.justonetech.biz.utils.enums.JdRecordStatus;
import com.justonetech.biz.utils.enums.JdRecordType;
import com.justonetech.biz.utils.enums.JdStopOrderType;
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
import java.util.Calendar;
import java.util.List;
import java.util.Map;


/**
 * note:安全质量监督--质量监督
 * author: wangfei
 * create date:
 * modify date:
 */
@Controller
public class JdRecordQualityController extends BaseCRUDActionController<JdRecordQuality> {
    private Logger logger = LoggerFactory.getLogger(JdRecordQualityController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private SysCodeManager sysCodeManager;

    @Autowired
    private PlanMainInfoManager planMainInfoManager;

    @Autowired
    private ConfigManager configManager;

    @Autowired
    private DocumentManager documentManager;

    @Autowired
    private DocDocumentService docDocumentService;


    @Autowired
    private JdRecordQualityService jdRecordQualityService;

    @Autowired
    private JdRecordManager jdRecordManager;

    @Autowired
    private JdRecordQuestionService jdRecordQuestionService;

    @Autowired
    private JdRecordPersonService jdRecordPersonService;

    @Autowired
    private SysPersonService sysPersonService;

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {
        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.JD_RECORD_QUALITY_EDIT));
        model.addAttribute("jdTypeCode", JdRecordType.TYPE_QUALITY.getCode());
        model.addAttribute("REFORM", JdStopOrderType.TYPE_REFORM.getCode());
        model.addAttribute("SUSPEND", JdStopOrderType.TYPE_SUSPEND.getCode());
        model.addAttribute("STOP", JdStopOrderType.TYPE_STOP.getCode());
        pushStaticValueToPage(model);
        return "view/jd/jdRecordQuality/grid";
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
    public void gridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows) {
        try {
            Page pageModel = new Page(page, rows, true);
            String hql = "from JdRecordQuality order by id desc";
            //增加自定义查询条件

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            pageModel = jdRecordQualityService.findByPage(pageModel, queryTranslate.toString());
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

    /**
     * 新增录入页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String add(Model model,String jdTaskCode,String planDetailId) {
        JdRecordQuality jdRecordQuality = new JdRecordQuality();
        //附件保存
        model.addAttribute("uploadButton", documentManager.getUploadButton(documentManager.getDefaultXmlConfig(),
                "JdRecord", jdRecordQuality.getDocument(), null, null));
        Calendar calendar = Calendar.getInstance();
//        jdStopOrder.setSignDate(new java.sql.Date(calendar.getTime().getTime()));
        jdRecordQuality.setJdDatetime(new java.sql.Date(calendar.getTime().getTime()));
        jdRecordQuality.setCode(jdRecordManager.generateCode(JdRecordType.TYPE_QUALITY.getCode(), null));
        /*获取监督人员：*/
        List<JdRecordPerson> jdRecordPersonList = jdRecordManager.getJdRecordPersons(JdRecordType.TYPE_QUALITY.getCode(), null);

        /*获取监督问题：*/
        List<JdRecordQuestion> jdRecordBehaviorQuestionList = jdRecordManager.getJdRecordQuestions(JdRecordType.TYPE_QUALITY.getCode(), Constants.JD_RECORD_QUALITY_CHECK_BEHAVIOR, null);
        List<JdRecordQuestion> jdRecordEntityQuestionList = jdRecordManager.getJdRecordQuestions(JdRecordType.TYPE_QUALITY.getCode(), Constants.JD_RECORD_QUALITY_CHECK_ENTITY, null);

        /*质量监督--问题类别--行为检查*/
        model.addAttribute("JD_RECORD_QUALITY_CHECK_BEHAVIOR", Constants.JD_RECORD_QUALITY_CHECK_BEHAVIOR);
        /*质量监督--问题类别--设施检查*/
        model.addAttribute("JD_RECORD_QUALITY_CHECK_ENTITY", Constants.JD_RECORD_QUALITY_CHECK_ENTITY);
        /*表单种类*/
        model.addAttribute("JD_RECORD_QUALITY_CHECK_TYPE", JdRecordType.TYPE_QUALITY.getCode());

        /*如需增加其他默认值请在此添加*/
        model.addAttribute("bean", jdRecordQuality);
        model.addAttribute("jdRecordPersonList", jdRecordPersonList);
        model.addAttribute("jdRecordBehaviorQuestionList", jdRecordBehaviorQuestionList);
        model.addAttribute("jdRecordEntityQuestionList", jdRecordEntityQuestionList);
        model.addAttribute("jdTaskCode", jdTaskCode);
        model.addAttribute("planDetailId", planDetailId);
        pushStaticValueToPage(model);

        return "view/jd/jdRecordQuality/input";
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
        JdRecordQuality jdRecordQuality = jdRecordQualityService.get(id);
        //附件保存
        model.addAttribute("uploadButton", documentManager.getUploadButton(documentManager.getDefaultXmlConfig(),
                "JdRecord", jdRecordQuality.getDocument(), null, null));
        System.out.println("jdRecordQuality.getId() = " + jdRecordQuality.getId());
        /*获取监督人员：*/
        List<JdRecordPerson> jdRecordPersonList = jdRecordManager.getJdRecordPersons(JdRecordType.TYPE_QUALITY.getCode(), jdRecordQuality.getId());
        System.out.println("111111111111jdRecordPersonList = " + jdRecordPersonList);
        String[] jdRecordPersons = new String[jdRecordPersonList.size()];
        String[] jdRecordPersonIds = new String[jdRecordPersonList.size()];
        for (int i = 0; i < jdRecordPersonList.size(); i++) {
            jdRecordPersons[i] = jdRecordPersonList.get(i).getJdPersonDesc();
            jdRecordPersonIds[i] = jdRecordPersonList.get(i).getJdPerson().getId() + "";
        }
        model.addAttribute("jdRecordPersons", StringHelper.join(jdRecordPersons, ","));
        /*获取监督问题：*/
        List<JdRecordQuestion> jdRecordBehaviorQuestionList = jdRecordManager.getJdRecordQuestions(JdRecordType.TYPE_QUALITY.getCode(), Constants.JD_RECORD_QUALITY_CHECK_BEHAVIOR, jdRecordQuality.getId());
        List<JdRecordQuestion> jdRecordEntityQuestionList = jdRecordManager.getJdRecordQuestions(JdRecordType.TYPE_QUALITY.getCode(), Constants.JD_RECORD_QUALITY_CHECK_ENTITY, jdRecordQuality.getId());
        /*质量监督--问题类别--行为检查*/
        model.addAttribute("JD_RECORD_QUALITY_CHECK_BEHAVIOR", Constants.JD_RECORD_QUALITY_CHECK_BEHAVIOR);
        /*质量监督--问题类别--设施检查*/
        model.addAttribute("JD_RECORD_QUALITY_CHECK_ENTITY", Constants.JD_RECORD_QUALITY_CHECK_ENTITY);
        /*表单种类*/
        model.addAttribute("JD_RECORD_QUALITY_CHECK_TYPE", JdRecordType.TYPE_QUALITY.getCode());

        /*如需增加其他默认值请在此添加*/
        model.addAttribute("bean", jdRecordQuality);
        model.addAttribute("jdRecordPersons", jdRecordPersons);
        model.addAttribute("jdRecordPersonIds", StringHelper.join(jdRecordPersonIds, ","));
        model.addAttribute("jdRecordPersonList", jdRecordPersonList);
        System.out.println("22222222jdRecordPersonList = " + jdRecordPersonList);
        model.addAttribute("jdRecordBehaviorQuestionList", jdRecordBehaviorQuestionList);
        model.addAttribute("jdRecordEntityQuestionList", jdRecordEntityQuestionList);
        pushStaticValueToPage(model);
        pushStaticValueToPage(model);
        return "view/jd/jdRecordQuality/input";
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
        JdRecordQuality jdRecordQuality = jdRecordQualityService.get(id);

        //显示附件
        model.addAttribute("docButton", documentManager.getDownloadButton(jdRecordQuality.getDocument()));
        List<JdRecordPerson> jdRecordPersonList = jdRecordManager.getJdRecordPersons(JdRecordType.TYPE_QUALITY.getCode(), jdRecordQuality.getId());
         /*获取监督问题：*/
        List<JdRecordQuestion> jdRecordBehaviorQuestionList = jdRecordManager.getJdRecordQuestions(JdRecordType.TYPE_QUALITY.getCode(), Constants.JD_RECORD_QUALITY_CHECK_BEHAVIOR, jdRecordQuality.getId());
        List<JdRecordQuestion> jdRecordEntityQuestionList = jdRecordManager.getJdRecordQuestions(JdRecordType.TYPE_QUALITY.getCode(), Constants.JD_RECORD_QUALITY_CHECK_ENTITY, jdRecordQuality.getId());
        model.addAttribute("bean", jdRecordQuality);
        /*表单种类*/
        model.addAttribute("JD_RECORD_QUALITY_CHECK_TYPE", JdRecordType.TYPE_QUALITY.getCode());
        /*质量监督--问题类别--行为检查*/
        model.addAttribute("JD_RECORD_QUALITY_CHECK_BEHAVIOR", Constants.JD_RECORD_QUALITY_CHECK_BEHAVIOR);
        /*质量监督--问题类别--设施检查*/
        model.addAttribute("JD_RECORD_QUALITY_CHECK_ENTITY", Constants.JD_RECORD_QUALITY_CHECK_ENTITY);
        model.addAttribute("jdRecordPersonList", jdRecordPersonList);
        model.addAttribute("jdRecordBehaviorQuestionList", jdRecordBehaviorQuestionList);
        model.addAttribute("jdRecordEntityQuestionList", jdRecordEntityQuestionList);
        return "view/jd/jdRecordQuality/view";
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
    public void save(HttpServletResponse response, @ModelAttribute("bean") JdRecordQuality entity, HttpServletRequest request) throws Exception {
        try {
            JdRecordQuality target;
            if (entity.getId() != null) {
                target = jdRecordQualityService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
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
                        "inspectionPosition",
                        "jdInspection",
                        "dealOpinion",
                        "description",
                        "jdDatetime",
                        "status"
                });

            } else {
                target = entity;
                target.setCode(jdRecordManager.generateCode(JdRecordType.TYPE_QUALITY.getCode(), null));
            }
            //保存附件
            String docId = request.getParameter("docId");
            if (StringHelper.isNotEmpty(docId)) {
                DocDocument docDocument = docDocumentService.get(Long.valueOf(docId));
                target.setDocument(docDocument);
            }
            jdRecordQualityService.save(target);
            String planDetailId = request.getParameter("planDetailId");
            if(!StringHelper.isEmpty(planDetailId)){
                String cancelCode = sysCodeManager.getCodeDetailByCode(Constants.PLAN_DETAIL_STATUS, Constants.PLAN_DETAIL_STATUS_CHECKED).getCode();
                planMainInfoManager.setDetailStatus(Long.valueOf(planDetailId), cancelCode, java.sql.Date.valueOf(DateTimeHelper.getCurrentDate()));
            }
            String scheduleItems[] = request.getParameterValues("scheduleItems");
            String attendPersonIds = request.getParameter("attendPersonIds");
            List<JdRecordPerson> jdRecordPersonList = jdRecordManager.getJdRecordPersons(JdRecordType.TYPE_QUALITY.getCode(), target.getId());
            for (JdRecordPerson jdRecordPerson : jdRecordPersonList) {
                jdRecordPersonService.delete(jdRecordPerson);
            }
            for (String attendPersonId : StringHelper.split(attendPersonIds, ",")) {
                JdRecordPerson jdRecordPerson = new JdRecordPerson();
                jdRecordPerson.setJdTypeCode(JdRecordType.TYPE_QUALITY.getCode());
                SysPerson sysPerson = sysPersonService.get(Long.parseLong(attendPersonId));
                jdRecordPerson.setJdPerson(sysPerson);
                jdRecordPerson.setJdPersonDesc(sysPerson.getName());
                System.out.println("target.getId = " + target.getId());
                jdRecordPerson.setRecordId(target.getId());
                jdRecordPersonService.save(jdRecordPerson);
            }
            target.setScheduleItems(StringHelper.join(scheduleItems, ","));
            String jdManager = request.getParameter("jdManager");
            if (!"".equals(jdManager)) {
                SysPerson sysPerson = sysPersonService.get(Long.parseLong(jdManager));
                target.setJdManager(sysPerson);
            }
            jdRecordQualityService.save(target);

            // 删除
            List<JdRecordQuestion> jdRecordQItemBehavior = jdRecordManager.getJdRecordQuestions(JdRecordType.TYPE_QUALITY.getCode(), Constants.JD_RECORD_QUALITY_CHECK_BEHAVIOR, target.getId());
            List<JdRecordQuestion> jdRecordQItemFacility = jdRecordManager.getJdRecordQuestions(JdRecordType.TYPE_QUALITY.getCode(), Constants.JD_RECORD_QUALITY_CHECK_ENTITY, target.getId());

            for (JdRecordQuestion jdRecordQuestion : jdRecordQItemBehavior) {
                jdRecordQuestionService.delete(jdRecordQuestion);
            }
            for (JdRecordQuestion jdRecordQuestion2 : jdRecordQItemFacility) {
                jdRecordQuestionService.delete(jdRecordQuestion2);
            }
            // 序号  行为抽查
            String[] orderNoBehavior = request.getParameterValues("orderNo" + Constants.JD_RECORD_QUALITY_CHECK_BEHAVIOR);
            // 问题 行为抽查
            String[] questionDescBehavior = request.getParameterValues("questionDesc" + Constants.JD_RECORD_QUALITY_CHECK_BEHAVIOR);
            String[] questionIdsBehavior = request.getParameterValues("questionDescId" + Constants.JD_RECORD_QUALITY_CHECK_BEHAVIOR);

            // 违反条约 行为抽查
            String[] unlawDescBehavior = request.getParameterValues("unlawDesc" + Constants.JD_RECORD_QUALITY_CHECK_BEHAVIOR);
            String[] unlawDescIdsBehavior = request.getParameterValues("unlawDescId" + Constants.JD_RECORD_QUALITY_CHECK_BEHAVIOR);

            // 监督员 行为抽查
            String[] jdPersonDescBehavior = request.getParameterValues("jdRecordQuestionPersonNames" + Constants.JD_RECORD_QUALITY_CHECK_BEHAVIOR);
            String[] jdPersonIDBehavior = request.getParameterValues("jdRecordQuestionPersonIds" + Constants.JD_RECORD_QUALITY_CHECK_BEHAVIOR);

            if (null != questionDescBehavior && questionDescBehavior.length != 0) {
                for (int id = 0; id < questionDescBehavior.length; id++) {
                    JdRecordQuestion jdRecordQuestion = new JdRecordQuestion();
                    if (!StringHelper.isEmpty(orderNoBehavior[id])) {
                        // 序号
                        jdRecordQuestion.setOrderNo(Integer.parseInt(orderNoBehavior[id]));

                        // 问题
                        jdRecordQuestion.setQuestionDesc(questionDescBehavior[id]);
                        if (!StringHelper.isEmpty(questionIdsBehavior[id]) && isNum(questionIdsBehavior[id])) {
                            jdRecordQuestion.setQuestionId(Long.valueOf(questionIdsBehavior[id]));
                        }
                        // 违反条约
                        jdRecordQuestion.setUnlawDesc(unlawDescBehavior[id]);
                        if (!StringHelper.isEmpty(unlawDescIdsBehavior[id]) && isNum(unlawDescIdsBehavior[id])) {
                            jdRecordQuestion.setUnlawId(Long.valueOf(unlawDescIdsBehavior[id]));
                        }
                        // 监督员
                        jdRecordQuestion.setJdPersonDesc(jdPersonDescBehavior[id]);
                        if (!StringHelper.isEmpty(jdPersonIDBehavior[id]) && isNum(jdPersonIDBehavior[id])) {
                            jdRecordQuestion.setJdPersonId(Long.valueOf(jdPersonIDBehavior[id]));
                        }
                        jdRecordQuestion.setRecordId(target.getId());
                        jdRecordQuestion.setJdTypeCode(JdRecordType.TYPE_QUALITY.getCode());
                        jdRecordQuestion.setTypeCode(Constants.JD_RECORD_QUALITY_CHECK_BEHAVIOR);

                        jdRecordQuestionService.save(jdRecordQuestion);
                    }
                }
            }
            // 序号 设施检查
            String[] orderNoFacility = request.getParameterValues("orderNo" + Constants.JD_RECORD_QUALITY_CHECK_ENTITY);
            // 问题 设施检查
            String[] questionDescFacility = request.getParameterValues("questionDesc" + Constants.JD_RECORD_QUALITY_CHECK_ENTITY);
            String[] questionIdsFacility = request.getParameterValues("questionDescId" + Constants.JD_RECORD_QUALITY_CHECK_ENTITY);

            // 违反条约 设施检查
            String[] unlawDescFacility = request.getParameterValues("unlawDesc" + Constants.JD_RECORD_QUALITY_CHECK_ENTITY);
            String[] unlawDescIdsFacility = request.getParameterValues("unlawDescId" + Constants.JD_RECORD_QUALITY_CHECK_ENTITY);

            // 监督员 设施检查
            String[] jdPersonDescFacility = request.getParameterValues("jdRecordQuestionPersonNames" + Constants.JD_RECORD_QUALITY_CHECK_ENTITY);
            String[] jdPersonIDFacility = request.getParameterValues("jdRecordQuestionPersonIds" + Constants.JD_RECORD_QUALITY_CHECK_ENTITY);

            if (null != questionDescFacility && questionDescFacility.length != 0) {
                for (int id = 0; id < questionDescFacility.length; id++) {
                    JdRecordQuestion jdRecordQuestion = new JdRecordQuestion();
                    if (!StringHelper.isEmpty(orderNoFacility[id])) {
                        // 序号
                        jdRecordQuestion.setOrderNo(Integer.parseInt(orderNoFacility[id]));

                        // 问题
                        jdRecordQuestion.setQuestionDesc(questionDescFacility[id]);
                        if (!StringHelper.isEmpty(questionIdsFacility[id]) && isNum(questionIdsFacility[id])) {
                            jdRecordQuestion.setQuestionId(Long.valueOf(questionIdsFacility[id]));
                        }
                        // 违反条约
                        jdRecordQuestion.setUnlawDesc(unlawDescFacility[id]);
                        if (!StringHelper.isEmpty(unlawDescIdsFacility[id]) && isNum(unlawDescIdsFacility[id])) {
                            jdRecordQuestion.setUnlawId(Long.valueOf(unlawDescIdsFacility[id]));
                        }
                        // 监督员
                        jdRecordQuestion.setJdPersonDesc(jdPersonDescFacility[id]);
                        if (!StringHelper.isEmpty(jdPersonIDFacility[id]) && isNum(jdPersonIDFacility[id])) {
                            jdRecordQuestion.setJdPersonId(Long.valueOf(jdPersonIDFacility[id]));
                        }
                        jdRecordQuestion.setRecordId(target.getId());
                        jdRecordQuestion.setJdTypeCode(JdRecordType.TYPE_QUALITY.getCode());
                        jdRecordQuestion.setTypeCode(Constants.JD_RECORD_QUALITY_CHECK_ENTITY);
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
        JdRecordQuality recordQuality = jdRecordQualityService.get(id);

        //删除问题列表
        List<JdRecordQuestion> list = jdRecordManager.getJdRecordQuestions(recordQuality.getJdTaskCode(), null, id);
        for (JdRecordQuestion jdRecordQuestion : list) {
            jdRecordQuestionService.delete(jdRecordQuestion);
        }

        //删除监督记录
        jdRecordQualityService.delete(id);

        sendSuccessJSON(response, "删除成功");
    }

    /**
     * 各种状态的编码
     *
     * @param model .
     */
    private void pushStaticValueToPage(Model model) {
        model.addAttribute("SUBMIT", JdRecordStatus.SUBMIT.getCode());
        model.addAttribute("EDIT", JdRecordStatus.EDIT.getCode());
        model.addAttribute("jdDept", configManager.getJdDeptName());
    }

    /**
     * 判断是否为数字
     *
     * @return .
     */
    public static boolean isNum(String str) {
        return str.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
    }
}