package com.ampf.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

import java.io.*;
import java.util.List;

/**
 *
 *
 * http://localhost:8080/attachments/fileService/upload
 */
@Path("/fileService")
@Component
public class FileUpload_DownloadController {

    /**
     * HEre list of attachments means list of multipart files
     * this method needs to be invoked either via html page or consumer java program
     * (in real time a big file will be splitted to multiple small subpart files and those will be sent)
     * and each part will have a content disposition header
     */
    @Path("/upload")
    public void upload(List<Attachment> attachments) throws FileNotFoundException {
         System.out.println("fired controller method received attachments list size is -->"+attachments.size());
        FileOutputStream outputStream=new FileOutputStream(new File("E:/junk/manigadipancard.pdf"));

                attachments.stream().forEach(attachment -> {
                    System.out.println("converting attachment stream and writing to file ");
                    try {
                        System.out.println(attachment.getContentDisposition().getParameters());
                        InputStream inputStream = attachment.getDataHandler().getInputStream();
                        FileCopyUtils.copy(inputStream,outputStream);
                        System.out.println("copied");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                });
        System.out.println(" controller method ended ");
    }

    @Path("/download")
    @GET
    @Produces(MediaType.APPLICATION_OCTET_STREAM) //even this is optional
    public Response download(){
        File file=new File("E:/junk/manigadipancard.pdf");
        Response.ResponseBuilder responseBuilder = Response.ok(file);
        responseBuilder.header("Content-Disposition","attachment;filename=manigadipancard.pdf");
        System.out.println("returning response with @Produces anno");
        return responseBuilder.build();

    }



}

