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
    private static final String[] FirstSeat = {"1A", "1C", "1D", "1F", "2A", "2C", "2D", "2F", "3A", "3C", "3D", "3F"
            , "4A", "4C", "4D", "4F"};
    private static final String[] EconomySeat = {"5A", "5B", "5C", "5D", "5E", "5F","6A", "6B", "6C", "6D", "6E", "6F",
            "7A", "7B", "7C", "7D", "7E", "7F", "8A", "8B", "8C", "8D", "8E", "8F","9A", "9B", "9C", "9D", "9E", "9F",
            "10A", "10B", "10C", "10D", "10E", "10F", "11A", "11B", "11C", "11D", "11E", "11F", "12A", "12B", "12C",
            "12D", "12E", "12F", "13A", "13B", "13C", "13D", "13E", "13F", "14A", "14B", "14C", "14D", "14E", "14F",
            "15A", "15B", "15C", "15D", "15E", "15F", "16A", "16B", "16C", "16D", "16E", "16F", "17A", "17B", "17C",
            "17D", "17E", "17F", "18A", "18B", "18C", "18D", "18E", "18F", "19A", "19B", "19C", "19D", "19E", "19F",
            "20A", "20B", "20C", "20D", "20E", "20F", "21A", "21B", "21C", "21D", "21E", "21F", "22A", "22B", "22C",
            "22D", "22E", "22F", "23A", "23B", "23C", "23D", "23E", "23F", "24A", "24B", "24C", "24D", "24E", "24F",
            "25A", "25B", "25C", "25D", "25E", "25F", "26A", "26B", "26C", "26D", "26E", "26F"};


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
