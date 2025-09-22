package com.ampf;

import com.ampf.model.Patient;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

public class SampleUnMarshaller {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, JAXBException {
        String nodesList= """
                <Patients>
                
                <Patient>
                <id>222</id>
                <name>radhika</name>
                </Patient>
                
                <Patient>
                <id>111</id>
                <name>santu</name>
                </Patient>
                </Patients>
                
                """;

        ArrayList<Patient> patients=new ArrayList<>();
        JAXBContext jaxbContext = JAXBContext.newInstance(Patient.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        DocumentBuilder documentBuilder = DocumentBuilderFactory.newDefaultInstance().newDocumentBuilder();
        Document doc = documentBuilder.parse(new InputSource(new StringReader(nodesList)));
        NodeList list = doc.getElementsByTagName("Patient");
        for (int i=0;i<list.getLength();i++){
            Node item = list.item(i);
            Patient p =(Patient) unmarshaller.unmarshal(item);
            patients.add(p);
        }
        System.out.println(patients.size());


    }
}
