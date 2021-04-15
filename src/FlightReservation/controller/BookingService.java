package FlightReservation.controller;

import FlightReservation.model.*;

import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BookingService {
    private BookingDBManager bookingDBManager;

    public BookingService() {
        this.bookingDBManager = new BookingDBManager();
    }

    public void book(Booking booking) {
        bookingDBManager.insertToDB(booking);
    }


    public void cancelBooking(Booking booking) {
        bookingDBManager.deleteFromDB(booking);
    }

    public String[] getFirstClassSeats(int flightID){
        ResultSet rs = bookingDBManager.getFirstClassSeats(flightID);
        String[] first = new String[9];
        try {
            int i = 0;
            while (rs.next()) {
                String seatNumber = rs.getString(1);
                first[i] = seatNumber;
                i += 1;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return first;
    }

    public String[] getEconomySeats(int flightID){
        ResultSet rs = bookingDBManager.getEconomySeats(flightID);
        String[] economy = new String[22];
        try {
            int i = 0;
            while (rs.next()) {
                String seatNumber = rs.getString(1);
                economy[i] = seatNumber;
                i += 1;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return economy;
    }

    public Ticket getTicket(int bookingID) {
        ResultSet rs = bookingDBManager.getTicketByBookingID(bookingID);
        Ticket ticket = null;
        try {
            while(rs.next()) {
                int ticketID = rs.getInt(1);

                int passengerID = rs.getInt(2);
                String name = rs.getString(3);
                String passportNumber = rs.getString(4);
                Passenger p = new Passenger(passengerID, name, passportNumber);

                int seatID = rs.getInt(5);
                String seatNumber = rs.getString(6);
                boolean seatOccupation = rs.getBoolean(7);
                boolean classEconomy = rs.getBoolean(8);
                Seat s = new Seat(seatID, seatNumber, seatOccupation, classEconomy);

                int flightID = rs.getInt(9);
                String flightNumber = rs.getString(10);
                String flightDeparture = rs.getString(11);
                String flightDestination = rs.getString(12);
                LocalDateTime departureTime = rs.getTimestamp(13).toLocalDateTime();
                LocalDateTime arrivalTime = rs.getTimestamp(14).toLocalDateTime();
                double flightTime = rs.getDouble(15);

                ticket = new Ticket(ticketID, p, s, flightID, flightNumber, flightDeparture, flightDestination, departureTime, arrivalTime, flightTime);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return ticket;
    }
}
