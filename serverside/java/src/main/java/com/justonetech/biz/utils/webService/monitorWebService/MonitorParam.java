
package com.justonetech.biz.utils.webService.monitorWebService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for monitorParam complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="monitorParam">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bjbh" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gdbh" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="qxbh" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="qydm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "monitorParam", propOrder = {
    "bjbh",
    "gdbh",
    "qxbh",
    "qydm"
})
public class MonitorParam {

    protected String bjbh;
    protected String gdbh;
    protected String qxbh;
    protected String qydm;

    /**
     * Gets the value of the bjbh property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBjbh() {
        return bjbh;
    }

    /**
     * Sets the value of the bjbh property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBjbh(String value) {
        this.bjbh = value;
    }

    /**
     * Gets the value of the gdbh property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGdbh() {
        return gdbh;
    }

    /**
     * Sets the value of the gdbh property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGdbh(String value) {
        this.gdbh = value;
    }

    /**
     * Gets the value of the qxbh property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQxbh() {
        return qxbh;
    }

    /**
     * Sets the value of the qxbh property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQxbh(String value) {
        this.qxbh = value;
    }

    /**
     * Gets the value of the qydm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQydm() {
        return qydm;
    }

    /**
     * Sets the value of the qydm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQydm(String value) {
        this.qydm = value;
    }

}
