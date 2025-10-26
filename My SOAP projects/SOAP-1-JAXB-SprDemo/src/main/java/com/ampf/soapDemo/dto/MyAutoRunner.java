package com.ampf.soapDemo.dto;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.bind.*;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;
import java.io.StringWriter;

@Component
public class MyAutoRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("fired this runner");

        Employee e1=new Employee("mani",20);

        JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
        StringWriter writer = new StringWriter();
        marshaller.marshal(e1,new StreamResult(writer));
        System.out.println(writer.toString());

    }


    public static void main(String[] args) throws JAXBException, XMLStreamException {

        Employee e1=new Employee("mani",20);

        JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
        StringWriter writer = new StringWriter();
        marshaller.marshal(e1,new StreamResult(writer));
        String unmarshalledStr = writer.toString();
        System.out.println(unmarshalledStr);

        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
//        unmarshaller.setProperty(XMLInputFactory.SUPPORT_DTD,false);
//        unmarshaller.setProperty(XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES,false);

        JAXBElement<Employee> unmarshal = unmarshaller.unmarshal(new StreamSource(new StringReader(unmarshalledStr)), Employee.class);
//        System.out.println("prop is -->"+unmarshaller.getProperty(XMLInputFactory.SUPPORT_DTD));
        unmarshal2(unmarshalledStr);
    }

    public static  void unmarshal2(String xmlPayload) throws XMLStreamException,JAXBException {
        XMLInputFactory xif=XMLInputFactory.newFactory();
        xif.setProperty(XMLInputFactory.SUPPORT_DTD,false);
        xif.setProperty(XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES,false);

        XMLStreamReader xmlStreamReader = xif.createXMLStreamReader(new StreamSource(new StringReader(xmlPayload)));
        JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        JAXBElement<Employee> unmarshal = unmarshaller.unmarshal(xmlStreamReader, Employee.class);
        System.out.println("unm using streamReader"+unmarshal.getValue());
    }
}
