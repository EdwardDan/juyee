
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
 * <p>Java class for baseCheckManager complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="baseCheckManager">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cardNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cardSn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="category" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="checkFingerPrints" type="{http://check.webservice.pagd.justonetech.com/}checkFingerPrint" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="checkInfos" type="{http://check.webservice.pagd.justonetech.com/}checkInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="checkManagerPositions" type="{http://check.webservice.pagd.justonetech.com/}checkManagerPosition" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="checkReasons" type="{http://check.webservice.pagd.justonetech.com/}checkReason" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="createTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="createUser" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="deleteTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="deleteUser" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="guid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="idCard" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isDelete" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="mobile" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="photoFile" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sex" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "baseCheckManager", propOrder = {
    "cardNo",
    "cardSn",
    "category",
    "checkFingerPrints",
    "checkInfos",
    "checkManagerPositions",
    "checkReasons",
    "createTime",
    "createUser",
    "deleteTime",
    "deleteUser",
    "guid",
    "id",
    "idCard",
    "isDelete",
    "mobile",
    "name",
    "photoFile",
    "sex",
    "updateTime",
    "updateUser"
})
@XmlSeeAlso({
    CheckManager.class
})
public abstract class BaseCheckManager {

    protected String cardNo;
    protected String cardSn;
    protected String category;
    @XmlElement(nillable = true)
    protected List<CheckFingerPrint> checkFingerPrints;
    @XmlElement(nillable = true)
    protected List<CheckInfo> checkInfos;
    @XmlElement(nillable = true)
    protected List<CheckManagerPosition> checkManagerPositions;
    @XmlElement(nillable = true)
    protected List<CheckReason> checkReasons;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar createTime;
    protected String createUser;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar deleteTime;
    protected String deleteUser;
    protected String guid;
    protected Long id;
    protected String idCard;
    protected Boolean isDelete;
    protected String mobile;
    protected String name;
    protected String photoFile;
    protected String sex;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar updateTime;
    protected String updateUser;

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
     * Gets the value of the cardSn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardSn() {
        return cardSn;
    }

    /**
     * Sets the value of the cardSn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardSn(String value) {
        this.cardSn = value;
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
     * Gets the value of the checkFingerPrints property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the checkFingerPrints property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCheckFingerPrints().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CheckFingerPrint }
     * 
     * 
     */
    public List<CheckFingerPrint> getCheckFingerPrints() {
        if (checkFingerPrints == null) {
            checkFingerPrints = new ArrayList<CheckFingerPrint>();
        }
        return this.checkFingerPrints;
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
     * Gets the value of the checkManagerPositions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the checkManagerPositions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCheckManagerPositions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CheckManagerPosition }
     * 
     * 
     */
    public List<CheckManagerPosition> getCheckManagerPositions() {
        if (checkManagerPositions == null) {
            checkManagerPositions = new ArrayList<CheckManagerPosition>();
        }
        return this.checkManagerPositions;
    }

    /**
     * Gets the value of the checkReasons property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the checkReasons property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCheckReasons().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CheckReason }
     * 
     * 
     */
    public List<CheckReason> getCheckReasons() {
        if (checkReasons == null) {
            checkReasons = new ArrayList<CheckReason>();
        }
        return this.checkReasons;
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
     * Gets the value of the idCard property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * Sets the value of the idCard property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdCard(String value) {
        this.idCard = value;
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
     * Gets the value of the mobile property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * Sets the value of the mobile property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMobile(String value) {
        this.mobile = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
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
     * Gets the value of the sex property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSex() {
        return sex;
    }

    /**
     * Sets the value of the sex property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSex(String value) {
        this.sex = value;
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
