package FlightReservation.controller;

import FlightReservation.model.Flight;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

public interface SearchServiceInterface {
    public ArrayList<Flight> findAll();
    public ArrayList<Flight> findFlights(LocalDateTime flightDate, String departureCity, String arrivalCity);
    public Optional<Flight> findFlightById(int flightId);
    public void deleteFlight(int flightId);
    public void editFlight(int flightId, LocalDateTime newDepartureTime, LocalDateTime newArrivalTime);
    public void addFlight(Flight flight);
    public ArrayList<Flight> sortByPrice(ArrayList<Flight> flights);
    public ArrayList<Flight> sortByDepartureTime(ArrayList<Flight> flights);
    public ArrayList<Flight> sortByArrivalTime(ArrayList<Flight> flights);
    public ArrayList<Flight> makeFlights();
}
