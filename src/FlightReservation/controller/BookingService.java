
package FlightReservation.controller;

import FlightReservation.controller.BookingDBManager;
import FlightReservation.model.*;

import java.sql.Array;
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

                String passengerKT = rs.getString(2);
                String name = rs.getString(3);
                String passportNumber = rs.getString(4);
                Passenger p = new Passenger(passengerKT, name, passportNumber);

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
                if (!rs.getBoolean(3) & rs.getBoolean(4)) {
                    economySeats.add(rs.getString(2));
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
                if (!rs.getBoolean(3) & !rs.getBoolean(4)) {
                    firstClassSeats.add(rs.getString(2));
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return firstClassSeats;
    }

    public Seat getSeat(int flightID, String seatNumber) {
        ResultSet rs = bookingDBManager.getAllSeats(flightID);
        Seat seat = null;
        try {
            while(rs.next()) {
                if (seatNumber.equals(rs.getString(2))) {
                    seat = new Seat(rs.getInt(1), rs.getString(2), rs.getBoolean(3), rs.getBoolean(4));
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return seat;
    }

    public int getNextBookingID() {
        ResultSet rs = bookingDBManager.getBookingID();
        int lastID = 0;
        try {
            if (rs.next()) {
                lastID = rs.getInt(1)+1;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return lastID;
    }

    public int getNextTicketID() {
        ResultSet rs = bookingDBManager.getTicketID();
        int lastID = 0;
        try {
            if (rs.next()) {
                lastID = rs.getInt(1)+1;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return lastID;
    }

    public ArrayList<Integer> getTicketsByPassenger(String kennitala) {
        ResultSet rs = bookingDBManager.getTicketIdByPassenger(kennitala);
        ArrayList<Integer> ticketIDs = new ArrayList<>();
        try {
            while(rs.next()) {
                ticketIDs.add(rs.getInt(1));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return ticketIDs;
    }

    public ArrayList<TicketToShow> getAllPassengerTickets(ArrayList<Integer> ticketIds, Passenger passenger) {
        ArrayList<TicketToShow> ticketToShowList= new ArrayList<>();
        for(Integer ticketId: ticketIds) {
            ResultSet rs = bookingDBManager.getSeatAndFlightNumber(ticketId);
            try {
                while(rs.next()) {
                    String seatNumber = rs.getString(2);
                    String flightNumber = rs.getString(6);
                    LocalDateTime departureTime = rs.getTimestamp(12).toLocalDateTime();
                    String departure = rs.getString(10);
                    String destination = rs.getString(11);
                    ticketToShowList.add(new TicketToShow(flightNumber, departureTime, passenger.getName(), passenger.getPassportNumber(), departure, destination, seatNumber));
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        return ticketToShowList;
    }

    public ArrayList<Passenger> getPassengersByKennitala(String name, String passportNumber, String kennitala) {
        ResultSet rs = bookingDBManager.getPassengersByKennitala(name, passportNumber, kennitala);
        ArrayList<Passenger> passengers = new ArrayList<>();
        try{
            while(rs.next()) {
                String passengerKt = rs.getString(1);
                String passengerName = rs.getString(2);
                String passengerPassportNumber = rs.getString(3);
                passengers.add(new Passenger(passengerKt, passengerName, passengerPassportNumber));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return passengers;
    }

    public ArrayList<String> getFlightCitiesByCondition(Boolean isDeparture){
        ResultSet rs =  bookingDBManager.getAllFlightCities();
        ArrayList<String> cities = new ArrayList<>();
        try{
            if (isDeparture) {
                while(rs.next()) {
                    if (!cities.contains(rs.getString(1))) {
                        cities.add(rs.getString(1));
                    }
                }
            } else {
                while(rs.next()) {
                    if (!cities.contains(rs.getString(2))) {
                        cities.add(rs.getString(2));
                    }
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return cities;
    }
}
