
package com.justonetech.biz.utils.webService.hkVideoWebservice.xmlbean;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for DevType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DevType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="IndexCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Addr" type="{}AddrType"/>
 *         &lt;element name="Auth" type="{}AuthType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="regtype" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="devtype" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DevType", propOrder = {
    "id",
    "indexCode",
    "addr",
    "auth"
})
public class DevType {

    @XmlElement(name = "Id", required = true)
    protected String id;
    @XmlElement(name = "IndexCode", required = true)
    protected String indexCode;
    @XmlElement(name = "Addr", required = true)
    protected AddrType addr;
    @XmlElement(name = "Auth", required = true)
    protected AuthType auth;
    @XmlAttribute
    protected String regtype;
    @XmlAttribute
    protected String devtype;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the indexCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndexCode() {
        return indexCode;
    }

    /**
     * Sets the value of the indexCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndexCode(String value) {
        this.indexCode = value;
    }

    /**
     * Gets the value of the addr property.
     * 
     * @return
     *     possible object is
     *     {@link AddrType }
     *     
     */
    public AddrType getAddr() {
        return addr;
    }

    /**
     * Sets the value of the addr property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddrType }
     *     
     */
    public void setAddr(AddrType value) {
        this.addr = value;
    }

    /**
     * Gets the value of the auth property.
     * 
     * @return
     *     possible object is
     *     {@link AuthType }
     *     
     */
    public AuthType getAuth() {
        return auth;
    }

    /**
     * Sets the value of the auth property.
     * 
     * @param value
     *     allowed object is
     *     {@link AuthType }
     *     
     */
    public void setAuth(AuthType value) {
        this.auth = value;
    }

    /**
     * Gets the value of the regtype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegtype() {
        return regtype;
    }

    /**
     * Sets the value of the regtype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegtype(String value) {
        this.regtype = value;
    }

    /**
     * Gets the value of the devtype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDevtype() {
        return devtype;
    }

    /**
     * Sets the value of the devtype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDevtype(String value) {
        this.devtype = value;
    }

}
