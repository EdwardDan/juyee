package com.justonetech.biz.manager.workflow;

import com.justonetech.core.utils.DateTimeHelper;
import com.justonetech.core.utils.FormatUtils;
import com.justonetech.biz.daoservice.BpmProcessInstanceService;
import com.justonetech.biz.domain.BpmProcessInstance;
import com.justonetech.biz.utils.Constants;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author Ma Ji
 * @version 1.0
 * @since <pre>2010-3-2</pre>
 */
@Service
public class BpmAuditResultManager {
    private static final Log log = LogFactory.getLog(BpmAuditResultManager.class);

    @Autowired
    private BpmProcessInstanceService bpmProcessInstanceService;

    @Autowired
    private BpmFormTemplateManager bpmFormTemplateManager;

    public void scan() {
        List<BpmProcessInstance> processInstances = getProcessInstances();

        for (BpmProcessInstance processInstance : processInstances) {
            saveAudit(processInstance);
        }
    }

    /**
     * @return
     */
    private List<BpmProcessInstance> getProcessInstances() {
        //get current format time
        String currentDate = getCurrentDate();
//        currentDate = "2010-01-21";

        String hql = "from BpmProcessInstance t where t.status='{0}' and t.processDefinition.code='{1}' and to_char(t.endTime,'yyyy-mm-dd')='{2}'";
        hql = FormatUtils.format(hql, Constants.BPM_STATUS_END, "BP-1-011", currentDate);
        return bpmProcessInstanceService.findByQuery(hql);
    }

    private void saveAudit(BpmProcessInstance processInstance) {
        try {
            //项目名称
            String projectName = bpmFormTemplateManager.getDataFromXml(processInstance, "xmmc");
            //施工单位
            String buildDept = bpmFormTemplateManager.getDataFromXml(processInstance, "cbdw");
            //上报时间
            String postTime = bpmFormTemplateManager.getDataFromXml(processInstance, "cb_rq");
            //上报单位
            String postDept = bpmFormTemplateManager.getDataFromXml(processInstance, "cbdw");
            //送审金额
            String postMoney = bpmFormTemplateManager.getDataFromXml(processInstance, "ssje");
            //审核状况(1等待审核2正在审核3完成审核)
            String auditType = "3";
            //审核人
            String auditPerson = bpmFormTemplateManager.getDataFromXml(processInstance, "jt_sjb_qz");
            //审定额
            String auditMoney = bpmFormTemplateManager.getDataFromXml(processInstance, "sdje");
            //完成时间
            String finishTime = bpmFormTemplateManager.getDataFromXml(processInstance, "jt_sjb_rq");
            //工程备注
            String memo = "";
            //来源于报表类型(范围["1"表示局投资项目预算审核情况表,"2"表示基层单位投资项目预算审核情况表,"3"两个]
            String boundid = "";

            String currentDate = getCurrentDate();
            //创建时间
            String createTime = currentDate;
            //最后修改时间
            String lastUpdateTim = currentDate;

        } catch (DocumentException e) {
            e.printStackTrace();
            log.error(e.getMessage());
//        } catch (SQLException e) {
//            e.printStackTrace();
//            log.error(e.getMessage());
        }

    }

    private String getCurrentDate() {
        return DateTimeHelper.formatTimestamp(new Timestamp(System.currentTimeMillis()), "YYYY-MM-DD");
    }
}
