
package com.justonetech.biz.utils.webService.jdrwsWebService.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getJdrwsByJdrwsbhResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getJdrwsByJdrwsbhResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://jdrwsWebService.webService.utils.biz.justonetech.com/}jdrws" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getJdrwsByJdrwsbhResponse", propOrder = {
    "_return"
})
public class GetJdrwsByJdrwsbhResponse {

    @XmlElement(name = "return")
    protected Jdrws _return;

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link Jdrws }
     *     
     */
    public Jdrws getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link Jdrws }
     *     
     */
    public void setReturn(Jdrws value) {
        this._return = value;
    }

}
