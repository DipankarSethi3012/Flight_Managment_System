package org.example;

public class Layover {
    private int layoverId;
    private int flightId;
    private int airportId;
    private int layoverTime;

    public Layover(int layoverId, int flightId, int airportId, int layoverTime) {
        this.layoverId = layoverId;
        this.flightId = flightId;
        this.airportId = airportId;
        this.layoverTime = layoverTime;
    }

    public int getLayoverId() {
        return layoverId;
    }

    public void setLayoverId(int layoverId) {
        this.layoverId = layoverId;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public int getAirportId() {
        return airportId;
    }

    public void setAirportId(int airportId) {
        this.airportId = airportId;
    }

    public int getLayoverTime() {
        return layoverTime;
    }

    public void setLayoverTime(int layoverTime) {
        this.layoverTime = layoverTime;
    }

    @Override
    public String toString() {
        return "Layover{" +
                "layoverId=" + layoverId +
                ", flightId=" + flightId +
                ", airportId=" + airportId +
                ", layoverTime=" + layoverTime +
                '}';
    }
}
