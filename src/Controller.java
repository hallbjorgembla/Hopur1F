//import java.awt.event.ActionEvent;
import FlightReservation.controller.SearchController;
import FlightReservation.controller.SearchService;
import FlightReservation.model.Flight;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.stage.Stage;

import java.awt.*;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller {

    @FXML
    Button fxCheckBooking;
    @FXML
    Button fxSearchFlight;
    @FXML
    Button fxFindBook;
    @FXML
    Button fxChooseBook;

    // Breytur fyrir FindFlight síðu
    @FXML
    private Button fxFindEnter;
    @FXML
    private TableView<Flight> fxFlightTable;
    @FXML
    private TableColumn fxFlightNumberCol;
    @FXML
    private TableColumn fxDepartureCityCol;
    @FXML
    private TableColumn fxArrivalCityCol;
    @FXML
    private TableColumn fxFlightDateCol;
    @FXML
    private TableColumn fxPriceFirstClassCol;
    @FXML
    private TableColumn fxPriceEconomyCol;
    @FXML
    private Button fxFindBack;
    @FXML
    private DatePicker fxFindDate;
    @FXML
    private TextField fxFindArr;
    @FXML
    private TextField fxFindDep;

    private SearchController searchController = new SearchController(new SearchService());

    public Controller() {
    }

    public void openCheckBooking(ActionEvent event) throws Exception {
        System.out.println("Hello World");
        Parent root = FXMLLoader.load(getClass().getResource("FlightReservation/view/CheckBooking.fxml"));

        Stage window = (Stage) fxCheckBooking.getScene().getWindow();
        window.setScene(new Scene(root,  430, 400));
    }

    public void openFindFlight(ActionEvent event) throws Exception {
        System.out.println("Hello World");
        Parent root = FXMLLoader.load(getClass().getResource("FlightReservation/view/FindFLight.fxml"));
        Stage window = (Stage) fxSearchFlight.getScene().getWindow();
        window.setScene(new Scene(root,  800, 600));
    }

    public void openBookFlight(ActionEvent event) throws Exception {
        System.out.println("Hello World");
        Parent root = FXMLLoader.load(getClass().getResource("FlightReservation/view/BookFlight.fxml"));

        Stage window = (Stage) fxFindBook.getScene().getWindow();
        window.setScene(new Scene(root,  430, 400));
    }

    public void openChooseSeat(ActionEvent event) throws Exception {
        System.out.println("Hello World");
        Parent root = FXMLLoader.load(getClass().getResource("FlightReservation/view/ChooseSeat.fxml"));

        Stage window = (Stage) fxChooseBook.getScene().getWindow();
        window.setScene(new Scene(root,  600, 400));
    }

    public void saekjaFlug(){
        setjaUppDalka();
        String arrivalCity = fxFindArr.getCharacters().toString();
        String departureCity = fxFindDep.getCharacters().toString();
        LocalDate departureDate = fxFindDate.getValue();
        //Boolean b = fxFindDate.
        ArrayList<Flight> resultList = searchController.leitaAdFlugum(departureDate, departureCity, arrivalCity);
        ObservableList<Flight> flightObservableList = FXCollections.observableArrayList(resultList);
        fxFlightTable.setItems(flightObservableList);
        /*

        if(arrivalCity.isEmpty() && departureCity.isEmpty()) {
            ArrayList<Flight> allFlights = searchController.findAll();
            ObservableList<Flight> flightObservableList = FXCollections.observableArrayList(allFlights);
            fxFlightTable.setItems(flightObservableList);
        }
        else {
            ArrayList<Flight> resultList = searchController.findFlights(departureDate, departureCity, arrivalCity);
            ObservableList<Flight> flightObservableList = FXCollections.observableArrayList(resultList);
            fxFlightTable.setItems(flightObservableList);
        }

         */
    }

    public void setjaUppDalka() {
        fxFlightNumberCol.setCellValueFactory(new PropertyValueFactory<Flight, String>("flightNumber"));
        fxDepartureCityCol.setCellValueFactory(new PropertyValueFactory<Flight, String>("flightDeparture"));
        fxArrivalCityCol.setCellValueFactory(new PropertyValueFactory<Flight, String>("flightDestination"));
        fxFlightDateCol.setCellValueFactory(new PropertyValueFactory<Flight, LocalDateTime>("departureTime"));
        fxPriceFirstClassCol.setCellValueFactory(new PropertyValueFactory<Flight, Double>("priceFirstClass"));
        fxPriceEconomyCol.setCellValueFactory(new PropertyValueFactory<Flight, Double>("priceEconomy"));
    }

}
