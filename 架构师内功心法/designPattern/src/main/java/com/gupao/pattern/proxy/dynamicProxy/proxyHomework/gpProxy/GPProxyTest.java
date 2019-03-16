package com.gupao.pattern.proxy.dynamicProxy.proxyHomework.gpProxy;

import com.gupao.pattern.proxy.dynamicProxy.Person;
import com.gupao.pattern.proxy.dynamicProxy.jdkProxy.Girl;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class GPProxyTest {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, IOException {
        Person person = (Person) new GPMeiPo().getInstance(new Girl());
        person.findLove();

        /*byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{Person.class});
        FileOutputStream fos = new FileOutputStream("D:\\Java\\$Proxy0.class");
        fos.write(bytes);
        fos.close();*/
    }
}
