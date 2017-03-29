package com.zvz.client.test;


import com.zvz.client.ServiceHello;
import com.zvz.client.ServiceHelloService;

import javax.xml.ws.BindingProvider;
import java.util.Map;

/**
 * Created by lilipo on 2017/3/29.
 */
public class ServiceTest {

    public static void main(String[] args){
        ServiceHello hello = new ServiceHelloService().getServiceHelloPort();

        // 设置超时时间
        Map<String, Object> requestContext = ((BindingProvider)hello).getRequestContext();
        requestContext.put("com.sun.xml.internal.ws.connect.timeout", 5000); // Timeout in millis
        requestContext.put("com.sun.xml.internal.ws.request.timeout", 5000); // Timeout in millis

        String name = hello.getValue("我曹");
        System.out.println(name);
    }
}
