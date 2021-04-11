package FlightReservation.controller;

import FlightReservation.model.Booking;
import FlightReservation.model.Ticket;

import java.util.ArrayList;

public class BookingController {
    private BookingService bookingService;
    private Booking booking;
    private ArrayList<Ticket> tickets;

    public BookingController() {
        this.bookingService = new BookingService();
    }
    public void book(Booking bookingNO) {
        bookingService.book(bookingNO);
    }

    public void cancelBooking(Booking bookingNO) {
        bookingService.cancelBooking(bookingNO);
    }

    public Booking showBooking(Booking bookingNO) {
        tickets = bookingService.getTickets(bookingNO.getBookingID());
        booking = new Booking(bookingNO.getBookingID(), tickets);
        return booking;
    }
}
