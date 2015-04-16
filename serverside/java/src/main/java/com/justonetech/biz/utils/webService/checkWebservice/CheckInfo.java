
package com.justonetech.biz.utils.webService.checkWebservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for checkInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="checkInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{http://check.webservice.pagd.justonetech.com/}baseCheckInfo">
 *       &lt;sequence>
 *         &lt;element name="belongArea" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="devGuid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="managerGuid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="photo" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="photoString" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="startInx" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "checkInfo", propOrder = {
    "belongArea",
    "devGuid",
    "managerGuid",
    "photo",
    "photoString",
    "startInx"
})
public class CheckInfo
    extends BaseCheckInfo
{

    protected String belongArea;
    protected String devGuid;
    protected String managerGuid;
    protected byte[] photo;
    protected String photoString;
    protected long startInx;

    /**
     * Gets the value of the belongArea property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBelongArea() {
        return belongArea;
    }

    /**
     * Sets the value of the belongArea property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBelongArea(String value) {
        this.belongArea = value;
    }

    /**
     * Gets the value of the devGuid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDevGuid() {
        return devGuid;
    }

    /**
     * Sets the value of the devGuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDevGuid(String value) {
        this.devGuid = value;
    }

    /**
     * Gets the value of the managerGuid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getManagerGuid() {
        return managerGuid;
    }

    /**
     * Sets the value of the managerGuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setManagerGuid(String value) {
        this.managerGuid = value;
    }

    /**
     * Gets the value of the photo property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getPhoto() {
        return photo;
    }

    /**
     * Sets the value of the photo property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setPhoto(byte[] value) {
        this.photo = value;
    }

    /**
     * Gets the value of the photoString property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhotoString() {
        return photoString;
    }

    /**
     * Sets the value of the photoString property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhotoString(String value) {
        this.photoString = value;
    }

    /**
     * Gets the value of the startInx property.
     * 
     */
    public long getStartInx() {
        return startInx;
    }

    /**
     * Sets the value of the startInx property.
     * 
     */
    public void setStartInx(long value) {
        this.startInx = value;
    }

}
