package com.justonetech.biz.controller.workflow;

import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.FormatUtils;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.*;
import com.justonetech.biz.domain.*;
import com.justonetech.biz.domain.bean.column.ColumnParam;
import com.justonetech.biz.manager.DocumentManager;
import com.justonetech.biz.manager.OaTaskManager;
import com.justonetech.biz.manager.workflow.*;
import com.justonetech.biz.utils.BizDataGenerator;
import com.justonetech.biz.utils.Constants;
import com.justonetech.biz.utils.JaxbUtil;
import com.justonetech.biz.utils.jbpm.node.TaskNodeDefinition;
import com.justonetech.biz.utils.jbpm.service.JbpmService;
import com.justonetech.biz.utils.operationMsg.OperationMsgManager;
import com.justonetech.biz.utils.process.page.BizHtml;
import com.justonetech.biz.utils.process.page.BizHtmlToXml;
import com.justonetech.system.daoservice.SysUserService;
import com.justonetech.system.domain.SysUser;
import com.justonetech.system.manager.SysUserManager;
import com.justonetech.system.utils.FileUtils;
import com.justonetech.system.utils.PrivilegeCode;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.jbpm.taskmgmt.exe.TaskInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.JAXBException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.*;


/**
 * note:业务流程实例表
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class BpmProcessInstanceController extends BaseCRUDActionController<BpmProcessInstance> {
    private Logger logger = LoggerFactory.getLogger(BpmProcessInstanceController.class);

    @Autowired
    private BpmProcessInstanceService bpmProcessInstanceService;

    @Autowired
    private JbpmService jbpmService;

    @Autowired
    private BpmFormTemplateService bpmFormTemplateService;

    @Autowired
    private BpmTaskInstanceService bpmTaskInstanceService;

    @Autowired
    private BpmProcessInstanceManager bpmProcessInstanceManager;

    @Autowired
    private BpmFormDataService bpmFormDataService;

    @Autowired
    private BpmStandardActionService bpmStandardActionService;

    @Autowired
    private BpmFormTemplateManager bpmFormTemplateManager;

    @Autowired
    private BpmProcessDefinitionManager bpmProcessDefinitionManager;

    @Autowired
    private BpmSwimlaneManager bpmSwimlaneManager;

    @Autowired
    private BpmGetDefaultValueManager bpmGetDefaultValueManager;

    @Autowired
    private BpmProcessTransitionService bpmProcessTransitionService;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private BpmProcessSendMsgManager bpmProcessSendMsgManager;

    @Autowired
    private DocumentManager documentManager;

    @Autowired
    private BpmTaskInstanceManager bpmTaskInstanceManager;

    @Autowired
    OaTaskManager oaTaskManager;

    @Autowired
    private BpmNodeDefinitionService bpmNodeDefinitionService;

    /**
     * tab显示页面
     *
     * @param model                 .
     * @param categoryCode          .
     * @param processDefinitionCode .
     * @return .
     * @throws Exception .
     */
    @RequestMapping
    public String init(Model model, String categoryCode, String processDefinitionCode) throws Exception {
        SysUser sysUser = sysUserManager.getSysUser();
        Long userId = sysUser.getId();

        model.addAttribute("categoryCode", JspHelper.getString(categoryCode));
        model.addAttribute("processDefinitionCode", JspHelper.getString(processDefinitionCode));
        BpmProcessDefinition definition = bpmProcessDefinitionManager.getBpmProcessDefinition(processDefinitionCode);

        boolean isViewSwimlaneActor = false;
        boolean isViewByCcUser = false;
        if (definition != null) {
            isViewSwimlaneActor = bpmSwimlaneManager.isViewSwimlaneActor(definition, String.valueOf(userId));
            isViewByCcUser = bpmSwimlaneManager.isViewByCcUser(definition, String.valueOf(userId));
        }

        model.addAttribute("isDisplayViewList", isViewSwimlaneActor || isViewByCcUser);

        return "view/workflow/bpmProcessInstance/init";
    }

    /**
     * 列表显示页面
     *
     * @param categoryCode          流程分类编码（系统代码表）
     * @param processDefinitionCode 指定流程编号
     * @param type                  查看类型tab
     * @param model                 .
     * @return .
     * @throws Exception .
     */
    @RequestMapping
    public String grid(String type, String categoryCode, String processDefinitionCode, Model model) throws Exception {
        //流程选择下拉框
        List<BpmProcessDefinition> bpmProcessDefinitions = bpmProcessDefinitionManager.getBpmProcessDefinitionListByCode(categoryCode, false);
        model.addAttribute("bpmProcessDefinitions", bpmProcessDefinitions);
        if (bpmProcessDefinitions.size() > 0 && StringHelper.isEmpty(processDefinitionCode)) {
            BpmProcessDefinition defaultDefinition = bpmProcessDefinitions.iterator().next();
            processDefinitionCode = defaultDefinition.getCode();
        }
        BpmProcessDefinition bpmProcessDefinition = bpmProcessDefinitionManager.getBpmProcessDefinition(processDefinitionCode);
        model.addAttribute("processDefinition", bpmProcessDefinition);
        model.addAttribute("type", type);
        model.addAttribute("categoryCode", JspHelper.getString(categoryCode));
        model.addAttribute("processDefinitionCode", JspHelper.getString(processDefinitionCode));

        SysUser sysUser = sysUserManager.getSysUser();

        //自定义列显示
        List<ColumnParam> columnGridList = null;
        boolean canEdit = false;

        if (bpmProcessDefinition != null) {
            columnGridList = bpmFormTemplateManager.getColumnGridList(bpmProcessDefinition.getColumnXml());

            //判断用户有没有启动流程的权限
            if (sysUser.getRegPerson() != null) {
                canEdit = true;
            } else {
                String[] startProcessInstanceActorIds = bpmProcessInstanceManager.getStartProcessInstanceActorIds(bpmProcessDefinition);
                if (startProcessInstanceActorIds != null) {
                    for (String startProcessInstanceActorId : startProcessInstanceActorIds) {
                        if (String.valueOf(sysUser.getId()).equals(startProcessInstanceActorId)) {
                            canEdit = true;
                        }
                    }
                }
            }
        } else {
            columnGridList = bpmFormTemplateManager.getColumnGridList();
        }
        model.addAttribute("canEdit", canEdit);
        model.addAttribute("columnGridList", columnGridList);

        return "view/workflow/bpmProcessInstance/grid";
    }

    /**
     * 获取列表数据
     *
     * @param response              .
     * @param filters               .
     * @param columns               .
     * @param page                  .
     * @param rows                  .
     * @param processDefinitionCode .
     * @param type                  .
     */
    @RequestMapping
    public void gridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows, String type, String processDefinitionCode, HttpSession session) {
        try {
            SysUser sysUser = sysUserManager.getSysUser();
            Long userId = sysUser.getId();

            Page pageModel = new Page(page, rows, true);
            String orderBy = " order by p.reportDate desc,p.id desc";

            BpmProcessDefinition definition = bpmProcessDefinitionManager.getBpmProcessDefinition(processDefinitionCode);
            if (StringHelper.isEmpty(type)) type = "waitAudit";
            if (type.equals("waitAudit")) {//待审
                List<BpmProcessInstance> list = bpmProcessInstanceManager.getWaitAuditList(processDefinitionCode, userId);

                String hql = "from BpmProcessInstance p where 1=1";
                if (!"all".equals(processDefinitionCode)) {
                    hql += " and p.processDefinition.code = '" + processDefinitionCode + "'";
                }
                QueryTranslateJq queryTranslate = new QueryTranslateJq(hql + orderBy, filters);
                String query = queryTranslate.toString();
                session.setAttribute(Constants.GRID_SQL_KEY, query);

                List<BpmProcessInstance> instances = bpmProcessInstanceService.findByQuery(query);
                list.retainAll(instances);

                pageModel = new Page<BpmProcessInstance>(page, rows, list);
                session.setAttribute(Constants.GRID_SQL_KEY, queryTranslate.toString());
            } else if (type.equals("hasAudit")) {//已审
                //已审列表表示所有该用户参与过的流程
                String hql = bpmProcessInstanceManager.getHasAuditHql(processDefinitionCode, userId, orderBy);
//                logger.debug("...................hql =" + hql);
                pageModel = bpmProcessInstanceService.findByPage(pageModel, hql);
                session.setAttribute(Constants.GRID_SQL_KEY, hql);

            } else if (type.equals("other")) {//查看
                //如果是查看，只要用户属于该流程的查看泳道，则可以查看所有的流程实例，否则不能查看
                boolean isViewSwimlaneActor = false;
                boolean isViewByCcUser = false;
                if (definition != null) {
                    isViewSwimlaneActor = bpmSwimlaneManager.isViewSwimlaneActor(definition, String.valueOf(userId));
                    isViewByCcUser = bpmSwimlaneManager.isViewByCcUser(definition, String.valueOf(userId));
                }
                String hql = "from BpmProcessInstance p where 1=1 ";
                if (!"all".equals(processDefinitionCode)) {
                    hql += " and p.processDefinition.code = '" + processDefinitionCode + "'";
                }
                hql += " and (1=1 ";
                //如果既是泳道查看者，又是被抄送者，则显示2者都能看到的流程实例（取并集）
                if (isViewSwimlaneActor && isViewByCcUser) {
                    hql += " or instr(','||p.ccUserIds||',','," + userId + ",')>0)";
                }
                //如果是被抄送者，但不是泳道查看者，则显示流程定义对应的流程实例（取交集）
                else if (isViewByCcUser && !isViewSwimlaneActor) {
                    hql += " and instr(','||p.ccUserIds||',','," + userId + ",')>0)";
                }
                //如果是泳道查看者，但不是被抄送者，则只有泳道查看者才能查看所有的流程实例
                else if (isViewSwimlaneActor && !isViewByCcUser) {
                    hql += ")";
                }
                //既不是被抄送者，也不是泳道查看者，则不能查看流程实例
                else {
                    hql += " and 1=2)";
                }
                hql += orderBy;
//                logger.debug("...................hql =" + hql);
                pageModel = bpmProcessInstanceService.findByPage(pageModel, hql);
                session.setAttribute(Constants.GRID_SQL_KEY, hql);

            }
            List<BpmProcessInstance> rowList = pageModel.getRows();
            List<Map<String, Object>> retList = new ArrayList<Map<String, Object>>();
            Map<String, Object> map;
            for (BpmProcessInstance data : rowList) {
                map = new HashMap<String, Object>();
                map.put("id", data.getId());
                map.put("code", data.getCode());
                map.put("title", data.getTitle());
                map.put("status", data.getStatus());
                map.put("content", data.getContent());
                map.put("reportDate", data.getReportDate());
                map.put("deptName", data.getDeptName());
                map.put("personName", data.getPersonName());
                map.put("bizData1", data.getBizData1());
                map.put("bizData2", data.getBizData2());
                map.put("bizData3", data.getBizData3());
                map.put("bizData4", data.getBizData4());
                map.put("bizData5", data.getBizData5());

                //状态列
                map.put("statusName", bpmProcessInstanceManager.getStatusName(data));

                //增加附件图标
                String attachImg = "";
                List<DocDocumentAttach> documentAttaches = bpmProcessInstanceManager.getFileDocumentAttachs(data);
                if (documentAttaches.size() > 0) {
                    attachImg += " <input type='button' title='查看附件' class='button_normal' value='附件' onClick='viewAttach(\"" + data.getId() + "\")'>";
                }
                map.put("attachImg", attachImg);

                //操作列显示--审核图标
                String auditImg = bpmProcessInstanceManager.getAuditImg(data, userId);
                if (sysUserManager.hasPrivilege(PrivilegeCode.BPM_PROCESS_INSTANCE_FORCE_DELETE) || bpmProcessInstanceManager.hasDeletePrivilege(data, sysUser)) {
                    auditImg += " <input type='button' title='删除记录' class='button_normal' value='删除' onClick='doDelete(\"" + data.getId() + "\")'>";
                }
                //短信内容--已审列表并且审核结束的实例允许发送短信
                if (type.equals("hasAudit") && Constants.BPM_STATUS_END.equals(data.getStatus())) {
                    auditImg += " <input type='button' title='发送短信' class='button_normal' value='短信' onClick='sendMsg(\"" + data.getId() + "\")'>";
                }

                //查看按钮
                auditImg += " <input type='button' title='查看' class='button_normal' value='查看' onClick='doView(\"" + data.getId() + "\")'>";
                map.put("auditImg", auditImg);

                retList.add(map);
            }

            //输出显示
            String json = GridJq.toJSON(retList, pageModel);
            map = null;

            sendJSON(response, json);

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
        }
    }

    /**
     * 获取短信发送内容
     *
     * @param bpmProcessInstanceId .
     * @param model                .
     * @return .
     * @throws Exception .
     */
    @RequestMapping
    private String getJsonMsg(Long bpmProcessInstanceId, Model model) throws Exception {
        String msg = "";
        String hql = "from BpmTaskInstance t where t.processInstance.id=" + bpmProcessInstanceId + " order by endTime desc,startTime desc";
        List<BpmTaskInstance> bpmTaskInstances = bpmTaskInstanceService.findByQuery(hql);
        if (bpmTaskInstances.size() > 0) {
            BpmTaskInstance taskInstance = bpmTaskInstances.iterator().next();
            Map<String, Object> map = bpmProcessSendMsgManager.getMsgContent(taskInstance, sysUserManager.getSysUser());
//            map.put("senderUser", "");  //必须去掉user对象，否则会死循环
//            msg = JSONArray.fromObject(map).toString();
            msg = JSONObject.fromObject(map).toString();
        }
        model.addAttribute("msg", msg);
        return "common/msg";
    }

    /**
     * 启动流程实例
     *
     * @param response              .
     * @param processDefinitionCode .
     * @param model                 .
     * @return .
     * @throws Exception .
     */
    @RequestMapping
    public String start(HttpServletResponse response, String processDefinitionCode, Model model) throws Exception {
        BpmProcessDefinition definition = bpmProcessDefinitionManager.getBpmProcessDefinition(processDefinitionCode);
        SysUser sysUser = sysUserManager.getSysUser();
        String jumpUrl = "{'success':{0},'msg':'{1}','id':'{2}'}";
        if (definition != null) {
            try {
                BpmProcessInstance bpmProcessInstance = bpmProcessInstanceManager.startBpmProcessInstance(definition, sysUser);
                BpmTaskInstance bpmTaskInstance = bpmTaskInstanceManager.getBpmTaskInstance(bpmProcessInstance, String.valueOf(sysUser.getId()));
                if (sysUser.getRegPerson() != null) {
                    List<BpmTaskInstance> list = bpmTaskInstanceService.findByQuery("from BpmTaskInstance where processInstance.id=" + bpmProcessInstance.getId());
                    if (list.size() > 0) {
                        bpmTaskInstance = list.iterator().next();
                    }
                }

                if (bpmTaskInstance != null) {
                    jumpUrl = FormatUtils.format(jumpUrl, "true", "创建成功，现转向编辑页面...", "" + bpmTaskInstance.getId());
                } else {
                    jumpUrl = FormatUtils.format(jumpUrl, "false", "创建失败，流程定义配置有误", "");
                }

            } catch (Exception e) {
                log.error("error", e);
                jumpUrl = FormatUtils.format(jumpUrl, "false", "创建失败", "");
            }
        } else {
            jumpUrl = FormatUtils.format(jumpUrl, "false", "创建失败，未找到有效流程", "");
        }
        model.addAttribute("msg", jumpUrl);
        return "common/msg";
    }

    /**
     * 编辑审核页面框架
     *
     * @param model             .
     * @param bpmTaskInstanceId .
     * @return .
     */
    @RequestMapping
    public String flow(Model model, Long bpmTaskInstanceId) {
        BpmTaskInstance bpmTaskInstance = bpmTaskInstanceService.get(bpmTaskInstanceId);
        BpmProcessInstance bpmProcessInstance = bpmTaskInstance.getProcessInstance();
        model.addAttribute("bpmProcessInstance", bpmProcessInstance);
        model.addAttribute("bpmTaskInstanceId", bpmTaskInstanceId);

        return "view/workflow/bpmProcessInstance/flow";
    }

    /**
     * 修改显示页面
     *
     * @param model             .
     * @param bpmTaskInstanceId .
     * @param formDataId        .
     * @return .
     * @throws javax.xml.bind.JAXBException .
     */
    @RequestMapping
    public String modify(Model model, Long bpmTaskInstanceId, String formDataId, String type, String categoryCode, String from, String act) throws Exception {
        model.addAttribute("type", StringHelper.isEmpty(type) ? "waitAudit" : type);
        model.addAttribute("categoryCode", JspHelper.getString(categoryCode));
        model.addAttribute("from", JspHelper.getString(from));
        model.addAttribute("act", JspHelper.getString(act));

        SysUser sysUser = sysUserManager.getSysUser();

        String privilege = "";
        String xmlData = "";
        //获取xmlData,权限privilege
        BpmTaskInstance bpmTaskInstance = bpmTaskInstanceService.get(bpmTaskInstanceId);

        BpmProcessInstance bpmProcessInstance = bpmTaskInstance.getProcessInstance();
        BpmProcessDefinition bpmProcessDefinition = bpmProcessInstance.getProcessDefinition();

        // 根据bpmTaskInstance取对应模板
        BpmFormTemplate bpmFormTemplate = bpmTaskInstanceManager.getBpmFormTemplate(bpmTaskInstance);

        //todo 判断是否第1步，如果第1步不允许采用标准操作方式，必须设置为表单模板方式
        BpmNodeDefinition nodeDefinition = bpmTaskInstance.getTaskDefinition();
        boolean firstTaskNode = bpmProcessInstanceManager.isFirstTaskNode(nodeDefinition);
        if (firstTaskNode && bpmFormTemplate == null) {
//            return OperationMsgManager.errorMsg(model, "grid.html?type=waitAudit&processDefinitionId=" + bpmProcessDefinition.getId(), "未找到表单模板！请检查是否设置模板或者第1步操作不允许设置为标准操作！");
        }

        String initScript = "";
        if (null != bpmTaskInstance.getTaskDefinition().getNodeDefinition()) {
            TaskNodeDefinition taskNodeDefinition = JaxbUtil.unmarshall(TaskNodeDefinition.class, bpmTaskInstance.getTaskDefinition().getNodeDefinition());
            String[] privileges = taskNodeDefinition.getPrivileges();
            if (null != privileges) {
                privilege = StringHelper.stringArrayToString(privileges, ",");
                privilege = privilege.substring(0, privilege.length() - 1);
            }
            //获取表单操作类型
            String operateType = taskNodeDefinition.getOperateType();
            initScript = taskNodeDefinition.getInitScript();
            model.addAttribute("operateType", operateType);
        }


        //取表单数据，如果当前步骤保存过数据,先从从表单操作表中读数据,否则从bpm_form_data中获取.
        BpmFormAction bpmFormAction = bpmTaskInstance.getBpmFormAction();
        if (null != bpmFormAction && null != bpmFormAction.getFormXml()) {
            xmlData = bpmFormAction.getFormXml();
        } else {
            BpmFormData bpmFormData = bpmProcessInstanceManager.getBpmFormData(bpmProcessInstance, bpmFormTemplate);
            if (null != bpmFormData && null != bpmFormData.getFormXml()) {
                xmlData = bpmFormData.getFormXml();
            }
        }

        String defaultXml = "";
        String userName = sysUser.getDisplayName();
        Map defaultValueMap = bpmGetDefaultValueManager.getDefaultValueMap();
        if (StringHelper.isEmpty(xmlData)) {
            BizHtmlToXml bizHtmlToXml;
            if (!StringHelper.isEmpty(privilege)) {
                bizHtmlToXml = new BizHtmlToXml(bpmFormTemplate.getHtmlTemplate(), privilege, defaultValueMap);
            } else {
                bizHtmlToXml = new BizHtmlToXml(bpmFormTemplate.getHtmlTemplate(), defaultValueMap);
            }
            defaultXml = bizHtmlToXml.generateXml();
        }

        //根据脚本获取其他表单数据
        if (!StringHelper.isEmpty(initScript)) {
            String otherFormXmlData = bpmTaskInstanceManager.processInitScript(bpmTaskInstance, initScript);
            if (!StringHelper.isEmpty(xmlData)) {
                xmlData = BizDataGenerator.mergeXml(otherFormXmlData, xmlData);
            } else if (!StringHelper.isEmpty(defaultXml) && !StringHelper.isEmpty(defaultXml)) {
                xmlData = BizDataGenerator.mergeXml(defaultXml, otherFormXmlData);
            } else {
                xmlData = otherFormXmlData;
            }
        }


        //标准操作根据formDataId查看任何表单
        if (!StringHelper.isEmpty(formDataId)) {
            BpmFormData bpmFormData = bpmFormDataService.get(Long.valueOf(formDataId));
            bpmFormTemplate = bpmFormData.getFormTemplate();
            xmlData = bpmFormData.getFormXml();
        }
        //防止xmlData为空
        if (StringHelper.isEmpty(xmlData)) {
            xmlData = "<Root></Root>";
        }

        BizHtml bizHtml = new BizHtml(bpmFormTemplate.getHtmlTemplate(), privilege, xmlData, userName, defaultValueMap);
        String html = bizHtml.process();
        TaskInstance taskInstance = jbpmService.getTaskInstance(bpmTaskInstance.getJbpmTaskInstanceId());
        if (taskInstance.getPooledActors().size() > 0) {
            model.addAttribute("actorSize", taskInstance.getPooledActors().size());
        }
        model.addAttribute("bpmTaskInstanceId", bpmTaskInstance.getId());

        //处理其他业务逻辑
        List<DocDocumentAttach> documentAttaches = bpmProcessInstanceManager.getFileDocumentAttachs(bpmProcessInstance);
        model.addAttribute("attachsNum", "(" + documentAttaches.size() + ")");
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        model.addAttribute("bizHtml", html);
        model.addAttribute("userName", userName);
        model.addAttribute("currenttime", currentTime);
        model.addAttribute("bpmProcessInstanceId", bpmProcessInstance.getId());
        model.addAttribute("formDatas", bpmProcessInstance.getBpmFormDatas());
        model.addAttribute("bpmFormTemplateId", bpmFormTemplate.getId());

        model.addAttribute("bpmProcessDefinition", bpmProcessDefinition);

        //added by chenjp 20100809
        model.addAttribute("bpmProcessInstance", bpmProcessInstance);

        //附件
        String downloadLinks = "";
        //表单操作
        Set<BpmFormAction> bpmFormActionSet = bpmProcessInstance.getBpmFormActions();
        for (BpmFormAction formAction : bpmFormActionSet) {
            DocDocument document = formAction.getDocument();
            if (document != null) {
                downloadLinks += documentManager.getDownloadButton(document) + "<br>";
            }
        }
        Set<BpmStandardAction> bpmStandardActionSet = bpmProcessInstance.getBpmStandardActions();
        for (BpmStandardAction standardAction : bpmStandardActionSet) {
            DocDocument document = standardAction.getDocument();
            if (document != null) {
                downloadLinks += documentManager.getDownloadButton(document) + "<br>";
            }
        }
        model.addAttribute("downloadLinks", downloadLinks);

        return "view/workflow/bpmProcessInstance/input";
    }

    /**
     * 保存操作
     *
     * @param response          .
     * @param bpmTaskInstanceId .
     * @param xmlData           .
     * @param ccUserIds         .
     * @throws Exception .
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void saveForm(HttpServletResponse response, Long bpmTaskInstanceId, String xmlData, String ccUserIds) throws Exception {
        try {
            bpmProcessInstanceManager.saveFormData(xmlData, bpmTaskInstanceId, ccUserIds);

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
            return;
        }
        sendSuccessJSON(response, "保存成功");
    }

    /**
     * 锁定--当多人审核时需要锁定避免其他人同时操作
     * @param response .
     * @param bpmTaskInstanceId .
     * @param model .
     */
    @RequestMapping
    public void lock(HttpServletResponse response, Long bpmTaskInstanceId, Model model) {
        SysUser sysUser = sysUserManager.getSysUser();
        BpmTaskInstance bpmTaskInstance = bpmTaskInstanceService.get(bpmTaskInstanceId);
        TaskInstance taskInstance = jbpmService.getTaskInstance(bpmTaskInstance.getJbpmTaskInstanceId());
        bpmProcessInstanceManager.setLock(taskInstance, String.valueOf(sysUser.getId()));

        sendSuccessJSON(response, "锁定成功");
    }

    /**
     * 表单操作
     *
     * @param bpmTaskInstanceId .
     * @param model             .
     * @return .
     * @throws javax.xml.bind.JAXBException .
     */
    @RequestMapping
    public String formOperation(Long bpmTaskInstanceId, Model model) throws JAXBException {
        BpmTaskInstance bpmTaskInstance = bpmTaskInstanceService.get(bpmTaskInstanceId);
        String currentTaskName = bpmTaskInstance.getTaskDefinition().getName();

        BpmProcessInstance bpmProcessInstance = bpmTaskInstance.getProcessInstance();
        boolean isFirstAuditTaskNode = bpmProcessInstanceManager.isFirstAuditTaskNode(bpmProcessInstance);
        model.addAttribute("isFirstAuditTaskNode", isFirstAuditTaskNode);

        String ccUserIds = bpmProcessInstance.getCcUserIds();
        if (StringUtils.isNotBlank(ccUserIds)) {
            HashMap<String, Object> sysUserHM = new HashMap<String, Object>();
            String[] ids = ccUserIds.split(",");
            for (String id : ids) {
                try {
                    SysUser sysUser = sysUserService.get(Long.valueOf(id));
                    sysUserHM.put(id, sysUser.getDisplayName());
                } catch (NumberFormatException e) {
//                    e.printStackTrace();
                    //排除id 无效的情况
                }
            }
            model.addAttribute("sysUserHM", sysUserHM);
        }

        TaskNodeDefinition taskNodeDefinition = bpmTaskInstanceManager.getTaskNodeDefinition(bpmTaskInstance.getTaskDefinition());
        //设置是否需要任务转发
        TaskInstance taskInstance = jbpmService.getTaskInstance(bpmTaskInstance.getJbpmTaskInstanceId());
        if (StringHelper.isEmpty(taskInstance.getActorId()) || taskInstance.getPooledActors().size() <= 1) {
            model.addAttribute("disabled", "disabled");
        }
        boolean canForward = false;
        if (null != taskNodeDefinition) {
            double hours = bpmTaskInstanceManager.getHours(taskNodeDefinition, bpmTaskInstance);
            model.addAttribute("hours", hours);
            canForward = taskNodeDefinition.isCanForward();
        }
        //获取下层节点任务
        List<Map> taskNodes = new ArrayList<Map>();
        Set<BpmProcessTransition> processTransitionSet = bpmTaskInstance.getTaskDefinition().getBpmProcessTransitionsByfrom();
        for (BpmProcessTransition bpmProcessTransition : processTransitionSet) {
            Map<String, Object> taskNode = new HashMap<String, Object>();
            taskNode.put("transition", bpmProcessTransition);

            String transitionName = bpmProcessTransition.getName();
            if (transitionName.indexOf("_") > 0) {
                transitionName = transitionName.substring(0, transitionName.indexOf("_"));
            }
            taskNode.put("transitionName", transitionName);
            BpmNodeDefinition to = bpmProcessTransition.getTo();
            taskNode.put("toNode", to);
            boolean isSelectUser = bpmTaskInstanceManager.getIsSelectUser(to);
            taskNode.put("isSelectUser", isSelectUser);

            String userNames = "";
            String userIds = "";
            List<SysUser> users = bpmTaskInstanceManager.getTaskHistoryUsers(bpmProcessInstance, to);
            if (users != null) {
                for (SysUser user : users) {
                    if (user.getPerson() != null) {
                        if ("".equals(userNames)) {
                            userNames += user.getPerson().getName();
                            userIds += user.getPerson().getId();
                        } else {
                            userNames += "," + user.getPerson().getName();
                            userIds += "," + user.getPerson().getId();
                        }
                    }

                }
            }
            taskNode.put("userNames", userNames);
            taskNode.put("userIds", userIds);

            //todo hint显示下步操作人员
            //未加表达式过滤
//            bpmSwimlaneManager.getCandidates(to.getBpmTaskSwimlane().getSwimlaneDefinition(), new HashMap<String, String>());

            taskNodes.add(taskNode);
        }

        //将退回和结束操作放在最后
        for (int i = 0; i < taskNodes.size(); i++) {
            Map map = taskNodes.get(i);
            String transitionName = JspHelper.getString(map.get("transitionName"));
            if (transitionName.indexOf("退回") >= 0) {
                Map tmp = taskNodes.get(taskNodes.size() - 1);
                taskNodes.set(taskNodes.size() - 1, map);
                taskNodes.set(i, tmp);
            } else if (transitionName.indexOf("结束") >= 0) {
                Map tmp = taskNodes.get(taskNodes.size() - 1);
                taskNodes.set(taskNodes.size() - 1, map);
                taskNodes.set(i, tmp);
            }
        }

        model.addAttribute("bpmTaskInstanceId", bpmTaskInstanceId);
        model.addAttribute("currentTaskName", currentTaskName);
        model.addAttribute("taskNodes", taskNodes);
        model.addAttribute("taskNodeListSize", processTransitionSet.size());
        model.addAttribute("canForward", canForward);
        model.addAttribute("processInstance", bpmProcessInstance);

        return "view/workflow/bpmProcessInstance/formOperation";
    }

    /**
     * 标准操作 (在日志查询中直接调用该页面,采用view标识 )
     *
     * @param bpmTaskInstanceId .
     * @param view              .
     * @param model             .
     * @return .
     * @throws JAXBException .
     */
    @RequestMapping
    public String standardOperation(Long bpmTaskInstanceId, String view, Model model) throws JAXBException {
        BpmTaskInstance bpmTaskInstance = bpmTaskInstanceService.get(bpmTaskInstanceId);
        BpmNodeDefinition nodeDefinition = bpmTaskInstance.getTaskDefinition();
        String currentTaskName = nodeDefinition.getName();

        TaskNodeDefinition taskNodeDefinition = bpmTaskInstanceManager.getTaskNodeDefinition(bpmTaskInstance.getTaskDefinition());
        if (null != taskNodeDefinition) {
            double hours = bpmTaskInstanceManager.getHours(taskNodeDefinition, bpmTaskInstance);
            model.addAttribute("hours", hours);
        }


        //批阅选择初始化
        Map<String, String> readValues = new HashMap<String, String>();
        readValues.put("false", "未阅");
        readValues.put("true", "已阅");

        Map<String, String> permitValues = new HashMap<String, String>();
        permitValues.put(Constants.FLAG_FALSE, "不同意");
        permitValues.put(Constants.FLAG_TRUE, "同意");
        BpmStandardAction bpmStandardAction = bpmTaskInstance.getBpmStandardAction();
        if (null == bpmStandardAction) {
            bpmStandardAction = new BpmStandardAction();
            bpmStandardAction.setIsRead(true);
            bpmStandardAction.setPermitValue("1");
        }

        model.addAttribute("bean", bpmStandardAction);
        model.addAttribute("permitValues", permitValues);
        model.addAttribute("readValues", readValues);
        //是否可见
        if (null != taskNodeDefinition) {
            model.addAttribute("isShowOpinion", taskNodeDefinition.isShowOpinion());
            model.addAttribute("isShowPermitted", taskNodeDefinition.isShowPermitted());
            model.addAttribute("isShowRead", taskNodeDefinition.isShowRead());
        }
        //获取下步节点
        List<Map> taskNodes = new ArrayList<Map>();
        Set<BpmProcessTransition> processTransitionSet = nodeDefinition.getBpmProcessTransitionsByfrom();
        for (BpmProcessTransition bpmProcessTransition : processTransitionSet) {
            Map<String, Object> taskNode = new HashMap<String, Object>();
            taskNode.put("transition", bpmProcessTransition);
            BpmNodeDefinition to = bpmProcessTransition.getTo();
            taskNode.put("toNode", to);
            boolean isSelectUser = bpmTaskInstanceManager.getIsSelectUser(to);
            taskNode.put("isSelectUser", isSelectUser);
            taskNodes.add(taskNode);
        }

        BpmProcessInstance bpmProcessInstance = bpmTaskInstance.getProcessInstance();
        String ccUserIds = bpmProcessInstance.getCcUserIds();
        if (StringUtils.isNotBlank(ccUserIds)) {
            HashMap<String, Object> sysUserHM = new HashMap<String, Object>();
            String[] ids = ccUserIds.split(",");
            for (String id : ids) {
                SysUser sysUser = sysUserService.get(Long.valueOf(id));
                sysUserHM.put(id, sysUser.getDisplayName());
            }
            model.addAttribute("sysUserHM", sysUserHM);
        }

        model.addAttribute("processInstance", bpmProcessInstance);
        model.addAttribute("bpmTaskInstanceId", bpmTaskInstanceId);
        model.addAttribute("taskNodes", taskNodes);
        model.addAttribute("currentTaskName", currentTaskName);
        model.addAttribute("view", view);

        return "view/workflow/bpmProcessInstance/standardOperation";
    }

    /**
     * 标准操作查看页面
     *
     * @param bpmTaskInstanceId .
     * @param view              .
     * @param model             .
     * @return .
     * @throws JAXBException .
     */
    @RequestMapping
    public String standardView(Long bpmTaskInstanceId, String view, Model model) throws JAXBException {
        BpmTaskInstance bpmTaskInstance = bpmTaskInstanceService.get(bpmTaskInstanceId);
        BpmNodeDefinition nodeDefinition = bpmTaskInstance.getTaskDefinition();
        String currentTaskName = nodeDefinition.getName();

        TaskNodeDefinition taskNodeDefinition = bpmTaskInstanceManager.getTaskNodeDefinition(bpmTaskInstance.getTaskDefinition());
        if (null != taskNodeDefinition) {
            double hours = bpmTaskInstanceManager.getHours(taskNodeDefinition, bpmTaskInstance);
            model.addAttribute("hours", hours);
        }


        //批阅选择初始化
        Map<String, String> readValues = new HashMap<String, String>();
        readValues.put("false", "未阅");
        readValues.put("true", "已阅");

        Map<String, String> permitValues = new HashMap<String, String>();
        permitValues.put("0", "不同意");
        permitValues.put("1", "同意");
        BpmStandardAction bpmStandardAction = bpmTaskInstance.getBpmStandardAction();
        if (null == bpmStandardAction) {
            bpmStandardAction = new BpmStandardAction();
            bpmStandardAction.setIsRead(true);
            bpmStandardAction.setPermitValue("1");
        }

        model.addAttribute("bean", bpmStandardAction);
        model.addAttribute("permitValues", permitValues);
        model.addAttribute("readValues", readValues);
        //是否可见
        if (null != taskNodeDefinition) {
            model.addAttribute("isShowOpinion", taskNodeDefinition.isShowOpinion());
            model.addAttribute("isShowPermitted", taskNodeDefinition.isShowPermitted());
            model.addAttribute("isShowRead", taskNodeDefinition.isShowRead());
        }
        //获取下步节点
        Set<BpmProcessTransition> processTransitionSet = nodeDefinition.getBpmProcessTransitionsByfrom();

        model.addAttribute("bpmTaskInstanceId", bpmTaskInstanceId);
        model.addAttribute("taskNodeList", processTransitionSet);
        model.addAttribute("currentTaskName", currentTaskName);
        model.addAttribute("view", view);

        return "view/workflow/bpmProcessInstance/standardView";
    }

    /**
     * 标准操作保存
     *
     * @param response               .
     * @param request                .
     * @param bpmStandardAction      .
     * @param bpmTaskInstanceId      .
     * @param bpmProcessTransitionId .
     * @param model                  .
     * @throws JAXBException .
     */
    @RequestMapping
    public void standardSave(HttpServletResponse response, HttpServletRequest request, BpmStandardAction bpmStandardAction, Long bpmTaskInstanceId, String bpmProcessTransitionId, Model model) throws Exception {
        SysUser sysUser = sysUserManager.getSysUser();
        BpmTaskInstance bpmTaskInstance = bpmTaskInstanceService.get(bpmTaskInstanceId);
        BpmStandardAction target;
        if (null != bpmStandardAction.getId()) {
            target = bpmStandardActionService.get(bpmStandardAction.getId());
            ReflectionUtils.copyBean(bpmStandardAction, target, new String[]{
                    "isRead", "opinion", "permitValue"
            });
        } else {
            target = bpmStandardAction;
        }
        BpmProcessTransition bpmProcessTransition = null;
        if (!StringHelper.isEmpty(bpmProcessTransitionId)) {
            bpmProcessTransition = bpmProcessTransitionService.get(Long.valueOf(bpmProcessTransitionId));
//            documentManager.updateDocumentByBizData(documentManager.getDocDocument(),null,null);

        }
        BpmProcessInstance processInstance = bpmTaskInstance.getProcessInstance();
        //建立双向关联
        bpmTaskInstance.setBpmStandardAction(target);
        target.setTaskInstance(bpmTaskInstance);
        target.setSubmitTime(new Timestamp(System.currentTimeMillis()));
        target.setSubmitUser(sysUser);
        target.setProcessInstance(processInstance);
        bpmStandardActionService.save(target);

        //设置下一步人员
        BpmNodeDefinition toNode = bpmProcessTransition.getTo();
        String userIds = request.getParameter("userIds_" + toNode.getName());
        if (!StringHelper.isEmpty(userIds)) {
            String[] actorIds = userIds.split(",");
            bpmTaskInstanceManager.setNextNodeActorIds(bpmTaskInstance, toNode.getName(), actorIds);
        }

        //结束任务实例
        bpmTaskInstanceManager.endTaskInstance(bpmTaskInstance, String.valueOf(sysUser.getId()), bpmProcessTransition);

//        return OperationMsgManager.successMsg(model, "grid.html?type=waitAudit&processDefinitionId=" + processInstance.getProcessDefinition().getId(), "操作成功");
        sendSuccessJSON(response, "操作成功");

    }

    /**
     * 取消独占
     *
     * @param response          .
     * @param bpmTaskInstanceId .
     * @param model             .
     * @throws JAXBException .
     */
    @RequestMapping
    public void cancelLock(HttpServletResponse response, Long bpmTaskInstanceId, Model model) throws JAXBException {
        BpmTaskInstance bpmInstance = bpmTaskInstanceService.get(bpmTaskInstanceId);
        TaskInstance taskInstance = jbpmService.getTaskInstance(bpmInstance.getJbpmTaskInstanceId());
        bpmProcessInstanceManager.cancelLock(taskInstance);
//        return OperationMsgManager.successMsg(model, "", "操作成功");
        sendSuccessJSON(response, "操作成功");
    }

    /**
     * 转发
     *
     * @param response          .
     * @param bpmTaskInstanceId .
     * @param actorId           .
     * @param model             .
     */
    @RequestMapping
    public void forward(HttpServletResponse response, Long bpmTaskInstanceId, String actorId, Model model) throws Exception {
        BpmTaskInstance bpmTaskInstance = bpmTaskInstanceService.get(bpmTaskInstanceId);
        bpmProcessInstanceManager.forwardTaskInstance(bpmTaskInstance.getJbpmTaskInstanceId(), actorId);
        bpmProcessInstanceManager.createForwardTask(bpmTaskInstance, new String[]{actorId});
        Long processDefinitionId = bpmTaskInstance.getProcessInstance().getProcessDefinition().getId();
//        return OperationMsgManager.successMsg(model, "grid.html?type=waitAudit&processDefinitionId=" + processDefinitionId, "操作成功");
        sendSuccessJSON(response, "转发成功");
    }

    /**
     * 提交审核
     *
     * @param response               .
     * @param request                .
     * @param xmlData                .
     * @param bpmTaskInstanceId      .
     * @param bpmProcessTransitionId .
     * @param model                  .
     * @return .
     * @throws JAXBException .
     */
    @RequestMapping
    public String submitCheck(HttpServletResponse response, HttpServletRequest request, String xmlData, Long bpmTaskInstanceId, String bpmProcessTransitionId, Model model) throws Exception {
        String categoryCode = JspHelper.getString(request.getParameter("categoryCode"));
        BpmTaskInstance bpmTaskInstance = bpmTaskInstanceService.get(bpmTaskInstanceId);
        SysUser sysUser = sysUserManager.getSysUser();
        String ccUserIds = request.getParameter("ccUserIds");
        bpmProcessInstanceManager.saveAndSubmit(xmlData, bpmTaskInstance, null, ccUserIds);

        BpmProcessTransition bpmProcessTransition = null;
        if (!StringHelper.isEmpty(bpmProcessTransitionId)) {
            bpmProcessTransition = bpmProcessTransitionService.get(Long.valueOf(bpmProcessTransitionId));
        }

        //设置下一步人员
        BpmNodeDefinition toNode = null;
        String toNodeName = request.getParameter("toNodeName");     //注意：这里的toNodeName为toNode.id
        //modify by chenjp 解决结束时无法清除流程任务的bug
        if (!StringHelper.isEmpty(toNodeName)) {
            toNode = bpmNodeDefinitionService.get(Long.valueOf(toNodeName));
            if(toNode.getName().startsWith("结束")){
                oaTaskManager.removeTask(BpmTaskInstance.class.getSimpleName(), bpmTaskInstanceId);
            }
        }
        String userIds = request.getParameter("userIds_" + toNodeName);
        if (!StringHelper.isEmpty(userIds) && toNode !=null) {
            String[] actorIds = userIds.split(",");
            //注意：这里的设置的toNodeName必须为toNode.name，否则在NodeEnterActionHandler中无法匹配取出下步人员
            bpmTaskInstanceManager.setNextNodeActorIds(bpmTaskInstance, toNode.getName(), actorIds);
        }

        logger.debug("start bpmTaskInstanceManager");
        bpmTaskInstanceManager.endTaskInstance(bpmTaskInstance, String.valueOf(sysUser.getId()), bpmProcessTransition);
        logger.debug("end bpmTaskInstanceManager");

        BpmProcessDefinition processDefinition = bpmTaskInstance.getProcessInstance().getProcessDefinition();

        if ("task".equals(request.getParameter("from"))) {
            return OperationMsgManager.successMsg(model, "oaTask/grid.do", "操作成功", "window.opener.refreshIframGrid('tab1',null);self.close()");
        } else {
            return OperationMsgManager.successMsg(model, "bpmProcessInstance/grid.do?type=waitAudit&processDefinitionCode=" + processDefinition.getCode() + "&categoryCode=" + categoryCode, "操作成功");
        }
    }

    /**
     * 打印操作
     *
     * @param response          .
     * @param formId            .
     * @param processInstanceId .
     * @param model             .
     * @return .
     * @throws Exception .
     */
    @RequestMapping
    public String print(Long processInstanceId, Long formId, HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
        String privilege = "0";
        String xmlData = "<Root></Root>";
        //模板和数据合并处理
        BizHtml bizHtml;
        BpmProcessInstance bpmProcessInstance = bpmProcessInstanceService.get(processInstanceId);
        BpmFormTemplate bpmFormTemplate = bpmFormTemplateService.get(formId);
        BpmFormData bpmFormData = bpmProcessInstanceManager.getBpmFormData(bpmProcessInstance, bpmFormTemplate);
        if (bpmFormData != null && null != bpmFormData.getFormXml()) {
            xmlData = bpmFormData.getFormXml();
            bizHtml = new BizHtml(bpmFormTemplate.getHtmlTemplate(), privilege, xmlData, "1");
        } else {
            bizHtml = new BizHtml(bpmFormTemplate.getHtmlTemplate(), privilege, xmlData, "1");
        }

        String fileName = bpmProcessInstance.getTitle() + "_" + bpmFormTemplate.getName();
        String html = bizHtml.process("print");
//        if(html.startsWith("<html>")){
//            html = html.replaceFirst("<html>","<html xmlns:o=\"urn:schemas-microsoft-com:office:office\"" +
//                    " xmlns:x=\"urn:schemas-microsoft-com:office:excel\"" +
//                    " xmlns=\"http://www.w3.org/TR/REC-html40\">");
//            System.out.println(".............html = " + html);
//        }
//        model.addAttribute("bizHtml", html);

        FileUtils.setDownloadContentType(request, response, fileName + ".xls", null, false);
//        response.reset();
        response.setContentType("Application/vnd.ms-excel");
        response.setCharacterEncoding("gb2312");
//        response.setHeader("Content-disposition", "attachment;filename=" + new String(fileName.getBytes(), "ISO8859-1") + ".xls");
        PrintWriter writer = response.getWriter();
        writer.print(html);
//        writer.close();
        response.flushBuffer();

        return null;
    }

    /**
     * 删除操作 供实施人员手动利用mapping删除流程实例
     *
     * @param response 。
     * @param id       。
     * @param model    。
     * @throws Exception 。
     */
    @RequestMapping
    public void delete(HttpServletResponse response, Long id, Model model) throws Exception {
        BpmProcessInstance bpmProcessInstance = bpmProcessInstanceService.get(id);

        bpmProcessInstanceManager.removeProcessInstance(bpmProcessInstance);
        sendSuccessJSON(response, "删除成功");
    }

    /**
     * 查看页面
     *
     * @param id    。
     * @param from  链接来源
     * @param model 。
     * @return .
     * @throws Exception .
     */
    @RequestMapping
    public String view(Long id, String from, Model model) throws Exception {
        BpmProcessInstance bpmProcessInstance = bpmProcessInstanceService.get(id);
        model.addAttribute("processInstanceId", bpmProcessInstance.getId());

        if (!StringHelper.isEmpty(from)) {
            model.addAttribute("from", from);
        } else {
            model.addAttribute("from", "");
        }
        model.addAttribute("ccUserNames", sysUserManager.getSysUserNames(StringHelper.stringToStringArray(bpmProcessInstance.getCcUserIds(), ",")));

        return "view/workflow/bpmProcessInstance/view";
    }

    /**
     * 查看页面--用于任务查看
     *
     * @param response          .
     * @param bpmTaskInstanceId .
     * @param model             .
     * @throws Exception .
     */
    @RequestMapping
    public void viewTask(HttpServletResponse response, Long bpmTaskInstanceId, Model model) throws Exception {
        BpmTaskInstance bpmTaskInstance = bpmTaskInstanceService.get(bpmTaskInstanceId);
        BpmProcessInstance bpmProcessInstance = bpmTaskInstance.getProcessInstance();
        String url = "../bpmProcessInstance/view.do?id={0}&from=task";
        response.sendRedirect(FormatUtils.format(url, String.valueOf(bpmProcessInstance.getId())));
    }

    /**
     * 表单查看
     *
     * @param processInstanceId .
     * @param pageNo            .
     * @param type              .
     * @param model             .
     * @return .
     * @throws Exception .
     */
    @RequestMapping
    public String viewForm(Long processInstanceId, String pageNo, String type, Model model) throws Exception {
        if (StringHelper.isEmpty(pageNo)) {
            pageNo = "1";
        }
        SysUser sysUser = sysUserManager.getSysUser();

        BpmFormTemplate formTemplate = null;
        int i = 0;
        BpmProcessInstance bpmProcessInstance = bpmProcessInstanceService.get(processInstanceId);
        BpmProcessDefinition processDefinition = bpmProcessInstance.getProcessDefinition();
        Set<BpmProcessDefinitionForm> bpmProcessDefinitionFormSet = processDefinition.getBpmProcessDefinitionForms();
        int size = bpmProcessDefinitionFormSet.size();
        int curNo = Integer.parseInt(pageNo);
        int prev = curNo - 1 > 0 ? curNo - 1 : 1;
        int next = curNo + 1 < size ? curNo + 1 : size;
        for (BpmProcessDefinitionForm definitionForm : bpmProcessDefinitionFormSet) {
            if (String.valueOf(i + 1).equals(pageNo)) {
                formTemplate = definitionForm.getFormTemplate();
                break;
            }
        }
        String html = "";
        if (formTemplate != null) {
            //模板和数据合并处理
            String privilege = "0";
            String xmlData = "<Root></Root>";
            BpmFormData bpmFormData = bpmProcessInstanceManager.getBpmFormData(bpmProcessInstance, formTemplate);
            if (bpmFormData != null && null != bpmFormData.getFormXml()) {
                xmlData = bpmFormData.getFormXml();
                BizHtml bizHtml = new BizHtml(bpmFormData.getFormTemplate().getHtmlTemplate(), privilege, xmlData, "1");
                html = bizHtml.process();
            } else {
                BizHtml bizHtml = new BizHtml(formTemplate.getHtmlTemplate(), privilege, xmlData, "1");
                html = bizHtml.process();
            }
            model.addAttribute("formId", formTemplate.getId());
        }
        model.addAttribute("bizHtml", html);
        model.addAttribute("count", size);
        model.addAttribute("pageNo", pageNo);
        model.addAttribute("prev", prev);
        model.addAttribute("next", next);

        boolean hasPrivilege = bpmProcessInstanceManager.hasDeletePrivilege(bpmProcessInstance, sysUser);
        model.addAttribute("canDelete", hasPrivilege);
        model.addAttribute("processInstanceId", processInstanceId);
        model.addAttribute("type", type == null ? "hasAudit" : type);

        //提供给fr打印
        model.addAttribute("definitionCode", processDefinition.getCode());
        if (formTemplate != null) {
            model.addAttribute("formCode", formTemplate.getCode());
            model.addAttribute("formId", formTemplate.getId());
        }

        //附件
        String downloadLinks = "";
        //表单操作
        Set<BpmFormAction> bpmFormActionSet = bpmProcessInstance.getBpmFormActions();
        for (BpmFormAction formAction : bpmFormActionSet) {
            DocDocument document = formAction.getDocument();
            if (document != null) {
                downloadLinks += documentManager.getDownloadButton(document);
            }
        }
        Set<BpmStandardAction> bpmStandardActionSet = bpmProcessInstance.getBpmStandardActions();
        for (BpmStandardAction standardAction : bpmStandardActionSet) {
            DocDocument document = standardAction.getDocument();
            if (document != null) {
                downloadLinks += documentManager.getDownloadButton(document);
            }
        }
        model.addAttribute("downloadLinks", downloadLinks);

        return "view/workflow/bpmProcessInstance/viewForm";
    }


    /**
     * 查看流转示意图
     *
     * @param id    .
     * @param model .
     * @return .
     * @throws Exception .
     */
    @RequestMapping
    public String viewFlowPic(Long id, Model model) throws Exception {
        BpmProcessInstance bpmProcessInstance = bpmProcessInstanceService.get(id);

        //当前任务节点的页面形状ID
        Long taskShapeId = null;
        BpmNodeDefinition bpmNodeDefinition = bpmTaskInstanceManager.getCurrentBpmNodeDefinition(bpmProcessInstance);
        if (bpmNodeDefinition != null) {
            taskShapeId = bpmNodeDefinition.getShapeId();
        }
        model.addAttribute("taskShapeId", taskShapeId);

        //获取当前任务节点所处泳道的页面形状ID
        Long visioSwimlaneId = bpmProcessDefinitionManager.getVisioSwimlaneId(bpmNodeDefinition);
        model.addAttribute("swimlaneShapeId", visioSwimlaneId);

        //流程定义
        BpmProcessDefinition bpmProcessDefinition = bpmProcessInstance.getProcessDefinition();
        model.addAttribute("bean", bpmProcessDefinition.getProcessTemplate());

        //获取页面数据
        String vmlHtml = bpmProcessDefinitionManager.getVmlHtml(bpmProcessDefinition.getProcessTemplate().getId());
        model.addAttribute("vmlHtml", vmlHtml);

        return "view/workflow/bpmProcessInstance/viewFlowPic";
    }
}