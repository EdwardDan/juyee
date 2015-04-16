package com.justonetech.biz.utils.webService.hkVideoWebservice.bean;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>ServerResult complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ServerResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="alarmServerDTOArray" type="{http://bo.webservice.cms.hikvision.com/xsd}AlarmServerDTO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="crossingServerArray" type="{http://crossing.bo.webservice.cms.hikvision.com/xsd}CrossingServerInfoDTO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="errorCode" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="interAreaArray" type="{http://bo.webservice.cms.hikvision.com/xsd}InterAreaDTO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="magServerArray" type="{http://bo.webservice.cms.hikvision.com/xsd}MagServerDTO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="networkMonitorServerArray" type="{http://bo.webservice.cms.hikvision.com/xsd}NetworkMonitorServerDTO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="pagServerArray" type="{http://bo.webservice.cms.hikvision.com/xsd}PagServerDTO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="pcnvrServerArray" type="{http://bo.webservice.cms.hikvision.com/xsd}PcnvrServerDTO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ptzServerArray" type="{http://bo.webservice.cms.hikvision.com/xsd}PtzServerDTO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="result" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="strXmlRev" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="streamServerDTOArray" type="{http://bo.webservice.cms.hikvision.com/xsd}StreamServerDTO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="talkServerArray" type="{http://bo.webservice.cms.hikvision.com/xsd}TalkServerDTO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="vrbServerArray" type="{http://bo.webservice.cms.hikvision.com/xsd}VrbServerDTO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="vrmServerDTOArray" type="{http://bo.webservice.cms.hikvision.com/xsd}VrmServerDTO" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServerResult", propOrder = {
    "alarmServerDTOArray",
    "crossingServerArray",
    "errorCode",
    "interAreaArray",
    "magServerArray",
    "networkMonitorServerArray",
    "pagServerArray",
    "pcnvrServerArray",
    "ptzServerArray",
    "result",
    "strXmlRev",
    "streamServerDTOArray",
    "talkServerArray",
    "vrbServerArray",
    "vrmServerDTOArray"
})
public class ServerResult {

    @XmlElement(nillable = true)
    protected List<AlarmServerDTO> alarmServerDTOArray;
    @XmlElement(nillable = true)
    protected List<CrossingServerInfoDTO> crossingServerArray;
    protected Integer errorCode;
    @XmlElement(nillable = true)
    protected List<InterAreaDTO> interAreaArray;
    @XmlElement(nillable = true)
    protected List<MagServerDTO> magServerArray;
    @XmlElement(nillable = true)
    protected List<NetworkMonitorServerDTO> networkMonitorServerArray;
    @XmlElement(nillable = true)
    protected List<PagServerDTO> pagServerArray;
    @XmlElement(nillable = true)
    protected List<PcnvrServerDTO> pcnvrServerArray;
    @XmlElement(nillable = true)
    protected List<PtzServerDTO> ptzServerArray;
    protected Boolean result;
    @XmlElementRef(name = "strXmlRev", namespace = "http://bo.webservice.cms.hikvision.com/xsd", type = JAXBElement.class)
    protected JAXBElement<String> strXmlRev;
    @XmlElement(nillable = true)
    protected List<StreamServerDTO> streamServerDTOArray;
    @XmlElement(nillable = true)
    protected List<TalkServerDTO> talkServerArray;
    @XmlElement(nillable = true)
    protected List<VrbServerDTO> vrbServerArray;
    @XmlElement(nillable = true)
    protected List<VrmServerDTO> vrmServerDTOArray;

    /**
     * Gets the value of the alarmServerDTOArray property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the alarmServerDTOArray property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAlarmServerDTOArray().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AlarmServerDTO }
     *
     *
     */
    public List<AlarmServerDTO> getAlarmServerDTOArray() {
        if (alarmServerDTOArray == null) {
            alarmServerDTOArray = new ArrayList<AlarmServerDTO>();
        }
        return this.alarmServerDTOArray;
    }

    /**
     * Gets the value of the crossingServerArray property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the crossingServerArray property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCrossingServerArray().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CrossingServerInfoDTO }
     *
     *
     */
    public List<CrossingServerInfoDTO> getCrossingServerArray() {
        if (crossingServerArray == null) {
            crossingServerArray = new ArrayList<CrossingServerInfoDTO>();
        }
        return this.crossingServerArray;
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
     * Gets the value of the interAreaArray property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the interAreaArray property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInterAreaArray().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InterAreaDTO }
     *
     *
     */
    public List<InterAreaDTO> getInterAreaArray() {
        if (interAreaArray == null) {
            interAreaArray = new ArrayList<InterAreaDTO>();
        }
        return this.interAreaArray;
    }

    /**
     * Gets the value of the magServerArray property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the magServerArray property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMagServerArray().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MagServerDTO }
     *
     *
     */
    public List<MagServerDTO> getMagServerArray() {
        if (magServerArray == null) {
            magServerArray = new ArrayList<MagServerDTO>();
        }
        return this.magServerArray;
    }

    /**
     * Gets the value of the networkMonitorServerArray property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the networkMonitorServerArray property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNetworkMonitorServerArray().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NetworkMonitorServerDTO }
     *
     *
     */
    public List<NetworkMonitorServerDTO> getNetworkMonitorServerArray() {
        if (networkMonitorServerArray == null) {
            networkMonitorServerArray = new ArrayList<NetworkMonitorServerDTO>();
        }
        return this.networkMonitorServerArray;
    }

    /**
     * Gets the value of the pagServerArray property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pagServerArray property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPagServerArray().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PagServerDTO }
     *
     *
     */
    public List<PagServerDTO> getPagServerArray() {
        if (pagServerArray == null) {
            pagServerArray = new ArrayList<PagServerDTO>();
        }
        return this.pagServerArray;
    }

    /**
     * Gets the value of the pcnvrServerArray property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pcnvrServerArray property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPcnvrServerArray().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PcnvrServerDTO }
     *
     *
     */
    public List<PcnvrServerDTO> getPcnvrServerArray() {
        if (pcnvrServerArray == null) {
            pcnvrServerArray = new ArrayList<PcnvrServerDTO>();
        }
        return this.pcnvrServerArray;
    }

    /**
     * Gets the value of the ptzServerArray property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ptzServerArray property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPtzServerArray().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PtzServerDTO }
     *
     *
     */
    public List<PtzServerDTO> getPtzServerArray() {
        if (ptzServerArray == null) {
            ptzServerArray = new ArrayList<PtzServerDTO>();
        }
        return this.ptzServerArray;
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
     * Gets the value of the streamServerDTOArray property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the streamServerDTOArray property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStreamServerDTOArray().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StreamServerDTO }
     *
     *
     */
    public List<StreamServerDTO> getStreamServerDTOArray() {
        if (streamServerDTOArray == null) {
            streamServerDTOArray = new ArrayList<StreamServerDTO>();
        }
        return this.streamServerDTOArray;
    }

    /**
     * Gets the value of the talkServerArray property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the talkServerArray property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTalkServerArray().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TalkServerDTO }
     * 
     * 
     */
    public List<TalkServerDTO> getTalkServerArray() {
        if (talkServerArray == null) {
            talkServerArray = new ArrayList<TalkServerDTO>();
        }
        return this.talkServerArray;
    }

    /**
     * Gets the value of the vrbServerArray property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vrbServerArray property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVrbServerArray().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VrbServerDTO }
     * 
     * 
     */
    public List<VrbServerDTO> getVrbServerArray() {
        if (vrbServerArray == null) {
            vrbServerArray = new ArrayList<VrbServerDTO>();
        }
        return this.vrbServerArray;
    }

    /**
     * Gets the value of the vrmServerDTOArray property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vrmServerDTOArray property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVrmServerDTOArray().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VrmServerDTO }
     * 
     * 
     */
    public List<VrmServerDTO> getVrmServerDTOArray() {
        if (vrmServerDTOArray == null) {
            vrmServerDTOArray = new ArrayList<VrmServerDTO>();
        }
        return this.vrmServerDTOArray;
    }

}
