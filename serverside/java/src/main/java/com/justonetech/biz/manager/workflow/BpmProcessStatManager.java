package com.justonetech.biz.manager.workflow;

import com.justonetech.core.utils.StringHelper;
import com.justonetech.biz.daoservice.BpmProcessDefinitionService;
import com.justonetech.biz.daoservice.BpmProcessInstanceService;
import com.justonetech.biz.daoservice.BpmTaskInstanceService;
import com.justonetech.biz.domain.BpmNodeDefinition;
import com.justonetech.biz.domain.BpmProcessDefinition;
import com.justonetech.biz.domain.BpmProcessInstance;
import com.justonetech.biz.domain.BpmTaskInstance;
import com.justonetech.biz.utils.Constants;
import com.justonetech.biz.utils.JaxbUtil;
import com.justonetech.biz.utils.jbpm.node.TaskNodeDefinition;
import com.justonetech.system.domain.SysUser;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Ma Ji
 * @version 1.0
 * @since <pre>2010-3-30</pre>
 */
@Service
public class BpmProcessStatManager {
    private static final Log log = LogFactory.getLog(BpmProcessStatManager.class);

    @Autowired
    private BpmTaskInstanceService bpmTaskInstanceService;

    @Autowired
    private BpmProcessInstanceService bpmProcessInstanceService;

    @Autowired
    private BpmProcessDefinitionService bpmProcessDefinitionService;

    @Autowired
    private BpmTaskInstanceManager bpmTaskInstanceManager;

    public List<BpmTaskInstance> getTimeOutProcessInstance(BpmProcessDefinition bpmProcessDefinition) {

        DetachedCriteria criteria = DetachedCriteria.forClass(BpmTaskInstance.class);

        //流程未完成
        criteria.createCriteria("processInstance").add(Restrictions.eq("status", Constants.BPM_STATUS_RUN));
        //未完成
        criteria.add(Restrictions.isNull("endTime"));
        //
        criteria.createCriteria("processInstance").add(Restrictions.eq("processDefinition", bpmProcessDefinition));
        //节点为超时节点
        criteria.createCriteria("taskDefinition").add(Restrictions.like("nodeDefinition", "'timeOutAction=\"1\"'"));
        //排序
        criteria.addOrder(Order.asc("id"));

        return bpmTaskInstanceService.findByCriteria(criteria);
    }

    public List<BpmProcessInstance> getAllProcessDefinitonInstanceByUser(SysUser sysUser, BpmProcessDefinition bpmProcessDefinition) {
        String hql = "select distinct p " +
                "from BpmProcessInstance p,org.jbpm.taskmgmt.exe.TaskInstance t " +
                "where p.jbpmProcessInstanceId=t.processInstance.id " +
                "and t.actorId=" + sysUser.getId() + " and p.processDefinition.id=" + bpmProcessDefinition.getId() + "";
        return bpmProcessInstanceService.findByQuery(hql);
    }

    public List<BpmTaskInstance> getAllTaskInstanceByUser(SysUser sysUser, BpmProcessDefinition bpmProcessDefinition) {
        String hql = "select p " +
                "from BpmTaskInstance p,org.jbpm.taskmgmt.exe.TaskInstance t " +
                "where p.jbpmTaskInstanceId=t.id " +
                "and t.actorId=" + sysUser.getId() + " and p.processInstance.processDefinition.id=" + bpmProcessDefinition.getId() + "";
        return bpmTaskInstanceService.findByQuery(hql);
    }

    public int getTimeOutCount(List<BpmTaskInstance> bpmTaskInstances) throws Exception {
        int timeOutCount = 0;
        for (BpmTaskInstance bpmTaskInstance : bpmTaskInstances) {
            BpmNodeDefinition bpmNodeDefinition = bpmTaskInstance.getTaskDefinition();
            String nodeDefinition = bpmNodeDefinition.getNodeDefinition();
            if (StringHelper.isEmpty(nodeDefinition)) {
                TaskNodeDefinition definition = JaxbUtil.unmarshall(TaskNodeDefinition.class, nodeDefinition);
                Boolean isNodeTimeOut = bpmTaskInstanceManager.isNodeTimeout(definition, bpmTaskInstance);
                if (isNodeTimeOut) {
                    timeOutCount++;
                }
            }
        }

        return timeOutCount;
    }
}
