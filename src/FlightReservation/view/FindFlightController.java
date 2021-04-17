package FlightReservation.view;

import FlightReservation.controller.SearchController;
import FlightReservation.controller.SearchService;
import FlightReservation.model.Flight;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class FindFlightController implements Initializable {
    public TextField fxFindDep;
    public TextField fxFindArr;
    public DatePicker fxFindDate;
    public Button fxFindEnter;
    public Button fxFindBook;
    public TableView<Flight> fxFlightTable;
    public TableColumn<Flight, String> fxFlightNumberCol;
    public TableColumn<Flight, String> fxDepartureCityCol;
    public TableColumn<Flight, String> fxArrivalCityCol;
    public TableColumn<Flight, LocalDateTime> fxFlightDateCol;
    public TableColumn<Flight, Double> fxPriceFirstClassCol;
    public TableColumn<Flight, Double> fxPriceEconomyCol;
    public Button fxFindBack;

    private SearchController searchController = new SearchController(new SearchService());
    private ArrayList<Flight> resultList;
    private ObservableList<Flight> flightObservableList;
    private String arrivalCity;
    private String departureCity;
    private LocalDate departureDate;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setjaUppDalka();
        arrivalCity = fxFindArr.getCharacters().toString();
        departureCity = fxFindDep.getCharacters().toString();
        departureDate = fxFindDate.getValue();
        resultList = searchController.leitaAdFlugum(departureDate, departureCity, arrivalCity);
        flightObservableList = FXCollections.observableArrayList(resultList);
        fxFlightTable.setItems(flightObservableList);
    }

    public void openStart(ActionEvent event) throws Exception {//til baka til start
        Button button = (Button) event.getSource();
        Parent root = FXMLLoader.load(getClass().getResource("Start.fxml"));

        Stage window = (Stage) button.getScene().getWindow();
        window.setScene(new Scene(root,  400, 200));
    }

    public void displayFlights(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FindFlight.fxml"));
        Stage window = (Stage) fxFindEnter.getScene().getWindow();
        window.setScene(new Scene(root,  600, 600));
    }

    public void openBookFlight(ActionEvent event) throws Exception {//áfram í BookFlight
        Flight f = fxFlightTable.getSelectionModel().getSelectedItem();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("BookFlight.fxml"));
        Parent root = loader.load();
        BookFlightController infoForNextScene = loader.getController();
        infoForNextScene.setFlight(f);

        Stage window = (Stage) fxFindBook.getScene().getWindow();
        window.setScene(new Scene(root,  430, 400));
    }

    public void saekjaFlug(){
        setjaUppDalka();
        arrivalCity = fxFindArr.getCharacters().toString();
        departureCity = fxFindDep.getCharacters().toString();
        departureDate = fxFindDate.getValue();
        resultList = searchController.leitaAdFlugum(departureDate, departureCity, arrivalCity);
        flightObservableList = FXCollections.observableArrayList(resultList);
        fxFlightTable.setItems(flightObservableList);
    }

    private void setjaUppDalka() {
        fxFlightTable.setPlaceholder(new Label("There are no flight matches for this search criteria"));
        fxFlightNumberCol.setCellValueFactory(new PropertyValueFactory<Flight, String>("flightNumber"));
        fxDepartureCityCol.setCellValueFactory(new PropertyValueFactory<Flight, String>("flightDeparture"));
        fxArrivalCityCol.setCellValueFactory(new PropertyValueFactory<Flight, String>("flightDestination"));
        fxFlightDateCol.setCellValueFactory(new PropertyValueFactory<Flight, LocalDateTime>("departureTime"));
        fxPriceFirstClassCol.setCellValueFactory(new PropertyValueFactory<Flight, Double>("priceFirstClass"));
        fxPriceEconomyCol.setCellValueFactory(new PropertyValueFactory<Flight, Double>("priceEconomy"));
    }

    public void selectFlight(MouseEvent mouseEvent) {
        if (!fxFlightTable.getSelectionModel().isEmpty()){
            fxFindBook.setDisable(false);
        }
    }
}
