package com.justonetech.biz.controller.jd;

import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.*;
import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.*;
import com.justonetech.biz.domain.*;
import com.justonetech.biz.manager.*;
import com.justonetech.biz.utils.Constants;
import com.justonetech.biz.utils.enums.JdRecordStatus;
import com.justonetech.biz.utils.enums.JdRecordType;
import com.justonetech.system.daoservice.SysCodeDetailService;
import com.justonetech.system.daoservice.SysPersonService;
import com.justonetech.system.domain.SysCodeDetail;
import com.justonetech.system.domain.SysPerson;
import com.justonetech.system.manager.SimpleQueryManager;
import com.justonetech.system.manager.SysCodeManager;
import com.justonetech.system.manager.SysUserManager;
import com.justonetech.system.tree.ZTreeBranch;
import com.justonetech.system.tree.ZTreeNode;
import com.justonetech.system.utils.PrivilegeCode;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;


/**
 * note:安全质量监督--竣工验收
 * author: nongyan
 * create date:
 * modify date:
 */
@Controller
public class JdRecordCompleteController extends BaseCRUDActionController<JdRecordComplete> {
    private Logger logger = LoggerFactory.getLogger(JdRecordCompleteController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private SysCodeManager sysCodeManager;

    @Autowired
    private RelateManager relateManager;

    @Autowired
    private ProjectManager projectManager;

    @Autowired
    private JdRecordManager jdRecordManager;

    @Autowired
    private ExcelJdDwgcService excelJdDwgcService;

    @Autowired
    private JdRecordCompCheckitemService jdRecordCompCheckitemService;

    @Autowired
    private JdRecordCompleteDwgcService jdRecordCompleteDwgcService;

    @Autowired
    private JdRecordCompleteResultService jdRecordCompleteResultService;

    @Autowired
    private SysCodeDetailService sysCodeDetailService;

    @Autowired
    private PlanMainInfoManager planMainInfoManager;

    @Autowired
    private ConfigManager configManager;

    @Autowired
    private DocumentManager documentManager;

    @Autowired
    private SimpleQueryManager simpleQueryManager;

    @Autowired
    private DocDocumentService docDocumentService;

    @Autowired
    private JdRecordCompleteService jdRecordCompleteService;

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
    public String grid(Model model,String code) {
        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.JD_RECORD_COMPLETE_EDIT));
        model.addAttribute("STATUS_EDIT_COLOR_NAME", JdRecordStatus.EDIT.getName());
        model.addAttribute("STATUS_SUBMIT_COLOR_NAME", JdRecordStatus.SUBMIT.getName());
        pushStaticValueToPage(model);
        model.addAttribute("code",code);
        return "view/jd/jdRecordComplete/grid";
    }

    //各种状态的编码
    private void pushStaticValueToPage(Model model) {
        model.addAttribute("STATUS_EDIT", JdRecordStatus.EDIT.getCode()); //正在填写
        model.addAttribute("STATUS_SUBMIT", JdRecordStatus.SUBMIT.getCode());//已提交
        model.addAttribute("jdTypeCode", JdRecordType.TYPE_COMPLETE.getCode()); //监督记录类别编码
        model.addAttribute("jdjg", configManager.getJdDeptName());

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
    public void gridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows,String code) {
        try {
            Page<JdRecordComplete> pageModel = new Page<JdRecordComplete>(page, rows, true);
            String hql = "from JdRecordComplete where jdTypeCode='" + code + "' order by id desc";
            //增加自定义查询条件

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            pageModel = jdRecordCompleteService.findByPage(pageModel, queryTranslate.toString());

            //输出显示
            String json = GridJq.toJSON(columns, pageModel);
            sendJSON(response, json);

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
        }
    }

    /**
     * 获取树数据
     *
     * @param model 。
     */
    @RequestMapping
    public String treeDataForSelect(String jdTaskCode, String type, String id, String icon, Model model) {
        ZTreeBranch treeBranch = new ZTreeBranch();
        treeBranch.setIcons(icon.split(","));

        if (StringUtils.isEmpty(id)) {
            treeBranch.addTreeNode(treeBranch.getRootNode("根节点"));
        } else if (StringUtils.equals(id, "root")) {
            String hql = "from ExcelJdDwgc where jdTaskCode='{0}' order by id";
            hql = FormatUtils.format(hql, jdTaskCode);
            List<ExcelJdDwgc> nodeList = excelJdDwgcService.findByQuery(hql);
            for (ExcelJdDwgc data : nodeList) {
                ZTreeNode treeNode = new ZTreeNode();
                treeNode.setId(data.getDwgcCode());
                treeNode.setIsLeaf(true);
                treeNode.setName(data.getDwgcName() + "(" + data.getDwgcCode() + ")");
                treeNode.setText(data.getDwgcCode());
                treeNode.setIcon("2");
                treeNode.setType("dept");
                treeBranch.addTreeNode(treeNode);
            }
        }

        model.addAttribute("msg", treeBranch.toJsonString(true));
        return "common/msg";
    }

    /**
     * 新增录入页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String add(Model model, String jdcode,String jdTaskCode,String planDetailId) {
        JdRecordComplete jdRecordComplete = new JdRecordComplete();
        //附件保存
        model.addAttribute("uploadButton", documentManager.getUploadButton(documentManager.getDefaultXmlConfig(),
                "JdRecord", jdRecordComplete.getDocument(), null, null));
        jdRecordComplete.setJdDatetime(new java.sql.Date(System.currentTimeMillis()));
        jdRecordComplete.setCode(jdRecordManager.generateCode(JdRecordType.TYPE_COMPLETE.getCode(), null));

        //如需增加其他默认值请在此添加
        List<SysCodeDetail> codeListByCode = sysCodeManager.getCodeListByCode(Constants.JD_RECORD_COMPLETE_CONDITION_TYPE);
        List<Map<String, Object>> checkItems = new ArrayList<Map<String, Object>>();
        for (SysCodeDetail sysCodeDetail : codeListByCode) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("itemTitle", sysCodeDetail.getName());

            String hql = "from JdRecordCompCheckitem where type.id={0} order by orderNo asc";
            hql = FormatUtils.format(hql, sysCodeDetail.getId());
            List<JdRecordCompCheckitem> jdRecordCompCheckitems = jdRecordCompCheckitemService.findByQuery(hql);
            for (JdRecordCompCheckitem jdRecordCompCheckitem : jdRecordCompCheckitems) {
                String selectItems = jdRecordCompCheckitem.getSelectItems();
                String[] split = StringUtils.split(selectItems, "|");
                String dom = "";
                for (String s : split) {
                    if ("".equals(dom)) {
                        dom = "<input type=\"radio\" checked name=\"checkItem_" + jdRecordCompCheckitem.getId() + "\" value=\"" + s + "\">" + s + "\n";
                    } else {
                        dom += "<input type=\"radio\" name=\"checkItem_" + jdRecordCompCheckitem.getId() + "\" value=\"" + s + "\">" + s + "\n";
                    }
                }

                jdRecordCompCheckitem.setSelectItems(dom);
            }

            map.put("checkItem", jdRecordCompCheckitems);
            checkItems.add(map);
        }

        model.addAttribute("checkItems", checkItems);
        model.addAttribute("bean", jdRecordComplete);
        model.addAttribute("weekCn", DateTimeHelper.getWeekCn(new Date()));

        model.addAttribute("JD_RECORD_COMPLETE_CHECK_OTHER", Constants.JD_RECORD_COMPLETE_CHECK_OTHER);
        model.addAttribute("JD_RECORD_SAFE_CHECK_TYPE", JdRecordType.TYPE_COMPLETE.getCode());
        model.addAttribute("jdTypeCode", JdRecordType.TYPE_COMPLETE.getCode()); //监督记录类别编码
        pushStaticValueToPage(model);
        model.addAttribute("jdcode", jdcode);
        model.addAttribute("jdTaskCode", jdTaskCode);
        model.addAttribute("planDetailId", planDetailId);
        return "view/jd/jdRecordComplete/input";
    }

    /**
     * 修改显示页面
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String modify(Model model, Long id,String jdcode) {
        JdRecordComplete jdRecordComplete = jdRecordCompleteService.get(id);
        //附件保存
        model.addAttribute("uploadButton", documentManager.getUploadButton(documentManager.getDefaultXmlConfig(),
                "JdRecord", jdRecordComplete.getDocument(), null, null));
        Set<JdRecordCompleteDwgc> jdRecordCompleteDwgcs = jdRecordComplete.getJdRecordCompleteDwgcs();
        String codes = "";
        String names = "";
        for (JdRecordCompleteDwgc jdRecordCompleteDwgc : jdRecordCompleteDwgcs) {
            if (StringUtils.isEmpty(codes)) {
                codes = jdRecordCompleteDwgc.getDwgcCode();
                names = jdRecordCompleteDwgc.getDwgcName() + "(" + jdRecordCompleteDwgc.getDwgcCode() + ")";
            } else {
                codes += "," + jdRecordCompleteDwgc.getDwgcCode();
                names += "," + jdRecordCompleteDwgc.getDwgcName() + "(" + jdRecordCompleteDwgc.getDwgcCode() + ")";
            }
        }
        model.addAttribute("excelJdDwgcIds", codes);
        model.addAttribute("excelJdDwgcNames", names);

        Map<Long, String> map1 = new HashMap<Long, String>();

        Set<JdRecordCompleteResult> jdRecordCompleteResults = jdRecordComplete.getJdRecordCompleteResults();
        for (JdRecordCompleteResult jdRecordCompleteResult : jdRecordCompleteResults) {
            map1.put(jdRecordCompleteResult.getCheckitem().getId(), jdRecordCompleteResult.getCheckResult());
        }

        List<SysCodeDetail> codeListByCode = sysCodeManager.getCodeListByCode(Constants.JD_RECORD_COMPLETE_CONDITION_TYPE);

        List<Map<String, Object>> checkItems = new ArrayList<Map<String, Object>>();
        for (SysCodeDetail sysCodeDetail : codeListByCode) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("itemTitle", sysCodeDetail.getName());

            String hql = "from JdRecordCompCheckitem where type.id={0} order by orderNo asc";
            hql = FormatUtils.format(hql, sysCodeDetail.getId());
            List<JdRecordCompCheckitem> jdRecordCompCheckitems = jdRecordCompCheckitemService.findByQuery(hql);
            for (JdRecordCompCheckitem jdRecordCompCheckitem : jdRecordCompCheckitems) {
                String selectItems = jdRecordCompCheckitem.getSelectItems();
                String[] split = StringUtils.split(selectItems, "|");
                String dom = "";
                for (String s : split) {
                    if (StringUtils.equals(s, map1.get(jdRecordCompCheckitem.getId()))) {
                        dom += "<input type=\"radio\" checked name=\"checkItem_" + jdRecordCompCheckitem.getId() + "\" value=\"" + s + "\">" + s + "\n";
                    } else {
                        dom += "<input type=\"radio\" name=\"checkItem_" + jdRecordCompCheckitem.getId() + "\" value=\"" + s + "\">" + s + "\n";
                    }
                }

                jdRecordCompCheckitem.setSelectItems(dom);
            }

            map.put("checkItem", jdRecordCompCheckitems);
            checkItems.add(map);
        }

        model.addAttribute("checkItems", checkItems);
        model.addAttribute("bean", jdRecordComplete);

        //处理其他业务逻辑
        model.addAttribute("bean", jdRecordComplete);

        model.addAttribute("JD_RECORD_COMPLETE_CHECK_OTHER", Constants.JD_RECORD_COMPLETE_CHECK_OTHER);
        model.addAttribute("JD_RECORD_SAFE_CHECK_TYPE", JdRecordType.TYPE_COMPLETE.getCode());
        model.addAttribute("jdTypeCode", JdRecordType.TYPE_COMPLETE.getCode()); //监督记录类别编码
        pushStaticValueToPage(model);
        model.addAttribute("attendPersonOptions", getReceivePersonOption(id));
        model.addAttribute("jdcode", jdcode);
        return "view/jd/jdRecordComplete/input";
    }

    /**
     * 根据传入的id取得参加监督人员，拼接前台的option项。
     *
     * @param id .
     * @return options .
     */
    private String getReceivePersonOption(Long id) {
        String options = "";
        if (id != null) {
            String hql = "select p from SysPerson p, JdRecordPerson j where j.jdPerson.id=p.id and j.recordId={0} order by p.id";
            hql = FormatUtils.format(hql, id);
            List<SysPerson> sysPersons = sysPersonService.findByQuery(hql);
            for (SysPerson sysPerson : sysPersons) {
                options += "<option value=\"" + sysPerson.getId() + "\">" + sysPerson.getName() + "</option>\n";
            }
        }
        return options;
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
        JdRecordComplete jdRecordComplete = jdRecordCompleteService.get(id);
        //显示附件
        model.addAttribute("docButton", documentManager.getDownloadButton(jdRecordComplete.getDocument()));
        Set<JdRecordCompleteDwgc> jdRecordCompleteDwgcs = jdRecordComplete.getJdRecordCompleteDwgcs();
        String codes = "";
        String names = "";
        for (JdRecordCompleteDwgc jdRecordCompleteDwgc : jdRecordCompleteDwgcs) {
            if (StringUtils.isEmpty(codes)) {
                codes = jdRecordCompleteDwgc.getDwgcCode();
                names = jdRecordCompleteDwgc.getDwgcName() + "(" + jdRecordCompleteDwgc.getDwgcCode() + ")";
            } else {
                codes += "," + jdRecordCompleteDwgc.getDwgcCode();
                names += "," + jdRecordCompleteDwgc.getDwgcName() + "(" + jdRecordCompleteDwgc.getDwgcCode() + ")";
            }
        }
        model.addAttribute("excelJdDwgcIds", codes);
        model.addAttribute("excelJdDwgcNames", names);

        Map<Long, String> map1 = new HashMap<Long, String>();

        Set<JdRecordCompleteResult> jdRecordCompleteResults = jdRecordComplete.getJdRecordCompleteResults();
        for (JdRecordCompleteResult jdRecordCompleteResult : jdRecordCompleteResults) {
            map1.put(jdRecordCompleteResult.getCheckitem().getId(), jdRecordCompleteResult.getCheckResult());
        }

        List<SysCodeDetail> codeListByCode = sysCodeManager.getCodeListByCode(Constants.JD_RECORD_COMPLETE_CONDITION_TYPE);
        List<Map<String, Object>> checkItems = new ArrayList<Map<String, Object>>();
        for (SysCodeDetail sysCodeDetail : codeListByCode) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("itemTitle", sysCodeDetail.getName());

            String hql = "from JdRecordCompCheckitem where type.id={0} order by orderNo asc";
            hql = FormatUtils.format(hql, sysCodeDetail.getId());
            List<JdRecordCompCheckitem> jdRecordCompCheckitems = jdRecordCompCheckitemService.findByQuery(hql);
            for (JdRecordCompCheckitem jdRecordCompCheckitem : jdRecordCompCheckitems) {
                String dom = map1.get(jdRecordCompCheckitem.getId());
                jdRecordCompCheckitem.setSelectItems(dom);
            }

            map.put("checkItem", jdRecordCompCheckitems);
            checkItems.add(map);
        }

        model.addAttribute("checkItems", checkItems);
        model.addAttribute("bean", jdRecordComplete);

        model.addAttribute("weekCn", DateTimeHelper.getWeekCn(new Date()));
        model.addAttribute("bean", jdRecordComplete);

        List<JdRecordQuestion> jdRecordQItem = jdRecordManager.getJdRecordQuestions(JdRecordType.TYPE_COMPLETE.getCode(), Constants.JD_RECORD_COMPLETE_CHECK_OTHER, jdRecordComplete.getId());
        model.addAttribute("jdRecordQItem", jdRecordQItem);
        model.addAttribute("jdjg", configManager.getJdDeptName());

        return "view/jd/jdRecordComplete/view";
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
    public void save(HttpServletResponse response, @ModelAttribute("bean") JdRecordComplete entity, String excelJdDwgcIds,
                     String attendPersonIds, String excelJdDwgcNames, HttpServletRequest request,String jdcode) throws Exception {
        try {
            JdRecordComplete target;
            if (entity.getId() != null) {
                target = jdRecordCompleteService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "code",
                        "jdTaskCode",
                        "bjbh",
                        "weather",
                        "projectName",
                        "jdManager",
                        "attendPersons",
                        "jsDept",
                        "kcDept",
                        "sjDept",
                        "sgDept",
                        "jlDept",
                        "jcDept",
                        "dealOpinion",
                        "description",
                        "jdDatetime",
                        "status",
                        "auditTime",
                        "auditUser"
                });

            } else {
                target = entity;
                //监督记录编号
                target.setCode(jdRecordManager.generateCode(JdRecordType.TYPE_COMPLETE.getCode(), null));
            }
            target.setJdTypeCode(jdcode);
            //保存附件
            String docId = request.getParameter("docId");
            if (StringHelper.isNotEmpty(docId)) {
                DocDocument docDocument = docDocumentService.get(Long.valueOf(docId));
                target.setDocument(docDocument);
            }
            jdRecordCompleteService.save(target);
            String planDetailId = request.getParameter("planDetailId");
            if(!StringHelper.isEmpty(planDetailId)){
                String cancelCode = sysCodeManager.getCodeDetailByCode(Constants.PLAN_DETAIL_STATUS, Constants.PLAN_DETAIL_STATUS_CHECKED).getCode();
                planMainInfoManager.setDetailStatus(Long.valueOf(planDetailId), cancelCode, java.sql.Date.valueOf(DateTimeHelper.getCurrentDate()));
            }
            //参加监督人员
            //先删除子表
            String hql = "select j from JdRecordPerson j where j.recordId={0}";
            hql = FormatUtils.format(hql, target.getId());
            List<JdRecordPerson> jdRecordPersons = jdRecordPersonService.findByQuery(hql);
            for (JdRecordPerson jdRecordPerson : jdRecordPersons) {
                jdRecordPersonService.delete(jdRecordPerson);
            }

            if (StringUtils.isNotEmpty(attendPersonIds)) {
                String[] apIds = StringUtils.split(attendPersonIds, ",");
                for (String apId : apIds) {
                    JdRecordPerson jdRecordPerson = new JdRecordPerson();
                    jdRecordPerson.setJdPerson(sysPersonService.get(JspHelper.getLong(apId)));
                    jdRecordPerson.setJdTypeCode(target.getJdTaskCode());
                    jdRecordPerson.setRecordId(target.getId());
//                    jdRecordPerson.setJdPersonDesc();
                    jdRecordPersonService.save(jdRecordPerson);
                }
            }

            //先删除子表：安全质量监督--竣工验收--单位工程
            Set<JdRecordCompleteDwgc> jdRecordCompleteDwgcs = target.getJdRecordCompleteDwgcs();
            for (JdRecordCompleteDwgc jdRecordCompleteDwgc : jdRecordCompleteDwgcs) {
                jdRecordCompleteDwgcService.delete(jdRecordCompleteDwgc);
            }

            if (StringUtils.isNotEmpty(excelJdDwgcIds)) {
                String[] codes = StringUtils.split(excelJdDwgcIds, ",");
                String[] names = StringUtils.split(excelJdDwgcNames, ",");

                for (int i = 0; i < names.length; i++) {
                    String name = names[i];
                    name = StringUtils.left(name, name.length() - codes[i].length() - 2);

                    JdRecordCompleteDwgc jdRecordCompleteDwgc = new JdRecordCompleteDwgc();
                    jdRecordCompleteDwgc.setDwgcCode(codes[i]);
                    jdRecordCompleteDwgc.setDwgcName(name);
                    jdRecordCompleteDwgc.setRecordComplete(target);
                    jdRecordCompleteDwgcService.save(jdRecordCompleteDwgc);
                }

            }

            //先删除子表：安全质量监督--竣工验收--验收结果
            Set<JdRecordCompleteResult> jdRecordCompleteResults = target.getJdRecordCompleteResults();
            for (JdRecordCompleteResult jdRecordCompleteResult : jdRecordCompleteResults) {
                jdRecordCompleteResultService.delete(jdRecordCompleteResult);
            }

            List<SysCodeDetail> codeListByCode = sysCodeManager.getCodeListByCode(Constants.JD_RECORD_COMPLETE_CONDITION_TYPE);

            for (SysCodeDetail sysCodeDetail : codeListByCode) {

                hql = "from JdRecordCompCheckitem where type.id={0} order by id desc,orderNo asc";
                hql = FormatUtils.format(hql, sysCodeDetail.getId());
                List<JdRecordCompCheckitem> jdRecordCompCheckitems = jdRecordCompCheckitemService.findByQuery(hql);
                for (JdRecordCompCheckitem jdRecordCompCheckitem : jdRecordCompCheckitems) {

                    String checkItem = request.getParameter("checkItem_" + jdRecordCompCheckitem.getId());
                    JdRecordCompleteResult jdRecordCompleteResult = new JdRecordCompleteResult();
                    jdRecordCompleteResult.setRecordComplete(target);
                    jdRecordCompleteResult.setCheckitem(jdRecordCompCheckitem);
                    jdRecordCompleteResult.setCheckResult(checkItem);
                    jdRecordCompleteResultService.save(jdRecordCompleteResult);
                }
            }

            // 删除
            List<JdRecordQuestion> jdRecordQItemBehavior = jdRecordManager.getJdRecordQuestions(JdRecordType.TYPE_COMPLETE.getCode(), Constants.JD_RECORD_COMPLETE_CHECK_OTHER, target.getId());
            for (JdRecordQuestion jdRecordQuestion : jdRecordQItemBehavior) {
                jdRecordQuestionService.delete(jdRecordQuestion);
            }

            // 序号  行为抽查
            String[] orderNoBehavior = request.getParameterValues("orderNo" + Constants.JD_RECORD_COMPLETE_CHECK_OTHER);
            // 问题 行为抽查
            String[] questionDescBehavior = request.getParameterValues("questionDesc" + Constants.JD_RECORD_COMPLETE_CHECK_OTHER);
            String[] questionIdsBehavior = request.getParameterValues("questionDescId" + Constants.JD_RECORD_COMPLETE_CHECK_OTHER);
            // 违反条约 行为抽查
            String[] unlawDescBehavior = request.getParameterValues("unlawDesc" + Constants.JD_RECORD_COMPLETE_CHECK_OTHER);
            String[] unlawDescIdsBehavior = request.getParameterValues("unlawDescId" + Constants.JD_RECORD_COMPLETE_CHECK_OTHER);
            // 监督员 行为抽查
            String[] jdPersonDescBehavior = request.getParameterValues("jdRecordQuestionPersonNames" + Constants.JD_RECORD_COMPLETE_CHECK_OTHER);
            String[] jdPersonIDBehavior = request.getParameterValues("jdRecordQuestionPersonIds" + Constants.JD_RECORD_COMPLETE_CHECK_OTHER);

            if (null != questionDescBehavior && questionDescBehavior.length != 0) {
                for (int id = 0; id < questionDescBehavior.length; id++) {
                    JdRecordQuestion jdRecordQuestion = new JdRecordQuestion();
                    if (StringUtils.isNotEmpty(orderNoBehavior[id])) {
                        // 序号
                        jdRecordQuestion.setOrderNo(id + 1);

                        // 问题
                        jdRecordQuestion.setQuestionDesc(questionDescBehavior[id]);
                        if (null != questionIdsBehavior[id] && "" != questionIdsBehavior[id] && isNum(questionIdsBehavior[id])) {
                            jdRecordQuestion.setQuestionId(Long.valueOf(questionIdsBehavior[id]));
                        }
                        // 违反条约
                        jdRecordQuestion.setUnlawDesc(unlawDescBehavior[id]);
                        if (null != unlawDescIdsBehavior[id] && "" != unlawDescIdsBehavior[id] && isNum(unlawDescIdsBehavior[id])) {
                            jdRecordQuestion.setUnlawId(Long.valueOf(unlawDescIdsBehavior[id]));
                        }
                        // 监督员
                        jdRecordQuestion.setJdPersonDesc(jdPersonDescBehavior[id]);
                        if (null != jdPersonIDBehavior[id] && "" != jdPersonIDBehavior[id] && isNum(jdPersonIDBehavior[id])) {
                            jdRecordQuestion.setJdPersonId(Long.valueOf(jdPersonIDBehavior[id]));
                        }

                        jdRecordQuestion.setRecordId(target.getId());
                        jdRecordQuestion.setJdTypeCode(JdRecordType.TYPE_COMPLETE.getCode());
                        jdRecordQuestion.setTypeCode(Constants.JD_RECORD_COMPLETE_CHECK_OTHER);

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
     * 判断是否为数字
     *
     * @return .
     */
    public static boolean isNum(String str) {
        return str.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
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

        JdRecordComplete jdRecordComplete = jdRecordCompleteService.get(id);

        //先删除子表：安全质量监督--竣工验收--单位工程
        Set<JdRecordCompleteDwgc> jdRecordCompleteDwgcs = jdRecordComplete.getJdRecordCompleteDwgcs();
        for (JdRecordCompleteDwgc jdRecordCompleteDwgc : jdRecordCompleteDwgcs) {
            jdRecordCompleteDwgcService.delete(jdRecordCompleteDwgc);
        }

        //先删除子表：安全质量监督--竣工验收--验收结果
        Set<JdRecordCompleteResult> jdRecordCompleteResults = jdRecordComplete.getJdRecordCompleteResults();
        for (JdRecordCompleteResult jdRecordCompleteResult : jdRecordCompleteResults) {
            jdRecordCompleteResultService.delete(jdRecordCompleteResult);
        }

        jdRecordCompleteService.delete(id);
        sendSuccessJSON(response, "删除成功");
    }

}