package FlightReservation.controller;

import FlightReservation.model.Booking;

import java.util.List;

public class BookingController {
    private BookingService bookingService;
    private List<Booking> bookings;

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
        return bookingService.getBooking(bookingNO);
    }
}
