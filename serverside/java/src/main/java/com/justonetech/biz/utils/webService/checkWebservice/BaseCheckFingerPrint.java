
package com.justonetech.biz.utils.webService.checkWebservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for baseCheckFingerPrint complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="baseCheckFingerPrint">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bioType" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="createTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="createUser" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="deleteTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="deleteUser" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="devSn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fingerVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fingerid" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="guid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="isDelete" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="manager" type="{http://check.webservice.pagd.justonetech.com/}checkManager" minOccurs="0"/>
 *         &lt;element name="template" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="updateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="updateUser" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "baseCheckFingerPrint", propOrder = {
    "bioType",
    "createTime",
    "createUser",
    "deleteTime",
    "deleteUser",
    "devSn",
    "fingerVersion",
    "fingerid",
    "guid",
    "id",
    "isDelete",
    "manager",
    "template",
    "updateTime",
    "updateUser"
})
@XmlSeeAlso({
    CheckFingerPrint.class
})
public abstract class BaseCheckFingerPrint {

    protected Long bioType;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar createTime;
    protected String createUser;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar deleteTime;
    protected String deleteUser;
    protected String devSn;
    protected String fingerVersion;
    protected Long fingerid;
    protected String guid;
    protected Long id;
    protected Boolean isDelete;
    protected CheckManager manager;
    protected String template;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar updateTime;
    protected String updateUser;

    /**
     * Gets the value of the bioType property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getBioType() {
        return bioType;
    }

    /**
     * Sets the value of the bioType property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setBioType(Long value) {
        this.bioType = value;
    }

    /**
     * Gets the value of the createTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreateTime() {
        return createTime;
    }

    /**
     * Sets the value of the createTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreateTime(XMLGregorianCalendar value) {
        this.createTime = value;
    }

    /**
     * Gets the value of the createUser property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * Sets the value of the createUser property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreateUser(String value) {
        this.createUser = value;
    }

    /**
     * Gets the value of the deleteTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDeleteTime() {
        return deleteTime;
    }

    /**
     * Sets the value of the deleteTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDeleteTime(XMLGregorianCalendar value) {
        this.deleteTime = value;
    }

    /**
     * Gets the value of the deleteUser property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeleteUser() {
        return deleteUser;
    }

    /**
     * Sets the value of the deleteUser property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeleteUser(String value) {
        this.deleteUser = value;
    }

    /**
     * Gets the value of the devSn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDevSn() {
        return devSn;
    }

    /**
     * Sets the value of the devSn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDevSn(String value) {
        this.devSn = value;
    }

    /**
     * Gets the value of the fingerVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFingerVersion() {
        return fingerVersion;
    }

    /**
     * Sets the value of the fingerVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFingerVersion(String value) {
        this.fingerVersion = value;
    }

    /**
     * Gets the value of the fingerid property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFingerid() {
        return fingerid;
    }

    /**
     * Sets the value of the fingerid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFingerid(Long value) {
        this.fingerid = value;
    }

    /**
     * Gets the value of the guid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGuid() {
        return guid;
    }

    /**
     * Sets the value of the guid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGuid(String value) {
        this.guid = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setId(Long value) {
        this.id = value;
    }

    /**
     * Gets the value of the isDelete property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsDelete() {
        return isDelete;
    }

    /**
     * Sets the value of the isDelete property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsDelete(Boolean value) {
        this.isDelete = value;
    }

    /**
     * Gets the value of the manager property.
     * 
     * @return
     *     possible object is
     *     {@link CheckManager }
     *     
     */
    public CheckManager getManager() {
        return manager;
    }

    /**
     * Sets the value of the manager property.
     * 
     * @param value
     *     allowed object is
     *     {@link CheckManager }
     *     
     */
    public void setManager(CheckManager value) {
        this.manager = value;
    }

    /**
     * Gets the value of the template property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemplate() {
        return template;
    }

    /**
     * Sets the value of the template property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemplate(String value) {
        this.template = value;
    }

    /**
     * Gets the value of the updateTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getUpdateTime() {
        return updateTime;
    }

    /**
     * Sets the value of the updateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setUpdateTime(XMLGregorianCalendar value) {
        this.updateTime = value;
    }

    /**
     * Gets the value of the updateUser property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUpdateUser() {
        return updateUser;
    }

    /**
     * Sets the value of the updateUser property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUpdateUser(String value) {
        this.updateUser = value;
    }

}
