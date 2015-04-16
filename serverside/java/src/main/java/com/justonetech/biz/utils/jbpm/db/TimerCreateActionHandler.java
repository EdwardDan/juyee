package com.justonetech.biz.utils.jbpm.db;

import com.justonetech.biz.daoservice.BpmNodeDefinitionService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jbpm.calendar.BusinessCalendar;
import org.jbpm.graph.def.ActionHandler;
import org.jbpm.graph.exe.ExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimerCreateActionHandler implements ActionHandler {

    @Autowired
    private BpmNodeDefinitionService bpmNodeDefinitionService;

    static BusinessCalendar businessCalendar = new BusinessCalendar();

    final static String frequentlyTime = "1 hours";
    final static String unfrequentlyTime = "8 hours";

    public String getTimerName() {
        return timerName;
    }

    public void setTimerName(String timerName) {
        this.timerName = timerName;
    }

    String timerName;

    public void execute(ExecutionContext executionContext) throws Exception {
//        Timer timer = executionContext.getTimer();
//        log.debug("timer " + timer.getName() + " is running ! DueDate:" + timer.getDueDate());
////        TaskInstance taskInstance = timer.getTaskInstance();
//
//        TaskNode node = (TaskNode) executionContext.getNode();
//        String hql = "from BpmNodeDefinition t where t.jbpmNodeId = " + node.getId();
//        BpmNodeDefinition bpmNodeDefinition = bpmNodeDefinitionService.findUnique(hql);
//        String nodeDefinition = bpmNodeDefinition.getNodeDefinition();
//        TaskNodeDefinition taskNodeDefinition = JaxbUtil.unmarshall(TaskNodeDefinition.class, nodeDefinition);
//
//        String earlyWarningType = taskNodeDefinition.getEarlyWarningType();
//
//        if (timer != null && timerName.equals(timer.getName())) {
//            Duration duration;
//            if (TaskNodeDefinition.WARNING_FREQUENTLY.equals(earlyWarningType)) {
//                duration = new Duration(frequentlyTime);
//                Date dueDateDate = businessCalendar.add(new Date(), duration);
//                timer.setDueDate(dueDateDate);
//                timer.setRepeat(frequentlyTime);
//            } else if (TaskNodeDefinition.WARNING_FREQUENTLY.equals(earlyWarningType)) {
//                duration = new Duration(unfrequentlyTime);
//                Date dueDateDate = businessCalendar.add(new Date(), duration);
//                timer.setDueDate(dueDateDate);
//                timer.setRepeat(unfrequentlyTime);
//            }else{
//                //earlyWarningType is none
//            }
//        } else {
//            throw new RuntimeException("timer is null!");
//        }
        System.out.println(" ================================== ");
    }

    private static final Log log = LogFactory.getLog(TimerActionHandler.class);
}