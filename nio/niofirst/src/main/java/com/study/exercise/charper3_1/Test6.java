package com.study.exercise.charper3_1;

import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.List;

public class Test6 {
    public static void main(String[] args) throws Exception {
        Enumeration<NetworkInterface> networkInterface = NetworkInterface.getNetworkInterfaces();
        while (networkInterface.hasMoreElements()){
            NetworkInterface eachNetworkInterface = networkInterface.nextElement();
            System.out.println("eachNetworkInterface.getName="+eachNetworkInterface.getName());
            System.out.println("eachNetworkInterface.getDisplayName="+eachNetworkInterface.getDisplayName());
            List<InterfaceAddress> addressList = eachNetworkInterface.getInterfaceAddresses();
            System.out.println();
            for (int i = 0; i < addressList.size(); i++) {
                InterfaceAddress eachAddress = addressList.get(i);
                InetAddress inetAddress = eachAddress.getAddress();
                if (inetAddress != null){
                    System.out.println("inetAddress.getHostAddress="+inetAddress.getHostAddress());
                }
                inetAddress = eachAddress.getBroadcast();
                if (inetAddress != null){
                    System.out.println("inetAddress.getHostAddress="+inetAddress.getHostAddress());
                }
                System.out.println("eachAddress.getNetworkPrefixLength="+eachAddress.getNetworkPrefixLength());
                System.out.println();
            }
            System.out.println();
        }
    }
}
