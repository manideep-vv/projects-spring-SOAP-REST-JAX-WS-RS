package com.ampf;
import java.nio.file.Paths;
import com.ampf.model.Patient;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
public class MyXmlMapperDemo {
    public static void main(String[] args) throws IOException {
        String payload= """
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

        XmlMapper xmlMapper = new XmlMapper();
//        List<Patient> patients = xmlMapper.readValue(payload, new TypeReference<List<Patient>>() {
//        });
        File file=Paths.get("patients.xml").toFile();
//        file=Paths.get("src/main/resources/patientsNew.xml").toFile();
        System.out.println("loaded using paths");
//        file=new File("src/main/resources/patientsNew.xml");
        List<Patient> patients = xmlMapper.readValue(file, new TypeReference<List<Patient>>() {
        });
        System.out.println("unmarshalled patients list is "+patients);

    }
}
