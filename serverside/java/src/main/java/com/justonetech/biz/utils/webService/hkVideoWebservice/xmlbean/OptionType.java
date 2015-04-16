
package com.justonetech.biz.utils.webService.hkVideoWebservice.xmlbean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OptionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OptionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Talk" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PreviewType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OptionType", propOrder = {
    "talk",
    "previewType"
})
public class OptionType {

    @XmlElement(name = "Talk", required = true)
    protected String talk;
    @XmlElement(name = "PreviewType", required = true)
    protected String previewType;

    /**
     * Gets the value of the talk property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTalk() {
        return talk;
    }

    /**
     * Sets the value of the talk property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTalk(String value) {
        this.talk = value;
    }

    /**
     * Gets the value of the previewType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPreviewType() {
        return previewType;
    }

    /**
     * Sets the value of the previewType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPreviewType(String value) {
        this.previewType = value;
    }

}
