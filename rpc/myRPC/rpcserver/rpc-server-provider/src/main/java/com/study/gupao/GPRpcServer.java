package com.study.gupao;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GPRpcServer implements ApplicationContextAware, InitializingBean {

    private ExecutorService executorService = Executors.newCachedThreadPool();

    private Map<String, Object> handlerMap = new HashMap<>();

    private int port;

    public GPRpcServer(int port) {
        this.port = port;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        ServerSocket serverSocket = null;
        serverSocket = new ServerSocket(port);//BIO
        while (true){
            Socket socket = serverSocket.accept();
            executorService.execute(new ProcessorHandler(socket, handlerMap));
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, Object> serviceBeanMap =
                applicationContext.getBeansWithAnnotation(RpcService.class);
        if (!serviceBeanMap.isEmpty()){
            for (Object serviceBean : serviceBeanMap.values()) {
                RpcService rpcService = serviceBean.getClass().getAnnotation(RpcService.class);
                String serviceName = rpcService.value().getName();//拿到接口类定义
                String version = rpcService.version();
                if (!StringUtils.isEmpty(version)){
                    serviceName += "-" + version;
                }
                handlerMap.put(serviceName, serviceBean);
            }
        }
    }
}
