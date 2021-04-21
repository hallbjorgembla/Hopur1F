package FlightReservation.view;

import FlightReservation.controller.*;
import FlightReservation.model.Flight;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class FindFlightController implements Initializable {
    public ComboBox<String> fxFindDep;
    public ComboBox<String> fxFindArr;
    public DatePicker fxFindDate;
    public Button fxFindEnter;
    public Button fxFindBook;
    public Button fxFindBack;
    public TableView<Flight> fxFlightTable;
    public TableColumn<Flight, String> fxFlightNumberCol;
    public TableColumn<Flight, String> fxDepartureCityCol;
    public TableColumn<Flight, String> fxArrivalCityCol;
    public TableColumn<Flight, LocalDateTime> fxFlightDateCol;
    public TableColumn<Flight, Double> fxPriceFirstClassCol;
    public TableColumn<Flight, Double> fxPriceEconomyCol;

    private SearchController searchController = new SearchController(new SearchService());
    private BookingController bc = new BookingController();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<String> dep = bc.getFlightCities(true);
        dep.add(0,"");
        fxFindDep.setItems(FXCollections.observableArrayList(dep));
        ArrayList<String> arr = bc.getFlightCities(false);
        arr.add(0,"");
        fxFindArr.setItems(FXCollections.observableArrayList(arr));

        setjaUppDalka();
        ArrayList<Flight> resultList = searchController.leitaAdFlugum(null, "", "");
        ObservableList<Flight> flightObservableList = FXCollections.observableArrayList(resultList);
        fxFlightTable.setItems(flightObservableList);
    }

    public void openStart() throws Exception {//til baka í start
        Parent root = FXMLLoader.load(getClass().getResource("Start.fxml"));
        Stage window = (Stage) fxFindBack.getScene().getWindow();
        window.setScene(new Scene(root,  400, 200));
    }

    public void openBookFlight() throws Exception {//áfram í ChooseSeat
        Flight f = fxFlightTable.getSelectionModel().getSelectedItem();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("ChooseSeat.fxml"));
        Parent root = loader.load();
        ChooseSeatController infoForNextScene = loader.getController();
        infoForNextScene.setFlight(f);

        Stage window = (Stage) fxFindBook.getScene().getWindow();
        window.setScene(new Scene(root,  600, 400));
    }

    public void saekjaFlug(){
        setjaUppDalka();
        String arrivalCity = fxFindArr.getSelectionModel().getSelectedItem();
        String departureCity = fxFindDep.getSelectionModel().getSelectedItem();
        LocalDate departureDate = fxFindDate.getValue();
        if (arrivalCity == null) {
            arrivalCity = "";
        }
        if (departureCity == null) {
            departureCity = "";
        }
        ArrayList<Flight> resultList = searchController.leitaAdFlugum(departureDate, departureCity, arrivalCity);
        ObservableList<Flight> flightObservableList = FXCollections.observableArrayList(resultList);
        fxFlightTable.setItems(flightObservableList);
        fxFindBook.setDisable(true);
    }

    private void setjaUppDalka() {
        fxFlightTable.setPlaceholder(new Label("There are no flight matches for this search criteria"));
        fxFlightNumberCol.setCellValueFactory(new PropertyValueFactory<>("flightNumber"));
        fxDepartureCityCol.setCellValueFactory(new PropertyValueFactory<>("flightDeparture"));
        fxArrivalCityCol.setCellValueFactory(new PropertyValueFactory<>("flightDestination"));
        fxFlightDateCol.setCellValueFactory(new PropertyValueFactory<>("departureTime"));
        fxPriceFirstClassCol.setCellValueFactory(new PropertyValueFactory<>("priceFirstClass"));
        fxPriceEconomyCol.setCellValueFactory(new PropertyValueFactory<>("priceEconomy"));
    }

    public void selectFlight() {
        if (!fxFlightTable.getSelectionModel().isEmpty()){
            fxFindBook.setDisable(false);
        }
    }

}
