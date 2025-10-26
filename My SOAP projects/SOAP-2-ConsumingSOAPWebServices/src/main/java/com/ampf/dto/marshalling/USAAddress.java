package com.ampf.dto.marshalling;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;
import java.io.StringWriter;

@XmlType(propOrder = { "city" , "state", "zip", "name","street"})
@XmlRootElement(name="USAAddressoh")
@XmlAccessorType(XmlAccessType.FIELD)
public class USAAddress {

    @XmlElement(name = "person name")
    String name;
    String city;
    String state;
    String street;
    Integer zip;

    public USAAddress() {
    }

    public USAAddress(String name, String city, String state, String street, Integer zip) {
        this.name = name;
        this.city = city;
        this.state = state;
        this.street = street;
        this.zip = zip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getZip() {
        return zip;
    }

    public void setZip(Integer zip) {
        this.zip = zip;
    }

    public static void main(String[] args) throws JAXBException {
        USAAddress add=new USAAddress("Mani","illinois","chicago","doughlas street",12112);
        JAXBContext jaxbContext=JAXBContext.newInstance(USAAddress.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
        StringWriter writer=new StringWriter();
        marshaller.marshal(add,writer);
        System.out.println(writer);
    }
}
