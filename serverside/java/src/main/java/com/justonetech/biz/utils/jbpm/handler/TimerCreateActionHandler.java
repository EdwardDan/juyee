package com.justonetech.biz.utils.jbpm.handler;

import com.justonetech.biz.domain.BpmNodeDefinition;
import com.justonetech.biz.manager.workflow.ProcessDataManager;
import com.justonetech.biz.utils.jbpm.node.TaskNodeDefinition;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jbpm.calendar.BusinessCalendar;
import org.jbpm.calendar.Duration;
import org.jbpm.graph.def.ActionHandler;
import org.jbpm.graph.exe.ExecutionContext;
import org.jbpm.graph.node.TaskNode;
import org.jbpm.job.Timer;

import java.util.Date;

/**
 * @version 1.0
 * @author: MaJi
 * @since: 2009-5-19
 */
public class TimerCreateActionHandler implements ActionHandler {
    private static final String TIMER_NAME_REMINDER = "reminder";
    private static final String TIMER_NAME_DEADLINE = "deadline";
    private static final String FREQUENTLY_TIME = "1 business hours";
    private static final String UNFREQUENTLY_TIME = "8 business hours";
    static BusinessCalendar businessCalendar = new BusinessCalendar();


    public void execute(ExecutionContext executionContext) throws Exception {
        Timer timer = executionContext.getTimer();
        log.debug("timer " + timer.getName() + " is running ! DueDate:" + timer.getDueDate());

        TaskNode node = (TaskNode) executionContext.getNode();

        //业务表相关
        BpmNodeDefinition bpmNodeDefinition = ProcessDataManager.getBpmNodeDefinition(node);
        TaskNodeDefinition taskNodeDefinition = ProcessDataManager.getTaskNodeDefinition(bpmNodeDefinition);
        String earlyWarningType = taskNodeDefinition.getEarlyWarningType();

        //timer 两种类型,1.reminder,2.deadline
        if (TIMER_NAME_REMINDER.equals(timer.getName())) {//reminder timer
            Integer dateLimit = taskNodeDefinition.getDateLimit();
            String dateType = taskNodeDefinition.getDateType();

            //根据工作日/自然日得到duration
            String duration;
            if (TaskNodeDefinition.DAY_TYPE_WORK_DAY.equals(dateType)) {
                duration = String.valueOf(dateLimit) + " business days";
            } else {//day
                duration = String.valueOf(dateLimit) + " days";
            }
            Date deadline = businessCalendar.add(new Date(), new Duration(duration));
            Date dueDate = new Date(deadline.getTime() - 5 * 24 * 60 * 60 * 1000);

            //由预警策略得到时间,
            if (TaskNodeDefinition.WARNING_FREQUENTLY.equals(earlyWarningType)) {//frequently
                timer.setDueDate(dueDate);
                timer.setRepeat(FREQUENTLY_TIME);
            } else if (TaskNodeDefinition.WARNING_UNFREQUENTLY.equals(earlyWarningType)) {//unfrequently
                timer.setDueDate(dueDate);
                timer.setRepeat(UNFREQUENTLY_TIME);
            } else {//none
                timer.setDueDate(null);
                timer.setRepeat(null);
            }
        } else if (TIMER_NAME_DEADLINE.equals(timer.getName())) {//dead line timer
            Integer dateLimit = taskNodeDefinition.getDateLimit();
            String dateType = taskNodeDefinition.getDateType();
            String duration;
            if (TaskNodeDefinition.DAY_TYPE_WORK_DAY.equals(dateType)) {
                duration = String.valueOf(dateLimit) + " business days";
            } else {//day
                duration = String.valueOf(dateLimit) + " days";
            }
            Date deadline = businessCalendar.add(new Date(), new Duration(duration));
            timer.setDueDate(deadline);
        } else {
            log.debug("bad type!");
        }
    }

    private static final Log log = LogFactory.getLog(TimerCreateActionHandler.class);
}
