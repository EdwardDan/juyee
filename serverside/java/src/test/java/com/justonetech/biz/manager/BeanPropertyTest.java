package com.justonetech.biz.manager;

import com.justonetech.biz.domain.OaNews;
import com.justonetech.core.utils.ReflectionUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.List;

/**
 * description:
 * User: Chenjp
 * Date: 14-4-28 下午5:33
 */
public class BeanPropertyTest {
    private static Logger logger = LoggerFactory.getLogger(BeanPropertyTest.class);

    @Test
    public void testMethod1() {
        List<String> allField = ReflectionUtils.getAllField(OaNews.class);
        for (String s : allField) {
            System.out.println("s = " + s);
        }
        OaNews data = new OaNews();
        System.out.println("--------------------");
        getMethodDeclaration(data.getClass());
        System.out.println("--------------------");
        getMethod(data.getClass());
    }

    public static void getMethodDeclaration(Class<?> clazz) {
        Method[] methods = clazz.getDeclaredMethods();
        System.out.println("MethodDeclaration in " + clazz.getName());
        for (Method method : methods) {
            method.setAccessible(true);
            System.out.println(method.getName());
            }
        }

    
            

    public static void getMethod(Class<?> clazz) {
        Method[] methods = clazz.getMethods();
        System.out.println("Method in " + clazz.getName());
        for (Method method : methods) {
            if(method.getName().startsWith("get"))
            System.out.println(method.getName());
            }
        }
}