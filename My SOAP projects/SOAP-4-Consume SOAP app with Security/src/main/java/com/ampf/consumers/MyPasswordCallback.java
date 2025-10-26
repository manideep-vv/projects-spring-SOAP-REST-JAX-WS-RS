package com.ampf.consumers;

import org.apache.wss4j.common.ext.WSPasswordCallback;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;

public class MyPasswordCallback implements CallbackHandler {
    @Override
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        //Retrieve the user name and set the password
        System.out.println("Executing callback class to set pass");
        for (Callback c:callbacks){
            WSPasswordCallback myCallback = (WSPasswordCallback) c;
            String identifier = myCallback.getIdentifier();
            if(identifier.equalsIgnoreCase("mani")){
                myCallback.setPassword("santu");
                System.out.println("password have been set to the user name, now about to fire webservice");
                break;
            }
        }
    }
}
