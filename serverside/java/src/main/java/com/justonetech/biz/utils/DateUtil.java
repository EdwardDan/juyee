package com.justonetech.biz.utils;

import com.justonetech.core.utils.DateTimeHelper;
import com.justonetech.core.utils.FormatUtils;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.XMLGregorianCalendarConversionUtils;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * User: Chen Junping
 * Date: 12-9-18
 */
public class DateUtil {
    /**
     * 时间格式转换--cxf不识别java.sql.Timestamp
     *
     * @param orgTime
     * @return
     */
    public static XMLGregorianCalendar timeToXmlDate(java.sql.Timestamp orgTime) {
        if (orgTime != null) {
            return XMLGregorianCalendarConversionUtils.asXMLGregorianCalendar(new Date(orgTime.getTime()));
        }
        return null;
    }

    /**
     * 将xmldate转为timestamp
     * @param cal
     * @return
     */
    public static java.sql.Timestamp xmlDate2Time(XMLGregorianCalendar cal){
        if(cal != null){
            return new java.sql.Timestamp(XMLGregorianCalendarConversionUtils.asDate(cal).getTime());
        }
        return null;
    }

    /**
     * 将Date类转换为XMLGregorianCalendar
     * @param date
     * @return
     */
    public static XMLGregorianCalendar dateToXmlDate(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        DatatypeFactory dtf = null;
        try {
            dtf = DatatypeFactory.newInstance();
        } catch (DatatypeConfigurationException e) {
        }
        XMLGregorianCalendar dateType = dtf.newXMLGregorianCalendar();
        dateType.setYear(cal.get(Calendar.YEAR));
        //由于Calendar.MONTH取值范围为0~11,需要加1
        dateType.setMonth(cal.get(Calendar.MONTH)+1);
        dateType.setDay(cal.get(Calendar.DAY_OF_MONTH));
        dateType.setHour(cal.get(Calendar.HOUR_OF_DAY));
        dateType.setMinute(cal.get(Calendar.MINUTE));
        dateType.setSecond(cal.get(Calendar.SECOND));
        return dateType;
    }

    /**
     * 将XMLGregorianCalendar转换为Date
     * @param cal
     * @return
     */
    public static Date xmlDate2Date(XMLGregorianCalendar cal){
        return cal.toGregorianCalendar().getTime();
    }

    /**
     * 获取工作时间：8:30 - 17:30
     * @param date
     * @return
     * @throws ParseException
     */
    public static String[] getWorkDate(String date) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cd = Calendar.getInstance();
        cd.setTime(simpleDateFormat.parse(date));
        cd.add(Calendar.HOUR, 7);
        cd.add(Calendar.MINUTE, 30);

        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String[] workDate = new String[2];
        workDate[0] = simpleDateFormat.format(cd.getTime());

        cd.add(Calendar.HOUR, 10);
        workDate[1] = simpleDateFormat.format(cd.getTime());
        return workDate;
    }

    public static String getQuarterMultiSelectOptions(String quarter){
        String options = DateTimeHelper.getQuarterSelectOptions(quarter);
        if ("5".equals(quarter)) {
            options += FormatUtils.format(JspHelper.SELECT_OPTION, "5", "上半年度", "selected");
        } else {
            options += FormatUtils.format(JspHelper.SELECTOPTION, "5","上半年度");
        }
        return options;
    }

    public static void main(String[] args) {
        Timestamp curTime = new Timestamp(System.currentTimeMillis());
        XMLGregorianCalendar calendar = timeToXmlDate(curTime);

        System.out.println("calendar = " + calendar);

        Timestamp timestamp = xmlDate2Time(calendar);
        System.out.println("timestamp = " + DateTimeHelper.formatTimeGBK(timestamp));
    }

}
