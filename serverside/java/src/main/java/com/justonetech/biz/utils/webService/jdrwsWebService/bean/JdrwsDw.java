
package com.justonetech.biz.utils.webService.jdrwsWebService.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for jdrwsDw complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="jdrwsDw">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dwDm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dwLx" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dwMc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lxr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lxrDh" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "jdrwsDw", propOrder = {
    "dwDm",
    "dwLx",
    "dwMc",
    "lxr",
    "lxrDh"
})
public class JdrwsDw {

    protected String dwDm;
    protected String dwLx;
    protected String dwMc;
    protected String lxr;
    protected String lxrDh;

    /**
     * Gets the value of the dwDm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDwDm() {
        return dwDm;
    }

    /**
     * Sets the value of the dwDm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDwDm(String value) {
        this.dwDm = value;
    }

    /**
     * Gets the value of the dwLx property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDwLx() {
        return dwLx;
    }

    /**
     * Sets the value of the dwLx property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDwLx(String value) {
        this.dwLx = value;
    }

    /**
     * Gets the value of the dwMc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDwMc() {
        return dwMc;
    }

    /**
     * Sets the value of the dwMc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDwMc(String value) {
        this.dwMc = value;
    }

    /**
     * Gets the value of the lxr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLxr() {
        return lxr;
    }

    /**
     * Sets the value of the lxr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLxr(String value) {
        this.lxr = value;
    }

    /**
     * Gets the value of the lxrDh property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLxrDh() {
        return lxrDh;
    }

    /**
     * Sets the value of the lxrDh property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLxrDh(String value) {
        this.lxrDh = value;
    }

}
