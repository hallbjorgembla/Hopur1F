package FlightReservation.controller;

import FlightReservation.model.Flight;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

public class SearchController {
    private SearchServiceInterface searchServiceInterface;

    public SearchController(SearchServiceInterface searchServiceInterface) {
        this.searchServiceInterface = searchServiceInterface;
    }

    public ArrayList<Flight> makeFlights(){
        return searchServiceInterface.makeFlights();
    }

    public ArrayList<Flight> findFlights(LocalDate flightDate, String departureCity, String arrivalCity){
        return searchServiceInterface.findFlights(flightDate, departureCity, arrivalCity);
    }

    public Optional<Flight> findById(int flightId) {
        return searchServiceInterface.findFlightById(flightId);
    }

    public ArrayList<Flight> sortByPrice(ArrayList<Flight> flights){
        return searchServiceInterface.sortByPrice(flights);
    }

    public ArrayList sortByDepartureTime(ArrayList<Flight> flights){
        return searchServiceInterface.sortByDepartureTime(flights);
    }

    public ArrayList sortByArrivalTime(ArrayList<Flight> flights) {
        return searchServiceInterface.sortByArrivalTime(flights);
    }

    public ArrayList showAllAvailableSeats(ArrayList<Flight> flights) {
        ArrayList<Integer> availableSeats = new ArrayList<>();
        for (Flight flight : flights) {
            availableSeats.add(flight.getAvailableSeats().size());
        }
        return availableSeats;
    }

    public ArrayList<Flight> findAll(){
        return searchServiceInterface.findAll();
    }

    public ArrayList<Flight> leitaAdFlugum(LocalDate departureDate, String departureCity, String arrivalCity) {
        if (departureCity.isEmpty() && arrivalCity.isEmpty() && departureDate == null){
            return searchServiceInterface.findAll();
        }
        else if (!departureCity.isEmpty() && !arrivalCity.isEmpty() && departureDate == null) {
            return searchServiceInterface.findByDepartureAndArrival(departureCity, arrivalCity);
        }
        else if (departureCity.isEmpty() && arrivalCity.isEmpty()) {
            return searchServiceInterface.findFlightByDate(departureDate);
        }
        else if (!departureCity.isEmpty() && !arrivalCity.isEmpty()) {
            return searchServiceInterface.findFlights(departureDate, departureCity, arrivalCity);
        }
        else {
            return searchServiceInterface.findFlightByArrOrDep(departureCity, arrivalCity);
        }
    }
}

