package FlightReservation.controller;

import FlightReservation.model.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class BookingController {
    private BookingService bookingService;
    private Booking booking;
    private Ticket ticket;
    private ArrayList<Seat> seats;

    public BookingController() {
        this.bookingService = new BookingService();
    }

    /*public Ticket addTicket(int ticketID, int passengerID, String name, String passportNumber, int seatID, String seatNumber, boolean seatOccupation, boolean classEconomy, int flightID, String flightNumber, String flightDeparture, String flightDestination, LocalDateTime departureTime, LocalDateTime arrivalTime, double flightTime) {
        Passenger p = addPassenger(passengerID, name, passportNumber);
        Seat s = addSeatForPassenger(seatID, seatNumber, seatOccupation, classEconomy);
        return new Ticket(ticketID, p, s, flightID, flightNumber, flightDeparture, flightDestination, departureTime, arrivalTime, flightTime);
    }

    public Passenger addPassenger(int passengerID, String name, String passportNumber){
        return new Passenger(passengerID, name, passportNumber);

    }

    public Seat addSeatForPassenger(int seatID, String seatNumber, boolean seatOccupation, boolean classEconomy){
        return new Seat(seatID, seatNumber, seatOccupation, classEconomy);
    }*/

    public void book(int bookingNO,  Ticket ticket) {
        bookingService.book(new Booking(bookingNO, ticket));
    }

    public void cancelBooking(int bookingNO, Ticket ticket) {
        bookingService.cancelBooking(new Booking(bookingNO, ticket));
    }

    public Booking showTicketInBooking(int bookingID) {
        ticket = bookingService.getTicket(bookingID);
        booking = new Booking(bookingID, ticket);
        return booking;
    }

    public ArrayList<String> getEconomySeats(int flightID) {
        return bookingService.getEconomySeats(flightID);
    }

    public ArrayList<String> getFirstClassSeats(int flightID) {
        return bookingService.getFirstClassSeats(flightID);
    }

    public Seat getSeat(int flightID, String seatNumber) {
        return bookingService.getSeat(flightID, seatNumber);
    }
}
