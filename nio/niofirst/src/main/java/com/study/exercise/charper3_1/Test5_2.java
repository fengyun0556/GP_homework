package com.study.exercise.charper3_1;

import java.net.InetAddress;

public class Test5_2 {
    public static void main(String[] args) throws Exception {
        InetAddress myAddress = InetAddress.getByName("PC-20160123DDYW");
        InetAddress baiduAddress = InetAddress.getByName("www.baidu.com");
        InetAddress ipStringAddress = InetAddress.getByName("192.168.199.187");
        InetAddress localhostAddress = InetAddress.getByName("localhost");
        System.out.println(localhostAddress.getClass().getName()+" "+localhostAddress.getHostAddress());
        System.out.println(myAddress.getClass().getName()+" "+myAddress.getHostAddress());
        System.out.println(baiduAddress.getClass().getName()+" "+baiduAddress.getHostAddress());
        System.out.println(ipStringAddress.getClass().getName()+" "+ipStringAddress.getHostAddress());

//        InetAddress notIPAddress = InetAddress.getByName("192.777.0.0");
//        System.out.println(notIPAddress.getClass().getName()+" "+notIPAddress.getHostAddress());
        InetAddress notDomainAddress = InetAddress.getByName("www.1234566789012345667890.com");
        System.out.println(notDomainAddress.getClass().getName()+" "+notDomainAddress.getHostAddress());
    }
}
