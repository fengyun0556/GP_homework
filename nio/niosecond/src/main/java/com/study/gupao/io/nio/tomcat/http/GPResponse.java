package com.study.gupao.io.nio.tomcat.http;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.*;

public class GPResponse {

    private ChannelHandlerContext ctx;

    private HttpRequest request;

    public GPResponse(ChannelHandlerContext ctx, HttpRequest request) {
        this.ctx = ctx;
        this.request = request;
    }

    public void write(String out) throws Exception{
        if (out == null || out.length() == 0){
            return;
        }

        FullHttpResponse response = new DefaultFullHttpResponse(
                HttpVersion.HTTP_1_1,
                HttpResponseStatus.OK,
                Unpooled.wrappedBuffer(out.getBytes("UTF-8")));

        response.headers().set("Content-Type", "text/html");
        ctx.write(response);
        ctx.flush();
        ctx.close();
    }
}
