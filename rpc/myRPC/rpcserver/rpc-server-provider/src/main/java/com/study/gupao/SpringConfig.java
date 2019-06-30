package com.study.gupao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.study.gupao")
public class SpringConfig {

    @Bean(name = "gpRpcServer")
    public GPRpcServer gpRpcServer(){
        return new GPRpcServer(8080);
    }
}
