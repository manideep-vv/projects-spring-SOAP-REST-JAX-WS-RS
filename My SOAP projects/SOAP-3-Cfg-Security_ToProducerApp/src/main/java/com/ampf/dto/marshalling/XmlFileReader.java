package com.ampf.dto.marshalling;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class XmlFileReader {
    public static void main(String[] args) throws IOException {
        File file = Path.of("src/main/resources/employee.xml").toFile();
        ObjectMapper objectMapper=new XmlMapper();
        JsonNode rootNode = objectMapper.readTree(file);
        //This get method will search both attributes and direct tags
//        System.out.println(rootNode.get("Title").asText());
        //xml data is very case sensitive
        System.out.println(rootNode.get("title").asText());
        //getting as int
        System.out.println(rootNode.get("edition").asInt());

        //Below will give error as get method will search only for the direct childs
//        System.out.println(rootNode.get("singer").asText());

        List<JsonNode> nodes = rootNode.findValues("author");
        for (JsonNode node1:nodes){
            System.out.println(node1.asText());
        }

//        readAndBind();
        writeXmlData();
    }

    public static NewBook readAndBind() throws IOException {
        System.out.println("going to read from xml file");
        File file = Path.of("src/main/resources/employee.xml").toFile();
        ObjectMapper xmlMapper = new XmlMapper();
        NewBook newBook = xmlMapper.readValue(file, NewBook.class);
        System.out.println(newBook.getAuthors());
        System.out.println(newBook.getTitle());
        System.out.println(newBook.getPublisherName());
        return newBook;
    }

    public static void writeXmlData() throws IOException {
        System.out.println("started reading xml data");
        XmlMapper xmlMapper=new XmlMapper();
        //writing to a file
        File newFile = Path.of("src/main/resources/torget.xml").toFile();
        xmlMapper.writer().withDefaultPrettyPrinter().writeValue(newFile,readAndBind());

        //writing to console
        String s = xmlMapper.writer().withDefaultPrettyPrinter().writeValueAsString(readAndBind());
        System.out.println(s);
    }
}
