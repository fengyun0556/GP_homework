package com.gupao.pattern.summary.spring.ioc;

import javax.annotation.Resource;

public class IOCTest {

    @Resource
    private OneService oneService;

    public void iocTest(){
        this.oneService.doSomeThing();
    }
}
