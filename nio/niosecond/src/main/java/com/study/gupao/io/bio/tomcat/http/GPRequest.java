package com.study.gupao.io.bio.tomcat.http;

import java.io.IOException;
import java.io.InputStream;

public class GPRequest {
    private String method;
    private String url;

    public GPRequest(InputStream inputStream) {
        try {
            String context = "";
            byte[] bytes = new byte[1024];
            int len = 0;
            if ((len = inputStream.read(bytes)) > 0){
                context = new String(bytes, 0 ,len);
            }
            String line = context.split("\\n")[0];
            String[] arr = line.split("\\s");

            this.method = arr[0];
            this.url = arr[1].split("\\?")[0];

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }
}
