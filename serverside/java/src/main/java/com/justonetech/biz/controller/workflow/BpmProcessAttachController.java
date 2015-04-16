package com.justonetech.biz.controller.workflow;

import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.security.user.BaseUser;
import com.justonetech.core.security.util.SpringSecurityUtils;
import com.justonetech.core.utils.FormatUtils;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.biz.daoservice.*;
import com.justonetech.biz.domain.*;
import com.justonetech.biz.manager.DocumentManager;
import com.justonetech.biz.manager.workflow.BpmTaskInstanceManager;
import com.justonetech.biz.utils.jbpm.node.TaskNodeDefinition;
import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.collections.ComparatorUtils;
import org.apache.commons.collections.comparators.ComparatorChain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;
import java.util.*;

/**
 * 文档上传通用
 *
 * @author tcg
 */
@Controller
@SessionAttributes
public class BpmProcessAttachController extends BaseCRUDActionController<BpmProcessInstance> {
    private Logger logger = LoggerFactory.getLogger(BpmProcessAttachController.class);

    @Autowired
    private DocDocumentService docDocumentService;

    @Autowired
    private DocumentManager documentManager;

    @Autowired
    private BpmTaskInstanceService bpmTaskInstanceService;

    @Autowired
    private BpmTaskInstanceManager bpmTaskInstanceManager;

    @Autowired
    private BpmFormActionService bpmFormActionService;

    @Autowired
    private BpmStandardActionService bpmStandardActionService;

    @Autowired
    private BpmProcessInstanceService bpmProcessInstanceService;

    /**
     * 附件挂接页面
     *
     * @param bpmTaskInstanceId .
     * @param act               如=view则无法上传附件(用户任务管理查看)
     * @param model             。
     * @return .
     * @throws Exception .
     */
    @RequestMapping
    public String formAttach(Long bpmTaskInstanceId, String act, Model model) throws Exception {
        model.addAttribute("act", JspHelper.getString(act));

        BaseUser loginUser = SpringSecurityUtils.getCurrentUser();

        BpmTaskInstance bpmTaskInstance = bpmTaskInstanceService.get(bpmTaskInstanceId);
        BpmProcessInstance bpmProcessInstance = bpmTaskInstance.getProcessInstance();
        BpmProcessDefinition processDefinition = bpmProcessInstance.getProcessDefinition();

        //当前附件所在步骤
        BpmFormAction currentFormAction = null;
        BpmStandardAction currentStandardAction = null;
        String xmlConfig = documentManager.getDefaultXmlConfig();

        //1、列出之前所有已挂接的文档
        List<Map> fileList = new ArrayList<Map>();
        //1.1表单操作
        Set<BpmFormAction> bpmFormActionSet = bpmProcessInstance.getBpmFormActions();
        for (BpmFormAction bpmFormAction : bpmFormActionSet) {
            BpmTaskInstance taskInstance = bpmFormAction.getTaskInstance();
            if (taskInstance.getId().equals(bpmTaskInstance.getId())) {
                currentFormAction = bpmFormAction;
                continue;
            }

            DocDocument document = bpmFormAction.getDocument();
            if (document == null) continue;

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("nodeName", taskInstance.getTaskDefinition().getName());
            map.put("submitUserName", bpmFormAction.getSubmitUser() != null ? bpmFormAction.getSubmitUser().getDisplayName() : "");
            map.put("submitTime", bpmFormAction.getSubmitTime());
            map.put("title", document.getName());
            map.put("documentLink", documentManager.getDownloadButton(document.getId()));
            map.put("fileId", document.getId());
            fileList.add(map);

        }

        //1.2标准操作
        Set<BpmStandardAction> standardActionSet = bpmProcessInstance.getBpmStandardActions();
        for (BpmStandardAction bpmStandardAction : standardActionSet) {
            BpmTaskInstance taskInstance = bpmStandardAction.getTaskInstance();
            if (taskInstance.getId().equals(bpmTaskInstance.getId())) {
                currentStandardAction = bpmStandardAction;
                continue;
            }
            DocDocument document = bpmStandardAction.getDocument();
            if (document == null) continue;

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("nodeName", taskInstance.getTaskDefinition().getName());
            map.put("submitUserName", bpmStandardAction.getSubmitUser() != null ? bpmStandardAction.getSubmitUser().getDisplayName() : "");
            map.put("submitTime", bpmStandardAction.getSubmitTime());
            map.put("title", document.getName());
            map.put("documentLink", documentManager.getDownloadButton(document.getId()));

            map.put("fileId", document.getId());
            fileList.add(map);
        }
//        Comparator mycmp = ComparableComparator.getInstance();
//        mycmp = ComparatorUtils.reversedComparator(mycmp);           //倒序
        Comparator mycmp = ComparatorUtils.NATURAL_COMPARATOR;      //顺序
        ArrayList<Object> sortFields = new ArrayList<Object>();
        sortFields.add(new BeanComparator("submitTime", mycmp));     //按字段submitTime排序
        ComparatorChain multiSort = new ComparatorChain(sortFields);
        Collections.sort(fileList, multiSort);
        model.addAttribute("fileList", fileList);

        //2、列出当前步骤挂接的文档
        DocCategory fileCategory = processDefinition.getFileCategory();
        if (fileCategory == null) {
            throw new RuntimeException(FormatUtils.format("根据{0}没有找到文档目录!", processDefinition.getCode()));
        }

        //当前附件修改为列表形式
        DocDocument fileDocument = bpmTaskInstanceManager.getFileDocument(bpmTaskInstance);
        Long documentId = null;
        if (fileDocument != null) {
            documentId = fileDocument.getId();
        }

        String documentLink = documentManager.getUploadButton(xmlConfig, fileCategory.getBizCode(), fileDocument, null, "");
        Map<String, Object> currentFileMap = new HashMap<String, Object>();
        currentFileMap.put("isPublic", true);
        currentFileMap.put("nodeName", bpmTaskInstance.getTaskDefinition().getName());
        if (documentId != null) {
            DocDocument document = docDocumentService.get(documentId);
            currentFileMap.put("title", document.getName());
            if (currentFormAction != null) {
                currentFileMap.put("submitUserName", currentFormAction.getSubmitUser() != null ? currentFormAction.getSubmitUser().getDisplayName() : "");
                currentFileMap.put("submitTime", currentFormAction.getSubmitTime());
            } else if (currentStandardAction != null) {
                currentFileMap.put("submitUserName", currentStandardAction.getSubmitUser() != null ? currentStandardAction.getSubmitUser().getDisplayName() : "");
                currentFileMap.put("submitTime", currentStandardAction.getSubmitTime());
            }
            currentFileMap.put("downloadLink", documentManager.getDownloadButton(documentId));

            currentFileMap.put("fileId", document);
        }
        currentFileMap.put("documentLink", documentLink);

        model.addAttribute("currentDocument", currentFileMap);

        model.addAttribute("bpmTaskInstanceId", bpmTaskInstanceId);
        model.addAttribute("taskName", bpmTaskInstance.getTaskDefinition().getName());

        return "view/workflow/bpmProcessAttach/formAttach";
    }


    /**
     * 附件上传
     */
    @RequestMapping
    public void attachSave(HttpServletResponse response, Long bpmTaskInstanceId, Long documentId) throws Exception {
        BpmTaskInstance bpmTaskInstance = bpmTaskInstanceService.get(bpmTaskInstanceId);
        DocDocument fileDocument = null;
        if (null != documentId) {
            fileDocument = docDocumentService.get(documentId);
        }
        bpmTaskInstanceService.save(bpmTaskInstance);

        //根据操作类型 将文件保存到不同的操作表中
        String operateType = bpmTaskInstanceManager.getOperateType(bpmTaskInstance);
        if (TaskNodeDefinition.OPERATION_TYPE_FORM.equalsIgnoreCase(operateType)) {
            BpmFormAction bpmFormAction = bpmTaskInstance.getBpmFormAction();
            if (null == bpmFormAction) {
                bpmFormAction = new BpmFormAction();
            }
            bpmFormAction.setProcessInstance(bpmTaskInstance.getProcessInstance());
            bpmFormAction.setTaskInstance(bpmTaskInstance);
            bpmFormAction.setDocument(fileDocument);
            bpmFormActionService.save(bpmFormAction);
            documentManager.updateDocumentByBizData(docDocumentService.get(documentId), bpmFormAction.getProcessInstance().getCode(), bpmTaskInstance.getTaskDefinition().getName());
        } else if (TaskNodeDefinition.OPERATION_TYPE_STANDARD.equalsIgnoreCase(operateType)) {
            BpmStandardAction standardAction = bpmTaskInstance.getBpmStandardAction();
            if (null == standardAction) {
                standardAction = new BpmStandardAction();
            }
            standardAction.setProcessInstance(bpmTaskInstance.getProcessInstance());
            standardAction.setTaskInstance(bpmTaskInstance);
            standardAction.setDocument(fileDocument);
            bpmStandardActionService.save(standardAction);
            documentManager.updateDocumentByBizData(docDocumentService.get(documentId), standardAction.getProcessInstance().getCode(), bpmTaskInstance.getTaskDefinition().getName());
        }
        sendSuccessJSON(response, "保存成功");
    }

    /**
     * 获取附件数量
     *
     * @param bpmTaskInstanceId .
     * @param model             .
     * @return .
     * @throws JAXBException .
     */
    @RequestMapping
    public String getAttachNum(@RequestParam Long bpmTaskInstanceId, Model model) throws JAXBException {
        int num = 0;
        BpmTaskInstance bpmTaskInstance = bpmTaskInstanceService.get(bpmTaskInstanceId);
        DocDocument fileDocument = null;

        //根据操作类型 将文件保存到不同的操作表中
        String operateType = bpmTaskInstanceManager.getOperateType(bpmTaskInstance);
        if (TaskNodeDefinition.OPERATION_TYPE_FORM.equalsIgnoreCase(operateType)) {
            BpmFormAction bpmFormAction = bpmTaskInstance.getBpmFormAction();
            if (bpmFormAction != null) {
                fileDocument = bpmFormAction.getDocument();
            }
        } else if (TaskNodeDefinition.OPERATION_TYPE_STANDARD.equalsIgnoreCase(operateType)) {
            BpmStandardAction standardAction = bpmTaskInstance.getBpmStandardAction();
            if (standardAction != null) {
                fileDocument = standardAction.getDocument();
            }
        }
        if (fileDocument != null) {
            num = fileDocument.getDocDocumentAttachs().size();
        }

        model.addAttribute("msg", "附件(" + num + ")");
        return "common/msg";
    }

    /**
     * 附件挂接页面
     *
     * @param processInstanceId .
     * @param from              .
     * @param model             .
     * @return .
     * @throws Exception .
     */
    @RequestMapping
    public String formAttachView(Long processInstanceId, String from, Model model) throws Exception {
        model.addAttribute("from", from);

        BpmProcessInstance bpmProcessInstance = bpmProcessInstanceService.get(processInstanceId);

        //1、列出之前所有已挂接的文档
        List<Map> fileList = new ArrayList<Map>();
        //1.1表单操作
        Set<BpmFormAction> bpmFormActionSet = bpmProcessInstance.getBpmFormActions();
        for (BpmFormAction bpmFormAction : bpmFormActionSet) {
            BpmTaskInstance taskInstance = bpmFormAction.getTaskInstance();

            DocDocument document = bpmFormAction.getDocument();
            if (document == null) continue;

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("nodeName", taskInstance.getTaskDefinition().getName());
            map.put("submitUserName", bpmFormAction.getSubmitUser() != null ? bpmFormAction.getSubmitUser().getDisplayName() : "");
            map.put("submitTime", bpmFormAction.getSubmitTime());
            map.put("title", document.getName());
            map.put("documentLink", documentManager.getDownloadButton(document.getId()));
            map.put("fileId", document.getId());
            fileList.add(map);

        }

        //1.2标准操作
        Set<BpmStandardAction> standardActionSet = bpmProcessInstance.getBpmStandardActions();
        for (BpmStandardAction bpmStandardAction : standardActionSet) {
            BpmTaskInstance taskInstance = bpmStandardAction.getTaskInstance();

            DocDocument document = bpmStandardAction.getDocument();
            if (document == null) continue;

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("nodeName", taskInstance.getTaskDefinition().getName());
            map.put("submitUserName", bpmStandardAction.getSubmitUser() != null ? bpmStandardAction.getSubmitUser().getDisplayName() : "");
            map.put("submitTime", bpmStandardAction.getSubmitTime());
            map.put("title", document.getName());
            map.put("documentLink", documentManager.getDownloadButton(document.getId()));

            map.put("fileId", document.getId());
            fileList.add(map);

        }
        Comparator mycmp = ComparatorUtils.NATURAL_COMPARATOR;      //顺序
        ArrayList<Object> sortFields = new ArrayList<Object>();
        sortFields.add(new BeanComparator("submitTime", mycmp));     //按字段submitTime排序
        ComparatorChain multiSort = new ComparatorChain(sortFields);
        Collections.sort(fileList, multiSort);
        model.addAttribute("fileList", fileList);

        return "view/workflow/bpmProcessAttach/formAttachView";
    }
}
