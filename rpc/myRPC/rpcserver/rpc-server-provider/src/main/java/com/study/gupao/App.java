package com.study.gupao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] argsGPRpcServer) {
        /*IHelloService helloService = new HelloServiceImpl();

        RpcProxyServer proxyServer = new RpcProxyServer();
        proxyServer.publisher(helloService, 8080);*/

        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        ((AnnotationConfigApplicationContext) context).start();
    }
}
