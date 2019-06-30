package com.study.gupao;

@RpcService(value = IHelloService.class, version = "v1.0")
public class HelloServiceImpl implements IHelloService {
    @Override
    public String sayHello(String content) {
        System.out.println("【v1.0】request in say hello : " + content);
        return "【v1.0】say hello : " + content;
    }

    @Override
    public String saveUser(User user) {
        System.out.println("【v1.0】save user : " + user);
        return "【v1.0】success";
    }
}
