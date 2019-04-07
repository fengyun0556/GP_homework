package com.gupao.springframework.service;

import com.gupao.springframework.annotation.GPService;

@GPService
public class DemoServiceImpl implements IDemoService {
    @Override
    public String getName(String name) {
        return "My name is " + name;
    }
}
