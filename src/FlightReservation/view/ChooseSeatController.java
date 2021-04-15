package FlightReservation.view;

import FlightReservation.controller.BookingController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ChooseSeatController implements Initializable {

    private static BookingController bc = new BookingController();

    @FXML
    private AnchorPane fxChooseSeatDialog;
    @FXML
    private ComboBox<String> fxChooseClass;
    @FXML
    private ComboBox<String> fxChooseSeat;
    @FXML
    private Button fxChooseSeatOK;

    private static final String[] Class = {"First Class", "Economy Class"};
    //fær öll sæti frá flug með flightID = 1
    private static final ArrayList<String> FirstSeat = bc.getFirstClassSeats(1);
    private static final ArrayList<String> EconomySeat = bc.getEconomySeats(1);


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        stillaBox();
    }

    private void stillaBox(){
        fxChooseClass.getItems().addAll(Class);
        fxChooseSeat.getItems().addAll(FirstSeat);
        fxChooseSeat.getItems().addAll(EconomySeat);
    }

    public void ClassHandler(ActionEvent actionEvent) {

        int chosenClass = fxChooseClass.getSelectionModel().getSelectedIndex();

        if(chosenClass == 0){
            fxChooseSeat.getItems().removeAll(FirstSeat);
            fxChooseSeat.getItems().removeAll(EconomySeat);
            fxChooseSeat.getItems().addAll(FirstSeat);
        }
        else if(chosenClass == 1){
            fxChooseSeat.getItems().removeAll(FirstSeat);
            fxChooseSeat.getItems().removeAll(EconomySeat);
            fxChooseSeat.getItems().addAll(EconomySeat);
        }

    }

    public void SeatHandler(ActionEvent actionEvent) {
    }

    public void openFindFlight(ActionEvent event) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("BookFlight.fxml"));
        Button button = (Button) event.getSource();
        Stage window = (Stage) button.getScene().getWindow();
        window.setScene(new Scene(root,  450, 450));
    }

}
