package FlightReservation.model;

import java.util.ArrayList;

public class Booking {
    private int bookingID;
    private Ticket ticket;

    public Booking(int bookingID, Ticket ticket) {
        this.bookingID = bookingID;
        this.ticket = ticket;
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
