package com.justonetech.biz.utils.process.page;

import org.htmlparser.Tag;

import java.lang.reflect.Field;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 2009-5-6
 * Time: 14:43:08
 * To change this template use File | Settings | File Templates.
 */
public class HtmlForm {
    public static HtmlTag CreateInputTag(Tag tag) throws IllegalAccessException {
        HtmlTag htmlTag = new HtmlTag();
        Field[] declaredFields = htmlTag.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            declaredField.set(htmlTag, tag.getAttribute(declaredField.getName()));
        }
        return htmlTag;
    }
}
