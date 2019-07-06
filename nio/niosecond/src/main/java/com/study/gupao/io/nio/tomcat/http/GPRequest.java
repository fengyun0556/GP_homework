package com.study.gupao.io.nio.tomcat.http;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.QueryStringDecoder;

import java.util.List;
import java.util.Map;

public class GPRequest {
    private ChannelHandlerContext ctx;

    private HttpRequest request;

    public GPRequest(ChannelHandlerContext ctx, HttpRequest request) {
        this.ctx = ctx;
        this.request = request;
    }

    public String getURL(){
        return request.uri();
    }

    public String getMethod(){
        return request.method().name();
    }

    public Map<String, List<String>> getParameters(){
        QueryStringDecoder decoder = new QueryStringDecoder(request.uri());
        return decoder.parameters();
    }

    public String getParameter(String name){
        Map<String, List<String>> params = this.getParameters();
        List<String> param = params.get(name);
        if (null == param){
            return null;
        } else {
            return param.get(0);
        }
    }

}
