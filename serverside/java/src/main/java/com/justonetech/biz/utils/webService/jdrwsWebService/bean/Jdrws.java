
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
 * <p>Java class for jdrws complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="jdrws">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bdh" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bjbh" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bz" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="changeTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="dataId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="gcdd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="htj" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="jdDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="jdrwsBh" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="jdrwsDwGcList" type="{http://jdrwsWebService.webService.utils.biz.justonetech.com/}jdrwsDwGc" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="jdrwsDwList" type="{http://jdrwsWebService.webService.utils.biz.justonetech.com/}jdrwsDw" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="jsdw" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="jsdwDm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="jsdwDz" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lxr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lxrDh" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="szqx" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="timeflag" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="xmlx" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="xmmc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="yzbm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "jdrws", propOrder = {
    "bdh",
    "bjbh",
    "bz",
    "changeTime",
    "dataId",
    "gcdd",
    "htj",
    "jdDateTime",
    "jdrwsBh",
    "jdrwsDwGcList",
    "jdrwsDwList",
    "jsdw",
    "jsdwDm",
    "jsdwDz",
    "lxr",
    "lxrDh",
    "status",
    "szqx",
    "timeflag",
    "xmlx",
    "xmmc",
    "yzbm"
})
public class Jdrws {

    protected String bdh;
    protected String bjbh;
    protected String bz;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar changeTime;
    protected Long dataId;
    protected String gcdd;
    protected Double htj;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar jdDateTime;
    protected String jdrwsBh;
    @XmlElement(nillable = true)
    protected List<JdrwsDwGc> jdrwsDwGcList;
    @XmlElement(nillable = true)
    protected List<JdrwsDw> jdrwsDwList;
    protected String jsdw;
    protected String jsdwDm;
    protected String jsdwDz;
    protected String lxr;
    protected String lxrDh;
    protected String status;
    protected String szqx;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar timeflag;
    protected String xmlx;
    protected String xmmc;
    protected String yzbm;

    /**
     * Gets the value of the bdh property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBdh() {
        return bdh;
    }

    /**
     * Sets the value of the bdh property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBdh(String value) {
        this.bdh = value;
    }

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
     * Gets the value of the bz property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBz() {
        return bz;
    }

    /**
     * Sets the value of the bz property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBz(String value) {
        this.bz = value;
    }

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
     * Gets the value of the dataId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDataId() {
        return dataId;
    }

    /**
     * Sets the value of the dataId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDataId(Long value) {
        this.dataId = value;
    }

    /**
     * Gets the value of the gcdd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGcdd() {
        return gcdd;
    }

    /**
     * Sets the value of the gcdd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGcdd(String value) {
        this.gcdd = value;
    }

    /**
     * Gets the value of the htj property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getHtj() {
        return htj;
    }

    /**
     * Sets the value of the htj property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setHtj(Double value) {
        this.htj = value;
    }

    /**
     * Gets the value of the jdDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getJdDateTime() {
        return jdDateTime;
    }

    /**
     * Sets the value of the jdDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setJdDateTime(XMLGregorianCalendar value) {
        this.jdDateTime = value;
    }

    /**
     * Gets the value of the jdrwsBh property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJdrwsBh() {
        return jdrwsBh;
    }

    /**
     * Sets the value of the jdrwsBh property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJdrwsBh(String value) {
        this.jdrwsBh = value;
    }

    /**
     * Gets the value of the jdrwsDwGcList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the jdrwsDwGcList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getJdrwsDwGcList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JdrwsDwGc }
     * 
     * 
     */
    public List<JdrwsDwGc> getJdrwsDwGcList() {
        if (jdrwsDwGcList == null) {
            jdrwsDwGcList = new ArrayList<JdrwsDwGc>();
        }
        return this.jdrwsDwGcList;
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
     * Gets the value of the jsdw property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJsdw() {
        return jsdw;
    }

    /**
     * Sets the value of the jsdw property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJsdw(String value) {
        this.jsdw = value;
    }

    /**
     * Gets the value of the jsdwDm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJsdwDm() {
        return jsdwDm;
    }

    /**
     * Sets the value of the jsdwDm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJsdwDm(String value) {
        this.jsdwDm = value;
    }

    /**
     * Gets the value of the jsdwDz property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJsdwDz() {
        return jsdwDz;
    }

    /**
     * Sets the value of the jsdwDz property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJsdwDz(String value) {
        this.jsdwDz = value;
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

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the szqx property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSzqx() {
        return szqx;
    }

    /**
     * Sets the value of the szqx property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSzqx(String value) {
        this.szqx = value;
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
     * Gets the value of the xmlx property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXmlx() {
        return xmlx;
    }

    /**
     * Sets the value of the xmlx property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXmlx(String value) {
        this.xmlx = value;
    }

    /**
     * Gets the value of the xmmc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXmmc() {
        return xmmc;
    }

    /**
     * Sets the value of the xmmc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXmmc(String value) {
        this.xmmc = value;
    }

    /**
     * Gets the value of the yzbm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getYzbm() {
        return yzbm;
    }

    /**
     * Sets the value of the yzbm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setYzbm(String value) {
        this.yzbm = value;
    }

}
