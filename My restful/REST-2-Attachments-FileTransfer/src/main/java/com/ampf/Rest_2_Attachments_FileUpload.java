package com.ampf;

import com.ampf.controller.FileUpload_DownloadController;
import org.apache.cxf.Bus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Rest_2_Attachments_FileUpload {
    @Autowired
    Bus bus;

    @Autowired
    FileUpload_DownloadController fileUploadController;

    public static void main(String[] args) {
        SpringApplication.run(Rest_2_Attachments_FileUpload.class,args);
    }

    @Bean
    public Server rsserver() {
        System.out.println(" creating jax-rs serverbean ");
        JAXRSServerFactoryBean serverBean = new JAXRSServerFactoryBean();
        serverBean.setBus(bus);
        serverBean.setAddress("/");
        serverBean.setServiceBeans(List.of(fileUploadController));
        return serverBean.create();
    }
}
