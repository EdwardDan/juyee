
package com.justonetech.biz.utils.webService.checkWebservice;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for baseCheckDeviceInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="baseCheckDeviceInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cancelDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="cancelStatus" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="cancelUserName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="category" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="checkInfos" type="{http://check.webservice.pagd.justonetech.com/}checkInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="createTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="createUser" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="deleteTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="deleteUser" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="devIp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="devMode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="devName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="devSim" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="devSn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gdCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="guid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="isDelete" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="lastOnlineTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="latitude" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="longitude" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="onlineStatus" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="positionLatitude" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="positionLongitude" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="positionTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="regDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="regUserName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "baseCheckDeviceInfo", propOrder = {
    "cancelDateTime",
    "cancelStatus",
    "cancelUserName",
    "category",
    "checkInfos",
    "createTime",
    "createUser",
    "deleteTime",
    "deleteUser",
    "devIp",
    "devMode",
    "devName",
    "devSim",
    "devSn",
    "gdCode",
    "guid",
    "id",
    "isDelete",
    "lastOnlineTime",
    "latitude",
    "longitude",
    "onlineStatus",
    "positionLatitude",
    "positionLongitude",
    "positionTime",
    "regDateTime",
    "regUserName",
    "updateTime",
    "updateUser"
})
@XmlSeeAlso({
    CheckDeviceInfo.class
})
public abstract class BaseCheckDeviceInfo {

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar cancelDateTime;
    protected Long cancelStatus;
    protected String cancelUserName;
    protected String category;
    @XmlElement(nillable = true)
    protected List<CheckInfo> checkInfos;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar createTime;
    protected String createUser;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar deleteTime;
    protected String deleteUser;
    protected String devIp;
    protected String devMode;
    protected String devName;
    protected String devSim;
    protected String devSn;
    protected String gdCode;
    protected String guid;
    protected Long id;
    protected Boolean isDelete;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastOnlineTime;
    protected Double latitude;
    protected Double longitude;
    protected Long onlineStatus;
    protected Double positionLatitude;
    protected Double positionLongitude;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar positionTime;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar regDateTime;
    protected String regUserName;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar updateTime;
    protected String updateUser;

    /**
     * Gets the value of the cancelDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCancelDateTime() {
        return cancelDateTime;
    }

    /**
     * Sets the value of the cancelDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCancelDateTime(XMLGregorianCalendar value) {
        this.cancelDateTime = value;
    }

    /**
     * Gets the value of the cancelStatus property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCancelStatus() {
        return cancelStatus;
    }

    /**
     * Sets the value of the cancelStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCancelStatus(Long value) {
        this.cancelStatus = value;
    }

    /**
     * Gets the value of the cancelUserName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCancelUserName() {
        return cancelUserName;
    }

    /**
     * Sets the value of the cancelUserName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCancelUserName(String value) {
        this.cancelUserName = value;
    }

    /**
     * Gets the value of the category property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets the value of the category property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCategory(String value) {
        this.category = value;
    }

    /**
     * Gets the value of the checkInfos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the checkInfos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCheckInfos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CheckInfo }
     * 
     * 
     */
    public List<CheckInfo> getCheckInfos() {
        if (checkInfos == null) {
            checkInfos = new ArrayList<CheckInfo>();
        }
        return this.checkInfos;
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
     * Gets the value of the devIp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDevIp() {
        return devIp;
    }

    /**
     * Sets the value of the devIp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDevIp(String value) {
        this.devIp = value;
    }

    /**
     * Gets the value of the devMode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDevMode() {
        return devMode;
    }

    /**
     * Sets the value of the devMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDevMode(String value) {
        this.devMode = value;
    }

    /**
     * Gets the value of the devName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDevName() {
        return devName;
    }

    /**
     * Sets the value of the devName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDevName(String value) {
        this.devName = value;
    }

    /**
     * Gets the value of the devSim property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDevSim() {
        return devSim;
    }

    /**
     * Sets the value of the devSim property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDevSim(String value) {
        this.devSim = value;
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
     * Gets the value of the lastOnlineTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLastOnlineTime() {
        return lastOnlineTime;
    }

    /**
     * Sets the value of the lastOnlineTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLastOnlineTime(XMLGregorianCalendar value) {
        this.lastOnlineTime = value;
    }

    /**
     * Gets the value of the latitude property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getLatitude() {
        return latitude;
    }

    /**
     * Sets the value of the latitude property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setLatitude(Double value) {
        this.latitude = value;
    }

    /**
     * Gets the value of the longitude property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getLongitude() {
        return longitude;
    }

    /**
     * Sets the value of the longitude property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setLongitude(Double value) {
        this.longitude = value;
    }

    /**
     * Gets the value of the onlineStatus property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getOnlineStatus() {
        return onlineStatus;
    }

    /**
     * Sets the value of the onlineStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setOnlineStatus(Long value) {
        this.onlineStatus = value;
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
     * Gets the value of the regDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getRegDateTime() {
        return regDateTime;
    }

    /**
     * Sets the value of the regDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setRegDateTime(XMLGregorianCalendar value) {
        this.regDateTime = value;
    }

    /**
     * Gets the value of the regUserName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegUserName() {
        return regUserName;
    }

    /**
     * Sets the value of the regUserName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegUserName(String value) {
        this.regUserName = value;
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
