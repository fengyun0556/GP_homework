package com.gupao.springframework.mvc.action;

import com.gupao.springframework.annotation.GPAutowired;
import com.gupao.springframework.annotation.GPController;
import com.gupao.springframework.annotation.GPRequestMapping;
import com.gupao.springframework.annotation.GPRequestParam;
import com.gupao.springframework.service.IDemoService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@GPController
@GPRequestMapping("demo")
public class DemoController {
    @GPAutowired
    private IDemoService demoService;

    @GPRequestMapping("query")
    public void query(HttpServletRequest req, HttpServletResponse resp, @GPRequestParam("name") String name) {
        String result = demoService.getName(name);
        try {
        	resp.getWriter().write(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GPRequestMapping("add")
    public void add(HttpServletRequest req, HttpServletResponse rep,
                    @GPRequestParam("a") Integer a, @GPRequestParam("b") Integer b) {
        try {
            rep.getWriter().write(a + "+" + b + "=" + (a + b));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GPRequestMapping("remove")
    public void remove(HttpServletRequest req, HttpServletResponse rep,@GPRequestParam("id") Integer id){

    }


}
