package FlightReservation.view;

import FlightReservation.controller.BookingController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class ChooseSeatController implements Initializable {


    @FXML
    private AnchorPane fxChooseSeatDialog;
    @FXML
    private ComboBox<String> fxChooseClass;
    @FXML
    private ComboBox<String> fxChooseSeat;
    @FXML
    private Button fxChooseSeatOK;

    private static BookingController bc = new BookingController();
    private static final String[] Class = {"First Class", "Economy Class"};
    //Þurfum að passa að breyta svo það tejur inn flightID, núna tekur það 1 sem er flightID hjá FL101;
    private static final String[] FirstSeat = bc.getSeatsFC(1);
    private static final String[] EconomySeat = bc.getSeatsE(1);


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

}
