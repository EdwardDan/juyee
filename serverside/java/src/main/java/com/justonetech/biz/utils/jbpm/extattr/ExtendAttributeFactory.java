package com.justonetech.biz.utils.jbpm.extattr;


import com.justonetech.biz.utils.jbpm.extattr.definition.Configuration;
import com.justonetech.biz.utils.jbpm.extattr.definition.ExtAttrDef;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.List;

public class ExtendAttributeFactory {
    private Configuration configuration;

    public ExtendAttributeFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    public ExtendAttributeFactory(File config) throws JAXBException, FileNotFoundException {
        this(loadFromXml(config));
    }

    public static Configuration loadFromXml(String xml) throws JAXBException {
        Reader reader = new StringReader(xml);
        JAXBContext jc = JAXBContext.newInstance(Configuration.class.getPackage().getName());
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        return (Configuration) unmarshaller.unmarshal(reader);
    }

    public static Configuration loadFromXml(File file) throws JAXBException, FileNotFoundException {
        InputStream is = new FileInputStream(file);
        JAXBContext jc = JAXBContext.newInstance(Configuration.class.getPackage().getName());
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        return (Configuration) unmarshaller.unmarshal(is);
    }

    public List<ExtAttrDef> getAllExtAttrDefList() {
        return configuration.getExtAttrDef();
    }

    public ExtAttrDef getExtAttrDef(String code) {
        List<ExtAttrDef> defs = getAllExtAttrDefList();
        for (ExtAttrDef extAttrDef : defs) {
            if (extAttrDef.getCode().equals(code)) {
                return extAttrDef;
            }
        }
        return null;
    }
}
