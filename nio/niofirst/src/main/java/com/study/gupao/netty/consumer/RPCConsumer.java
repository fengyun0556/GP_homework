package com.study.gupao.netty.consumer;

import com.study.gupao.netty.api.IRPCHelloService;
import com.study.gupao.netty.api.IRPCService;

public class RPCConsumer {
    public static void main(String[] args) {
        IRPCHelloService helloService = RPCProxy.create(IRPCHelloService.class);
        System.out.println(helloService.hello("TOM 老师"));
        IRPCService service = RPCProxy.create(IRPCService.class);
        System.out.println(service.add(8, 2));
        System.out.println(service.sub(8, 2));
        System.out.println(service.mult(8, 2));
        System.out.println(service.div(8, 2));
    }
}
