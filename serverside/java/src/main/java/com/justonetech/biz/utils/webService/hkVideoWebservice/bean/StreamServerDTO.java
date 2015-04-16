package com.justonetech.biz.utils.webService.hkVideoWebservice.bean;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>StreamServerDTO complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="StreamServerDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="controlUnitId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="createTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="ctrlPort" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="indexCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="intRev1" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="intRev2" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="ipAddr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="netAgentPort" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="operatorId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="relativePath" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="rtpTcpBasePort" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="rtpUdpBasePort" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="rtspPort" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="secondIp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sequenceIdx" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="shareFlag" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *         &lt;element name="strRev1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="strRev2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="strXmlRev" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="streamSvId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="udpPortCount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="updateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StreamServerDTO", propOrder = {
    "controlUnitId",
    "createTime",
    "ctrlPort",
    "indexCode",
    "intRev1",
    "intRev2",
    "ipAddr",
    "name",
    "netAgentPort",
    "operatorId",
    "relativePath",
    "rtpTcpBasePort",
    "rtpUdpBasePort",
    "rtspPort",
    "secondIp",
    "sequenceIdx",
    "shareFlag",
    "strRev1",
    "strRev2",
    "strXmlRev",
    "streamSvId",
    "udpPortCount",
    "updateTime"
})
public class StreamServerDTO {

    @XmlElementRef(name = "controlUnitId", namespace = "http://bo.webservice.cms.hikvision.com/xsd", type = JAXBElement.class)
    protected JAXBElement<Integer> controlUnitId;
    @XmlElementRef(name = "createTime", namespace = "http://bo.webservice.cms.hikvision.com/xsd", type = JAXBElement.class)
    protected JAXBElement<XMLGregorianCalendar> createTime;
    @XmlElementRef(name = "ctrlPort", namespace = "http://bo.webservice.cms.hikvision.com/xsd", type = JAXBElement.class)
    protected JAXBElement<Integer> ctrlPort;
    @XmlElementRef(name = "indexCode", namespace = "http://bo.webservice.cms.hikvision.com/xsd", type = JAXBElement.class)
    protected JAXBElement<String> indexCode;
    @XmlElementRef(name = "intRev1", namespace = "http://bo.webservice.cms.hikvision.com/xsd", type = JAXBElement.class)
    protected JAXBElement<Integer> intRev1;
    @XmlElementRef(name = "intRev2", namespace = "http://bo.webservice.cms.hikvision.com/xsd", type = JAXBElement.class)
    protected JAXBElement<Integer> intRev2;
    @XmlElementRef(name = "ipAddr", namespace = "http://bo.webservice.cms.hikvision.com/xsd", type = JAXBElement.class)
    protected JAXBElement<String> ipAddr;
    @XmlElementRef(name = "name", namespace = "http://bo.webservice.cms.hikvision.com/xsd", type = JAXBElement.class)
    protected JAXBElement<String> name;
    @XmlElementRef(name = "netAgentPort", namespace = "http://bo.webservice.cms.hikvision.com/xsd", type = JAXBElement.class)
    protected JAXBElement<Integer> netAgentPort;
    @XmlElementRef(name = "operatorId", namespace = "http://bo.webservice.cms.hikvision.com/xsd", type = JAXBElement.class)
    protected JAXBElement<Integer> operatorId;
    @XmlElementRef(name = "relativePath", namespace = "http://bo.webservice.cms.hikvision.com/xsd", type = JAXBElement.class)
    protected JAXBElement<String> relativePath;
    @XmlElementRef(name = "rtpTcpBasePort", namespace = "http://bo.webservice.cms.hikvision.com/xsd", type = JAXBElement.class)
    protected JAXBElement<Integer> rtpTcpBasePort;
    @XmlElementRef(name = "rtpUdpBasePort", namespace = "http://bo.webservice.cms.hikvision.com/xsd", type = JAXBElement.class)
    protected JAXBElement<Integer> rtpUdpBasePort;
    @XmlElementRef(name = "rtspPort", namespace = "http://bo.webservice.cms.hikvision.com/xsd", type = JAXBElement.class)
    protected JAXBElement<Integer> rtspPort;
    @XmlElementRef(name = "secondIp", namespace = "http://bo.webservice.cms.hikvision.com/xsd", type = JAXBElement.class)
    protected JAXBElement<String> secondIp;
    @XmlElementRef(name = "sequenceIdx", namespace = "http://bo.webservice.cms.hikvision.com/xsd", type = JAXBElement.class)
    protected JAXBElement<Integer> sequenceIdx;
    @XmlElementRef(name = "shareFlag", namespace = "http://bo.webservice.cms.hikvision.com/xsd", type = JAXBElement.class)
    protected JAXBElement<Short> shareFlag;
    @XmlElementRef(name = "strRev1", namespace = "http://bo.webservice.cms.hikvision.com/xsd", type = JAXBElement.class)
    protected JAXBElement<String> strRev1;
    @XmlElementRef(name = "strRev2", namespace = "http://bo.webservice.cms.hikvision.com/xsd", type = JAXBElement.class)
    protected JAXBElement<String> strRev2;
    @XmlElementRef(name = "strXmlRev", namespace = "http://bo.webservice.cms.hikvision.com/xsd", type = JAXBElement.class)
    protected JAXBElement<String> strXmlRev;
    @XmlElementRef(name = "streamSvId", namespace = "http://bo.webservice.cms.hikvision.com/xsd", type = JAXBElement.class)
    protected JAXBElement<Integer> streamSvId;
    @XmlElementRef(name = "udpPortCount", namespace = "http://bo.webservice.cms.hikvision.com/xsd", type = JAXBElement.class)
    protected JAXBElement<Integer> udpPortCount;
    @XmlElementRef(name = "updateTime", namespace = "http://bo.webservice.cms.hikvision.com/xsd", type = JAXBElement.class)
    protected JAXBElement<XMLGregorianCalendar> updateTime;

    /**
     * 获取controlUnitId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link Integer }{@code >}
     *
     */
    public JAXBElement<Integer> getControlUnitId() {
        return controlUnitId;
    }

    /**
     * 设置controlUnitId属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link Integer }{@code >}
     *
     */
    public void setControlUnitId(JAXBElement<Integer> value) {
        this.controlUnitId = value;
    }

    /**
     * 获取createTime属性的值。
     *
     * @return
     *     possible object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link javax.xml.datatype.XMLGregorianCalendar }{@code >}
     *
     */
    public JAXBElement<XMLGregorianCalendar> getCreateTime() {
        return createTime;
    }

    /**
     * 设置createTime属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link javax.xml.datatype.XMLGregorianCalendar }{@code >}
     *
     */
    public void setCreateTime(JAXBElement<XMLGregorianCalendar> value) {
        this.createTime = value;
    }

    /**
     * 获取ctrlPort属性的值。
     *
     * @return
     *     possible object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link Integer }{@code >}
     *
     */
    public JAXBElement<Integer> getCtrlPort() {
        return ctrlPort;
    }

    /**
     * 设置ctrlPort属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link Integer }{@code >}
     *
     */
    public void setCtrlPort(JAXBElement<Integer> value) {
        this.ctrlPort = value;
    }

    /**
     * 获取indexCode属性的值。
     *
     * @return
     *     possible object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getIndexCode() {
        return indexCode;
    }

    /**
     * 设置indexCode属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setIndexCode(JAXBElement<String> value) {
        this.indexCode = value;
    }

    /**
     * 获取intRev1属性的值。
     *
     * @return
     *     possible object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link Integer }{@code >}
     *
     */
    public JAXBElement<Integer> getIntRev1() {
        return intRev1;
    }

    /**
     * 设置intRev1属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link Integer }{@code >}
     *
     */
    public void setIntRev1(JAXBElement<Integer> value) {
        this.intRev1 = value;
    }

    /**
     * 获取intRev2属性的值。
     *
     * @return
     *     possible object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link Integer }{@code >}
     *
     */
    public JAXBElement<Integer> getIntRev2() {
        return intRev2;
    }

    /**
     * 设置intRev2属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link Integer }{@code >}
     *
     */
    public void setIntRev2(JAXBElement<Integer> value) {
        this.intRev2 = value;
    }

    /**
     * 获取ipAddr属性的值。
     *
     * @return
     *     possible object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getIpAddr() {
        return ipAddr;
    }

    /**
     * 设置ipAddr属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setIpAddr(JAXBElement<String> value) {
        this.ipAddr = value;
    }

    /**
     * 获取name属性的值。
     *
     * @return
     *     possible object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getName() {
        return name;
    }

    /**
     * 设置name属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setName(JAXBElement<String> value) {
        this.name = value;
    }

    /**
     * 获取netAgentPort属性的值。
     *
     * @return
     *     possible object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link Integer }{@code >}
     *
     */
    public JAXBElement<Integer> getNetAgentPort() {
        return netAgentPort;
    }

    /**
     * 设置netAgentPort属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link Integer }{@code >}
     *
     */
    public void setNetAgentPort(JAXBElement<Integer> value) {
        this.netAgentPort = value;
    }

    /**
     * 获取operatorId属性的值。
     *
     * @return
     *     possible object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link Integer }{@code >}
     *
     */
    public JAXBElement<Integer> getOperatorId() {
        return operatorId;
    }

    /**
     * 设置operatorId属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link Integer }{@code >}
     *
     */
    public void setOperatorId(JAXBElement<Integer> value) {
        this.operatorId = value;
    }

    /**
     * 获取relativePath属性的值。
     *
     * @return
     *     possible object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getRelativePath() {
        return relativePath;
    }

    /**
     * 设置relativePath属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setRelativePath(JAXBElement<String> value) {
        this.relativePath = value;
    }

    /**
     * 获取rtpTcpBasePort属性的值。
     *
     * @return
     *     possible object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link Integer }{@code >}
     *
     */
    public JAXBElement<Integer> getRtpTcpBasePort() {
        return rtpTcpBasePort;
    }

    /**
     * 设置rtpTcpBasePort属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link Integer }{@code >}
     *
     */
    public void setRtpTcpBasePort(JAXBElement<Integer> value) {
        this.rtpTcpBasePort = value;
    }

    /**
     * 获取rtpUdpBasePort属性的值。
     *
     * @return
     *     possible object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link Integer }{@code >}
     *
     */
    public JAXBElement<Integer> getRtpUdpBasePort() {
        return rtpUdpBasePort;
    }

    /**
     * 设置rtpUdpBasePort属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link Integer }{@code >}
     *
     */
    public void setRtpUdpBasePort(JAXBElement<Integer> value) {
        this.rtpUdpBasePort = value;
    }

    /**
     * 获取rtspPort属性的值。
     *
     * @return
     *     possible object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link Integer }{@code >}
     *
     */
    public JAXBElement<Integer> getRtspPort() {
        return rtspPort;
    }

    /**
     * 设置rtspPort属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link Integer }{@code >}
     *
     */
    public void setRtspPort(JAXBElement<Integer> value) {
        this.rtspPort = value;
    }

    /**
     * 获取secondIp属性的值。
     *
     * @return
     *     possible object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getSecondIp() {
        return secondIp;
    }

    /**
     * 设置secondIp属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setSecondIp(JAXBElement<String> value) {
        this.secondIp = value;
    }

    /**
     * 获取sequenceIdx属性的值。
     *
     * @return
     *     possible object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link Integer }{@code >}
     *
     */
    public JAXBElement<Integer> getSequenceIdx() {
        return sequenceIdx;
    }

    /**
     * 设置sequenceIdx属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link Integer }{@code >}
     *
     */
    public void setSequenceIdx(JAXBElement<Integer> value) {
        this.sequenceIdx = value;
    }

    /**
     * 获取shareFlag属性的值。
     *
     * @return
     *     possible object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link Short }{@code >}
     *
     */
    public JAXBElement<Short> getShareFlag() {
        return shareFlag;
    }

    /**
     * 设置shareFlag属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link Short }{@code >}
     *
     */
    public void setShareFlag(JAXBElement<Short> value) {
        this.shareFlag = value;
    }

    /**
     * 获取strRev1属性的值。
     *
     * @return
     *     possible object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getStrRev1() {
        return strRev1;
    }

    /**
     * 设置strRev1属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setStrRev1(JAXBElement<String> value) {
        this.strRev1 = value;
    }

    /**
     * 获取strRev2属性的值。
     *
     * @return
     *     possible object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getStrRev2() {
        return strRev2;
    }

    /**
     * 设置strRev2属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setStrRev2(JAXBElement<String> value) {
        this.strRev2 = value;
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
     * 获取streamSvId属性的值。
     *
     * @return
     *     possible object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link Integer }{@code >}
     *
     */
    public JAXBElement<Integer> getStreamSvId() {
        return streamSvId;
    }

    /**
     * 设置streamSvId属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link Integer }{@code >}
     *
     */
    public void setStreamSvId(JAXBElement<Integer> value) {
        this.streamSvId = value;
    }

    /**
     * 获取udpPortCount属性的值。
     *
     * @return
     *     possible object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link Integer }{@code >}
     *
     */
    public JAXBElement<Integer> getUdpPortCount() {
        return udpPortCount;
    }

    /**
     * 设置udpPortCount属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link Integer }{@code >}
     *
     */
    public void setUdpPortCount(JAXBElement<Integer> value) {
        this.udpPortCount = value;
    }

    /**
     * 获取updateTime属性的值。
     *
     * @return
     *     possible object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link javax.xml.datatype.XMLGregorianCalendar }{@code >}
     *
     */
    public JAXBElement<XMLGregorianCalendar> getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置updateTime属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link javax.xml.datatype.XMLGregorianCalendar }{@code >}
     *     
     */
    public void setUpdateTime(JAXBElement<XMLGregorianCalendar> value) {
        this.updateTime = value;
    }

}
