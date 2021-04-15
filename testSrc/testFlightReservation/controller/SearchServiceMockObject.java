package testFlightReservation.controller;

import FlightReservation.controller.Comparable;
import FlightReservation.controller.SearchServiceInterface;
import FlightReservation.model.Flight;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

public class SearchServiceMockObject implements SearchServiceInterface {
    private ArrayList<Flight> flights;

    public SearchServiceMockObject() {
        flights = makeFlights();
    }

    // Skilar lista af flugum sem passa við leitarskilyrði
    public ArrayList<Flight> findFlights(LocalDate flightDate, String departureCity, String arrivalCity){
        if(departureCity.equals("")|arrivalCity.equals("")){
            throw new IllegalArgumentException();
        }
        ArrayList<Flight> flightResultList = new ArrayList<>();
        for(Flight flight: flights){
            if(flight.getDepartureTime().getYear() == flightDate.getYear() &&
                    flight.getDepartureTime().getMonthValue() == flightDate.getMonthValue() &&
                    flight.getDepartureTime().getDayOfMonth() == flightDate.getDayOfMonth() &&
                    flight.getFlightDeparture().equals(departureCity) &&
                    flight.getFlightDestination().equals(arrivalCity)){
                    flightResultList.add(flight);
            }
        }
        return flightResultList;
    }

    // Skilar flugi með ákveðið flight id eða tómum Optional hlut ef ekkert flug finnst
    public Optional<Flight> findFlightById(int flightId) {
        if(flightId < 0) {
            throw new IllegalArgumentException();
        }
        ArrayList<Flight> allFlights = makeFlights();
        for(Flight flight: allFlights) {
            if(flight.getFlightID() == flightId) {
                return Optional.of(flight);
            }
        }
        return Optional.empty();
    }


    public ArrayList<Flight> sortByPrice(ArrayList<Flight> flights) {
        Collections.sort(flights, Comparable::comparePrice);
        return flights;
    }

    public ArrayList<Flight> sortByDepartureTime(ArrayList<Flight> flights){
        Collections.sort(flights, Comparable::compareDepartureTime);
        return flights;
    }

    public ArrayList<Flight> sortByArrivalTime(ArrayList<Flight> flights) {
        Collections.sort(flights, Comparable::compareArrivalTime);
        return flights;
    }


    public ArrayList<Flight> findAll(){
        return this.flights;
    }

    // Skilar lista af 5 flugum
    public ArrayList<Flight> makeFlights() {
        ArrayList<Flight> flights = new ArrayList<>();
        flights.add(new Flight(1, "Flug 1", "Reykjavík", "Akureyri", LocalDateTime.of(2021, 6, 10, 10, 30), 2, 100, 20000, 10000));
        flights.add(new Flight(2, "Flug 2", "Akureyri", "Reykjavík", LocalDateTime.of(2021, 6, 10, 15, 30), 2, 100, 25000, 12500));
        flights.add(new Flight(3, "Flug 3", "Reykjavík", "Egilsstaðir", LocalDateTime.of(2021, 6, 15, 10, 0), 3, 50, 28000, 14000));
        flights.add(new Flight(4, "Flug 4", "Reykjavík", "Egilsstaðir", LocalDateTime.of(2021, 6, 15, 18, 30), 3, 50, 24000, 12000));
        flights.add(new Flight(5, "Flug 5", "Egilsstaðir", "Reykjavík", LocalDateTime.of(2021, 6, 15, 15, 0), 3, 50, 20000, 10000));
        return flights;
    }

    @Override
    public ArrayList<Flight> findFlightByDate(LocalDate departureDate) {
        return null;
    }

    @Override
    public ArrayList<Flight> findByDepartureAndArrival(String departureCity, String arrivalCity) {
        return null;
    }
}
