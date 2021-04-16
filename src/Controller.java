//import java.awt.event.ActionEvent;
import FlightReservation.controller.BookingController;
import FlightReservation.controller.SearchController;
import FlightReservation.controller.SearchService;
import FlightReservation.model.Flight;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Controller {
    private SearchController searchController = new SearchController(new SearchService());
    private BookingController bc = new BookingController();

    private ObservableList<String> seatClass = FXCollections.observableArrayList("First Class", "Economy Class");
    private ObservableList<String> firstSeat = FXCollections.observableArrayList(bc.getFirstClassSeats(1));
    private ObservableList<String> economySeat = FXCollections.observableArrayList(bc.getEconomySeats(1));
    @FXML
    ComboBox<String> fxChooseClass;
    @FXML
    ComboBox<String> fxChooseSeat;
    @FXML
    Button fxChooseSeatOK;
    @FXML
    Button fxCheckBooking;
    @FXML
    Button fxSearchFlight;
    @FXML
    Button fxFindBook;
    @FXML
    Button fxChooseBook;
    @FXML
    Button fxEnterCheck;
    @FXML
    Button fxShowAnother;
    @FXML
    Button fxConfirmBook;

    // Breytur fyrir FindFlight síðu
    @FXML
    private Button fxFindEnter;
    @FXML
    private TableView<Flight> fxFlightTable;
    @FXML
    private TableColumn<Flight, String> fxFlightNumberCol;
    @FXML
    private TableColumn<Flight, String> fxDepartureCityCol;
    @FXML
    private TableColumn<Flight, String> fxArrivalCityCol;
    @FXML
    private TableColumn<Flight, LocalDateTime> fxFlightDateCol;
    @FXML
    private TableColumn<Flight, Double> fxPriceFirstClassCol;
    @FXML
    private TableColumn<Flight, Double> fxPriceEconomyCol;
    @FXML
    private Button fxFindBack;
    @FXML
    private DatePicker fxFindDate;
    @FXML
    private TextField fxFindArr;
    @FXML
    private TextField fxFindDep;

    public Controller() {
    }

    //Start
    public void openCheckBooking(ActionEvent event) throws Exception {
        Button button = (Button) event.getSource();
        Parent root = FXMLLoader.load(getClass().getResource("FlightReservation/view/CheckBooking.fxml"));

        Stage window = (Stage) button.getScene().getWindow();
        window.setScene(new Scene(root,  430, 400));

    }

    public void openFindFlight(ActionEvent event) throws Exception {
        Button button = (Button) event.getSource();
        Parent root = FXMLLoader.load(getClass().getResource("FlightReservation/view/FindFLight.fxml"));
        Stage window = (Stage) fxSearchFlight.getScene().getWindow();
        window.setScene(new Scene(root,  800, 600));
    }
    //Start

    //FindFlight
    public void openStart(ActionEvent event) throws Exception {//til baka til start
        Button button = (Button) event.getSource();
        Parent root = FXMLLoader.load(getClass().getResource("Start.fxml"));

        Stage window = (Stage) button.getScene().getWindow();
        window.setScene(new Scene(root,  400, 200));
    }

    public void displayFlights(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FlightReservation/view/FindFlight.fxml"));
        Stage window = (Stage) fxFindEnter.getScene().getWindow();
        window.setScene(new Scene(root,  600, 600));

        //birta töflu
    }

    public void openBookFlight(ActionEvent event) throws Exception {//áfram í passenger booking
        Parent root = FXMLLoader.load(getClass().getResource("FlightReservation/view/BookFlight.fxml"));

        Stage window = (Stage) fxFindBook.getScene().getWindow();
        window.setScene(new Scene(root,  430, 400));
    }
    //FindFlight

    //BookFlight
    public void openFindFlightBack(ActionEvent event) throws Exception {//til baka í FindFlight
        Button button = (Button) event.getSource();
        Parent root = FXMLLoader.load(getClass().getResource("FlightReservation/view/FindFlight.fxml"));

        Stage window = (Stage) button.getScene().getWindow();
        window.setScene(new Scene(root,  800, 600));
    }

    public void openChooseSeat(ActionEvent event) throws Exception {//áfram í ChooseSeat
        Parent root = FXMLLoader.load(getClass().getResource("FlightReservation/view/ChooseSeat.fxml"));

        Stage window = (Stage) fxChooseBook.getScene().getWindow();
        window.setScene(new Scene(root,  600, 400));
    }

    public void openBookingConfirmed(ActionEvent event) throws Exception {//áfram í BookingConfirmed
        Parent root = FXMLLoader.load(getClass().getResource("FlightReservation/view/BookingConfirmed.fxml"));

        Stage window = (Stage) fxConfirmBook.getScene().getWindow();
        window.setScene(new Scene(root,  300, 200));
    }
    //BookFlight

    //ChooseSeat
    public void onSeatInit(Event event) {
        fxChooseClass.setItems(seatClass);
    }

    public void ClassHandler(ActionEvent actionEvent) {
        int chosenClass = fxChooseClass.getSelectionModel().getSelectedIndex();

        if(chosenClass == 0){
            fxChooseSeat.getItems().removeAll();
            fxChooseSeat.getItems().addAll(firstSeat);
        }
        else if(chosenClass == 1){
            fxChooseSeat.getItems().removeAll();
            fxChooseSeat.getItems().addAll(economySeat);
        }
    }

    public void SeatHandler(ActionEvent actionEvent) {
    }

    public void openBookFlightFromSeat(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FlightReservation/view/BookFlight.fxml"));

        Stage window = (Stage) fxChooseSeatOK.getScene().getWindow();
        window.setScene(new Scene(root,  450, 450));
    }
    //ChooseSeat

    public void openShowBooking(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FlightReservation/view/ShowBooking.fxml"));

        Stage window = (Stage) fxEnterCheck.getScene().getWindow();
        window.setScene(new Scene(root,  600, 400));
    }

   public void openBookFlightCheckBooking(ActionEvent event) throws Exception {
        Button button = (Button) event.getSource();
        Parent root = FXMLLoader.load(getClass().getResource("FlightReservation/view/BookFlight.fxml"));

        Stage window = (Stage) button.getScene().getWindow();
        window.setScene(new Scene(root, 430, 400));

    }

    public void openStartClose(ActionEvent event) throws Exception {
        Button button = (Button) event.getSource();
        Parent root = FXMLLoader.load(getClass().getResource("Start.fxml"));

        Stage window = (Stage) button.getScene().getWindow();
        window.setScene(new Scene(root, 400, 200));

    }

    public void saekjaFlug(){
        setjaUppDalka();
        String arrivalCity = fxFindArr.getCharacters().toString();
        String departureCity = fxFindDep.getCharacters().toString();
        LocalDate departureDate = fxFindDate.getValue();
        ArrayList<Flight> resultList = searchController.leitaAdFlugum(departureDate, departureCity, arrivalCity);
        ObservableList<Flight> flightObservableList = FXCollections.observableArrayList(resultList);
        fxFlightTable.setItems(flightObservableList);
    }

    public void setjaUppDalka() {
        fxFlightTable.setPlaceholder(new Label("There are no flight matches for this search criteria"));
        fxFlightNumberCol.setCellValueFactory(new PropertyValueFactory<Flight, String>("flightNumber"));
        fxDepartureCityCol.setCellValueFactory(new PropertyValueFactory<Flight, String>("flightDeparture"));
        fxArrivalCityCol.setCellValueFactory(new PropertyValueFactory<Flight, String>("flightDestination"));
        fxFlightDateCol.setCellValueFactory(new PropertyValueFactory<Flight, LocalDateTime>("departureTime"));
        fxPriceFirstClassCol.setCellValueFactory(new PropertyValueFactory<Flight, Double>("priceFirstClass"));
        fxPriceEconomyCol.setCellValueFactory(new PropertyValueFactory<Flight, Double>("priceEconomy"));
    }
}
