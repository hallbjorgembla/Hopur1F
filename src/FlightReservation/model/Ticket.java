package FlightReservation.model;

public class Ticket {
    private int ticketID;
    private Passenger passenger;
    private Seat seat;
    private Flight flight;

    public Ticket(int ticketID, Passenger passenger, Seat seat, Flight flight) {
        this.ticketID = ticketID;
        this.passenger = passenger;
        this.seat = seat;
        this.flight = flight;
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

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }
}
