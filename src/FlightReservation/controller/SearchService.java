package FlightReservation.controller;

import FlightReservation.model.Flight;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

public class SearchService implements SearchServiceInterface {
    SearchDBManager searchDBManager;

    public SearchService() {
        this.searchDBManager = new SearchDBManager();
    }

    @Override
    public ArrayList<Flight> findAll() {
        ResultSet rs = searchDBManager.findAll();
        ArrayList<Flight> flightList = new ArrayList<>();
        resultToList(rs, flightList);
        return flightList;
    }

    @Override
    public ArrayList<Flight> findFlights(LocalDate flightDate, String departureCity, String arrivalCity) {
        ResultSet rs = searchDBManager.findFlights(flightDate, departureCity, arrivalCity);
        ArrayList<Flight> flightList = new ArrayList<>();
        resultToList(rs, flightList);
        return flightList;
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

    @Override
    public ArrayList<Flight> findFlightByDate(LocalDate departureDate) {
        ResultSet rs = searchDBManager.findFlightsByDate(departureDate);
        ArrayList<Flight> flightList = new ArrayList<Flight>();
        resultToList(rs, flightList);
        return flightList;
    }

    @Override
    public ArrayList<Flight> findByDepartureAndArrival(String departureCity, String arrivalCity) {
        ResultSet rs = searchDBManager.findDepartureAndArrival(departureCity, arrivalCity);
        ArrayList<Flight> flightList = new ArrayList<>();
        resultToList(rs, flightList);
        return flightList;
    }

    @Override
    public ArrayList<Flight> findFlightByArrOrDep(String departureCity, String arrivalCity) {
        ResultSet rs;
        ArrayList<Flight> flightList = new ArrayList<>();
        if (departureCity.equals("") && !arrivalCity.equals("")){
            rs = searchDBManager.findFlightByArrival(arrivalCity);
        }
        else {
            rs = searchDBManager.findFlightByDeparture(departureCity);
        }
        resultToList(rs, flightList);
        return flightList;
    }

    public void resultToList(ResultSet rs, ArrayList<Flight> flightList) {
        try {
            while (rs.next()) {
                int flightId = rs.getInt(1);
                String flightNumber = rs.getString(2);
                String departureCity = rs.getString(3);
                String arrivalCity = rs.getString(4);
                LocalDateTime departure = rs.getTimestamp(5).toLocalDateTime();
                double flightTime = rs.getDouble(7);
                double priceFirstClass = rs.getDouble(8);
                double priceEconomy = rs.getDouble(9);
                int numberOfSeats = rs.getInt(10);
                Flight flight = new Flight(flightId, flightNumber, departureCity, arrivalCity, departure, flightTime, numberOfSeats, priceFirstClass, priceEconomy);
                flightList.add(flight);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
