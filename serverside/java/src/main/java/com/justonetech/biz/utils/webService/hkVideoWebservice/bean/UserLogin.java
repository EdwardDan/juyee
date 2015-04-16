package com.justonetech.biz.utils.webService.hkVideoWebservice.bean;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;


/**
 * <p>anonymous complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="userName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pwd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="clientIp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="clientPort" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="cmsUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "userName",
    "pwd",
    "clientIp",
    "clientPort",
    "cmsUrl"
})
@XmlRootElement(name = "userLogin", namespace = "http://webservice.cms.hikvision.com")
public class UserLogin {

    @XmlElementRef(name = "userName", namespace = "http://webservice.cms.hikvision.com", type = JAXBElement.class)
    protected JAXBElement<String> userName;
    @XmlElementRef(name = "pwd", namespace = "http://webservice.cms.hikvision.com", type = JAXBElement.class)
    protected JAXBElement<String> pwd;
    @XmlElementRef(name = "clientIp", namespace = "http://webservice.cms.hikvision.com", type = JAXBElement.class)
    protected JAXBElement<String> clientIp;
    @XmlElement(namespace = "http://webservice.cms.hikvision.com")
    protected Integer clientPort;
    @XmlElementRef(name = "cmsUrl", namespace = "http://webservice.cms.hikvision.com", type = JAXBElement.class)
    protected JAXBElement<String> cmsUrl;

    /**
     * 获取userName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getUserName() {
        return userName;
    }

    /**
     * 设置userName属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setUserName(JAXBElement<String> value) {
        this.userName = value;
    }

    /**
     * 获取pwd属性的值。
     *
     * @return
     *     possible object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getPwd() {
        return pwd;
    }

    /**
     * 设置pwd属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setPwd(JAXBElement<String> value) {
        this.pwd = value;
    }

    /**
     * 获取clientIp属性的值。
     *
     * @return
     *     possible object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getClientIp() {
        return clientIp;
    }

    /**
     * 设置clientIp属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setClientIp(JAXBElement<String> value) {
        this.clientIp = value;
    }

    /**
     * 获取clientPort属性的值。
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getClientPort() {
        return clientPort;
    }

    /**
     * 设置clientPort属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setClientPort(Integer value) {
        this.clientPort = value;
    }

    /**
     * 获取cmsUrl属性的值。
     *
     * @return
     *     possible object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getCmsUrl() {
        return cmsUrl;
    }

    /**
     * 设置cmsUrl属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCmsUrl(JAXBElement<String> value) {
        this.cmsUrl = value;
    }

}
