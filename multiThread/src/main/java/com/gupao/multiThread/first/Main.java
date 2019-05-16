package com.gupao.multiThread.first;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        List<FlightData> flightDataList = new ArrayList<>();
        FlightData flightData0 = new FlightData("CA001", "SHA", "KUL", "2019-01-12");
        FlightData flightData1 = new FlightData("MU002", "BJS", "WUH", "2019-02-11");
        FlightData flightData2 = new FlightData("CZ003", "CTU", "CAN", "2019-03-10");
        FlightData flightData3 = new FlightData("MH004", "CAN", "CTU", "2019-04-09");
        FlightData flightData4 = new FlightData("G5005", "WUH", "BJS", "2019-05-08");
        FlightData flightData5 = new FlightData("AS006", "KUL", "SHA", "2019-06-07");

        flightDataList.add(flightData0);
        flightDataList.add(flightData1);
        flightDataList.add(flightData2);
        flightDataList.add(flightData3);
        flightDataList.add(flightData4);
        flightDataList.add(flightData5);

        List<Thread> threads = new ArrayList<>();
        for (FlightData flightData : flightDataList) {
            Runnable runnable = new FlightServiceThread(flightData);
            Thread thread = new Thread(runnable);
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

    }


}
