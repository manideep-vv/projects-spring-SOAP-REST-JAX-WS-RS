package com.ampf.handler;

import jakarta.xml.soap.Node;
import jakarta.xml.soap.SOAPException;
import jakarta.xml.soap.SOAPHeader;
import jakarta.xml.soap.SOAPMessage;
import jakarta.xml.ws.handler.MessageContext;
import jakarta.xml.ws.handler.soap.SOAPHandler;
import jakarta.xml.ws.handler.soap.SOAPMessageContext;
import org.springframework.stereotype.Component;

import javax.wsdl.Message;
import javax.xml.namespace.QName;
import java.util.Iterator;
import java.util.Set;

@Component
public class IdCardCheckerSOAPHandler implements SOAPHandler<SOAPMessageContext> {

    @Override
    public Set<QName> getHeaders() {
        return Set.of();
    }

    @Override
    public boolean handleMessage(SOAPMessageContext soapMessageContext) {
        boolean isResponse = (Boolean)soapMessageContext.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        if(isResponse){
            System.out.println("executing handler class- handleMessage method - for response ");
        }else {
            System.out.println("executing handler class- handleMessage method - for request");
            SOAPMessage message = soapMessageContext.getMessage();
            try{
                SOAPHeader header = message.getSOAPPart().getEnvelope().getHeader();
                Iterator<Node> childElements = header.getChildElements();
                System.out.println("iterating all header");
                while (childElements.hasNext()){
                    Node currentHeader = childElements.next();
                    System.out.println("header name -->"+currentHeader.getLocalName()+" header value -->"+currentHeader.getValue());
                }
            } catch (SOAPException e) {
                throw new RuntimeException(e);
            }

        }
        return true;
    }

    @Override
    public boolean handleFault(SOAPMessageContext soapMessageContext) {
        System.out.println("executing handler class- handleFault method");
        return false;
    }

    @Override
    public void close(MessageContext messageContext) {

    }
}
