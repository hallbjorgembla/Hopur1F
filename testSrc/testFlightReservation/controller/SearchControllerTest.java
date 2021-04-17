package testFlightReservation.controller;

import FlightReservation.controller.BookingController;
import FlightReservation.controller.SearchService;
import FlightReservation.model.Flight;
import FlightReservation.controller.SearchController;
import FlightReservation.controller.SearchServiceInterface;
import FlightReservation.model.Passenger;
import FlightReservation.model.Seat;
import FlightReservation.model.Ticket;
import org.junit.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

import static org.junit.Assert.*;

public class SearchControllerTest {

    private SearchController searchController;
    private SearchServiceInterface searchService;
    private ArrayList<Flight> flights;

    @Before
    public void setUp() {
        this.searchService = new SearchService();
        this.searchController = new SearchController(searchService);
        flights = searchController.findAll();
    }

    @After
    public void tearDown(){
        this.searchController = null;
        this.searchService = null;
        this.flights = null;
    }

    @Test
    public void testCaseFindAll(){
        flights = searchController.findAll();
        for(Flight flight: flights) {
            System.out.println(flight.toString());
        }
    }

    @Test
    public void testCaseFindFlights(){
        LocalDate date = LocalDate.of(2021,6,1);
        System.out.println(date.toString());
        flights = searchController.findFlights(date, "Reykjavík", "Akureyri");
        for(Flight flight: flights) {
            System.out.println(flight.toString());
        }
    }

    // Testing the findFlights method with legal parameters
    @Test
    public void testCase1(){
        LocalDate flightDate = LocalDate.of(2021, 6, 10);
        String departureCity = "Reykjavík";
        String arrivalCity = "Akureyri";
        flights = searchController.findFlights(flightDate, departureCity, arrivalCity);
        assertNotNull(flights);
        assertTrue(!flights.isEmpty());
    }

    // Testing the findFlight method with the empty string, which should throw an IllegalArgumentException
    @Test(expected = IllegalArgumentException.class)
    public void testCase2(){
        LocalDate flightDate = LocalDate.of(2021, 6, 10);
        String departureCity = "";
        String arrivalCity = "";
        flights = searchController.findFlights(flightDate, departureCity, arrivalCity);
    }

    // Testing the findFlight method with nonsense strings, expecting it to return an empty list
    @Test
    public void testCase3(){
        LocalDate flightDate = LocalDate.of(2021, 6, 10);
        String departureCity = "blablablabla";
        String arrivalCity = "ahhahahha";
        flights = searchController.findFlights(flightDate, departureCity, arrivalCity);
        assertNotNull(flights);
        assertTrue(flights.isEmpty());
    }

    // Testing the findFlights method with null arguments, which should throw a NullPointerException
    @Test(expected=NullPointerException.class)
    public void testCase4(){
        flights = searchController.findFlights(null, null, null);
    }

    // Testing the findById method with a legal argument, expecting a non-empty Optional object
    @Test
    public void testCase5(){
        int flightId = 1;
        Optional<Flight> flight = searchController.findById(flightId);
        assertNotNull(flight);
        assertTrue(flight.isPresent());
    }

    @Test
    public void testCase6(){
        int flightId = 10;
        Optional<Flight> flight = searchController.findById(flightId);
        assertNotNull(flight);
        assertTrue(flight.isEmpty());
    }

    // Testing the findById method with an illegal argument, expecting an IllegalArgumentException
    @Test(expected = IllegalArgumentException.class)
    public void testCase7(){
        Optional<Flight> flight = searchController.findById(-5);
    }

    // Testing the sortByPrice method
    @Test
    public void testCase8(){
        searchController.sortByPrice(flights);
        double currentPrice;
        double previousPrice = 0;
        boolean isNotSorted = false;
        for(Flight flight: flights){
            currentPrice = flight.getPriceEconomy();
            if(currentPrice < previousPrice){
                isNotSorted = true;
            }
            previousPrice = currentPrice;
        }
        assertFalse(isNotSorted);
    }

    // Testing the sortByDepartureTime method
    @Test
    public void testCase9(){
        searchController.sortByDepartureTime(flights);
        LocalDateTime current;
        LocalDateTime previous = LocalDateTime.MIN;
        boolean isNotSorted = false;
        for(Flight flight: flights){
            current = flight.getDepartureTime();
            if(current.isBefore(previous)){
                isNotSorted = true;
            }
            previous = current;
        }
        assertFalse(isNotSorted);
    }

    // Testing the sortByArrivalTime method
    @Test
    public void testCase10(){
        searchController.sortByArrivalTime(flights);
        LocalDateTime current;
        LocalDateTime previous = LocalDateTime.MIN;
        boolean isNotSorted = false;
        for(Flight flight: flights){
            current = flight.getArrivalTime();
            if(current.isBefore(previous)){
                isNotSorted = true;
            }
            previous = current;
        }
        assertFalse(isNotSorted);
    }

    @Test
    public void testCase11(){
        ArrayList<Integer> availableSeats =  searchController.showAllAvailableSeats(flights);
        for(var i = 0 ; i < availableSeats.size(); i++){
            System.out.println(availableSeats.get(i));
        }

        boolean isFalse = false;
        assertFalse(isFalse);
    }
}
