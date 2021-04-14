//import java.awt.event.ActionEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.awt.*;

public class Controller {
    public Controller() {
    }
    @FXML
    Button fxCheckBooking;
    @FXML
    Button fxSearchFlight;
    @FXML
    Button fxFindBook;
    @FXML
    Button fxChooseBook;


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
        window.setScene(new Scene(root,  600, 600));
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

}
