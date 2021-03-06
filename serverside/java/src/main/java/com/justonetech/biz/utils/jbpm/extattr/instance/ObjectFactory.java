//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2009.03.26 at 03:35:54 下午 CST
//


package com.justonetech.biz.utils.jbpm.extattr.instance;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the com.justonetech.ipromis.core.extattr.instance package.
 * <p>An ObjectFactory allows you to programatically
 * construct new instances of the Java representation
 * for XML content. The Java representation of XML
 * content can consist of schema derived interfaces
 * and classes representing the binding of schema
 * type definitions, element declarations and model
 * groups.  Factory methods for each of these are
 * provided in this class.
 *
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Value_QNAME = new QName("", "Value");
    private final static QName _Expression_QNAME = new QName("", "Expression");
    private final static QName _None_QNAME = new QName("", "None");
    private final static QName _All_QNAME = new QName("", "All");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.justonetech.ipromis.core.extattr.instance
     *
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Values }
     *
     */
    public Values createValues() {
        return new Values();
    }

    /**
     * Create an instance of {@link Attributes }
     *
     */
    public Attributes createAttributes() {
        return new Attributes();
    }

    /**
     * Create an instance of {@link Attribute }
     *
     */
    public Attribute createAttribute() {
        return new Attribute();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "", name = "Value")
    public JAXBElement<Long> createValue(Long value) {
        return new JAXBElement<Long>(_Value_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "", name = "Expression")
    public JAXBElement<String> createExpression(String value) {
        return new JAXBElement<String>(_Expression_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "", name = "None")
    public JAXBElement<Object> createNone(Object value) {
        return new JAXBElement<Object>(_None_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "", name = "All")
    public JAXBElement<Object> createAll(Object value) {
        return new JAXBElement<Object>(_All_QNAME, Object.class, null, value);
    }

}
