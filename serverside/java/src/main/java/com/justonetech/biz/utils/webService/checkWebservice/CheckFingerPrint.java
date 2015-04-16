
package com.justonetech.biz.utils.webService.checkWebservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for checkFingerPrint complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="checkFingerPrint">
 *   &lt;complexContent>
 *     &lt;extension base="{http://check.webservice.pagd.justonetech.com/}baseCheckFingerPrint">
 *       &lt;sequence>
 *         &lt;element name="managerGuid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "checkFingerPrint", propOrder = {
    "managerGuid"
})
public class CheckFingerPrint
    extends BaseCheckFingerPrint
{

    protected String managerGuid;

    /**
     * Gets the value of the managerGuid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getManagerGuid() {
        return managerGuid;
    }

    /**
     * Sets the value of the managerGuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setManagerGuid(String value) {
        this.managerGuid = value;
    }

}
