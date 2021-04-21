package FlightReservation.controller;

import FlightReservation.model.*;

import java.sql.SQLException;
import java.util.ArrayList;

public class BookingController {
    private BookingService bookingService;

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
        Ticket ticket = bookingService.getTicket(bookingID);
        Booking booking = new Booking(bookingID, ticket);
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

    public ArrayList<TicketToShow> getTicketsByPassenger(Passenger p) throws SQLException {
        ArrayList<Integer> ticketIds = bookingService.getTicketsByPassenger(p.getPassengerKT());
        System.out.println(ticketIds);
        ArrayList<TicketToShow> tickets = bookingService.getAllPassengerTickets(ticketIds, p);
        return tickets;
    }

    public ArrayList<TicketToShow> getTicketsToShow(String name, String passportNumber, String kennitala) throws SQLException {
        System.out.println("Kalla á getTicketsToShow með " + name + passportNumber + kennitala);
        ArrayList<Passenger> passengers = bookingService.getPassengersByKennitala(name, passportNumber,kennitala);
        /*for(Passenger passenger:passengers) {
            ArrayList<TicketToShow> ti
        }*/
        if(!passengers.isEmpty()) {
            ArrayList<TicketToShow> ticketList = getTicketsByPassenger(passengers.get(0));
            return ticketList;
        }
        else {
            System.out.println("Engir miðar fyrir þennan passenger");
            return new ArrayList<TicketToShow>();
        }
    }

    public ArrayList<String> getFlightCities(Boolean isDeparture){
        return bookingService.getFlightCitiesByCondition(isDeparture);
    }
}
