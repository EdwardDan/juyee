//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.02.23 at 01:21:00 ���� CST 
//


package com.justonetech.biz.utils.process.visio;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}Shapes"/>
 *       &lt;/sequence>
 *       &lt;attribute name="ID" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="NameU" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "shapes"
})
@XmlRootElement(name = "Page")
public class Page {

    @XmlElement(name = "Shapes", required = true)
    protected Shapes shapes;
    @XmlAttribute(name = "ID")
    protected String id;
    @XmlAttribute(name = "Name")
    protected String name;
    @XmlAttribute(name = "NameU")
    protected String nameU;

    /**
     * Gets the value of the shapes property.
     * 
     * @return
     *     possible object is
     *     {@link Shapes }
     *     
     */
    public Shapes getShapes() {
        return shapes;
    }

    /**
     * Sets the value of the shapes property.
     * 
     * @param value
     *     allowed object is
     *     {@link Shapes }
     *     
     */
    public void setShapes(Shapes value) {
        this.shapes = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getID() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setID(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the nameU property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameU() {
        return nameU;
    }

    /**
     * Sets the value of the nameU property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameU(String value) {
        this.nameU = value;
    }

}
