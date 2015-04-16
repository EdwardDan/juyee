package com.justonetech.biz.manager;

import com.justonetech.biz.utils.Constants;
import com.justonetech.biz.utils.JaxbUtil;
import com.justonetech.biz.utils.calendar.WorkCalendar;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.daoservice.SysParameterService;
import com.justonetech.system.domain.SysParameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Calendar;

/**
 * User: Chen Junping
 * Date: 2009-12-16
 */
@Service
public class SysWorkCalendarManager {
    private Logger logger = LoggerFactory.getLogger(SysParameterManager.class);

    @Autowired
    private SysParameterService sysParameterService;

    @Autowired
    private SysParameterManager sysParameterManager;

    /**
     * 获取当前项目的日历信息（如果没有则取全局日历）
     *
     * @return
     * @throws Exception
     */
    public WorkCalendar getWorkCalendar() throws Exception {
        WorkCalendar workCalendar = null;
        String clobValue = sysParameterManager.getSysParameterValue(Constants.SYS_WORKCALENDAR);
        if (!StringHelper.isEmpty(clobValue)) {
            workCalendar = JaxbUtil.unmarshall(WorkCalendar.class, clobValue);
        }
        return workCalendar;
    }

    /**
     * 保存项目日历
     *
     * @param sysParameterId
     * @param clobValue
     */
    public void saveWorkCalendar(Long sysParameterId, String clobValue) {
        String calendarCode = Constants.SYS_WORKCALENDAR;
        SysParameter sysParameter;
        if (sysParameterId != null) {
            sysParameter = sysParameterService.get(sysParameterId);
        } else {
            sysParameter = new SysParameter();
            sysParameter.setCode(calendarCode);
            sysParameter.setName("项目日历");
            sysParameter.setValue(calendarCode);
            String constraint = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                    "<Constraint visible=\"true\" default=\"" + calendarCode + "\" definition=\"" + calendarCode + "=日历\" readonly=\"false\" type=\"String\"/>";
            sysParameter.setConstraint(constraint);
        }
        if (clobValue != null) {
            sysParameter.setClobvalue(clobValue);
        }
        sysParameterService.save(sysParameter);
    }

    /**
     * 判断是否超时
     *
     * @param startTime 任务实例启动时间
     * @param delayDays 任务定义延时天数
     * @param endTime   任务结束时间
     * @return 是否超时
     * @throws Exception
     */
    public Boolean isTimeout(Timestamp startTime, int delayDays, int endTime) throws Exception {
        WorkCalendar workCalendar = getWorkCalendar();  //项目日历（系统参数表）
        if (workCalendar != null) {
            Calendar c = Calendar.getInstance();
            c.setTimeInMillis(startTime.getTime());

            Timestamp finalTime = null;
            for (int i = 0; i < delayDays; i++) {
                c.add(endTime, 1);
                if (!workCalendar.isWorkTime(c.getTime())) {
                    c.add(endTime, 1);
                }
            }
            Timestamp currentTime = new Timestamp(System.currentTimeMillis());
            finalTime = new Timestamp(c.getTimeInMillis());
            logger.debug(".........finalTime=" + finalTime);
            return currentTime.after(finalTime);
        }
        return false;
    }

    public Boolean isTimeout(Timestamp startTime, int delayDays) throws Exception {
        return isTimeout(startTime, delayDays, Calendar.DATE);
    }
}
