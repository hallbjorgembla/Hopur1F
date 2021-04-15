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

    public Ticket addTicket(int ticketID, int passengerID, String name, String passportNumber, int seatID, String seatNumber, boolean seatOccupation, boolean classEconomy, int flightID, String flightNumber, String flightDeparture, String flightDestination, LocalDateTime departureTime, LocalDateTime arrivalTime, double flightTime) {
        Passenger p = addPassenger(passengerID, name, passportNumber);
        Seat s = addSeatForPassenger(seatID, seatNumber, seatOccupation, classEconomy);
        ticket = new Ticket(ticketID, p, s, flightID, flightNumber, flightDeparture, flightDestination, departureTime, arrivalTime, flightTime);
        return ticket;
    }

    public Passenger addPassenger(int passengerID, String name, String passportNumber){
        return new Passenger(passengerID, name, passportNumber);

    }

    public Seat addSeatForPassenger(int seatID, String seatNumber, boolean seatOccupation, boolean classEconomy){
        return new Seat(seatID, seatNumber, seatOccupation, classEconomy);
    }

    public void book(int bookingNO,  Ticket ticket) {
        booking = new Booking(bookingNO, ticket);
        bookingService.book(booking);
    }

    public void cancelBooking(int bookingNO, Ticket ticket) {
        booking = new Booking(bookingNO, ticket);
        bookingService.cancelBooking(booking);
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
}
