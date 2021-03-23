package test;

import FlightReservation.Flight;
import FlightReservation.SearchController;
import FlightReservation.SearchServiceInterface;
import FlightReservation.SearchServiceMockObject;
import org.junit.*;
import org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class SearchControllerTest {

    private SearchController searchController;
    private SearchServiceInterface mockSearchServiceInterface;

    @Before
    public void setUp() {
        this.mockSearchServiceInterface = new SearchServiceMockObject();
        this.searchController = new SearchController(mockSearchServiceInterface);
    }

    @After
    public void tearDown(){
        this.searchController = null;
        this.searchController = null;
    }

    // Testing the findFlights method with legal parameters
    @Test
    public void testCase1(){
        LocalDateTime flightDate = LocalDateTime.of(2021, 6, 10, 10, 0);
        String departureCity = "Reykjavík";
        String arrivalCity = "Akureyri";
        ArrayList<Flight> flights = searchController.findFlights(flightDate, departureCity, arrivalCity);
        assertNotNull(flights);
        assertTrue(!flights.isEmpty());
    }

    // Tesding the findFligth method with made up strings as Arrival/Departure city
    @Test
    public void testCase2(){
        LocalDateTime flightDate = LocalDateTime.of(2021, 6, 10, 10, 0);
        String departureCity = "Bla";
        String arrivalCity = "BlaBla";
        ArrayList<Flight> flights = searchController.findFlights(flightDate, departureCity, arrivalCity);
        assertNotNull(flights);
        assertTrue(flights.isEmpty());
    }

    @Test
    public void testCase3(){
        int flightId = 1;
        Optional<Flight> flight = searchController.findById(flightId);
        assertNotNull(flight);
        assertTrue(flight.isPresent());
    }

    @Test
    public void testCase4(){
        int flightId = 10;
        Optional<Flight> flight = searchController.findById(flightId);
        assertNotNull(flight);
        assertTrue(flight.isEmpty());
    }
}
