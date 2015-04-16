
package com.justonetech.biz.utils.webService.hkVideoWebservice.xmlbean;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for MessageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MessageType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Camera" type="{}CameraType"/>
 *         &lt;element name="Dev" type="{}DevType"/>
 *         &lt;element name="Vag" type="{}VagType"/>
 *         &lt;element name="Voice" type="{}VoiceType"/>
 *         &lt;element name="User" type="{}UserType"/>
 *         &lt;element name="Media" type="{}MediaType"/>
 *         &lt;element name="Privilege" type="{}PrivilegeType"/>
 *         &lt;element name="Option" type="{}OptionType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MessageType", propOrder = {
    "camera",
    "dev",
    "vag",
    "voice",
    "user",
    "media",
    "privilege",
    "option"
})
public class MessageType {

    @XmlElement(name = "Camera", required = true)
    protected CameraType camera;
    @XmlElement(name = "Dev", required = true)
    protected DevType dev;
    @XmlElement(name = "Vag", required = true)
    protected VagType vag;
    @XmlElement(name = "Voice", required = true)
    protected VoiceType voice;
    @XmlElement(name = "User", required = true)
    protected UserType user;
    @XmlElement(name = "Media", required = true)
    protected MediaType media;
    @XmlElement(name = "Privilege", required = true)
    protected PrivilegeType privilege;
    @XmlElement(name = "Option", required = true)
    protected OptionType option;

    /**
     * Gets the value of the camera property.
     * 
     * @return
     *     possible object is
     *     {@link CameraType }
     *     
     */
    public CameraType getCamera() {
        return camera;
    }

    /**
     * Sets the value of the camera property.
     * 
     * @param value
     *     allowed object is
     *     {@link CameraType }
     *     
     */
    public void setCamera(CameraType value) {
        this.camera = value;
    }

    /**
     * Gets the value of the dev property.
     * 
     * @return
     *     possible object is
     *     {@link DevType }
     *
     */
    public DevType getDev() {
        return dev;
    }

    /**
     * Sets the value of the dev property.
     *
     * @param value
     *     allowed object is
     *     {@link DevType }
     *
     */
    public void setDev(DevType value) {
        this.dev = value;
    }

    /**
     * Gets the value of the vag property.
     *
     * @return
     *     possible object is
     *     {@link VagType }
     *
     */
    public VagType getVag() {
        return vag;
    }

    /**
     * Sets the value of the vag property.
     *
     * @param value
     *     allowed object is
     *     {@link VagType }
     *
     */
    public void setVag(VagType value) {
        this.vag = value;
    }

    /**
     * Gets the value of the voice property.
     *
     * @return
     *     possible object is
     *     {@link VoiceType }
     *
     */
    public VoiceType getVoice() {
        return voice;
    }

    /**
     * Sets the value of the voice property.
     *
     * @param value
     *     allowed object is
     *     {@link VoiceType }
     *
     */
    public void setVoice(VoiceType value) {
        this.voice = value;
    }

    /**
     * Gets the value of the user property.
     *
     * @return
     *     possible object is
     *     {@link UserType }
     *
     */
    public UserType getUser() {
        return user;
    }

    /**
     * Sets the value of the user property.
     *
     * @param value
     *     allowed object is
     *     {@link UserType }
     *
     */
    public void setUser(UserType value) {
        this.user = value;
    }

    /**
     * Gets the value of the media property.
     *
     * @return
     *     possible object is
     *     {@link MediaType }
     *
     */
    public MediaType getMedia() {
        return media;
    }

    /**
     * Sets the value of the media property.
     *
     * @param value
     *     allowed object is
     *     {@link MediaType }
     *
     */
    public void setMedia(MediaType value) {
        this.media = value;
    }

    /**
     * Gets the value of the privilege property.
     *
     * @return
     *     possible object is
     *     {@link PrivilegeType }
     *
     */
    public PrivilegeType getPrivilege() {
        return privilege;
    }

    /**
     * Sets the value of the privilege property.
     *
     * @param value
     *     allowed object is
     *     {@link PrivilegeType }
     *     
     */
    public void setPrivilege(PrivilegeType value) {
        this.privilege = value;
    }

    /**
     * Gets the value of the option property.
     * 
     * @return
     *     possible object is
     *     {@link OptionType }
     *     
     */
    public OptionType getOption() {
        return option;
    }

    /**
     * Sets the value of the option property.
     * 
     * @param value
     *     allowed object is
     *     {@link OptionType }
     *     
     */
    public void setOption(OptionType value) {
        this.option = value;
    }

}
