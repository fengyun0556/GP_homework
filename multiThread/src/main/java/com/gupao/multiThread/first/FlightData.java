package com.gupao.multiThread.first;

/**
 * 机票数据
 */
public class FlightData {
    /** 航班号 */
    private String flightNo;
    /** 出发城市 */
    private String departureCity;
    /** 到达城市 */
    private String arrivalCity;
    /** 起飞日期 */
    private String departureDate;

    public FlightData(String flightNo, String departureCity, String arrivalCity, String departureDate) {
        this.flightNo = flightNo;
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.departureDate = departureDate;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    @Override
    public String toString() {
        return "FlightData{" +
                "flightNo='" + flightNo + '\'' +
                ", departureCity='" + departureCity + '\'' +
                ", arrivalCity='" + arrivalCity + '\'' +
                ", departureDate='" + departureDate + '\'' +
                '}';
    }
}
