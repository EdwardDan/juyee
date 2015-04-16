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
 *         &lt;element name="return" type="{http://bo.webservice.cms.hikvision.com/xsd}RegionInfoResult" minOccurs="0"/>
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
    "_return"
})
@XmlRootElement(name = "getAllRegionInfoForListResponse", namespace = "http://webservice.cms.hikvision.com")
public class GetAllRegionInfoForListResponse {

    @XmlElementRef(name = "return", namespace = "http://webservice.cms.hikvision.com", type = JAXBElement.class)
    protected JAXBElement<RegionInfoResult> _return;

    /**
     * 获取return属性的值。
     * 
     * @return
     *     possible object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link RegionInfoResult }{@code >}
     *
     */
    public JAXBElement<RegionInfoResult> getReturn() {
        return _return;
    }

    /**
     * 设置return属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link RegionInfoResult }{@code >}
     *     
     */
    public void setReturn(JAXBElement<RegionInfoResult> value) {
        this._return = value;
    }

}
