package com.ampf.consumers;

import com.ampf.controller.StudentSOAPController;
import com.ampf.controller.StudentSOAPControllerService;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.wss4j.common.WSS4JConstants;
import org.apache.wss4j.dom.handler.WSHandlerConstants;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class MySOAPConsumer {
    public static void main(String[] args) throws MalformedURLException {

        StudentSOAPControllerService svc=new StudentSOAPControllerService(new URL("http://localhost:8080/student?wsdl"));
        StudentSOAPController controller = svc.getStudentSOAPControllerPort();

        Client client = ClientProxy.getClient(controller);
        Endpoint endpoint = client.getEndpoint();

        Map<String,Object> props=new HashMap<String,Object>();
        props.put(WSHandlerConstants.ACTION,WSHandlerConstants.USERNAME_TOKEN);
        props.put(WSHandlerConstants.USER,"mani");
        props.put(WSHandlerConstants.PASSWORD_TYPE, WSS4JConstants.PW_TEXT);
        props.put(WSHandlerConstants.PW_CALLBACK_CLASS,MyPasswordCallback.class.getName());

        //We must add a task to every interceptor/security guard
        WSS4JOutInterceptor outInterceptor =new WSS4JOutInterceptor(props);
        //add the interceptor to endpoint
        endpoint.getOutInterceptors().add(outInterceptor);


        String studentAddress = controller.getStudentAddress();
        System.out.println("web service result is -->"+studentAddress);
    }
}
