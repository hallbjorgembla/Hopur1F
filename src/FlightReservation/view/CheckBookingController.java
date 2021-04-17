package FlightReservation.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class CheckBookingController implements Initializable {
    @FXML
    private TextField fxNameCheck;
    @FXML
    private TextField fxPassportNoCheck;
    @FXML
    private TextField fxKennitalaCheck;
    @FXML
    private Button fxEnterCheck;
    @FXML
    private Button fxCancelCheck;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void openShowBooking() throws Exception {
        String kennitala = fxKennitalaCheck.getText();
        String passportNumber = fxPassportNoCheck.getText();
        String name = fxNameCheck.getText();
        System.out.println(kennitala + passportNumber + name);
        // Load Show Booking Scene
        FXMLLoader loader = new FXMLLoader((getClass().getResource("ShowBooking.fxml")));
        Parent root = loader.load();
        // Get controller of Show Booking Scene
        ShowBookingController infoForNextScene = loader.getController();
        // Pass data to Show Booking Scene
        infoForNextScene.setStrings(kennitala, passportNumber, name);
        infoForNextScene.saekjaFlug();
        // Show scene
        Stage window = (Stage) fxEnterCheck.getScene().getWindow();
        window.setScene(new Scene(root, 600, 400));
    }

    public void openStart() throws Exception { //til baka í start
        Parent root = FXMLLoader.load(getClass().getResource("Start.fxml"));
        Stage window = (Stage) fxCancelCheck.getScene().getWindow();
        window.setScene(new Scene(root,  400, 200));
    }
}
