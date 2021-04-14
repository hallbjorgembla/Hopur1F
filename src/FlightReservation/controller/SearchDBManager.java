package FlightReservation.controller;

import FlightReservation.model.Flight;

import javax.sql.rowset.CachedRowSet;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

public class SearchDBManager {
    public SearchDBManager() {
    }

    private Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/flightSearchDB", "root", "password123");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public ResultSet executeQuery(String sql){
        Connection c = null;
        ResultSet rs = null;
        try {
            c = getConnection();
            PreparedStatement preparedStatement = null;
            preparedStatement = c.prepareStatement(sql);
            rs = preparedStatement.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        return rs;
    }

    public ResultSet findAll(){
        Connection c = null;
        ResultSet rs = null;
        rs = executeQuery("SELECT * FROM Flights");
        return rs;
    }

    public ResultSet findFlights(){
        return null;
    }

    public String createQuery() {
        return null;
    }
}
