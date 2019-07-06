package com.study.gupao.io.bio.tomcat;

import com.study.gupao.io.bio.tomcat.http.GPRequest;
import com.study.gupao.io.bio.tomcat.http.GPResponse;
import com.study.gupao.io.bio.tomcat.http.GPServlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class GPTomcat {
    private int port = 8080;
    private ServerSocket server;
    private Map<String, GPServlet> servletMapping = new HashMap<>();
    private Properties webxml = new Properties();

    //1、配置好启动端口，默认8080
    //2、配置web.xml 自己写的Servlet继承HttpServlet
    //3、读取配置，url-pattern 和 Servlet建立一个映射关系

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
        //1、加载配置文件，初始化ServletMapping
        init();

        try {
            server = new ServerSocket(this.port);
            System.out.println("GP Tomcat start, port : " + this.port);
            //2、等待用户请求
            while (true){
                Socket client = server.accept();
                //http请求，发送的数据就是字符串，有规律的字符串
                process(client);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void process(Socket client){
        try {
            InputStream inputStream = client.getInputStream();
            OutputStream outputStream = client.getOutputStream();

            GPRequest request = new GPRequest(inputStream);
            GPResponse response = new GPResponse(outputStream);

            String url = request.getUrl();

            if (servletMapping.containsKey(url)){
                servletMapping.get(url).service(request, response);
            } else {
                response.write("404 - Not Found");
            }

            outputStream.flush();
            outputStream.close();

            inputStream.close();
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new GPTomcat().start();
    }

}
