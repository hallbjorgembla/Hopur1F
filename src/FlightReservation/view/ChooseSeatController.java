package FlightReservation.view;

import FlightReservation.controller.BookingController;
import FlightReservation.model.Flight;
import FlightReservation.model.Seat;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ChooseSeatController implements Initializable {
    public ComboBox<String> fxChooseClass;
    public ComboBox<String> fxChooseSeat;
    public Button fxChooseSeatBack;
    public Button fxChooseSeatConfirm;

    private BookingController bc = new BookingController();
    private Flight f;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> seatClass = FXCollections.observableArrayList("First Class", "Economy Class");
        fxChooseClass.setItems(seatClass);
    }

    public void setFlight(Flight flight){
        f = flight;
    }

    public void ClassHandler() {
        int chosenClass = fxChooseClass.getSelectionModel().getSelectedIndex();
        ObservableList<String> firstSeat = FXCollections.observableArrayList(bc.getFirstClassSeats(f.getFlightID()));
        ObservableList<String> economySeat = FXCollections.observableArrayList(bc.getEconomySeats(f.getFlightID()));

        if(chosenClass == 0){
            fxChooseSeat.getItems().removeAll();
            fxChooseSeat.getItems().addAll(firstSeat);
        }
        else if(chosenClass == 1){
            fxChooseSeat.getItems().removeAll();
            fxChooseSeat.getItems().addAll(economySeat);
        }
        fxChooseSeat.setDisable(false);
    }

    public void SeatHandler() {
        if (!fxChooseSeat.getSelectionModel().isEmpty()){
            fxChooseSeatConfirm.setDisable(false);
        }
    }

    public void openBookFlightFromSeat() throws Exception {//??fram ?? BookFlight
        Seat s = bc.getSeat(f.getFlightID(), fxChooseSeat.getSelectionModel().getSelectedItem());

        FXMLLoader loader = new FXMLLoader(getClass().getResource("BookFlight.fxml"));
        Parent root = loader.load();
        BookFlightController infoForNextScene = loader.getController();
        infoForNextScene.setFlightAndSeat(f, s);

        Stage window = (Stage) fxChooseSeatConfirm.getScene().getWindow();
        window.setScene(new Scene(root,  450, 450));
    }

    public void openFindFlight() throws IOException {//tilbaka ?? FindFlight
        Parent root = FXMLLoader.load(getClass().getResource("FindFLight.fxml"));
        Stage window = (Stage) fxChooseSeatBack.getScene().getWindow();
        window.setScene(new Scene(root,  800, 600));
    }
}
