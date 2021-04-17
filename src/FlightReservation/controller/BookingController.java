package FlightReservation.controller;

import FlightReservation.model.*;

import java.util.ArrayList;

public class BookingController {
    private BookingService bookingService;
    private Booking booking;
    private Ticket ticket;
    private ArrayList<Seat> seats;

    public BookingController() {
        this.bookingService = new BookingService();
    }

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

    public int getNextBookingID() {
        return bookingService.getNextBookingID();
    }

    public int getNextTicketID() {
        return bookingService.getNextTicketID();
    }
}
