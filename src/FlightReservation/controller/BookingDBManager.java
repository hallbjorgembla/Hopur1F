package FlightReservation.controller;

import FlightReservation.model.Booking;
import FlightReservation.model.Ticket;

import java.sql.*;
import java.util.ArrayList;

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

    public ResultSet getAvailableSeatsFromFlight(int flightID){
        Connection c;
        ResultSet rs = null;
        try {
            c = getConnection();
            PreparedStatement pStmt;
            String sql= (
                    "SELECT * FROM Seats WHERE " +
                            "flightID = ? AND " +
                            "seatOccupation = FALSE GROUP BY " +
                                "seatID;");
            pStmt = c.prepareStatement(sql);
            pStmt.setInt(1, flightID);
            rs = pStmt.executeQuery();
        }
        catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        return rs;
    }

    public ResultSet getTicketsByBookingID(int bookingID){
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
                                    "Ticket.ticketID = Passengers.ticketID AND " +
                                    "Ticket.ticketID = Seats.ticketID AND " +
                                    "Ticket.bookingID = ? AND " +
                                    "Seats.flightID = Flight.flightID GROUP BY" +
                                        "ticketID;");
            pStmt = c.prepareStatement(sql);
            pStmt.setInt(1, bookingID);
            rs = pStmt.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        return rs;
    }

    public void insertToDB(Booking booking){
        Connection a;
        try {
            a = getConnection();
            PreparedStatement pStmt;
            String sql;

            int bookingID = booking.getBookingID();
            sql = "INSERT INTO Bookings (bookingID) VALUES (?)";
            pStmt = a.prepareStatement(sql);
            pStmt.setInt(1, bookingID);
            pStmt.execute();

            ArrayList<Ticket> tickets = booking.getTickets();
            for(Ticket ticket: tickets){

                sql = "INSERT INTO Tickets (ticketID, bookingID) VALUES (?,?)";
                pStmt = a.prepareStatement(sql);
                pStmt.setInt(1, ticket.getTicketID());
                pStmt.setInt(2, bookingID);
                pStmt.execute();

                sql = "INSERT INTO Tickets (ticketID, bookingID) VALUES (?,?)";
                pStmt = a.prepareStatement(sql);
                pStmt.setInt(1, ticket.getTicketID());
                pStmt.setInt(2, bookingID);
                pStmt.execute();

                sql = "INSERT INTO Passengers (passengerID, name, passportNumber) VALUES (?,?,?)";
                pStmt = a.prepareStatement(sql);
                pStmt.setInt(1, ticket.getPassenger().getPassengerID());
                pStmt.setString(2, ticket.getPassenger().getName());
                pStmt.setString(3, ticket.getPassenger().getPassportNumber());
                pStmt.execute();

                sql = "UPDATE Seats SET seatOccupation = ? AND ticketID = ? WHERE seatID = ?";
                pStmt = a.prepareStatement(sql);
                pStmt.setBoolean(1, ticket.getSeat().isSeatOccupation());
                pStmt.setInt(2, ticket.getTicketID());
                pStmt.setInt(3, ticket.getSeat().getSeatID());
                pStmt.execute();
            }


            a.close();

        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }

    //sleppa??
    public void deleteFromDB(Booking booking) {

    }

    public String createQuery() {
        return null;
    }
}
