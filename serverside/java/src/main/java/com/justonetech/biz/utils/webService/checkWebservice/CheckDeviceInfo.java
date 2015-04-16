
package com.justonetech.biz.utils.webService.checkWebservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for checkDeviceInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="checkDeviceInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{http://check.webservice.pagd.justonetech.com/}baseCheckDeviceInfo">
 *       &lt;sequence>
 *         &lt;element name="belongArea" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="startInx" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "checkDeviceInfo", propOrder = {
    "belongArea",
    "startInx"
})
public class CheckDeviceInfo
    extends BaseCheckDeviceInfo
{

    protected String belongArea;
    protected long startInx;

    /**
     * Gets the value of the belongArea property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBelongArea() {
        return belongArea;
    }

    /**
     * Sets the value of the belongArea property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBelongArea(String value) {
        this.belongArea = value;
    }

    /**
     * Gets the value of the startInx property.
     * 
     */
    public long getStartInx() {
        return startInx;
    }

    /**
     * Sets the value of the startInx property.
     * 
     */
    public void setStartInx(long value) {
        this.startInx = value;
    }

}
