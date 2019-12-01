package com.study.exercise.charper3_1;

import java.net.InetAddress;

public class Test5_6 {
    public static void main(String[] args) throws Exception {
        InetAddress address1 = InetAddress.getLocalHost();
        System.out.println("A1 "+address1.getCanonicalHostName());
        System.out.println("A2 "+address1.getHostName());
        System.out.println();
        InetAddress address2 = InetAddress.getByName("www.baidu.com");
        System.out.println("B1 "+address2.getCanonicalHostName());
        System.out.println("B2 "+address2.getHostName());
        System.out.println();
        InetAddress address3 = InetAddress.getByName("14.215.177.38");
        System.out.println("C1 "+address3.getCanonicalHostName());
        System.out.println("C2 "+address3.getHostName());
        System.out.println();
    }
}
