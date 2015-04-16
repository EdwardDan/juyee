package com.justonetech.biz.domain.bean.android;

import java.io.Serializable;

/**
 * note:
 * User: Shaxj
 * Date: 14-8-6
 * Time: 下午1:27
 */
public class AndroidConst implements Serializable {
    //问题类别--对应字段：JD_RECORD_QUESTION.TYPE_CODE
    public static final String JD_RECORD_FIRST_CHECK_NORMAL = "normal"; //首次监督--问题类别--正常
    public static final String JD_RECORD_SAFE_CHECK_BEHAVIOR = "behavior"; //安全监督--问题类别--行为检查
    public static final String JD_RECORD_SAFE_CHECK_FACILITY = "facility"; //安全监督--问题类别--设施检查
    public static final String JD_RECORD_QUALITY_CHECK_BEHAVIOR = "behavior"; //质量监督--问题类别--行为抽查
    public static final String JD_RECORD_QUALITY_CHECK_ENTITY = "entity"; //质量监督--问题类别--实体抽查
    public static final String JD_RECORD_COMPLETE_CHECK_OTHER = "other"; //竣工验收监督--问题类别--其他抽查

    public static final String TYPE_REFORM = "reform";   // 整改指令单
    public static final String TYPE_SUSPEND = "suspend";   // 局部暂缓施工指令单
    public static final String TYPE_STOP = "stop";  // 停工指令单
}
