package com.justonetech.biz.utils.process.visio;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;

public class XMLReader {

    public XMLReader() {
    }

    public VisioDocument loadFromXml(String xml) throws JAXBException {
        Reader reader = new StringReader(xml);
        JAXBContext jc = JAXBContext.newInstance(VisioDocument.class.getPackage().getName());
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        return (VisioDocument) unmarshaller.unmarshal(reader);
    }

    public VisioDocument loadFromXml(File file) throws JAXBException, FileNotFoundException {
        InputStream is = new FileInputStream(file);
        JAXBContext jc = JAXBContext.newInstance(VisioDocument.class.getPackage().getName());
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        return (VisioDocument) unmarshaller.unmarshal(is);
    }
}

