 package com.justonetech.biz.utils.webService.hkVideoWebservice.bean;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


 /**
  * <p>CmsTimingResult complex type的 Java 类。
  *
  * <p>以下模式片段指定包含在此类中的预期内容。
  *
  * <pre>
  * &lt;complexType name="CmsTimingResult">
  *   &lt;complexContent>
  *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
  *       &lt;sequence>
  *         &lt;element name="message" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
  *         &lt;element name="result" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
  *       &lt;/sequence>
  *     &lt;/restriction>
  *   &lt;/complexContent>
  * &lt;/complexType>
  * </pre>
  *
  *
  */
 @XmlAccessorType(XmlAccessType.FIELD)
 @XmlType(name = "CmsTimingResult", propOrder = {
     "message",
     "result"
 })
 public class CmsTimingResult {

     @XmlElementRef(name = "message", namespace = "http://bo.webservice.cms.hikvision.com/xsd", type = JAXBElement.class)
     protected JAXBElement<String> message;
     protected Boolean result;

     /**
      * 获取message属性的值。
      *
      * @return
      *     possible object is
      *     {@link javax.xml.bind.JAXBElement }{@code <}{@link String }{@code >}
      *
      */
     public JAXBElement<String> getMessage() {
         return message;
     }

     /**
      * 设置message属性的值。
      *
      * @param value
      *     allowed object is
      *     {@link javax.xml.bind.JAXBElement }{@code <}{@link String }{@code >}
      *
      */
     public void setMessage(JAXBElement<String> value) {
         this.message = value;
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

 }
