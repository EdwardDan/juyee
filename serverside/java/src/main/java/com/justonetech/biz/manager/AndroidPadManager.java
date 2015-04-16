package com.justonetech.biz.manager;

import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: yujun
 * Date: 12-9-12
 * Time: 上午9:14
 */
@Service
public class AndroidPadManager {
    /**
     * 获取padTime和系统时间差,返回真实时间
     */

    public static Timestamp getTrueTime(String padTime, String initTime) throws ParseException {
        Timestamp timeStamp = null;
        if (padTime != null && initTime != null) {
            Date date = new Date(System.currentTimeMillis());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date timePad = simpleDateFormat.parse(padTime);
            Date timeInit = simpleDateFormat.parse(initTime);
            Long quot = date.getTime() - timePad.getTime();
            Long createTime = timeInit.getTime() + quot;
            timeStamp = new Timestamp(createTime);
        }
        return timeStamp;
    }

    public static Timestamp getTrueTime(String padTime, Timestamp initTime) throws ParseException {
        Timestamp timeStamp = null;
        if (padTime != null && initTime != null) {
            Date date = new Date(System.currentTimeMillis());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date timePad = simpleDateFormat.parse(padTime);
//            Date timeInit = simpleDateFormat.parse(initTime);
            Long quot = date.getTime() - timePad.getTime();
            Long createTime = initTime.getTime() + quot;
            timeStamp = new Timestamp(createTime);
        }
        return timeStamp;
    }
}
