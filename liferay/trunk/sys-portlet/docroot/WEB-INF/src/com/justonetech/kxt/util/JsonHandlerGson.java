package com.justonetech.kxt.util;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.Type;

/**
 * JSON序列化辅助类
 **/
public class JsonHandlerGson {

    public static String ToJsonStr(Object obj) {
    	return JSON.toJSONString(obj);
    }

    /**
     * json字符串转类
     *
     * @param json
     * @param classOfT
     * @return
     */
    public static <T> T formJsonStr(String json, Class<T> classOfT) {
    	return JSON.parseObject(json,classOfT);

    }

    /**
     * json字符串转集合
     *
     * @param json
     * @param typeOfT
     * @return
     */
    public static <T> T formJsonStr(String json, Type typeOfT) {
    	return JSON.parseObject(json,typeOfT);
    }
}
