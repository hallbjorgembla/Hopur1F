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
                            "passengerKT, " +
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
            Ticket ticket = booking.getTicket();

            sql = "INSERT INTO Bookings (bookingID) VALUES (?)";
            pStmt = a.prepareStatement(sql);
            pStmt.setInt(1, bookingID);
            pStmt.execute();

            sql = "INSERT INTO Tickets (ticketID, bookingID) VALUES (?,?)";
            pStmt = a.prepareStatement(sql);
            pStmt.setInt(1, ticket.getTicketID());
            pStmt.setInt(2, bookingID);
            pStmt.execute();

            sql = "INSERT INTO Passengers (passengerKT, name, passportNumber, ticketID) VALUES (?,?,?,?)";
            pStmt = a.prepareStatement(sql);
            pStmt.setString(1, ticket.getPassenger().getPassengerKT());
            pStmt.setString(2, ticket.getPassenger().getName());
            pStmt.setString(3, ticket.getPassenger().getPassportNumber());
            pStmt.setInt(4, ticket.getTicketID());
            pStmt.execute();

            sql = "UPDATE Seats SET seatOccupation = ?, ticketID = ? WHERE flightID = ? AND seatID = ?";
            pStmt = a.prepareStatement(sql);
            pStmt.setBoolean(1, true);
            pStmt.setInt(2, ticket.getTicketID());
            pStmt.setInt(3, ticket.getFlightID());
            pStmt.setInt(4, ticket.getSeat().getSeatID());
            pStmt.executeUpdate();

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

            sql = "UPDATE Seats SET seatOccupation = ?, ticketID = ? WHERE ticketID = ?";
            pStmt = a.prepareStatement(sql);
            pStmt.setBoolean(1, false);
            pStmt.setNull(2, Types.NULL);
            pStmt.setInt(3, ticketID);
            pStmt.executeUpdate();

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
        ResultSet rs = null;
        try {
            a = getConnection();
            PreparedStatement pStmt;
            String sql;

            sql = "SELECT * FROM Seats WHERE flightID = ?";
            pStmt = a.prepareStatement(sql);
            pStmt.setInt(1, flightID);
            rs = pStmt.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Opened database successfully");
        return rs;
    }

    public ResultSet getBookingID() {
        Connection a;
        ResultSet rs = null;
        try {
            a = getConnection();
            PreparedStatement pStmt;
            String sql = "SELECT bookingID FROM Bookings ORDER BY bookingID DESC LIMIT 1";//nær í seinustu línu
            pStmt = a.prepareStatement(sql);
            rs = pStmt.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Opened database successfully");
        return rs;
    }

    public ResultSet getTicketID() {
        Connection a;
        ResultSet rs = null;
        try {
            a = getConnection();
            PreparedStatement pStmt;
            String sql = "SELECT ticketID FROM Tickets ORDER BY ticketID DESC LIMIT 1";//nær í seinustu línu
            pStmt = a.prepareStatement(sql);
            rs = pStmt.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Opened database successfully");
        return rs;
    }
    public ResultSet getTicketIdByPassenger(String kennitala) {
        Connection a;
        ResultSet rs = null;
        try{
            a = getConnection();
            PreparedStatement pStmt;
            String sql;

            sql = "SELECT ticketID from Passengers WHERE passengerKT = ?";
            pStmt = a.prepareStatement(sql);
            pStmt.setString(1, kennitala);
            rs = pStmt.executeQuery();

        }
        catch (Exception e){
            e.printStackTrace();
            System.exit(0);
        }
        return rs;
    }

    public ResultSet getSeatAndFlightNumber(int ticketID) {
        Connection c;
        ResultSet rs = null;
        try {
            c = getConnection();
            PreparedStatement pStmt;
            String sql = (
                    "SELECT * FROM " +
                            "Seats, Flights WHERE " +
                            "ticketID = ? AND " +
                            "Seats.flightID = Flights.flightID");
            pStmt = c.prepareStatement(sql);
            pStmt.setInt(1, ticketID);
            rs = pStmt.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        return rs;
    }

    public ResultSet getPassengersByKennitala(String name, String passportNumber, String kennitala) {
        Connection c;
        ResultSet rs = null;
        try {
            c = getConnection();
            PreparedStatement pStmt;
            String sql = (
                    "SELECT * FROM " +
                            "Passengers WHERE " +
                            "passengerKT = ?" +" AND " +
                            "name = ?" + " AND " +
                            "passportNumber = ?");
            pStmt = c.prepareStatement(sql);
            pStmt.setString(1, kennitala);
            pStmt.setString(2, name);
            pStmt.setString(3, passportNumber);
            rs = pStmt.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        return rs;
    }

    public ResultSet getAllFlightCities() {
        Connection c;
        ResultSet rs = null;
        try {
            c = getConnection();
            PreparedStatement pStmt;
            String sql = ("SELECT flightDeparture, flightDestination FROM Flights");
            pStmt = c.prepareStatement(sql);
            rs = pStmt.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        return rs;
    }
}
