package com.zvz.service;

import com.sun.net.httpserver.HttpExchange;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import java.net.InetSocketAddress;

/**
 * Created by lilipo on 2017/3/29.
 */
@WebService
public class ServiceHello {

    @Resource
    private WebServiceContext wsContext;

    public String getValue(String name){

        System.out.println("get==="+name);

        return "qqqqq:"+name;
    }

    public static void main(String[] args){
        Endpoint.publish("http://192.168.10.28:9001/Service/ServiceHello",new ServiceHello());
        System.out.println("成功");
    }

    private String getClientInfo() {
        MessageContext mc = wsContext.getMessageContext();
        System.out.println(mc);
        HttpExchange exchange = (HttpExchange)mc.get("com.sun.xml.internal.ws.http.exchange");
        InetSocketAddress isa = exchange.getRemoteAddress();
        return isa.getHostName()+"  "+isa.getHostString()+ "  "+isa.getAddress().getHostAddress();

    }

}
