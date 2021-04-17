
package FlightReservation.controller;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.time.LocalDate;

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
        Connection c;
        ResultSet rs = null;
        try {
            c = getConnection();
            PreparedStatement preparedStatement;
            preparedStatement = c.prepareStatement(sql);
            rs = preparedStatement.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        return rs;
    }

    public ResultSet findAll(){
        ResultSet rs;
        rs = executeQuery("SELECT * FROM Flights");
        return rs;
    }

    public ResultSet findFlights(LocalDate departureDate, String departureCity, String arrivalCity){
        String searchString = "SELECT * FROM Flights WHERE " +
                "departureTime LIKE '" + departureDate.toString() + "%' AND " +
                "flightDeparture = '" + departureCity + "' AND " +
                "flightDestination = '" + arrivalCity + "'";
        return executeQuery(searchString);
    }

    public ResultSet findFlightsByDate(LocalDate departureDate) {
        String searchString = "SELECT * FROM Flights WHERE " +
                "departureTime LIKE '" + departureDate.toString() + "%'";
        return executeQuery(searchString);
    }

    public ResultSet findDepartureAndArrival(String departureCity, String arrivalCity) {
        String searchString = "SELECT * FROM Flights WHERE " +
                "flightDeparture = '" + departureCity + "' AND " +
                "flightDestination = '" + arrivalCity + "'";
        return executeQuery(searchString);
    }

    public ResultSet findFlightByDeparture(String departureCity) {
        String sql = "SELECT * FROM Flights WHERE " +
                "flightDeparture = '" + departureCity + "'";
        return executeQuery(sql);
    }

    public ResultSet findFlightByArrival(String destinationCity) {
        String sql = "SELECT * FROM Flights WHERE " +
                "flightDestination = '" + destinationCity + "'";
        return executeQuery(sql);
    }
}
