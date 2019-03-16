package com.gupao.pattern.proxy.dynamicProxy.jdkProxy;

import com.gupao.pattern.proxy.dynamicProxy.Person;
import sun.misc.ProxyGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class JDKProxyTest {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, IOException {
        Person person = (Person) new JDKMeiPo().getInstance(new Girl());
        person.findLove();

        /*byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{Person.class});
        FileOutputStream fos = new FileOutputStream("D:\\Java\\$Proxy0.class");
        fos.write(bytes);
        fos.close();*/
    }
}
