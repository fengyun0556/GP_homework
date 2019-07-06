package com.study.gupao.io.nio.tomcat.servlet;

import com.study.gupao.io.nio.tomcat.http.GPRequest;
import com.study.gupao.io.nio.tomcat.http.GPResponse;
import com.study.gupao.io.nio.tomcat.http.GPServlet;

import java.io.IOException;

public class SecondServlet extends GPServlet {
    @Override
    protected void doPost(GPRequest request, GPResponse response) throws Exception {
        response.write("This is second servlet");
    }

    @Override
    protected void doGet(GPRequest request, GPResponse response) throws Exception {
        this.doPost(request, response);
    }
}
