package com.study.gupao.io.bio.tomcat.http;

import java.io.IOException;

public abstract class GPServlet {

    public void service(GPRequest request, GPResponse response) throws IOException {
        if ("GET".equalsIgnoreCase(request.getMethod())){
            doGet(request, response);
        } else {
            doPost(request, response);
        }
    }

    protected abstract void doPost(GPRequest request, GPResponse response) throws IOException;

    protected abstract void doGet(GPRequest request, GPResponse response) throws IOException;
}
