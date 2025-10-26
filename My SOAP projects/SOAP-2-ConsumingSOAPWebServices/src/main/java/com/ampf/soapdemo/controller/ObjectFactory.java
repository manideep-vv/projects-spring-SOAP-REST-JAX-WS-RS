
package com.ampf.soapdemo.controller;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.ampf.soapdemo.controller package. 
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

    private final static QName _EmpDetails_QNAME = new QName("http://controller.soapDemo.ampf.com/", "empDetails");
    private final static QName _EmpDetailsResponse_QNAME = new QName("http://controller.soapDemo.ampf.com/", "empDetailsResponse");
    private final static QName _Employee1_QNAME = new QName("http://controller.soapDemo.ampf.com/", "employee1");
    private final static QName _GetAllEmployees_QNAME = new QName("http://controller.soapDemo.ampf.com/", "getAllEmployees");
    private final static QName _GetAllEmployeesResponse_QNAME = new QName("http://controller.soapDemo.ampf.com/", "getAllEmployeesResponse");
    private final static QName _Init_QNAME = new QName("http://controller.soapDemo.ampf.com/", "init");
    private final static QName _InitResponse_QNAME = new QName("http://controller.soapDemo.ampf.com/", "initResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.ampf.soapdemo.controller
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link EmpDetails }
     * 
     */
    public EmpDetails createEmpDetails() {
        return new EmpDetails();
    }

    /**
     * Create an instance of {@link EmpDetailsResponse }
     * 
     */
    public EmpDetailsResponse createEmpDetailsResponse() {
        return new EmpDetailsResponse();
    }

    /**
     * Create an instance of {@link Employee }
     * 
     */
    public Employee createEmployee() {
        return new Employee();
    }

    /**
     * Create an instance of {@link GetAllEmployees }
     * 
     */
    public GetAllEmployees createGetAllEmployees() {
        return new GetAllEmployees();
    }

    /**
     * Create an instance of {@link GetAllEmployeesResponse }
     * 
     */
    public GetAllEmployeesResponse createGetAllEmployeesResponse() {
        return new GetAllEmployeesResponse();
    }

    /**
     * Create an instance of {@link Init }
     * 
     */
    public Init createInit() {
        return new Init();
    }

    /**
     * Create an instance of {@link InitResponse }
     * 
     */
    public InitResponse createInitResponse() {
        return new InitResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EmpDetails }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EmpDetails }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.soapDemo.ampf.com/", name = "empDetails")
    public JAXBElement<EmpDetails> createEmpDetails(EmpDetails value) {
        return new JAXBElement<EmpDetails>(_EmpDetails_QNAME, EmpDetails.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EmpDetailsResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EmpDetailsResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.soapDemo.ampf.com/", name = "empDetailsResponse")
    public JAXBElement<EmpDetailsResponse> createEmpDetailsResponse(EmpDetailsResponse value) {
        return new JAXBElement<EmpDetailsResponse>(_EmpDetailsResponse_QNAME, EmpDetailsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Employee }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Employee }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.soapDemo.ampf.com/", name = "employee1")
    public JAXBElement<Employee> createEmployee1(Employee value) {
        return new JAXBElement<Employee>(_Employee1_QNAME, Employee.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllEmployees }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAllEmployees }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.soapDemo.ampf.com/", name = "getAllEmployees")
    public JAXBElement<GetAllEmployees> createGetAllEmployees(GetAllEmployees value) {
        return new JAXBElement<GetAllEmployees>(_GetAllEmployees_QNAME, GetAllEmployees.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllEmployeesResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAllEmployeesResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.soapDemo.ampf.com/", name = "getAllEmployeesResponse")
    public JAXBElement<GetAllEmployeesResponse> createGetAllEmployeesResponse(GetAllEmployeesResponse value) {
        return new JAXBElement<GetAllEmployeesResponse>(_GetAllEmployeesResponse_QNAME, GetAllEmployeesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Init }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Init }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.soapDemo.ampf.com/", name = "init")
    public JAXBElement<Init> createInit(Init value) {
        return new JAXBElement<Init>(_Init_QNAME, Init.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InitResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link InitResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.soapDemo.ampf.com/", name = "initResponse")
    public JAXBElement<InitResponse> createInitResponse(InitResponse value) {
        return new JAXBElement<InitResponse>(_InitResponse_QNAME, InitResponse.class, null, value);
    }

}
