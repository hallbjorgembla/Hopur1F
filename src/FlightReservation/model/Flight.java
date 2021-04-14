package FlightReservation.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
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

    public Flight(int flightID, String flightNumber, String flightDeparture, String flightDestination, LocalDateTime departureTime, double flightTime, int totalNumberOfSeats, double priceFirstClass, double priceEconomy) {
        this.flightID = flightID;
        this.flightNumber = flightNumber;
        this.flightDeparture = flightDeparture;
        this.flightDestination = flightDestination;
        this.departureTime = departureTime;
        this.arrivalTime = departureTime.plusHours((int) flightTime);
        this.flightTime = flightTime;
        this.totalNumberOfSeats = totalNumberOfSeats;
        this.priceFirstClass = priceFirstClass;
        this.priceEconomy = priceEconomy;

        this.availableSeats = new ArrayList<Seat>();
        this.seats = new ArrayList<Seat>();
        for(int i = 0; i < totalNumberOfSeats; i++){
            availableSeats.add(new Seat(i, String.valueOf(i+1), false, false));
            seats.add(new Seat(i, String.valueOf(i+1), false, false));
        }
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

    @Override
    public String toString() {
        return "Flight{" +
                "flightID=" + flightID +
                ", flightNumber='" + flightNumber + '\'' +
                ", flightDeparture='" + flightDeparture + '\'' +
                ", flightDestination='" + flightDestination + '\'' +
                ", departureTime=" + departureTime +
                ", arrivalTime=" + arrivalTime +
                ", flightTime=" + flightTime +
                '}';
    }
}
