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
    Button fxCheckBooking;
    @FXML
    Button fxSearchFlight;
    @FXML
    Button fxEnterCheck;


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
}
