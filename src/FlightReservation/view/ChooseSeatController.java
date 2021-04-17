package FlightReservation.view;

import FlightReservation.controller.BookingController;
import FlightReservation.model.Flight;
import FlightReservation.model.Seat;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ChooseSeatController implements Initializable {
    public ComboBox fxChooseClass;
    public ComboBox fxChooseSeat;
    public Button fxChooseSeatOK;

    private BookingController bc = new BookingController();
    private Flight f;
    private Seat s;
    private ObservableList<String> firstSeat;
    private ObservableList<String> economySeat;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> seatClass = FXCollections.observableArrayList("First Class", "Economy Class");
        firstSeat = FXCollections.observableArrayList(bc.getFirstClassSeats(f.getFlightID()));
        economySeat = FXCollections.observableArrayList(bc.getEconomySeats(f.getFlightID()));
        fxChooseClass.setItems(seatClass);
    }

    public void setFlight(Flight flight){
        this.f = flight;
    }

    public  void setSeat(Seat seat){
        this.s = seat;
    }

    public void ClassHandler(ActionEvent actionEvent) {
        int chosenClass = fxChooseClass.getSelectionModel().getSelectedIndex();

        if(chosenClass == 0){
            fxChooseSeat.getItems().removeAll();
            fxChooseSeat.getItems().addAll(firstSeat);
        }
        else if(chosenClass == 1){
            fxChooseSeat.getItems().removeAll();
            fxChooseSeat.getItems().addAll(economySeat);
        }
    }

    public void SeatHandler(ActionEvent actionEvent) {
    }

    public void openBookFlightFromSeat(ActionEvent event) throws Exception {//áfram í BookFlight
        s = bc.getSeat(f.getFlightID(), fxChooseSeat.getSelectionModel().getSelectedItem().toString());

        FXMLLoader loader = new FXMLLoader(getClass().getResource("BookFlight.fxml"));
        Parent root = loader.load();
        BookFlightController infoForNextScene = loader.getController();
        infoForNextScene.setFlight(f);
        infoForNextScene.setSeat(s);

        Stage window = (Stage) fxChooseSeatOK.getScene().getWindow();
        window.setScene(new Scene(root,  450, 450));
    }
}
