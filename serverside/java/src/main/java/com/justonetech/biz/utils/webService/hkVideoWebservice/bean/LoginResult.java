package com.justonetech.biz.utils.webService.hkVideoWebservice.bean;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>LoginResult complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="LoginResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="controlUnitId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="errorCode" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="ipType" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="outNetCmsUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="outNetUserName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="outNetUserPwd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="priority" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="privilegeCode" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="result" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="sessionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="strXmlRev" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LoginResult", propOrder = {
    "controlUnitId",
    "errorCode",
    "ipType",
    "outNetCmsUrl",
    "outNetUserName",
    "outNetUserPwd",
    "priority",
    "privilegeCode",
    "result",
    "sessionId",
    "strXmlRev",
    "userId"
})
public class LoginResult {

    protected Integer controlUnitId;
    protected Integer errorCode;
    protected Integer ipType;
    @XmlElementRef(name = "outNetCmsUrl", namespace = "http://bo.webservice.cms.hikvision.com/xsd", type = JAXBElement.class)
    protected JAXBElement<String> outNetCmsUrl;
    @XmlElementRef(name = "outNetUserName", namespace = "http://bo.webservice.cms.hikvision.com/xsd", type = JAXBElement.class)
    protected JAXBElement<String> outNetUserName;
    @XmlElementRef(name = "outNetUserPwd", namespace = "http://bo.webservice.cms.hikvision.com/xsd", type = JAXBElement.class)
    protected JAXBElement<String> outNetUserPwd;
    protected Integer priority;
    @XmlElement(nillable = true)
    protected List<Integer> privilegeCode;
    protected Boolean result;
    @XmlElementRef(name = "sessionId", namespace = "http://bo.webservice.cms.hikvision.com/xsd", type = JAXBElement.class)
    protected JAXBElement<String> sessionId;
    @XmlElementRef(name = "strXmlRev", namespace = "http://bo.webservice.cms.hikvision.com/xsd", type = JAXBElement.class)
    protected JAXBElement<String> strXmlRev;
    protected Integer userId;

    /**
     * 获取controlUnitId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getControlUnitId() {
        return controlUnitId;
    }

    /**
     * 设置controlUnitId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setControlUnitId(Integer value) {
        this.controlUnitId = value;
    }

    /**
     * 获取errorCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getErrorCode() {
        return errorCode;
    }

    /**
     * 设置errorCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setErrorCode(Integer value) {
        this.errorCode = value;
    }

    /**
     * 获取ipType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIpType() {
        return ipType;
    }

    /**
     * 设置ipType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIpType(Integer value) {
        this.ipType = value;
    }

    /**
     * 获取outNetCmsUrl属性的值。
     * 
     * @return
     *     possible object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getOutNetCmsUrl() {
        return outNetCmsUrl;
    }

    /**
     * 设置outNetCmsUrl属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setOutNetCmsUrl(JAXBElement<String> value) {
        this.outNetCmsUrl = value;
    }

    /**
     * 获取outNetUserName属性的值。
     *
     * @return
     *     possible object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getOutNetUserName() {
        return outNetUserName;
    }

    /**
     * 设置outNetUserName属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setOutNetUserName(JAXBElement<String> value) {
        this.outNetUserName = value;
    }

    /**
     * 获取outNetUserPwd属性的值。
     *
     * @return
     *     possible object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getOutNetUserPwd() {
        return outNetUserPwd;
    }

    /**
     * 设置outNetUserPwd属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setOutNetUserPwd(JAXBElement<String> value) {
        this.outNetUserPwd = value;
    }

    /**
     * 获取priority属性的值。
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getPriority() {
        return priority;
    }

    /**
     * 设置priority属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setPriority(Integer value) {
        this.priority = value;
    }

    /**
     * Gets the value of the privilegeCode property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the privilegeCode property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPrivilegeCode().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Integer }
     *
     *
     */
    public List<Integer> getPrivilegeCode() {
        if (privilegeCode == null) {
            privilegeCode = new ArrayList<Integer>();
        }
        return this.privilegeCode;
    }

    /**
     * 获取result属性的值。
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean isResult() {
        return result;
    }

    /**
     * 设置result属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setResult(Boolean value) {
        this.result = value;
    }

    /**
     * 获取sessionId属性的值。
     *
     * @return
     *     possible object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getSessionId() {
        return sessionId;
    }

    /**
     * 设置sessionId属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setSessionId(JAXBElement<String> value) {
        this.sessionId = value;
    }

    /**
     * 获取strXmlRev属性的值。
     *
     * @return
     *     possible object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getStrXmlRev() {
        return strXmlRev;
    }

    /**
     * 设置strXmlRev属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setStrXmlRev(JAXBElement<String> value) {
        this.strXmlRev = value;
    }

    /**
     * 获取userId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置userId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setUserId(Integer value) {
        this.userId = value;
    }

}
