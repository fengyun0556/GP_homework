package com.study.gupao.io.nio.tomcat;

import com.study.gupao.io.nio.tomcat.http.GPRequest;
import com.study.gupao.io.nio.tomcat.http.GPResponse;
import com.study.gupao.io.nio.tomcat.http.GPServlet;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpRequestEncoder;
import io.netty.handler.codec.http.HttpResponseEncoder;

import java.io.FileInputStream;
import java.net.ServerSocket;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class GPTomcat {

    private int port = 8080;
    private ServerSocket server;
    private Map<String, GPServlet> servletMapping = new HashMap<>();
    private Properties webxml = new Properties();

    private void init(){
        try{
            String WEB_INF = this.getClass().getResource("/").getPath();
            FileInputStream fis = new FileInputStream(WEB_INF + "web.properties");
            webxml.load(fis);

            for (Object o : webxml.keySet()) {
                String key = o.toString();
                if (key.endsWith(".url")){
                    String servletName = key.replaceAll("\\.url$", "");
                    String url = webxml.getProperty(key);
                    String className = webxml.getProperty(servletName + ".className");
                    //单实例，多线程
                    GPServlet servlet = (GPServlet) Class.forName(className).newInstance();
                    servletMapping.put(url, servlet);
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void start(){
        init();

        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap server = new ServerBootstrap();

            server.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel client) throws Exception {
                            client.pipeline().addLast(new HttpResponseEncoder());
                            client.pipeline().addLast(new HttpRequestDecoder());
                            client.pipeline().addLast(new GPTomcatHandler());
                        }
                    })
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true);

            //启动服务器
            ChannelFuture f = server.bind(port).sync();
            System.out.println("GP Tomcat already start, port : " + this.port);
            f.channel().closeFuture().sync();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }


    public class GPTomcatHandler extends ChannelInboundHandlerAdapter{
        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            if (msg instanceof HttpRequest){
                HttpRequest req = (HttpRequest) msg;
                GPRequest request = new GPRequest(ctx, req);
                GPResponse response = new GPResponse(ctx, req);

                String url = request.getURL();

                if (servletMapping.containsKey(url)){
                    servletMapping.get(url).service(request, response);
                } else {
                    response.write("404 - Not Found");
                }
            }
        }
    }

    public static void main(String[] args) {
        new GPTomcat().start();
    }
}
