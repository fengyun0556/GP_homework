package com.study.gupao.io.bio.tomcat.servlet;

import com.study.gupao.io.bio.tomcat.http.GPRequest;
import com.study.gupao.io.bio.tomcat.http.GPResponse;
import com.study.gupao.io.bio.tomcat.http.GPServlet;

import java.io.IOException;

public class SecondServlet extends GPServlet {
    @Override
    protected void doPost(GPRequest request, GPResponse response) throws IOException {
        response.write("This is second servlet");
    }

    @Override
    protected void doGet(GPRequest request, GPResponse response) throws IOException {
        this.doPost(request, response);
    }
}
