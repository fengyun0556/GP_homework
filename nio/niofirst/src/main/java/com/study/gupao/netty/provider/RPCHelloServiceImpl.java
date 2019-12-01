package com.study.gupao.netty.provider;

import com.study.gupao.netty.api.IRPCHelloService;

public class RPCHelloServiceImpl implements IRPCHelloService {
    @Override
    public String hello(String name) {
        return "Hello " + name + "!";
    }
}
