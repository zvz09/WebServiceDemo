package com.zvz.client.test;


import com.zvz.client.ServiceHello;
import com.zvz.client.ServiceHelloService;

/**
 * Created by lilipo on 2017/3/29.
 */
public class ServiceTest {

    public static void main(String[] args){
        ServiceHello hello = new ServiceHelloService().getServiceHelloPort();

        String name = hello.getValue("我曹");
        System.out.println(name);
    }
}
