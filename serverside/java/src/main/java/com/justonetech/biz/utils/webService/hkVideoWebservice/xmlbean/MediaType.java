
package com.justonetech.biz.utils.webService.hkVideoWebservice.xmlbean;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for MediaType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MediaType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Vtdu" type="{}VtduType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Protocol" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Stream" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MediaType", propOrder = {
    "vtdu"
})
public class MediaType {

    @XmlElement(name = "Vtdu", required = true)
    protected VtduType vtdu;
    @XmlAttribute(name = "Protocol")
    protected String protocol;
    @XmlAttribute(name = "Stream")
    protected String stream;

    /**
     * Gets the value of the vtdu property.
     * 
     * @return
     *     possible object is
     *     {@link VtduType }
     *
     */
    public VtduType getVtdu() {
        return vtdu;
    }

    /**
     * Sets the value of the vtdu property.
     *
     * @param value
     *     allowed object is
     *     {@link VtduType }
     *     
     */
    public void setVtdu(VtduType value) {
        this.vtdu = value;
    }

    /**
     * Gets the value of the protocol property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProtocol() {
        return protocol;
    }

    /**
     * Sets the value of the protocol property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProtocol(String value) {
        this.protocol = value;
    }

    /**
     * Gets the value of the stream property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStream() {
        return stream;
    }

    /**
     * Sets the value of the stream property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStream(String value) {
        this.stream = value;
    }

}
