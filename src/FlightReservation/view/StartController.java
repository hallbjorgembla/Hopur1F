package FlightReservation.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class StartController {

    @FXML
    Button fxCheckBooking;
    @FXML
    Button fxSearchFlight;

    public void openCheckBooking() throws Exception {//áfram í CheckBooking
        Parent root = FXMLLoader.load(getClass().getResource("CheckBooking.fxml"));
        Stage window = (Stage) fxCheckBooking.getScene().getWindow();
        window.setScene(new Scene(root,  430, 400));
    }

    public void openFindFlight() throws Exception {//áfram í FindFlight
        Parent root = FXMLLoader.load(getClass().getResource("FindFLight.fxml"));
        Stage window = (Stage) fxSearchFlight.getScene().getWindow();
        window.setScene(new Scene(root,  800, 600));
    }
}
