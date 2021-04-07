package FlightReservation.controller;

import FlightReservation.model.Flight;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

public interface SearchServiceInterface {
    ArrayList<Flight> findAll();
    ArrayList<Flight> findFlights(LocalDateTime flightDate, String departureCity, String arrivalCity);
    Optional<Flight> findFlightById(int flightId);
    ArrayList<Flight> sortByPrice(ArrayList<Flight> flights);
    ArrayList<Flight> sortByDepartureTime(ArrayList<Flight> flights);
    ArrayList<Flight> sortByArrivalTime(ArrayList<Flight> flights);
    ArrayList<Flight> makeFlights();
}
