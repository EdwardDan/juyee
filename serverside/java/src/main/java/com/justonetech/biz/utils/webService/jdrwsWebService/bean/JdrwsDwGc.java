
package com.justonetech.biz.utils.webService.jdrwsWebService.bean;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for jdrwsDwGc complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="jdrwsDwGc">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="changeTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="dsCs" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="dwgcBh" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dwgcMc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dxCs" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="gcLx" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="jdrwsDwList" type="{http://jdrwsWebService.webService.utils.biz.justonetech.com/}jdrwsDw" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="jgLx" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mj" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="timeflag" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="ts" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="zj" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "jdrwsDwGc", propOrder = {
    "changeTime",
    "dsCs",
    "dwgcBh",
    "dwgcMc",
    "dxCs",
    "gcLx",
    "jdrwsDwList",
    "jgLx",
    "mj",
    "timeflag",
    "ts",
    "zj"
})
public class JdrwsDwGc {

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar changeTime;
    protected int dsCs;
    protected String dwgcBh;
    protected String dwgcMc;
    protected int dxCs;
    protected String gcLx;
    @XmlElement(nillable = true)
    protected List<JdrwsDw> jdrwsDwList;
    protected String jgLx;
    protected Double mj;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar timeflag;
    protected int ts;
    protected Double zj;

    /**
     * Gets the value of the changeTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getChangeTime() {
        return changeTime;
    }

    /**
     * Sets the value of the changeTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setChangeTime(XMLGregorianCalendar value) {
        this.changeTime = value;
    }

    /**
     * Gets the value of the dsCs property.
     * 
     */
    public int getDsCs() {
        return dsCs;
    }

    /**
     * Sets the value of the dsCs property.
     * 
     */
    public void setDsCs(int value) {
        this.dsCs = value;
    }

    /**
     * Gets the value of the dwgcBh property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDwgcBh() {
        return dwgcBh;
    }

    /**
     * Sets the value of the dwgcBh property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDwgcBh(String value) {
        this.dwgcBh = value;
    }

    /**
     * Gets the value of the dwgcMc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDwgcMc() {
        return dwgcMc;
    }

    /**
     * Sets the value of the dwgcMc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDwgcMc(String value) {
        this.dwgcMc = value;
    }

    /**
     * Gets the value of the dxCs property.
     * 
     */
    public int getDxCs() {
        return dxCs;
    }

    /**
     * Sets the value of the dxCs property.
     * 
     */
    public void setDxCs(int value) {
        this.dxCs = value;
    }

    /**
     * Gets the value of the gcLx property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGcLx() {
        return gcLx;
    }

    /**
     * Sets the value of the gcLx property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGcLx(String value) {
        this.gcLx = value;
    }

    /**
     * Gets the value of the jdrwsDwList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the jdrwsDwList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getJdrwsDwList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JdrwsDw }
     * 
     * 
     */
    public List<JdrwsDw> getJdrwsDwList() {
        if (jdrwsDwList == null) {
            jdrwsDwList = new ArrayList<JdrwsDw>();
        }
        return this.jdrwsDwList;
    }

    /**
     * Gets the value of the jgLx property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJgLx() {
        return jgLx;
    }

    /**
     * Sets the value of the jgLx property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJgLx(String value) {
        this.jgLx = value;
    }

    /**
     * Gets the value of the mj property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getMj() {
        return mj;
    }

    /**
     * Sets the value of the mj property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setMj(Double value) {
        this.mj = value;
    }

    /**
     * Gets the value of the timeflag property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTimeflag() {
        return timeflag;
    }

    /**
     * Sets the value of the timeflag property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTimeflag(XMLGregorianCalendar value) {
        this.timeflag = value;
    }

    /**
     * Gets the value of the ts property.
     * 
     */
    public int getTs() {
        return ts;
    }

    /**
     * Sets the value of the ts property.
     * 
     */
    public void setTs(int value) {
        this.ts = value;
    }

    /**
     * Gets the value of the zj property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getZj() {
        return zj;
    }

    /**
     * Sets the value of the zj property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setZj(Double value) {
        this.zj = value;
    }

}
