package com.justonetech.biz.utils.webService.hkVideoWebservice.bean;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>MagServerDTO complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="MagServerDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bTrans" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="controlUnitId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="createTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="ctrlPort" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="indexCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ipAddr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="magServerId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="netAgentPort" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="netZoneId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="operatorId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="outBitRate" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="outEncodeType" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="outFrameRate" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="outResolution" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="port" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="strXmlRev" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="subStream" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
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
@XmlType(name = "MagServerDTO", propOrder = {
    "bTrans",
    "controlUnitId",
    "createTime",
    "ctrlPort",
    "indexCode",
    "ipAddr",
    "magServerId",
    "name",
    "netAgentPort",
    "netZoneId",
    "operatorId",
    "outBitRate",
    "outEncodeType",
    "outFrameRate",
    "outResolution",
    "port",
    "strXmlRev",
    "subStream",
    "updateTime"
})
public class MagServerDTO {

    @XmlElementRef(name = "bTrans", namespace = "http://bo.webservice.cms.hikvision.com/xsd", type = JAXBElement.class)
    protected JAXBElement<Integer> bTrans;
    @XmlElementRef(name = "controlUnitId", namespace = "http://bo.webservice.cms.hikvision.com/xsd", type = JAXBElement.class)
    protected JAXBElement<Integer> controlUnitId;
    @XmlElementRef(name = "createTime", namespace = "http://bo.webservice.cms.hikvision.com/xsd", type = JAXBElement.class)
    protected JAXBElement<XMLGregorianCalendar> createTime;
    @XmlElementRef(name = "ctrlPort", namespace = "http://bo.webservice.cms.hikvision.com/xsd", type = JAXBElement.class)
    protected JAXBElement<Integer> ctrlPort;
    @XmlElementRef(name = "indexCode", namespace = "http://bo.webservice.cms.hikvision.com/xsd", type = JAXBElement.class)
    protected JAXBElement<String> indexCode;
    @XmlElementRef(name = "ipAddr", namespace = "http://bo.webservice.cms.hikvision.com/xsd", type = JAXBElement.class)
    protected JAXBElement<String> ipAddr;
    @XmlElementRef(name = "magServerId", namespace = "http://bo.webservice.cms.hikvision.com/xsd", type = JAXBElement.class)
    protected JAXBElement<Integer> magServerId;
    @XmlElementRef(name = "name", namespace = "http://bo.webservice.cms.hikvision.com/xsd", type = JAXBElement.class)
    protected JAXBElement<String> name;
    @XmlElementRef(name = "netAgentPort", namespace = "http://bo.webservice.cms.hikvision.com/xsd", type = JAXBElement.class)
    protected JAXBElement<Integer> netAgentPort;
    @XmlElementRef(name = "netZoneId", namespace = "http://bo.webservice.cms.hikvision.com/xsd", type = JAXBElement.class)
    protected JAXBElement<Integer> netZoneId;
    @XmlElementRef(name = "operatorId", namespace = "http://bo.webservice.cms.hikvision.com/xsd", type = JAXBElement.class)
    protected JAXBElement<Integer> operatorId;
    @XmlElementRef(name = "outBitRate", namespace = "http://bo.webservice.cms.hikvision.com/xsd", type = JAXBElement.class)
    protected JAXBElement<Integer> outBitRate;
    @XmlElementRef(name = "outEncodeType", namespace = "http://bo.webservice.cms.hikvision.com/xsd", type = JAXBElement.class)
    protected JAXBElement<Integer> outEncodeType;
    @XmlElementRef(name = "outFrameRate", namespace = "http://bo.webservice.cms.hikvision.com/xsd", type = JAXBElement.class)
    protected JAXBElement<Integer> outFrameRate;
    @XmlElementRef(name = "outResolution", namespace = "http://bo.webservice.cms.hikvision.com/xsd", type = JAXBElement.class)
    protected JAXBElement<Integer> outResolution;
    @XmlElementRef(name = "port", namespace = "http://bo.webservice.cms.hikvision.com/xsd", type = JAXBElement.class)
    protected JAXBElement<Integer> port;
    @XmlElementRef(name = "strXmlRev", namespace = "http://bo.webservice.cms.hikvision.com/xsd", type = JAXBElement.class)
    protected JAXBElement<String> strXmlRev;
    @XmlElementRef(name = "subStream", namespace = "http://bo.webservice.cms.hikvision.com/xsd", type = JAXBElement.class)
    protected JAXBElement<Integer> subStream;
    @XmlElementRef(name = "updateTime", namespace = "http://bo.webservice.cms.hikvision.com/xsd", type = JAXBElement.class)
    protected JAXBElement<XMLGregorianCalendar> updateTime;

    /**
     * 获取bTrans属性的值。
     * 
     * @return
     *     possible object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link Integer }{@code >}
     *
     */
    public JAXBElement<Integer> getBTrans() {
        return bTrans;
    }

    /**
     * 设置bTrans属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link Integer }{@code >}
     *
     */
    public void setBTrans(JAXBElement<Integer> value) {
        this.bTrans = value;
    }

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
     * 获取magServerId属性的值。
     *
     * @return
     *     possible object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link Integer }{@code >}
     *
     */
    public JAXBElement<Integer> getMagServerId() {
        return magServerId;
    }

    /**
     * 设置magServerId属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link Integer }{@code >}
     *
     */
    public void setMagServerId(JAXBElement<Integer> value) {
        this.magServerId = value;
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
     * 获取netZoneId属性的值。
     *
     * @return
     *     possible object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link Integer }{@code >}
     *
     */
    public JAXBElement<Integer> getNetZoneId() {
        return netZoneId;
    }

    /**
     * 设置netZoneId属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link Integer }{@code >}
     *
     */
    public void setNetZoneId(JAXBElement<Integer> value) {
        this.netZoneId = value;
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
     * 获取outBitRate属性的值。
     *
     * @return
     *     possible object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link Integer }{@code >}
     *
     */
    public JAXBElement<Integer> getOutBitRate() {
        return outBitRate;
    }

    /**
     * 设置outBitRate属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link Integer }{@code >}
     *
     */
    public void setOutBitRate(JAXBElement<Integer> value) {
        this.outBitRate = value;
    }

    /**
     * 获取outEncodeType属性的值。
     *
     * @return
     *     possible object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link Integer }{@code >}
     *
     */
    public JAXBElement<Integer> getOutEncodeType() {
        return outEncodeType;
    }

    /**
     * 设置outEncodeType属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link Integer }{@code >}
     *
     */
    public void setOutEncodeType(JAXBElement<Integer> value) {
        this.outEncodeType = value;
    }

    /**
     * 获取outFrameRate属性的值。
     *
     * @return
     *     possible object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link Integer }{@code >}
     *
     */
    public JAXBElement<Integer> getOutFrameRate() {
        return outFrameRate;
    }

    /**
     * 设置outFrameRate属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link Integer }{@code >}
     *
     */
    public void setOutFrameRate(JAXBElement<Integer> value) {
        this.outFrameRate = value;
    }

    /**
     * 获取outResolution属性的值。
     *
     * @return
     *     possible object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link Integer }{@code >}
     *
     */
    public JAXBElement<Integer> getOutResolution() {
        return outResolution;
    }

    /**
     * 设置outResolution属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link Integer }{@code >}
     *
     */
    public void setOutResolution(JAXBElement<Integer> value) {
        this.outResolution = value;
    }

    /**
     * 获取port属性的值。
     *
     * @return
     *     possible object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link Integer }{@code >}
     *
     */
    public JAXBElement<Integer> getPort() {
        return port;
    }

    /**
     * 设置port属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link Integer }{@code >}
     *
     */
    public void setPort(JAXBElement<Integer> value) {
        this.port = value;
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
     * 获取subStream属性的值。
     *
     * @return
     *     possible object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link Integer }{@code >}
     *
     */
    public JAXBElement<Integer> getSubStream() {
        return subStream;
    }

    /**
     * 设置subStream属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link Integer }{@code >}
     *
     */
    public void setSubStream(JAXBElement<Integer> value) {
        this.subStream = value;
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
