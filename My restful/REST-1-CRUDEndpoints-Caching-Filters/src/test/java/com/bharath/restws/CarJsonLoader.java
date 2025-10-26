package com.bharath.restws;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

public class CarJsonLoader {
    public void init() throws IOException {
        InputStream inputStream= getClass().getClassLoader().getResourceAsStream("student.json");
        ObjectMapper mapper=new ObjectMapper();
        String fileData = mapper.readTree(inputStream).toString();
        System.out.println(fileData);
    }
    public void extractFromJson() throws IOException {
        InputStream inputStream= getClass().getClassLoader().getResourceAsStream("student.json");
        ObjectMapper mapper=new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(inputStream);
        JsonNode allFields = jsonNode.get("data");
        JsonNode js1 = allFields.path("name1");
        JsonNode js2 = allFields.get("name1");
        System.out.println(js1+"--"+js2);
        JsonNode streetName = jsonNode.at("/data/address/street/name");
        System.out.println(streetName);
    }
    public static void main(String[] args) throws IOException {
        new CarJsonLoader().extractFromJson();
    }
}
