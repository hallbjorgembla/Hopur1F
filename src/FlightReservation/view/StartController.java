package FlightReservation.view;//import java.awt.event.ActionEvent;

import FlightReservation.controller.BookingController;
import FlightReservation.controller.SearchController;
import FlightReservation.controller.SearchService;
import FlightReservation.model.Flight;
import FlightReservation.model.Seat;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.time.LocalDateTime;

public class StartController {
    public TextField fxNameBook;
    public TextField fxPassportNoBook;
    public TextField fxKennitalaBook;
    private SearchController searchController = new SearchController(new SearchService());
    private BookingController bc = new BookingController();
    private Flight f;
    private Seat s;

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

    //transfer data
    public void setFlight(Flight flight){
        f = flight;
    }

    public  void setSeat(Seat seat){
        s = seat;
    }
    //transfer data

    //Start
    public void openCheckBooking(ActionEvent event) throws Exception {
        Button button = (Button) event.getSource();
        Parent root = FXMLLoader.load(getClass().getResource("CheckBooking.fxml"));

        Stage window = (Stage) button.getScene().getWindow();
        window.setScene(new Scene(root,  430, 400));

    }

    public void openFindFlight(ActionEvent event) throws Exception {
        Button button = (Button) event.getSource();
        Parent root = FXMLLoader.load(getClass().getResource("FindFLight.fxml"));
        Stage window = (Stage) fxSearchFlight.getScene().getWindow();
        window.setScene(new Scene(root,  800, 600));
    }
    //Start

    public void openShowBooking(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("ShowBooking.fxml"));

        Stage window = (Stage) fxEnterCheck.getScene().getWindow();
        window.setScene(new Scene(root,  600, 400));
    }

   public void openBookFlightCheckBooking(ActionEvent event) throws Exception {
        Button button = (Button) event.getSource();
        Parent root = FXMLLoader.load(getClass().getResource("BookFlight.fxml"));

        Stage window = (Stage) button.getScene().getWindow();
        window.setScene(new Scene(root, 430, 400));
    }

    public void openStartClose(ActionEvent event) throws Exception {
        Button button = (Button) event.getSource();
        Parent root = FXMLLoader.load(getClass().getResource("Start.fxml"));

        Stage window = (Stage) button.getScene().getWindow();
        window.setScene(new Scene(root, 400, 200));
    }
}
