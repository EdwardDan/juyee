<?xml version="1.0" encoding="utf-8"?>
<wsdl:definitions xmlns:s="http://www.w3.org/2001/XMLSchema" xmlns:soap12="http://schemas.xmlsoap.org/wsdl/soap12/" xmlns:mime="http://schemas.xmlsoap.org/wsdl/mime/" xmlns:tns="http://tempuri.org/" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:tm="http://microsoft.com/wsdl/mime/textMatching/" xmlns:http="http://schemas.xmlsoap.org/wsdl/http/" xmlns:soapenc="http://schemas.xmlsoap.org/soap/encoding/" targetNamespace="http://tempuri.org/" xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">
  <wsdl:types>
    <s:schema elementFormDefault="qualified" targetNamespace="http://tempuri.org/">
      <s:element name="HelloWorld">
        <s:complexType />
      </s:element>
      <s:element name="HelloWorldResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="HelloWorldResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetJdrwsByBjbh">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="bjbh" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetJdrwsByBjbhResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetJdrwsByBjbhResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetGcmxByJdrwsbh">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="jdrwsbh" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetGcmxByJdrwsbhResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetGcmxByJdrwsbhResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
    </s:schema>
  </wsdl:types>
  <wsdl:message name="HelloWorldSoapIn">
    <wsdl:part name="parameters" element="tns:HelloWorld" />
  </wsdl:message>
  <wsdl:message name="HelloWorldSoapOut">
    <wsdl:part name="parameters" element="tns:HelloWorldResponse" />
  </wsdl:message>
  <wsdl:message name="GetJdrwsByBjbhSoapIn">
    <wsdl:part name="parameters" element="tns:GetJdrwsByBjbh" />
  </wsdl:message>
  <wsdl:message name="GetJdrwsByBjbhSoapOut">
    <wsdl:part name="parameters" element="tns:GetJdrwsByBjbhResponse" />
  </wsdl:message>
  <wsdl:message name="GetGcmxByJdrwsbhSoapIn">
    <wsdl:part name="parameters" element="tns:GetGcmxByJdrwsbh" />
  </wsdl:message>
  <wsdl:message name="GetGcmxByJdrwsbhSoapOut">
    <wsdl:part name="parameters" element="tns:GetGcmxByJdrwsbhResponse" />
  </wsdl:message>
  <wsdl:portType name="IntegratedServiceSoap">
    <wsdl:operation name="HelloWorld">
      <wsdl:input message="tns:HelloWorldSoapIn" />
      <wsdl:output message="tns:HelloWorldSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetJdrwsByBjbh">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">根据报建编号获得监督任务书信息</wsdl:documentation>
      <wsdl:input message="tns:GetJdrwsByBjbhSoapIn" />
      <wsdl:output message="tns:GetJdrwsByBjbhSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetGcmxByJdrwsbh">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">根据监督任务书编号获得单位工程信息</wsdl:documentation>
      <wsdl:input message="tns:GetGcmxByJdrwsbhSoapIn" />
      <wsdl:output message="tns:GetGcmxByJdrwsbhSoapOut" />
    </wsdl:operation>
  </wsdl:portType>
  <wsdl:binding name="IntegratedServiceSoap" type="tns:IntegratedServiceSoap">
    <soap:binding transport="http://schemas.xmlsoap.org/soap/http" />
    <wsdl:operation name="HelloWorld">
      <soap:operation soapAction="http://tempuri.org/HelloWorld" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetJdrwsByBjbh">
      <soap:operation soapAction="http://tempuri.org/GetJdrwsByBjbh" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetGcmxByJdrwsbh">
      <soap:operation soapAction="http://tempuri.org/GetGcmxByJdrwsbh" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
  </wsdl:binding>
  <wsdl:binding name="IntegratedServiceSoap12" type="tns:IntegratedServiceSoap">
    <soap12:binding transport="http://schemas.xmlsoap.org/soap/http" />
    <wsdl:operation name="HelloWorld">
      <soap12:operation soapAction="http://tempuri.org/HelloWorld" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetJdrwsByBjbh">
      <soap12:operation soapAction="http://tempuri.org/GetJdrwsByBjbh" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetGcmxByJdrwsbh">
      <soap12:operation soapAction="http://tempuri.org/GetGcmxByJdrwsbh" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
  </wsdl:binding>
  <wsdl:service name="IntegratedService">
    <wsdl:port name="IntegratedServiceSoap" binding="tns:IntegratedServiceSoap">
      <soap:address location="http://ciacdata.ciac.sh.cn/Service/IntegratedService.asmx" />
    </wsdl:port>
    <wsdl:port name="IntegratedServiceSoap12" binding="tns:IntegratedServiceSoap12">
      <soap12:address location="http://ciacdata.ciac.sh.cn/Service/IntegratedService.asmx" />
    </wsdl:port>
  </wsdl:service>
</wsdl:definitions>