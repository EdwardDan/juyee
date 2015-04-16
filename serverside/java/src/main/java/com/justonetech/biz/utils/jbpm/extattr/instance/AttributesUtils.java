package com.justonetech.biz.utils.jbpm.extattr.instance;

import javax.xml.bind.Unmarshaller;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.StringReader;
import java.io.Reader;
import java.io.Writer;
import java.io.StringWriter;
import java.util.List;

public class AttributesUtils {
    public static Attributes loadFromXml(String xml) throws JAXBException {
        Reader reader = new StringReader(xml);
        JAXBContext jc = JAXBContext.newInstance(Attributes.class.getPackage().getName());
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        return (Attributes) unmarshaller.unmarshal(reader);
    }

    public static Attributes loadFromXml(File file) throws JAXBException, FileNotFoundException {
        InputStream is = new FileInputStream(file);
        JAXBContext jc = JAXBContext.newInstance(Attributes.class.getPackage().getName());
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        return (Attributes) unmarshaller.unmarshal(is);
    }

    public static String saveToXml(Attributes attributes) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(Attributes.class.getPackage().getName());
        Marshaller marshaller = jc.createMarshaller();
        Writer writer = new StringWriter();
        marshaller.marshal(attributes, writer);
        return writer.toString();
    }

    public static Attribute getAttribute(Attributes attributes, String attributeName) {
        List<Attribute> attributeList = attributes.getAttribute();
        for (Attribute attribute : attributeList) {
            if(attribute.getCode()!=null&&attribute.getCode().equals(attributeName)){
                return attribute;
            }
        }
        return null;
    }
}
