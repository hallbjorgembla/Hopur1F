package FlightReservation.controller;

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
            String sql1 = ("SELECT * FROM Tickets Where bookingID == " + bookingID + ";");//Finna alla miða með sömu bókunarnúmer
            String sql2 = ("SELECT ticketID, name, seat, flight FROM ");//finna alla upplýsingar fyrir hvern miða
            pStmt = c.prepareStatement(sql1);
            rs = pStmt.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        return rs;
    }

    public String createQuery() {
        return null;
    }
}
