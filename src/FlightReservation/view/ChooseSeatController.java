package FlightReservation.view;

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

    private static final String[] Class = {"First Class", "Economy Class"};
    private static final String[] FirstSeat = {"2A", "2D", "2F", "3A", "3D", "3F", "4A", "4D", "4F"};
    private static final String[] EconomySeat = {"5A", "5D", "5F", "6A", "6D", "6F", "7A", "7D", "7F", "8A",
            "8D", "8F", "9A", "9D", "9F", "10A", "10D", "10F", "11A", "11D", "11F", "12A", "12C", "12D", "12F"};


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
