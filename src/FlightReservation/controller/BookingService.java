package FlightReservation.controller;

import FlightReservation.model.Booking;

import java.sql.ResultSet;

public class BookingService {
    BookingDBManager bookingDBManager;

    public BookingService() {
        this.bookingDBManager = new BookingDBManager();
    }

    public void book(Booking bookingNO) {

    }

    public void cancelBooking(Booking bookingNO) {

    }

    public Booking getBooking(Booking bookingNO) {
        ResultSet rs = bookingDBManager.allBooking();
        return bookingNO;
    }
}
