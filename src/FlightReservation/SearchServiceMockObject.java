package FlightReservation;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

public class SearchServiceMockObject implements SearchServiceInterface {

    public SearchServiceMockObject() {
    }

    // Skilar lista af flugum sem passa við leitarskilyrði
    public ArrayList<Flight> findFlights(LocalDateTime flightDate, String departureCity, String arrivalCity){
        ArrayList<Flight> flightResultList = new ArrayList<>();
        ArrayList<Flight> allFlights = makeFlights();
        for(Flight flight: allFlights){
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

    // Skilar lista af 5 flugum
    public ArrayList<Flight> makeFlights() {
        ArrayList<Flight> flights = new ArrayList<>();
        flights.add(new Flight(1, "Flug 1", "Reykjavík", "Akureyri", LocalDateTime.of(2021, 6, 10, 10, 30), LocalDateTime.of(2021, 6, 10, 10, 30).plusHours(2), 2, 100, 10000, 20000));
        flights.add(new Flight(2, "Flug 2", "Akureyri", "Reykjavík", LocalDateTime.of(2021, 6, 10, 15, 30), LocalDateTime.of(2021, 6, 10, 15, 30).plusHours(2), 2, 100, 12500, 25000));
        flights.add(new Flight(3, "Flug 3", "Reykjavík", "Egilsstaðir", LocalDateTime.of(2021, 6, 15, 10, 0), LocalDateTime.of(2021, 6, 15, 10, 0).plusHours(3), 3, 50, 14000, 28000));
        flights.add(new Flight(4, "Flug 4", "Reykjavík", "Egilsstaðir", LocalDateTime.of(2021, 6, 15, 18, 30), LocalDateTime.of(2021, 6, 15, 18, 30).plusHours(3), 3, 50, 12000, 24000));
        flights.add(new Flight(5, "Flug 5", "Egilsstaðir", "Reykjavík", LocalDateTime.of(2021, 6, 15, 15, 0), LocalDateTime.of(2021, 6, 15, 15, 0).plusHours(3), 3, 50, 10000, 20000));
        return flights;
    }
}
