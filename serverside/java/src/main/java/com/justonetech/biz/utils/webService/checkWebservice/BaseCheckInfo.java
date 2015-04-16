
package com.justonetech.biz.utils.webService.checkWebservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for baseCheckInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="baseCheckInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cardNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="checkStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="checkTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="createTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="createUser" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="deleteTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="deleteUser" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dev" type="{http://check.webservice.pagd.justonetech.com/}checkDeviceInfo" minOccurs="0"/>
 *         &lt;element name="devSn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gdCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="guid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="isDelete" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="manager" type="{http://check.webservice.pagd.justonetech.com/}checkManager" minOccurs="0"/>
 *         &lt;element name="managerName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="photoFile" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="positionLatitude" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="positionLongitude" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="positionTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="updateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="updateUser" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="verifyCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "baseCheckInfo", propOrder = {
    "cardNo",
    "checkStatus",
    "checkTime",
    "createTime",
    "createUser",
    "deleteTime",
    "deleteUser",
    "dev",
    "devSn",
    "gdCode",
    "guid",
    "id",
    "isDelete",
    "manager",
    "managerName",
    "photoFile",
    "positionLatitude",
    "positionLongitude",
    "positionTime",
    "updateTime",
    "updateUser",
    "verifyCode"
})
@XmlSeeAlso({
    CheckInfo.class
})
public abstract class BaseCheckInfo {

    protected String cardNo;
    protected String checkStatus;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar checkTime;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar createTime;
    protected String createUser;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar deleteTime;
    protected String deleteUser;
    protected CheckDeviceInfo dev;
    protected String devSn;
    protected String gdCode;
    protected String guid;
    protected Long id;
    protected Boolean isDelete;
    protected CheckManager manager;
    protected String managerName;
    protected String photoFile;
    protected Double positionLatitude;
    protected Double positionLongitude;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar positionTime;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar updateTime;
    protected String updateUser;
    protected String verifyCode;

    /**
     * Gets the value of the cardNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardNo() {
        return cardNo;
    }

    /**
     * Sets the value of the cardNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardNo(String value) {
        this.cardNo = value;
    }

    /**
     * Gets the value of the checkStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCheckStatus() {
        return checkStatus;
    }

    /**
     * Sets the value of the checkStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCheckStatus(String value) {
        this.checkStatus = value;
    }

    /**
     * Gets the value of the checkTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCheckTime() {
        return checkTime;
    }

    /**
     * Sets the value of the checkTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCheckTime(XMLGregorianCalendar value) {
        this.checkTime = value;
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
     * Gets the value of the dev property.
     * 
     * @return
     *     possible object is
     *     {@link CheckDeviceInfo }
     *     
     */
    public CheckDeviceInfo getDev() {
        return dev;
    }

    /**
     * Sets the value of the dev property.
     * 
     * @param value
     *     allowed object is
     *     {@link CheckDeviceInfo }
     *     
     */
    public void setDev(CheckDeviceInfo value) {
        this.dev = value;
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
     * Gets the value of the gdCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGdCode() {
        return gdCode;
    }

    /**
     * Sets the value of the gdCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGdCode(String value) {
        this.gdCode = value;
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
     * Gets the value of the managerName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getManagerName() {
        return managerName;
    }

    /**
     * Sets the value of the managerName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setManagerName(String value) {
        this.managerName = value;
    }

    /**
     * Gets the value of the photoFile property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhotoFile() {
        return photoFile;
    }

    /**
     * Sets the value of the photoFile property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhotoFile(String value) {
        this.photoFile = value;
    }

    /**
     * Gets the value of the positionLatitude property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getPositionLatitude() {
        return positionLatitude;
    }

    /**
     * Sets the value of the positionLatitude property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setPositionLatitude(Double value) {
        this.positionLatitude = value;
    }

    /**
     * Gets the value of the positionLongitude property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getPositionLongitude() {
        return positionLongitude;
    }

    /**
     * Sets the value of the positionLongitude property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setPositionLongitude(Double value) {
        this.positionLongitude = value;
    }

    /**
     * Gets the value of the positionTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPositionTime() {
        return positionTime;
    }

    /**
     * Sets the value of the positionTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPositionTime(XMLGregorianCalendar value) {
        this.positionTime = value;
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

    /**
     * Gets the value of the verifyCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVerifyCode() {
        return verifyCode;
    }

    /**
     * Sets the value of the verifyCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVerifyCode(String value) {
        this.verifyCode = value;
    }

}
