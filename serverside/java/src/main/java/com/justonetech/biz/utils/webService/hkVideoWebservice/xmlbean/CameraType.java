
package com.justonetech.biz.utils.webService.hkVideoWebservice.xmlbean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CameraType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CameraType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="IndexCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ChanNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Matrix" type="{}MatrixType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CameraType", propOrder = {
    "id",
    "indexCode",
    "name",
    "chanNo",
    "matrix"
})
public class CameraType {

    @XmlElement(name = "Id", required = true)
    protected String id;
    @XmlElement(name = "IndexCode", required = true)
    protected String indexCode;
    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElement(name = "ChanNo", required = true)
    protected String chanNo;
    @XmlElement(name = "Matrix", required = true)
    protected MatrixType matrix;

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
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the chanNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChanNo() {
        return chanNo;
    }

    /**
     * Sets the value of the chanNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChanNo(String value) {
        this.chanNo = value;
    }

    /**
     * Gets the value of the matrix property.
     * 
     * @return
     *     possible object is
     *     {@link MatrixType }
     *     
     */
    public MatrixType getMatrix() {
        return matrix;
    }

    /**
     * Sets the value of the matrix property.
     * 
     * @param value
     *     allowed object is
     *     {@link MatrixType }
     *     
     */
    public void setMatrix(MatrixType value) {
        this.matrix = value;
    }

}
