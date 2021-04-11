package FlightReservation.controller;

import FlightReservation.model.Booking;

import java.sql.*;

public class BookingDBManager {

    public BookingDBManager() {
    }

    private Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:company.db");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public ResultSet ticketsByBookingID(int bookingID){
        Connection c;
        ResultSet rs = null;
        try {
            c = getConnection();
            PreparedStatement pStmt;
            String sql= (
                    "SELECT ticketID, " +
                            "passengerID, " +
                            "name, " +
                            "passportNumber, " +
                            "seatID, " +
                            "seatNumber, " +
                            "seatOccupation, " +
                            "classEconomy, " +
                            "flightID, " +
                            "flightNumber, " +
                            "flightDeparture, " +
                            "flightDestination, " +
                            "departureTime, " +
                            "arrivalTime, " +
                            "flightTime FROM " +
                                "Tickets, Passengers, Seats, Flights WHERE " +
                                    "Ticket.ticketID == Passengers.ticketID AND " +
                                    "Ticket.ticketID == Seats.ticketID AND " +
                                    "Ticket.bookingID == " + bookingID + " AND " +
                                    "Seats.flightID == Flight.flightID GROUP BY" +
                                        "ticketID;");
            pStmt = c.prepareStatement(sql);
            rs = pStmt.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        return rs;
    }

    public void insertToDB(Booking booking){

    }

    public String createQuery() {
        return null;
    }
}
