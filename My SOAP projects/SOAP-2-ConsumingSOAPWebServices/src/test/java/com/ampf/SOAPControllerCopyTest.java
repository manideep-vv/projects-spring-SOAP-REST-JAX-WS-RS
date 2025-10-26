package com.ampf;

import com.ampf.controller.StudentSOAPController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Soap1JaxbSprDemoApplication.class)
public class SOAPControllerCopyTest {

    @Autowired
    StudentSOAPController studentSOAPController;

    @Test
    public void test1(){
        System.out.println("Testing class-->"+this.getClass().getSimpleName());
        System.out.println(studentSOAPController.hashCode());
    }
    @Test
    public void test2(){
        System.out.println(studentSOAPController.hashCode());
    }
}
