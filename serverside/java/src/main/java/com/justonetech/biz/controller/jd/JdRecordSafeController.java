package com.justonetech.biz.controller.jd;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.DocDocumentService;
import com.justonetech.biz.daoservice.JdRecordPersonService;
import com.justonetech.biz.daoservice.JdRecordQuestionService;
import com.justonetech.biz.daoservice.JdRecordSafeService;
import com.justonetech.biz.domain.DocDocument;
import com.justonetech.biz.domain.JdRecordPerson;
import com.justonetech.biz.domain.JdRecordQuestion;
import com.justonetech.biz.domain.JdRecordSafe;
import com.justonetech.biz.domain.bean.jdRecord.JdProjectInfo;
import com.justonetech.biz.manager.DocumentManager;
import com.justonetech.biz.manager.JdRecordManager;
import com.justonetech.biz.manager.PlanMainInfoManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.biz.utils.enums.JdRecordStatus;
import com.justonetech.biz.utils.enums.JdRecordType;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.*;
import com.justonetech.system.daoservice.SysCodeDetailService;
import com.justonetech.system.daoservice.SysPersonService;
import com.justonetech.system.domain.SysCodeDetail;
import com.justonetech.system.domain.SysPerson;
import com.justonetech.system.domain.SysUser;
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
 * note:安全质量监督--安全监督
 * author: shaxiaojie
 * create 2014/1/09:
 * modify 2014/1/09:
 */
@Controller
public class JdRecordSafeController extends BaseCRUDActionController<JdRecordSafe> {
    private Logger logger = LoggerFactory.getLogger(JdRecordSafeController.class);

    @Autowired
    private SysCodeDetailService sysCodeDetailService;

    @Autowired
    private SysCodeManager sysCodeManager;

    @Autowired
    private PlanMainInfoManager planMainInfoManager;

    @Autowired
    private DocumentManager documentManager;

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private JdRecordPersonService jdRecordPersonService;

    @Autowired
    private JdRecordSafeService jdRecordSafeService;

    @Autowired
    private JdRecordManager jdRecordManager;

    @Autowired
    private DocDocumentService docDocumentService;

    @Autowired
    private SysPersonService sysPersonService;

    @Autowired
    private JdRecordQuestionService jdRecordQuestionService;


    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {
        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.JD_RECORD_SAFE_EDIT));
        model.addAttribute("jdTypeCode", JdRecordType.TYPE_SAFE.getCode()); //监督记录类别编码
        pushStaticValueToPage(model);
        return "view/jd/jdRecordSafe/grid";
    }

    /**
     * 获取列表数据
     *
     * @param response .
     * @param filters  .
     * @param columns  .
     * @param columns  .
     * @param page     .
     * @param rows     .
     */
    @RequestMapping
    public void gridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows) {
        try {
            Page pageModel = new Page(page, rows, true);
            String hql = "from JdRecordSafe order by id desc";
            //增加自定义查询条件

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            pageModel = jdRecordSafeService.findByPage(pageModel, queryTranslate.toString());

            List<Map> list = GridJq.getGridValue(pageModel.getRows(), columns);
            for (Map bean : list) {
                if (null != bean.get("id")) {
                    JdRecordSafe jdRecordSafe = jdRecordSafeService.get(JspHelper.getLong(bean.get("id")));
                    if (null != jdRecordSafe.getStatus()) {
                        bean.put("statusName", JdRecordStatus.getNameByCode(jdRecordSafe.getStatus()));
                    }
                }
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
    public String add(Model model,String planDetailId) {
        model.addAttribute("planDetailId", planDetailId);
        JdRecordSafe jdRecordSafe = new JdRecordSafe();

        //附件保存
        model.addAttribute("uploadButton", documentManager.getUploadButton(documentManager.getDefaultXmlConfig(),
                "JdRecord", jdRecordSafe.getDocument(), null, null));
        // 初始化监督日期：
        Calendar calendar = Calendar.getInstance();
        jdRecordSafe.setJdDatetime(new java.sql.Date(calendar.getTime().getTime()));

        String code = jdRecordManager.generateCode(JdRecordType.TYPE_SAFE.getCode(), null);
        jdRecordSafe.setCode(code);

        SysUser sysu = sysUserManager.getSysUser();
        if (null != sysu && null != sysu.getId() && !"".equals(sysu.getId())) {
            SysPerson sysPerson = sysPersonService.get(sysu.getId());
//                jdRecordSafe.setJdManager(sysPerson);
//                jdRecordSafe.setJdManagerName(sysPerson.getName());
        }
         /*获取监督人员：*/
        List<JdRecordPerson> jdRecordPersonList = jdRecordManager.getJdRecordPersons(JdRecordType.TYPE_SAFE.getCode(), null);
        model.addAttribute("jdRecordPersonList", jdRecordPersonList);
        //安全监督--问题类别--行为检查
        model.addAttribute("JD_RECORD_SAFE_CHECK_BEHAVIOR", Constants.JD_RECORD_SAFE_CHECK_BEHAVIOR);
        //安全监督--问题类别--设施检查
        model.addAttribute("JD_RECORD_SAFE_CHECK_FACILITY", Constants.JD_RECORD_SAFE_CHECK_FACILITY);

        model.addAttribute("JD_RECORD_SAFE_CHECK_TYPE", JdRecordType.TYPE_SAFE.getCode());

        model.addAttribute("bean", jdRecordSafe);
        pushStaticValueToPage(model);
        List<SysCodeDetail> listCode = getCodeListByCode(Constants.JD_RECORD_SAFE_SS_TYPE);
        model.addAttribute("listCode", listCode);
        return "view/jd/jdRecordSafe/input";
    }


    /**
     * 根据代码取得代码列表值
     *
     * @param code 代码类型Code
     * @return SysCodeDetail列表
     */
    public List<SysCodeDetail> getCodeListByCode(String code) {
        String hql = "from SysCodeDetail t where t.sysCode.code = '" + code
                + "' order by t.treeId";
        return sysCodeDetailService.findByQuery(hql);
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

        JdRecordSafe jdRecordSafe = jdRecordSafeService.get(id);

        //附件保存
        model.addAttribute("uploadButton", documentManager.getUploadButton(documentManager.getDefaultXmlConfig(),
                "JdRecord", jdRecordSafe.getDocument(), null, null));
        String code = jdRecordManager.generateCode(JdRecordType.TYPE_SAFE.getCode(), id);
        jdRecordSafe.setCode(code);
        model.addAttribute("bean", jdRecordSafe);

        List<SysCodeDetail> listCode = getCodeListByCode(Constants.JD_RECORD_SAFE_SS_TYPE);
        model.addAttribute("listCode", listCode);

         /*获取监督人员：*/
        List<JdRecordPerson> jdRecordPersonList = jdRecordManager.getJdRecordPersons(JdRecordType.TYPE_SAFE.getCode(), jdRecordSafe.getId());
        model.addAttribute("jdRecordPersonList", jdRecordPersonList);
        String[] jdRecordPersonIds = new String[jdRecordPersonList.size()];
        for (int i = 0; i < jdRecordPersonList.size(); i++) {
            jdRecordPersonIds[i] = jdRecordPersonList.get(i).getJdPerson().getId() + "";
        }
        model.addAttribute("jdRecordPersonIds", StringHelper.join(jdRecordPersonIds, ","));
        // 获取报建编号
        JdProjectInfo jdProjectInfo = jdRecordManager.getProjectInfo(jdRecordSafe.getJdTaskCode());
        model.addAttribute("jdjg", jdProjectInfo.getJdjg());

        //安全监督--问题类别--行为检查
        model.addAttribute("JD_RECORD_SAFE_CHECK_BEHAVIOR", Constants.JD_RECORD_SAFE_CHECK_BEHAVIOR);
        //安全监督--问题类别--设施检查
        model.addAttribute("JD_RECORD_SAFE_CHECK_FACILITY", Constants.JD_RECORD_SAFE_CHECK_FACILITY);
        model.addAttribute("JD_RECORD_SAFE_CHECK_TYPE", JdRecordType.TYPE_SAFE.getCode());
        pushStaticValueToPage(model);

        return "view/jd/jdRecordSafe/input";
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
        JdRecordSafe jdRecordSafe = jdRecordSafeService.get(id);

        //显示附件
        model.addAttribute("docButton", documentManager.getDownloadButton(jdRecordSafe.getDocument()));
        model.addAttribute("bean", jdRecordSafe);

        JdProjectInfo jdProjectInfo = jdRecordManager.getProjectInfo(jdRecordSafe.getJdTaskCode());
        model.addAttribute("jdjg", jdProjectInfo.getJdjg());

        //安全监督--问题类别--行为检查
        model.addAttribute("JD_RECORD_SAFE_CHECK_BEHAVIOR", Constants.JD_RECORD_SAFE_CHECK_BEHAVIOR);
        //安全监督--问题类别--设施检查
        model.addAttribute("JD_RECORD_SAFE_CHECK_FACILITY", Constants.JD_RECORD_SAFE_CHECK_FACILITY);
        model.addAttribute("JD_RECORD_SAFE_CHECK_TYPE", JdRecordType.TYPE_SAFE.getCode());
        pushStaticValueToPage(model);
        return "view/jd/jdRecordSafe/view";
    }

    //各种状态的编码
    private void pushStaticValueToPage(Model model) {
        model.addAttribute("STATUS_EDIT", JdRecordStatus.EDIT.getCode()); //正在填写
        model.addAttribute("STATUS_SUBMIT", JdRecordStatus.SUBMIT.getCode());//已提交
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
     * 保存操作
     *
     * @param response .
     * @param entity   .
     * @param request  .
     * @throws Exception .
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void save(HttpServletResponse response, @ModelAttribute("bean") JdRecordSafe entity, HttpServletRequest request) throws Exception {
        try {
            JdRecordSafe target;
            if (entity.getId() != null) {
                target = jdRecordSafeService.get(entity.getId());
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
                        "inspectionContent",
                        "inspectionPosition",
                        "dealOpinion",
                        "description",
                        "jdDatetime",
                        "status"
                });

            } else {
                target = entity;
            }
            //保存附件
            String docId = request.getParameter("docId");
            if (StringHelper.isNotEmpty(docId)) {
                DocDocument docDocument = docDocumentService.get(Long.valueOf(docId));
                target.setDocument(docDocument);
            }
            String code = jdRecordManager.generateCode(JdRecordType.TYPE_SAFE.getCode(), target.getId());
            target.setCode(code);
            String attendPersonIds = request.getParameter("attendPersonIds");
            String scheduleItems[] = request.getParameterValues("scheduleItems");
            target.setScheduleItems(StringHelper.join(scheduleItems, ","));
            String jdManager = request.getParameter("jdManager");
            if (!StringHelper.isEmpty(jdManager)) {
                SysPerson sysPerson = sysPersonService.get(Long.parseLong(jdManager));
                target.setJdManager(sysPerson);
            }
            jdRecordSafeService.save(target);
            String planDetailId = request.getParameter("planDetailId");
            if(!StringHelper.isEmpty(planDetailId)){
                String cancelCode = sysCodeManager.getCodeDetailByCode(Constants.PLAN_DETAIL_STATUS, Constants.PLAN_DETAIL_STATUS_CHECKED).getCode();
                planMainInfoManager.setDetailStatus(Long.valueOf(planDetailId), cancelCode, java.sql.Date.valueOf(DateTimeHelper.getCurrentDate()));
            }
            String hql = "select j from JdRecordPerson j where j.recordId={0}";
            hql = FormatUtils.format(hql, target.getId());
            List<JdRecordPerson> jdRecordPersons = jdRecordPersonService.findByQuery(hql);
            for (JdRecordPerson jdRecordPerson : jdRecordPersons) {
                jdRecordPersonService.delete(jdRecordPerson);
            }

            if (!StringHelper.isEmpty(attendPersonIds)) {
                for (String attendPersonId : StringHelper.split(attendPersonIds, ",")) {
                    if (!"".equals(attendPersonId)) {
                        JdRecordPerson jdRecordPerson = new JdRecordPerson();
                        jdRecordPerson.setJdTypeCode(JdRecordType.TYPE_SAFE.getCode());
                        SysPerson sysPerson = sysPersonService.get(Long.parseLong(attendPersonId));
                        jdRecordPerson.setJdPerson(sysPerson);
                        jdRecordPerson.setJdPersonDesc(sysPerson.getName());
                        jdRecordPerson.setRecordId(target.getId());
                        // 保存参加监督人员
                        jdRecordPersonService.save(jdRecordPerson);
                    }
                }
            }
            // 删除安全监督问题
            List<JdRecordQuestion> jdRecordQItemBehavior = jdRecordManager.getJdRecordQuestions(JdRecordType.TYPE_SAFE.getCode(), Constants.JD_RECORD_SAFE_CHECK_BEHAVIOR, target.getId());
            List<JdRecordQuestion> jdRecordQItemFacility = jdRecordManager.getJdRecordQuestions(JdRecordType.TYPE_SAFE.getCode(), Constants.JD_RECORD_SAFE_CHECK_FACILITY, target.getId());
            // 删除安全监督-行为检查问题
            for (JdRecordQuestion jdRecordQuestion : jdRecordQItemBehavior) {
                jdRecordQuestionService.delete(jdRecordQuestion);
            }

            // 删除安全监督-设施检查
            for (JdRecordQuestion jdRecordQuestion2 : jdRecordQItemFacility) {
                jdRecordQuestionService.delete(jdRecordQuestion2);
            }

            //  行为检查问题保存
            // 序号  行为抽查
            String[] orderNoBehavior = request.getParameterValues("orderNo" + Constants.JD_RECORD_SAFE_CHECK_BEHAVIOR);
            // 问题 行为抽查
            String[] questionDescBehavior = request.getParameterValues("questionDesc" + Constants.JD_RECORD_SAFE_CHECK_BEHAVIOR);
            String[] questionIdsBehavior = request.getParameterValues("questionDescId" + Constants.JD_RECORD_SAFE_CHECK_BEHAVIOR);
            // 违反条约 行为抽查
            String[] unlawDescBehavior = request.getParameterValues("unlawDesc" + Constants.JD_RECORD_SAFE_CHECK_BEHAVIOR);
            String[] unlawDescIdsBehavior = request.getParameterValues("unlawDescId" + Constants.JD_RECORD_SAFE_CHECK_BEHAVIOR);
            // 监督员 行为抽查
            String[] jdPersonDescBehavior = request.getParameterValues("jdRecordQuestionPersonNames" + Constants.JD_RECORD_SAFE_CHECK_BEHAVIOR);
            String[] jdPersonIDBehavior = request.getParameterValues("jdRecordQuestionPersonIds" + Constants.JD_RECORD_SAFE_CHECK_BEHAVIOR);
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
                        jdRecordQuestion.setJdTypeCode(JdRecordType.TYPE_SAFE.getCode());
                        jdRecordQuestion.setTypeCode(Constants.JD_RECORD_SAFE_CHECK_BEHAVIOR);
                        // 删除安全监督-行为检查问题
                        jdRecordQuestionService.save(jdRecordQuestion);
                    }
                }
            }
            // 安全监督设施检查问题
            // 序号 设施检查
            String[] orderNoFacility = request.getParameterValues("orderNo" + Constants.JD_RECORD_SAFE_CHECK_FACILITY);
            // 问题 设施检查
            String[] questionDescFacility = request.getParameterValues("questionDesc" + Constants.JD_RECORD_SAFE_CHECK_FACILITY);
            String[] questionIdsFacility = request.getParameterValues("questionDescId" + Constants.JD_RECORD_SAFE_CHECK_FACILITY);
            // 违反条约 设施检查
            String[] unlawDescFacility = request.getParameterValues("unlawDesc" + Constants.JD_RECORD_SAFE_CHECK_FACILITY);
            String[] unlawDescIdsFacility = request.getParameterValues("unlawDescId" + Constants.JD_RECORD_SAFE_CHECK_FACILITY);
            // 监督员 设施检查
            String[] jdPersonDescFacility = request.getParameterValues("jdRecordQuestionPersonNames" + Constants.JD_RECORD_SAFE_CHECK_FACILITY);
            String[] jdPersonIDFacility = request.getParameterValues("jdRecordQuestionPersonIds" + Constants.JD_RECORD_SAFE_CHECK_FACILITY);

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
                        jdRecordQuestion.setJdTypeCode(JdRecordType.TYPE_SAFE.getCode());
                        jdRecordQuestion.setTypeCode(Constants.JD_RECORD_SAFE_CHECK_FACILITY);
                        // 安全监督设施检查问题
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
        jdRecordSafeService.delete(id);
        // 删除安全监督问题
        List<JdRecordQuestion> jdRecordQItemBehavior = jdRecordManager.getJdRecordQuestions(JdRecordType.TYPE_SAFE.getCode(), Constants.JD_RECORD_SAFE_CHECK_BEHAVIOR, id);
        List<JdRecordQuestion> jdRecordQItemFacility = jdRecordManager.getJdRecordQuestions(JdRecordType.TYPE_SAFE.getCode(), Constants.JD_RECORD_SAFE_CHECK_FACILITY, id);
        // 删除安全监督-行为检查问题
        for (JdRecordQuestion jdRecordQuestion : jdRecordQItemBehavior)
            jdRecordQuestionService.delete(jdRecordQuestion);

        // 删除安全监督-设施检查
        for (JdRecordQuestion jdRecordQuestion2 : jdRecordQItemFacility)
            jdRecordQuestionService.delete(jdRecordQuestion2);

        sendSuccessJSON(response, "删除成功");
    }

}