package testFlightReservation.controller;

import FlightReservation.model.Flight;
import FlightReservation.controller.SearchController;
import FlightReservation.controller.SearchServiceInterface;
import org.junit.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
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

    // Testing the findFlight method with made up strings as Arrival/Departure city
    //henda inn röngu tagi
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

        // prófa með röngu tagi
    @Test
    public void testCase4(){
        int flightId = 10;
        Optional<Flight> flight = searchController.findById(flightId);
        assertNotNull(flight);
        assertTrue(flight.isEmpty());
    }

    @Test
    public void testCase5(){
        ArrayList<Flight> flightsToSort = searchController.findAll();
        searchController.sortByPrice(flightsToSort);
        System.out.println(flightsToSort);
        assertNotNull(flightsToSort);
        double currentPrice = 0;
        double previousPrice = 0;
        for(Flight flight: flightsToSort){
            currentPrice = flight.getPriceEconomy();
            System.out.println(currentPrice);
            assertTrue(currentPrice >= previousPrice);
            previousPrice = currentPrice;
        }
    }

    @Test
    public void testCase6(){
        ArrayList<Flight> flightsToSort = searchController.findAll();
        searchController.sortByDepartureTime(flightsToSort);
        System.out.println(flightsToSort);
        assertNotNull(flightsToSort);
        LocalDateTime current;
        LocalDateTime previous = LocalDateTime.MIN;
        for(Flight flight: flightsToSort){
            current = flight.getDepartureTime();
            System.out.println(current);
            assertTrue(current.isAfter(previous));
            previous = current;
        }
    }

    @Test
    public void testCase7(){
        ArrayList<Flight> flightsToSort = searchController.findAll();
        searchController.sortByArrivalTime(flightsToSort);
        System.out.println(flightsToSort);
        assertNotNull(flightsToSort);
        LocalDateTime current;
        LocalDateTime previous = LocalDateTime.MIN;
        for(Flight flight: flightsToSort){
            current = flight.getArrivalTime();
            System.out.println(current);
            assertTrue(current.isAfter(previous));
            previous = current;
        }
    }
}
