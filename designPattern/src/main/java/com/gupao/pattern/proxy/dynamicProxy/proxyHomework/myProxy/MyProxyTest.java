package com.gupao.pattern.proxy.dynamicProxy.proxyHomework.myProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class MyProxyTest {
    public static void main(String[] args) {
        Teacher teacher = new JavaTeacher();
        InvocationHandler handler = new LogInvocation(teacher);
        Teacher teacherProxy = (Teacher) Proxy.newProxyInstance(teacher.getClass().getClassLoader(),
                teacher.getClass().getInterfaces(), handler);
        teacherProxy.teach();

        System.out.println("=============================");

        Student student = new JavaStudent();
        handler = new LogInvocation(student);
        Student studentProxy = (Student) Proxy.newProxyInstance(student.getClass().getClassLoader(),
                student.getClass().getInterfaces(), handler);
        studentProxy.study();

    }
}
