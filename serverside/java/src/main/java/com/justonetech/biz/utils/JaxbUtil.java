package com.justonetech.biz.utils;

import org.apache.commons.jexl.Expression;
import org.apache.commons.jexl.ExpressionFactory;
import org.apache.commons.jexl.JexlContext;
import org.apache.commons.jexl.JexlHelper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.Map;


/**
 * Jaxb的工具类以及通过表达式进行验证的方法.
 *
 * @author Youyiming
 */
public class JaxbUtil {

    public static String marshall(final Object object) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(object.getClass().getPackage().getName());
        Marshaller marshaller = jc.createMarshaller();
        Writer writer = new StringWriter();
        marshaller.marshal(object, writer);
        return writer.toString();
    }

    public static void marshall(final Object object, File file) throws JAXBException, IOException {
        JAXBContext jc = JAXBContext.newInstance(object.getClass().getPackage().getName());
        Marshaller marshaller = jc.createMarshaller();
        OutputStream outputStream = new FileOutputStream(file);
        marshaller.marshal(object, outputStream);
        outputStream.flush();
        outputStream.close();
    }

    public static <T extends Object> T unmarshall(final Class<T> clazz, final String xml) throws JAXBException {
        Reader reader = new StringReader(xml);
        JAXBContext jc = JAXBContext.newInstance(clazz.getPackage().getName());
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        return (T) unmarshaller.unmarshal(reader);
    }

    public static <T extends Object> T unmarshall(final Class<T> clazz, final File file) throws JAXBException, FileNotFoundException {
        InputStream inputStream = new FileInputStream(file);
        JAXBContext jc = JAXBContext.newInstance(clazz.getPackage().getName());
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        return (T) unmarshaller.unmarshal(inputStream);
    }

    /**
     * 通过表达式验证
     *
     * @param map
     * @param expression 表达式
     * @return 验证结果(true, false)
     * @throws Exception
     */
    public static boolean evaluate(Map map, String expression) throws Exception {
        Expression e = ExpressionFactory.createExpression(expression);
        JexlContext jc = JexlHelper.createContext();
        jc.setVars(map);
        Boolean message = (Boolean) e.evaluate(jc);

        return message;
    }
}
