package com.justonetech.biz.utils.webService.hkVideoWebservice.bean;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>CameraDTO complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="CameraDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cameraId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="cameraType" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="chanNum" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="cmsCascadeId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="connectType" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="deviceId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="indexCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="latitude" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="longitude" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="matrixCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pixel" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="privilegeCode" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ptzType" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="recLacation" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="sound" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="streamId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="streamType" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="vrmId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CameraDTO", propOrder = {
    "cameraId",
    "cameraType",
    "chanNum",
    "cmsCascadeId",
    "connectType",
    "deviceId",
    "indexCode",
    "latitude",
    "longitude",
    "matrixCode",
    "name",
    "pixel",
    "privilegeCode",
    "ptzType",
    "recLacation",
    "sound",
    "streamId",
    "streamType",
    "vrmId"
})
public class CameraDTO {

    @XmlElementRef(name = "cameraId", namespace = "http://bo.webservice.cms.hikvision.com/xsd", type = JAXBElement.class)
    protected JAXBElement<Integer> cameraId;
    @XmlElementRef(name = "cameraType", namespace = "http://bo.webservice.cms.hikvision.com/xsd", type = JAXBElement.class)
    protected JAXBElement<Integer> cameraType;
    @XmlElementRef(name = "chanNum", namespace = "http://bo.webservice.cms.hikvision.com/xsd", type = JAXBElement.class)
    protected JAXBElement<Integer> chanNum;
    @XmlElementRef(name = "cmsCascadeId", namespace = "http://bo.webservice.cms.hikvision.com/xsd", type = JAXBElement.class)
    protected JAXBElement<Integer> cmsCascadeId;
    @XmlElementRef(name = "connectType", namespace = "http://bo.webservice.cms.hikvision.com/xsd", type = JAXBElement.class)
    protected JAXBElement<Integer> connectType;
    @XmlElementRef(name = "deviceId", namespace = "http://bo.webservice.cms.hikvision.com/xsd", type = JAXBElement.class)
    protected JAXBElement<Integer> deviceId;
    @XmlElementRef(name = "indexCode", namespace = "http://bo.webservice.cms.hikvision.com/xsd", type = JAXBElement.class)
    protected JAXBElement<String> indexCode;
    @XmlElementRef(name = "latitude", namespace = "http://bo.webservice.cms.hikvision.com/xsd", type = JAXBElement.class)
    protected JAXBElement<Double> latitude;
    @XmlElementRef(name = "longitude", namespace = "http://bo.webservice.cms.hikvision.com/xsd", type = JAXBElement.class)
    protected JAXBElement<Double> longitude;
    @XmlElementRef(name = "matrixCode", namespace = "http://bo.webservice.cms.hikvision.com/xsd", type = JAXBElement.class)
    protected JAXBElement<String> matrixCode;
    @XmlElementRef(name = "name", namespace = "http://bo.webservice.cms.hikvision.com/xsd", type = JAXBElement.class)
    protected JAXBElement<String> name;
    @XmlElementRef(name = "pixel", namespace = "http://bo.webservice.cms.hikvision.com/xsd", type = JAXBElement.class)
    protected JAXBElement<Integer> pixel;
    @XmlElement(nillable = true)
    protected List<Integer> privilegeCode;
    @XmlElementRef(name = "ptzType", namespace = "http://bo.webservice.cms.hikvision.com/xsd", type = JAXBElement.class)
    protected JAXBElement<Integer> ptzType;
    @XmlElement(nillable = true)
    protected List<Integer> recLacation;
    @XmlElementRef(name = "sound", namespace = "http://bo.webservice.cms.hikvision.com/xsd", type = JAXBElement.class)
    protected JAXBElement<Boolean> sound;
    @XmlElementRef(name = "streamId", namespace = "http://bo.webservice.cms.hikvision.com/xsd", type = JAXBElement.class)
    protected JAXBElement<Integer> streamId;
    @XmlElementRef(name = "streamType", namespace = "http://bo.webservice.cms.hikvision.com/xsd", type = JAXBElement.class)
    protected JAXBElement<Integer> streamType;
    @XmlElementRef(name = "vrmId", namespace = "http://bo.webservice.cms.hikvision.com/xsd", type = JAXBElement.class)
    protected JAXBElement<Integer> vrmId;

    /**
     * 获取cameraId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link Integer }{@code >}
     *
     */
    public JAXBElement<Integer> getCameraId() {
        return cameraId;
    }

    /**
     * 设置cameraId属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link Integer }{@code >}
     *
     */
    public void setCameraId(JAXBElement<Integer> value) {
        this.cameraId = value;
    }

    /**
     * 获取cameraType属性的值。
     *
     * @return
     *     possible object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link Integer }{@code >}
     *
     */
    public JAXBElement<Integer> getCameraType() {
        return cameraType;
    }

    /**
     * 设置cameraType属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link Integer }{@code >}
     *
     */
    public void setCameraType(JAXBElement<Integer> value) {
        this.cameraType = value;
    }

    /**
     * 获取chanNum属性的值。
     *
     * @return
     *     possible object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link Integer }{@code >}
     *
     */
    public JAXBElement<Integer> getChanNum() {
        return chanNum;
    }

    /**
     * 设置chanNum属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link Integer }{@code >}
     *
     */
    public void setChanNum(JAXBElement<Integer> value) {
        this.chanNum = value;
    }

    /**
     * 获取cmsCascadeId属性的值。
     *
     * @return
     *     possible object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link Integer }{@code >}
     *
     */
    public JAXBElement<Integer> getCmsCascadeId() {
        return cmsCascadeId;
    }

    /**
     * 设置cmsCascadeId属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link Integer }{@code >}
     *
     */
    public void setCmsCascadeId(JAXBElement<Integer> value) {
        this.cmsCascadeId = value;
    }

    /**
     * 获取connectType属性的值。
     *
     * @return
     *     possible object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link Integer }{@code >}
     *
     */
    public JAXBElement<Integer> getConnectType() {
        return connectType;
    }

    /**
     * 设置connectType属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link Integer }{@code >}
     *
     */
    public void setConnectType(JAXBElement<Integer> value) {
        this.connectType = value;
    }

    /**
     * 获取deviceId属性的值。
     *
     * @return
     *     possible object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link Integer }{@code >}
     *
     */
    public JAXBElement<Integer> getDeviceId() {
        return deviceId;
    }

    /**
     * 设置deviceId属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link Integer }{@code >}
     *
     */
    public void setDeviceId(JAXBElement<Integer> value) {
        this.deviceId = value;
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
     * 获取latitude属性的值。
     *
     * @return
     *     possible object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link Double }{@code >}
     *
     */
    public JAXBElement<Double> getLatitude() {
        return latitude;
    }

    /**
     * 设置latitude属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link Double }{@code >}
     *
     */
    public void setLatitude(JAXBElement<Double> value) {
        this.latitude = value;
    }

    /**
     * 获取longitude属性的值。
     *
     * @return
     *     possible object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link Double }{@code >}
     *
     */
    public JAXBElement<Double> getLongitude() {
        return longitude;
    }

    /**
     * 设置longitude属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link Double }{@code >}
     *
     */
    public void setLongitude(JAXBElement<Double> value) {
        this.longitude = value;
    }

    /**
     * 获取matrixCode属性的值。
     *
     * @return
     *     possible object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getMatrixCode() {
        return matrixCode;
    }

    /**
     * 设置matrixCode属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setMatrixCode(JAXBElement<String> value) {
        this.matrixCode = value;
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
     * 获取pixel属性的值。
     *
     * @return
     *     possible object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link Integer }{@code >}
     *
     */
    public JAXBElement<Integer> getPixel() {
        return pixel;
    }

    /**
     * 设置pixel属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link Integer }{@code >}
     *
     */
    public void setPixel(JAXBElement<Integer> value) {
        this.pixel = value;
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
     * 获取ptzType属性的值。
     *
     * @return
     *     possible object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link Integer }{@code >}
     *
     */
    public JAXBElement<Integer> getPtzType() {
        return ptzType;
    }

    /**
     * 设置ptzType属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link Integer }{@code >}
     *
     */
    public void setPtzType(JAXBElement<Integer> value) {
        this.ptzType = value;
    }

    /**
     * Gets the value of the recLacation property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the recLacation property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRecLacation().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Integer }
     *
     *
     */
    public List<Integer> getRecLacation() {
        if (recLacation == null) {
            recLacation = new ArrayList<Integer>();
        }
        return this.recLacation;
    }

    /**
     * 获取sound属性的值。
     *
     * @return
     *     possible object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link Boolean }{@code >}
     *
     */
    public JAXBElement<Boolean> getSound() {
        return sound;
    }

    /**
     * 设置sound属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link Boolean }{@code >}
     *
     */
    public void setSound(JAXBElement<Boolean> value) {
        this.sound = value;
    }

    /**
     * 获取streamId属性的值。
     *
     * @return
     *     possible object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link Integer }{@code >}
     *
     */
    public JAXBElement<Integer> getStreamId() {
        return streamId;
    }

    /**
     * 设置streamId属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link Integer }{@code >}
     *
     */
    public void setStreamId(JAXBElement<Integer> value) {
        this.streamId = value;
    }

    /**
     * 获取streamType属性的值。
     *
     * @return
     *     possible object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link Integer }{@code >}
     *
     */
    public JAXBElement<Integer> getStreamType() {
        return streamType;
    }

    /**
     * 设置streamType属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link Integer }{@code >}
     *
     */
    public void setStreamType(JAXBElement<Integer> value) {
        this.streamType = value;
    }

    /**
     * 获取vrmId属性的值。
     *
     * @return
     *     possible object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link Integer }{@code >}
     *
     */
    public JAXBElement<Integer> getVrmId() {
        return vrmId;
    }

    /**
     * 设置vrmId属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setVrmId(JAXBElement<Integer> value) {
        this.vrmId = value;
    }

}
