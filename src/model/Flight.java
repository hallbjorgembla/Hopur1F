package model;

import java.time.LocalDateTime;
import java.util.List;

public class Flight {
    private int flightID;
    private String flightNumber;
    private String flightDeparture;
    private String flightDestination;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private double flightTime;
    private int totalNumberOfSeats;
    private List<Seat> seats;
    private List<Seat> availableSeats;
    private double priceFirstClass;
    private double priceEconomy;

    public Flight(int flightID, String flightNumber, String flightDeparture, String flightDestination, LocalDateTime departureTime, LocalDateTime arrivalTime, double flightTime, int totalNumberOfSeats, List<Seat> seats, List<Seat> availableSeats, double priceFirstClass, double priceEconomy) {
        this.flightID = flightID;
        this.flightNumber = flightNumber;
        this.flightDeparture = flightDeparture;
        this.flightDestination = flightDestination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.flightTime = flightTime;
        this.totalNumberOfSeats = totalNumberOfSeats;
        this.seats = seats;
        this.availableSeats = availableSeats;
        this.priceFirstClass = priceFirstClass;
        this.priceEconomy = priceEconomy;
    }

    public int getFlightID() {
        return flightID;
    }

    public void setFlightID(int flightID) {
        this.flightID = flightID;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getFlightDeparture() {
        return flightDeparture;
    }

    public void setFlightDeparture(String flightDeparture) {
        this.flightDeparture = flightDeparture;
    }

    public String getFlightDestination() {
        return flightDestination;
    }

    public void setFlightDestination(String flightDestination) {
        this.flightDestination = flightDestination;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public double getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(double flightTime) {
        this.flightTime = flightTime;
    }

    public int getTotalNumberOfSeats() {
        return totalNumberOfSeats;
    }

    public void setTotalNumberOfSeats(int totalNumberOfSeats) {
        this.totalNumberOfSeats = totalNumberOfSeats;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public List<Seat> getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(List<Seat> availableSeats) {
        this.availableSeats = availableSeats;
    }

    public double getPriceFirstClass() {
        return priceFirstClass;
    }

    public void setPriceFirstClass(double priceFirstClass) {
        this.priceFirstClass = priceFirstClass;
    }

    public double getPriceEconomy() {
        return priceEconomy;
    }

    public void setPriceEconomy(double priceEconomy) {
        this.priceEconomy = priceEconomy;
    }

}
