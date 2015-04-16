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
 *         &lt;element name="sessionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="req" type="{http://bo.webservice.cms.hikvision.com/xsd}PlaybackParamReq" minOccurs="0"/>
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
    "sessionId",
    "req"
})
@XmlRootElement(name = "getPlaybackParam", namespace = "http://webservice.cms.hikvision.com")
public class GetPlaybackParam {

    @XmlElementRef(name = "sessionId", namespace = "http://webservice.cms.hikvision.com", type = JAXBElement.class)
    protected JAXBElement<String> sessionId;
    @XmlElementRef(name = "req", namespace = "http://webservice.cms.hikvision.com", type = JAXBElement.class)
    protected JAXBElement<PlaybackParamReq> req;

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
     * 获取req属性的值。
     *
     * @return
     *     possible object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link PlaybackParamReq }{@code >}
     *
     */
    public JAXBElement<PlaybackParamReq> getReq() {
        return req;
    }

    /**
     * 设置req属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link PlaybackParamReq }{@code >}
     *     
     */
    public void setReq(JAXBElement<PlaybackParamReq> value) {
        this.req = value;
    }

}
