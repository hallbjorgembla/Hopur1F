package FlightReservation.controller;

import FlightReservation.model.Booking;
import FlightReservation.model.Passenger;
import FlightReservation.model.Seat;
import FlightReservation.model.Ticket;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class BookingController {
    private BookingService bookingService;
    private Booking booking;
    private ArrayList<Ticket> tickets;

    public BookingController() {
        this.bookingService = new BookingService();
    }

    public ArrayList<Ticket> addTicket(int ticketID, int passengerID, String name, String passportNumber, int seatID, String seatNumber, boolean seatOccupation, boolean classEconomy, int flightID, String flightNumber, String flightDeparture, String flightDestination, LocalDateTime departureTime, LocalDateTime arrivalTime, double flightTime) {
        Passenger p = addPassenger(passengerID, name, passportNumber);
        Seat s = addSeatForPassenger(seatID, seatNumber, seatOccupation, classEconomy);
        Ticket t = new Ticket(ticketID, p, s, flightID, flightNumber, flightDeparture, flightDestination, departureTime, arrivalTime, flightTime);
        tickets.add(t);
        return tickets;
    }

    public Passenger addPassenger(int passengerID, String name, String passportNumber){
        return new Passenger(passengerID, name, passportNumber);

    }

    public Seat addSeatForPassenger(int seatID, String seatNumber, boolean seatOccupation, boolean classEconomy){
        return new Seat(seatID, seatNumber, seatOccupation, classEconomy);
    }

    public void book(int bookingNO, ArrayList<Ticket> tickets) {
        booking = new Booking(bookingNO, tickets);
        bookingService.book(booking);
    }

    public void cancelBooking() {
        bookingService.cancelBooking(booking);
    }

    public Booking getBooking(Booking bookingNO) {//sýnir alla miða fyrir bókun
        tickets = bookingService.getTickets(bookingNO.getBookingID());
        booking = new Booking(bookingNO.getBookingID(), tickets);
        return booking;
    }
}
