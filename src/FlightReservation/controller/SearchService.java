package FlightReservation.controller;

import FlightReservation.model.Flight;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

public class SearchService implements SearchServiceInterface {
    BookingDBManager bookingDBManager;

    public SearchService() {
    }

    @Override
    public ArrayList<Flight> findAll() {
        return null;
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
