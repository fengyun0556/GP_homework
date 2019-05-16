package com.gupao.multiThread.first;

public class FlightServiceThread implements Runnable{

    private FlightData flightData;

    public FlightServiceThread(FlightData flightData) {
        this.flightData = flightData;
    }

    public void doDealWithFlightData() {
        System.out.println("当前线程：" + Thread.currentThread().getName() + "，处理航班数据：" + flightData);
    }

    @Override
    public void run() {
        this.doDealWithFlightData();
    }
}

