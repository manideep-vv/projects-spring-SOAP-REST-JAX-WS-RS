package com.ampf;

import org.apache.wss4j.common.ext.WSPasswordCallback;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MyUTPasswordTokenCallback implements CallbackHandler {

    Map<String,String> credentials =new HashMap<>();
    public MyUTPasswordTokenCallback(){
        credentials.put("mani","santu");
        credentials.put("mohan","radhika");

    }
    @Override
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        System.out.println("executing the callback class, num of callback classes are "+callbacks.length+" -->"+callbacks[0].toString());
        for (Callback callback: callbacks) {
            WSPasswordCallback callback1 = (WSPasswordCallback) callback;
            String userName = callback1.getIdentifier(); //from where this is being pulled
            String password = credentials.get(userName);
            if (password!=null){
                //pass which we set will be compared with pass from header, if mismatch then exception
                callback1.setPassword(password);
                System.out.println("setted the password to callback");
                break;
            }

        }
    }
}
