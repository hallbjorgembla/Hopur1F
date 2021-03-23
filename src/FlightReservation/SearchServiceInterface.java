package FlightReservation;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface SearchServiceInterface {
    public ArrayList<Flight> findFlights(LocalDateTime flightDate, String departureCity, String arrivalCity);
    public Optional<Flight> findFlightById(int flightId);
    public void deleteFlight(int flightId);
    public void editFlight(int flightId, LocalDateTime newDepartureTime, LocalDateTime newArrivalTime);
    public void addFlight(Flight flight);
}
