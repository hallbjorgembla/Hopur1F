package FlightReservation.model;

import java.util.ArrayList;

public class Booking {
    private int bookingID;
    private ArrayList<Ticket> tickets;

    public Booking(int bookingID, ArrayList<Ticket> tickets) {
        this.bookingID = bookingID;
        this.tickets = tickets;
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
    }
}

