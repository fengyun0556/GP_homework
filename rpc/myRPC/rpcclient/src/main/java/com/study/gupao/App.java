package com.study.gupao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        /*RpcProxyClient rpcProxyClient = new RpcProxyClient();
        IHelloService helloService = rpcProxyClient.clientProxy(IHelloService.class, "localhost", 8080);
        String result = helloService.sayHello("zhang san");
        System.out.println(result);*/

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        RpcProxyClient rpcProxyClient = applicationContext.getBean(RpcProxyClient.class);
        IPaymentService iPaymentService = rpcProxyClient.clientProxy(IPaymentService.class, "localhost",8080);
        iPaymentService.doPay();

    }
}
