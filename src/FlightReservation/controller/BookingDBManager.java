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

    public ResultSet allBooking(){
        Connection c;
        ResultSet rs = null;
        try {
            c = getConnection();
            PreparedStatement pStmt;
            String sql = "Select * FROM Booking";//Á eftir að bæta meir
            pStmt = c.prepareStatement(sql);
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
