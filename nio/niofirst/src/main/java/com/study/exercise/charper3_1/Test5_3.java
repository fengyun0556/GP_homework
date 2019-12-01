package com.study.exercise.charper3_1;

import java.net.InetAddress;

public class Test5_3 {
    public static void main(String[] args) throws Exception {
        InetAddress[] myAddressArray = InetAddress.getAllByName("PC-20160123DDYW");
        InetAddress[] baiduAddressArray = InetAddress.getAllByName("www.baidu.com");
        InetAddress[] ipStringAddressArray = InetAddress.getAllByName("192.168.199.187");

        InetAddress[][] inetAddresses = new InetAddress[][]{myAddressArray, baiduAddressArray, ipStringAddressArray};
        for (InetAddress[] inetAddressArray : inetAddresses) {
            for (int i = 0; i < inetAddressArray.length; i++) {
                InetAddress inetAddress = inetAddressArray[i];
                System.out.println(inetAddress.getHostAddress()+" "+inetAddress.getClass().getName());
            }
            System.out.println();
        }
    }
}
