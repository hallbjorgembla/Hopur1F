package FlightReservation.model;

import java.time.LocalDateTime;

public class Ticket {
    private int ticketID;
    private Passenger passenger;
    private Seat seat;
    private int flightID;
    private String flightNumber;
    private String flightDeparture;
    private String flightDestination;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private double flightTime;

    public Ticket(int ticketID, Passenger passenger, Seat seat, int flightID, String flightNumber, String flightDeparture, String flightDestination, LocalDateTime departureTime, LocalDateTime arrivalTime, double flightTime) {
        this.ticketID = ticketID;
        this.passenger = passenger;
        this.seat = seat;
        this.flightID  = flightID;
        this.flightNumber = flightNumber;
        this.flightDeparture = flightDeparture;
        this.flightDestination = flightDestination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.flightTime = flightTime;
    }

    public int getTicketID() {
        return ticketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public int getFlightID() {
        return flightID;
    }

    public void setFlightID(int flightID) {
        this.flightID  = flightID;
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

    public void setFlightTime() {
        this.flightTime = flightTime;
    }
}
