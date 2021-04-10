package FlightReservation.controller;

import FlightReservation.model.Flight;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

public class SearchService implements SearchServiceInterface {
    private SearchDBManager searchDBManager;
    public SearchService() {
        this.searchDBManager  = new SearchDBManager();
    }

    @Override
    public ArrayList<Flight> findAll() {
        ResultSet rs = searchDBManager.findAll();
        ArrayList<Flight> flightList = new ArrayList<Flight>();
        try {
            while (rs.next()) {
                int flightId = rs.getInt(1);
                String flightNumber = rs.getString(2);
                String departureCity = rs.getString(3);
                String arrivalCity = rs.getString(4);
                LocalDateTime departure = rs.getTimestamp(5).toLocalDateTime();
                //LocalDateTime arrival = rs.getTimestamp(6).toLocalDateTime();
                double flightTime = rs.getDouble(7);
                double priceFirstClass = rs.getDouble(8);
                double priceEconomy = rs.getDouble(9);
                int numberOfSeats = rs.getInt(10);
                Flight flight = new Flight(flightId, flightNumber, departureCity, arrivalCity, departure, flightTime, numberOfSeats, priceFirstClass, priceEconomy);
                flightList.add(flight);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return flightList;
    }

    @Override
    public ArrayList<Flight> findFlights(LocalDateTime flightDate, String departureCity, String arrivalCity) {
        return null;
    }

    @Override
    public Optional<Flight> findFlightById(int flightId) {
        return Optional.empty();
    }

    @Override
    public ArrayList<Flight> sortByPrice(ArrayList<Flight> flights) {
        return null;
    }

    @Override
    public ArrayList<Flight> sortByDepartureTime(ArrayList<Flight> flights) {
        return null;
    }

    @Override
    public ArrayList<Flight> sortByArrivalTime(ArrayList<Flight> flights) {
        return null;
    }

    @Override
    public ArrayList<Flight> makeFlights() {
        return null;
    }
}
