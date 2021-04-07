package FlightReservation.model;

import java.util.List;

public class Booking {
    private int bookingID;
    private List<Ticket> tickets;

    public Booking(int bookingID, List<Ticket> tickets) {
        this.bookingID = bookingID;
        this.tickets = tickets;
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}

