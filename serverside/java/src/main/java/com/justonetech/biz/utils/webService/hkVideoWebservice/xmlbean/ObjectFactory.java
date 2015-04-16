
package com.justonetech.biz.utils.webService.hkVideoWebservice.xmlbean;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.justonetech.biz.utils.webService.hkVideoWebservice.xmlbean package. 
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

    private final static QName _Message_QNAME = new QName("", "Message");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.justonetech.biz.utils.webService.hkVideoWebservice.xmlbean
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddrType }
     * 
     */
    public AddrType createAddrType() {
        return new AddrType();
    }

    /**
     * Create an instance of {@link MatrixType }
     * 
     */
    public MatrixType createMatrixType() {
        return new MatrixType();
    }

    /**
     * Create an instance of {@link VagType }
     * 
     */
    public VagType createVagType() {
        return new VagType();
    }

    /**
     * Create an instance of {@link AuthType }
     * 
     */
    public AuthType createAuthType() {
        return new AuthType();
    }

    /**
     * Create an instance of {@link PrivilegeType }
     *
     */
    public PrivilegeType createPrivilegeType() {
        return new PrivilegeType();
    }

    /**
     * Create an instance of {@link VoiceType }
     *
     */
    public VoiceType createVoiceType() {
        return new VoiceType();
    }

    /**
     * Create an instance of {@link DevType }
     *
     */
    public DevType createDevType() {
        return new DevType();
    }

    /**
     * Create an instance of {@link MessageType }
     *
     */
    public MessageType createMessageType() {
        return new MessageType();
    }

    /**
     * Create an instance of {@link CameraType }
     *
     */
    public CameraType createCameraType() {
        return new CameraType();
    }

    /**
     * Create an instance of {@link MediaType }
     *
     */
    public MediaType createMediaType() {
        return new MediaType();
    }

    /**
     * Create an instance of {@link OptionType }
     *
     */
    public OptionType createOptionType() {
        return new OptionType();
    }

    /**
     * Create an instance of {@link VtduType }
     *
     */
    public VtduType createVtduType() {
        return new VtduType();
    }

    /**
     * Create an instance of {@link UserType }
     *
     */
    public UserType createUserType() {
        return new UserType();
    }

    /**
     * Create an instance of {@link javax.xml.bind.JAXBElement }{@code <}{@link MessageType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Message")
    public JAXBElement<MessageType> createMessage(MessageType value) {
        return new JAXBElement<MessageType>(_Message_QNAME, MessageType.class, null, value);
    }

}
