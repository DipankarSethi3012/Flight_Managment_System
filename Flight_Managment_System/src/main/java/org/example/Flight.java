package org.example;

public class Flight {
    private int flightId;
    private String flightName;
    private String source;
    private String destination;
    private int totalSeats;
    private int bookedSeats;

    public Flight(int flightId, String flightName, String source, String destination, int totalSeats) {
        this.flightId = flightId;
        this.flightName = flightName;
        this.source = source;
        this.destination = destination;
        this.totalSeats = totalSeats;
        this.bookedSeats = 0;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public int getBookedSeats() {
        return bookedSeats;
    }

    public void setBookedSeats(int bookedSeats) {
        this.bookedSeats = bookedSeats;
    }

    // Method to book a seat
    public boolean bookSeat() {
        if (isAvailable()) {
            bookedSeats += 1;
            return true;
        }
        return false;
    }

    // Method to check if seats are available
    public boolean isAvailable() {
        return bookedSeats < totalSeats;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightId=" + flightId +
                ", flightName='" + flightName + '\'' +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", totalSeats=" + totalSeats +
                ", bookedSeats=" + bookedSeats +
                ", isAvailable=" + isAvailable() +
                '}';
    }
}
