package com.justonetech.biz.controller.workflow;

import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.biz.daoservice.BpmProcessInstanceService;
import com.justonetech.biz.daoservice.BpmTaskInstanceService;
import com.justonetech.biz.domain.BpmFormAction;
import com.justonetech.biz.domain.BpmFormTemplate;
import com.justonetech.biz.domain.BpmProcessInstance;
import com.justonetech.biz.domain.BpmTaskInstance;
import com.justonetech.biz.manager.workflow.BpmTaskInstanceManager;
import com.justonetech.biz.utils.jbpm.node.TaskNodeDefinition;
import com.justonetech.biz.utils.process.page.BizHtml;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.xml.bind.JAXBException;
import java.util.List;
import java.util.Map;


/**
 * note:流程日志实例表
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class BpmProcessLogController extends BaseCRUDActionController<BpmProcessInstance> {
    private Logger logger = LoggerFactory.getLogger(BpmProcessLogController.class);

    @Autowired
    private BpmProcessInstanceService bpmProcessInstanceService;

    @Autowired
    private BpmTaskInstanceManager bpmTaskInstanceManager;

    @Autowired
    private BpmTaskInstanceService bpmTaskInstanceService;


    /**
     * 审核日志
     *
     * @param processInstanceId 。
     * @param from              .
     * @param model             .
     * @return .
     * @throws javax.xml.bind.JAXBException .
     */
    @RequestMapping
    public String log(Long processInstanceId, String from, Model model) throws JAXBException {

        BpmProcessInstance bpmProcessInstance = bpmProcessInstanceService.get(processInstanceId);
        Boolean existStandardOperation = false;
        List<Map<String, Object>> logs = bpmTaskInstanceManager.getLogs(bpmProcessInstance);
        for(Map<String, Object> map:logs){
           if(TaskNodeDefinition.OPERATION_TYPE_STANDARD.equals(map.get("operateType"))){
               existStandardOperation = true;
               break;
           }
        }
        model.addAttribute("logs", logs);
        model.addAttribute("existStandardOperation", existStandardOperation);
        model.addAttribute("from", from);

        return "view/workflow/bpmProcessLog/log";
    }

    /**
     * 日志详细信息
     *
     * @param bpmTaskInstanceId .
     * @param operateType       .
     * @param model             .
     * @return .
     * @throws Exception .
     */
    @RequestMapping
    public String logDetail(Long bpmTaskInstanceId, String operateType, Model model) throws Exception {

        String xmlData = "<Root></Root>";
        //获取xmlData,权限privilege
        BpmTaskInstance bpmTaskInstance = bpmTaskInstanceService.get(bpmTaskInstanceId);

        // 根据bpmTaskInstance取对应模板
        BpmFormTemplate bpmFormTemplate = bpmTaskInstanceManager.getBpmFormTemplate(bpmTaskInstance);

        if (TaskNodeDefinition.OPERATION_TYPE_FORM.equalsIgnoreCase(operateType)) {
            //取表单数据，
            BpmFormAction bpmFormAction = bpmTaskInstance.getBpmFormAction();
            if (null != bpmFormAction && null != bpmFormAction.getFormXml()) {
                xmlData = bpmFormAction.getFormXml();
            }

            BizHtml bizHtml = new BizHtml(bpmFormTemplate.getHtmlTemplate(), "0", xmlData, "1");
            String html = bizHtml.process();
            //处理其他业务逻辑
            model.addAttribute("bizHtml", html);
        } else {
            String url = "/workflow/bpmProcessInstance/standardView.do?bpmTaskInstanceId=" + bpmTaskInstanceId + "&view=1";
            model.addAttribute("url", url);
        }

        return "view/workflow/bpmProcessLog/logDetail";
    }

}
