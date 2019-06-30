package com.study.gupao;

@RpcService(value = IHelloService.class, version = "v2.0")
public class HelloServiceImpl2 implements IHelloService {
    @Override
    public String sayHello(String content) {
        System.out.println("【v2.0】request in say hello : " + content);
        return "【v2.0】say hello : " + content;
    }

    @Override
    public String saveUser(User user) {
        System.out.println("【v2.0】save user : " + user);
        return "【v2.0】success";
    }
}
