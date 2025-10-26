
package com.ampf.controller;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.ampf.controller package. 
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

    private final static QName _GetStudentAddress_QNAME = new QName("http://controller.ampf.com/", "getStudentAddress");
    private final static QName _GetStudentAddressResponse_QNAME = new QName("http://controller.ampf.com/", "getStudentAddressResponse");
    private final static QName _GetStudentName_QNAME = new QName("http://controller.ampf.com/", "getStudentName");
    private final static QName _GetStudentNameResponse_QNAME = new QName("http://controller.ampf.com/", "getStudentNameResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.ampf.controller
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetStudentAddress }
     * 
     */
    public GetStudentAddress createGetStudentAddress() {
        return new GetStudentAddress();
    }

    /**
     * Create an instance of {@link GetStudentAddressResponse }
     * 
     */
    public GetStudentAddressResponse createGetStudentAddressResponse() {
        return new GetStudentAddressResponse();
    }

    /**
     * Create an instance of {@link GetStudentName }
     * 
     */
    public GetStudentName createGetStudentName() {
        return new GetStudentName();
    }

    /**
     * Create an instance of {@link GetStudentNameResponse }
     * 
     */
    public GetStudentNameResponse createGetStudentNameResponse() {
        return new GetStudentNameResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentAddress }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetStudentAddress }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.ampf.com/", name = "getStudentAddress")
    public JAXBElement<GetStudentAddress> createGetStudentAddress(GetStudentAddress value) {
        return new JAXBElement<GetStudentAddress>(_GetStudentAddress_QNAME, GetStudentAddress.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentAddressResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetStudentAddressResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.ampf.com/", name = "getStudentAddressResponse")
    public JAXBElement<GetStudentAddressResponse> createGetStudentAddressResponse(GetStudentAddressResponse value) {
        return new JAXBElement<GetStudentAddressResponse>(_GetStudentAddressResponse_QNAME, GetStudentAddressResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentName }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetStudentName }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.ampf.com/", name = "getStudentName")
    public JAXBElement<GetStudentName> createGetStudentName(GetStudentName value) {
        return new JAXBElement<GetStudentName>(_GetStudentName_QNAME, GetStudentName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentNameResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetStudentNameResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.ampf.com/", name = "getStudentNameResponse")
    public JAXBElement<GetStudentNameResponse> createGetStudentNameResponse(GetStudentNameResponse value) {
        return new JAXBElement<GetStudentNameResponse>(_GetStudentNameResponse_QNAME, GetStudentNameResponse.class, null, value);
    }

}
