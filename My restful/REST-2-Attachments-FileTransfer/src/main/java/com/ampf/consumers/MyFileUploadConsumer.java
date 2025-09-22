package com.ampf.consumers;

import jakarta.ws.rs.core.MediaType;
import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.multipart.ContentDisposition;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MyFileUploadConsumer {
    public static void main(String[] args) throws FileNotFoundException {

        WebClient webClient= WebClient.create("http://localhost:8080/attachments/fileService/upload");
        webClient.type(MediaType.MULTIPART_FORM_DATA);
        ContentDisposition disposition=new ContentDisposition("attachment;filename=Web Dev Syllabus.pdf");

        //Here attachment is nothing but a small part
        Attachment attachment=new Attachment("root",new FileInputStream("E:/study related/my git hub -new/HTML/Web Dev Syllabus.pdf"),disposition);
        webClient.post(attachment);
    }
}
