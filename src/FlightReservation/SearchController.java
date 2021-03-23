package FlightReservation;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

public class SearchController {
    private SearchServiceInterface searchServiceInterface;
    private ArrayList<Flight> flights;

    public SearchController(SearchServiceInterface searchServiceInterface) {
        this.searchServiceInterface = searchServiceInterface;
    }

    public ArrayList<Flight> findFlights(LocalDateTime flightDate, String departureCity, String arrivalCity){
        return searchServiceInterface.findFlights(flightDate, departureCity, arrivalCity);
    }

    public Optional<Flight> findById(int flightId) {
        return searchServiceInterface.findFlightById(flightId);
    }

    public void sortByPrice(){

    }

    public void sortByFlightTime(){

    }

    /* ÞURFUM VIÐ AÐ HAFA ÞETTA HÉR?
    public void delete(int flightId) {
        searchServiceInterface.deleteFlight(flightId);
    }

    public void editFlight(int flightId, LocalDateTime newDepartureTime, LocalDateTime newArrivalTime){
        searchServiceInterface.editFlight(flightId, newDepartureTime, newArrivalTime);
    }

    public void addFlight(Flight flight) {
        searchServiceInterface.addFlight(flight);
    }

     */
}
