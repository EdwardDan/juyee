
package com.justonetech.biz.utils.webService.monitorWebService;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.justonetech.biz.utils.webService.monitorWebService package.
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetMonitorService_QNAME = new QName("http://monitor.webservice.pagd.justonetech.com/", "getMonitorService");
    private final static QName _GetMonitorServiceResponse_QNAME = new QName("http://monitor.webservice.pagd.justonetech.com/", "getMonitorServiceResponse");
    private final static QName _GetMonitorList_QNAME = new QName("http://monitor.webservice.pagd.justonetech.com/", "getMonitorList");
    private final static QName _GetMonitorListResponse_QNAME = new QName("http://monitor.webservice.pagd.justonetech.com/", "getMonitorListResponse");
    private final static QName _Exception_QNAME = new QName("http://monitor.webservice.pagd.justonetech.com/", "Exception");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.justonetech.biz.utils.webService.monitorWebService
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link GetMonitorListResponse }
     * 
     */
    public GetMonitorListResponse createGetMonitorListResponse() {
        return new GetMonitorListResponse();
    }

    /**
     * Create an instance of {@link GetMonitorServiceResponse }
     * 
     */
    public GetMonitorServiceResponse createGetMonitorServiceResponse() {
        return new GetMonitorServiceResponse();
    }

    /**
     * Create an instance of {@link GetMonitorService }
     * 
     */
    public GetMonitorService createGetMonitorService() {
        return new GetMonitorService();
    }

    /**
     * Create an instance of {@link GetMonitorList }
     * 
     */
    public GetMonitorList createGetMonitorList() {
        return new GetMonitorList();
    }

    /**
     * Create an instance of {@link Monitor }
     * 
     */
    public Monitor createMonitor() {
        return new Monitor();
    }

    /**
     * Create an instance of {@link MonitorParam }
     * 
     */
    public MonitorParam createMonitorParam() {
        return new MonitorParam();
    }

    /**
     * Create an instance of {@link MonitorService }
     * 
     */
    public MonitorService createMonitorService() {
        return new MonitorService();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMonitorService }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://monitor.webservice.pagd.justonetech.com/", name = "getMonitorService")
    public JAXBElement<GetMonitorService> createGetMonitorService(GetMonitorService value) {
        return new JAXBElement<GetMonitorService>(_GetMonitorService_QNAME, GetMonitorService.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMonitorServiceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://monitor.webservice.pagd.justonetech.com/", name = "getMonitorServiceResponse")
    public JAXBElement<GetMonitorServiceResponse> createGetMonitorServiceResponse(GetMonitorServiceResponse value) {
        return new JAXBElement<GetMonitorServiceResponse>(_GetMonitorServiceResponse_QNAME, GetMonitorServiceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMonitorList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://monitor.webservice.pagd.justonetech.com/", name = "getMonitorList")
    public JAXBElement<GetMonitorList> createGetMonitorList(GetMonitorList value) {
        return new JAXBElement<GetMonitorList>(_GetMonitorList_QNAME, GetMonitorList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMonitorListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://monitor.webservice.pagd.justonetech.com/", name = "getMonitorListResponse")
    public JAXBElement<GetMonitorListResponse> createGetMonitorListResponse(GetMonitorListResponse value) {
        return new JAXBElement<GetMonitorListResponse>(_GetMonitorListResponse_QNAME, GetMonitorListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://monitor.webservice.pagd.justonetech.com/", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
    }

}
