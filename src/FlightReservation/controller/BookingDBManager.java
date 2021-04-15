package FlightReservation.controller;

import FlightReservation.model.*;

import java.sql.*;

public class BookingDBManager {

    public BookingDBManager() {
    }

    private Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/flightsearchdb", "root", "password123");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public ResultSet getTicketByBookingID(int bookingID) {
        Connection c;
        ResultSet rs = null;
        try {
            c = getConnection();
            PreparedStatement pStmt;
            String sql = (
                    "SELECT Tickets.ticketID, " +
                            "passengerID, " +
                            "name, " +
                            "passportNumber, " +
                            "seatID, " +
                            "seatNumber, " +
                            "seatOccupation, " +
                            "seatEconomy, " +
                            "Flights.flightID, " +
                            "Flights.flightNumber, " +
                            "flightDeparture, " +
                            "flightDestination, " +
                            "departureTime, " +
                            "arrivalTime, " +
                            "flightTime FROM " +
                            "Tickets, Passengers, Seats, Flights WHERE " +
                            "Tickets.ticketID = Passengers.ticketID AND " +
                            "Tickets.ticketID = Seats.ticketID AND " +
                            "Tickets.bookingID = ? AND " +
                            "Seats.flightID = Flights.flightID GROUP BY " +
                            "ticketID");
            pStmt = c.prepareStatement(sql);
            pStmt.setInt(1, bookingID);
            rs = pStmt.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        return rs;
    }

    public void insertToDB(Booking booking) {
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

            Ticket ticket = booking.getTicket();
            sql = "INSERT INTO Tickets (ticketID, bookingID) VALUES (?,?)";
            pStmt = a.prepareStatement(sql);
            pStmt.setInt(1, ticket.getTicketID());
            pStmt.setInt(2, bookingID);
            pStmt.execute();

            sql = "INSERT INTO Passengers (passengerID, name, passportNumber, ticketID) VALUES (?,?,?,?)";
            pStmt = a.prepareStatement(sql);
            pStmt.setInt(1, ticket.getPassenger().getPassengerID());
            pStmt.setString(2, ticket.getPassenger().getName());
            pStmt.setString(3, ticket.getPassenger().getPassportNumber());
            pStmt.setInt(4, ticket.getTicketID());
            pStmt.execute();

            sql = "INSERT INTO Seats(seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) " +
                    "VALUES(?,?,?,?,?,?,?)";
            pStmt = a.prepareStatement(sql);
            pStmt.setInt(1, ticket.getSeat().getSeatID());
            pStmt.setString(2, ticket.getSeat().getSeatNumber());
            pStmt.setBoolean(3, ticket.getSeat().isSeatOccupation());
            pStmt.setBoolean(4, ticket.getSeat().isClassEconomy());
            pStmt.setInt(5, ticket.getFlightID());
            pStmt.setString(6, ticket.getFlightNumber());
            pStmt.setInt(7, ticket.getTicketID());
            pStmt.execute();

            a.close();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }

    public void deleteFromDB(Booking booking) {
        Connection a;
        try {
            a = getConnection();
            PreparedStatement pStmt;
            String sql;
            int ticketID = booking.getTicket().getTicketID();
            int bookingID = booking.getBookingID();

            sql = "DELETE FROM Passengers WHERE ticketID = ?";
            pStmt = a.prepareStatement(sql);
            pStmt.setInt(1, ticketID);
            pStmt.execute();

            sql = "DELETE FROM Seats WHERE ticketID = ?";
            pStmt = a.prepareStatement(sql);
            pStmt.setInt(1, ticketID);
            pStmt.execute();

            sql = "DELETE FROM Tickets WHERE ticketID = ?";
            pStmt = a.prepareStatement(sql);
            pStmt.setInt(1, ticketID);
            pStmt.execute();

            sql = "DELETE FROM Bookings WHERE bookingID = ?";
            pStmt = a.prepareStatement(sql);
            pStmt.setInt(1, bookingID);
            pStmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }

    public ResultSet getAllSeats(int flightID) {
        Connection a;
        try {
            a = getConnection();
            PreparedStatement pStmt;
            String sql;

            sql = "SELECT seatNumber,  FROM Passengers WHERE ticketID = ?";
            pStmt = a.prepareStatement(sql);
            pStmt.setInt(1, ticketID);
            pStmt.execute();

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }
}
