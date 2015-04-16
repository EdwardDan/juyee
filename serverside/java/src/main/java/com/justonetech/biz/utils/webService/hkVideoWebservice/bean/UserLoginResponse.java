package com.justonetech.biz.utils.webService.hkVideoWebservice.bean;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;


/**
 * <p>anonymous complex type鐨�Java 绫汇�
 * 
 * <p>浠ヤ笅妯″紡鐗囨鎸囧畾鍖呭惈鍦ㄦ绫讳腑鐨勯鏈熷唴瀹广�
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://bo.webservice.cms.hikvision.com/xsd}LoginResult" minOccurs="0"/>
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
@XmlRootElement(name = "userLoginResponse", namespace = "http://webservice.cms.hikvision.com")
public class UserLoginResponse {

    @XmlElementRef(name = "return", namespace = "http://webservice.cms.hikvision.com", type = JAXBElement.class)
    protected JAXBElement<LoginResult> _return;

    /**
     * 鑾峰彇return灞炴�鐨勫�銆�
     * 
     * @return
     *     possible object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link LoginResult }{@code >}
     *
     */
    public JAXBElement<LoginResult> getReturn() {
        return _return;
    }

    /**
     * 璁剧疆return灞炴�鐨勫�銆�
     *
     * @param value
     *     allowed object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link LoginResult }{@code >}
     *     
     */
    public void setReturn(JAXBElement<LoginResult> value) {
        this._return = value;
    }

}
