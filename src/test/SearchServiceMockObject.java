package test;

import FlightReservation.controller.SearchServiceInterface;
import FlightReservation.model.Flight;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Optional;

public class SearchServiceMockObject implements SearchServiceInterface {
    private ArrayList<Flight> flights;

    public SearchServiceMockObject() {
        flights = makeFlights();
    }

    // Skilar lista af flugum sem passa við leitarskilyrði
    public ArrayList<Flight> findFlights(LocalDateTime flightDate, String departureCity, String arrivalCity){
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

    // Eyðir flugi - veit ekki alveg með þetta
    public void deleteFlight(int flightId) {
        ArrayList<Flight> allFlights = makeFlights();
        for(Flight flight: allFlights){
            if(flight.getFlightID() == flightId){
                allFlights.remove(flight);
                System.out.println("Eyði flugi nr" + flight.getFlightID());
            }
        }
    }

    // Breytir flugi
    public void editFlight(int flightId, LocalDateTime newDepartureTime, LocalDateTime newArrivalTime){
        // TODO: implement method
    }

    // Bætir við flugi
    public void addFlight(Flight flight){
        // TODO: implement method
    }

    public ArrayList<Flight> sortByPrice(ArrayList<Flight> flightList){
        Collections.sort(flightList, new Comparator<Flight>() {
            @Override
            public int compare(Flight o1, Flight o2) {
                return o1.getPriceEconomy() > o2.getPriceEconomy() ? 1: o1.getPriceEconomy() < o2.getPriceEconomy() ? -1: 0;
            }
        });
        System.out.println(flights);
        return flightList;
    }

    public ArrayList<Flight> sortByDepartureTime(ArrayList<Flight> flightList){
        Collections.sort(flightList, new Comparator<Flight>() {
            @Override
            public int compare(Flight o1, Flight o2) {
                LocalDateTime time1 = o1.getDepartureTime();
                LocalDateTime time2 = o2.getDepartureTime();

                return time1.isBefore(time2) ? -1: time1.isEqual(time2) ? 0 : 1;
            }
        });
        return flightList;
    }
    public ArrayList<Flight> sortByArrivalTime(ArrayList<Flight> flightList){
        Collections.sort(flightList, new Comparator<Flight>() {
            @Override
            public int compare(Flight o1, Flight o2) {
                LocalDateTime time1 = o1.getArrivalTime();
                LocalDateTime time2 = o2.getArrivalTime();

                return time1.isBefore(time2) ? -1: time1.isEqual(time2) ? 0 : 1;
            }
        });
        return flightList;
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
}
