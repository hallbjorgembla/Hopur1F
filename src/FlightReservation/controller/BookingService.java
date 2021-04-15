package FlightReservation.controller;

import FlightReservation.model.*;

import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;

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

    public ArrayList<String> getEconomySeats(int flightID) {
        ResultSet rs = bookingDBManager.getAllSeats(flightID);
        ArrayList<String> economySeats = new ArrayList<>();
        try {
            while(rs.next()) {
                if (!rs.getBoolean(2) & rs.getBoolean(3)) {
                    economySeats.add(rs.getString(1));
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return economySeats;
    }

    public ArrayList<String> getFirstClassSeats(int flightID) {
        ResultSet rs = bookingDBManager.getAllSeats(flightID);
        ArrayList<String> firstClassSeats = new ArrayList<>();
        try {
            while(rs.next()) {
                //if seatOccupation is false & it is first class
                if (!rs.getBoolean(2) & !rs.getBoolean(3)) {
                    firstClassSeats.add(rs.getString(1));
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return firstClassSeats;
    }
}
