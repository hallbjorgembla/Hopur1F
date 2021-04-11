package FlightReservation.controller;

import FlightReservation.model.*;

import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BookingService {
    BookingDBManager bookingDBManager;

    public BookingService() {
        this.bookingDBManager = new BookingDBManager();
    }

    public void book(Booking bookingNO) {

    }

    public void cancelBooking(Booking bookingNO) {

    }

    public ArrayList<Ticket> getTickets(int bookingID) {
        ResultSet rs = bookingDBManager.ticketsByBookingID(bookingID);
        ArrayList<Ticket>  ticketList = new ArrayList<Ticket>();
        try {
            while(rs.next()) {
                int ticketID = rs.getInt(1);

                int passengerID = rs.getInt(2);
                String name = rs.getString(3);
                String passPortnumber = rs.getString(4);
                Passenger p = new Passenger(passengerID, name, passPortnumber);

                int seatID = rs.getInt(5);
                String seatNumber = rs.getString(6);
                Boolean seatOccupation = rs.getBoolean(7);
                Boolean classEconomy = rs.getBoolean(8);
                Seat s = new Seat(seatID, seatNumber, seatOccupation, classEconomy);

                int flightID = rs.getInt(9);
                String flightNumber = rs.getString(10);
                String flightDeparture = rs.getString(11);
                String flightDestination = rs.getString(12);
                LocalDateTime departureTime = rs.getTimestamp(13).toLocalDateTime();
                LocalDateTime arrivalTime = rs.getTimestamp(14).toLocalDateTime();
                double flightTime = rs.getDouble(15);

                Ticket t = new Ticket(ticketID, p, s, flightID, flightNumber, flightDeparture, flightDestination, departureTime, arrivalTime, flightTime);
                ticketList.add(t);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return ticketList;
    }
}
