package FlightReservation.view;

import FlightReservation.controller.BookingController;
import FlightReservation.model.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class BookFlightController implements Initializable {

    public TextField fxNameBook;
    public TextField fxPassportNoBook;
    public TextField fxKennitalaBook;
    public Button fxBackBook;
    public Button fxConfirmBook;

    private BookingController bc = new BookingController();
    private Flight f;
    private Seat s;
    private Boolean isValidName;
    private Boolean isValidKt;
    private Boolean isValidPassport;

    public  BookFlightController(){
    }

    void setFlightAndSeat(Flight flight, Seat seat){
        this.f = flight;
        this.s = seat;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fxNameBook.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                isValidName = !newValue.equals("");
                enableConfirmButton();
            }
        });

        fxPassportNoBook.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                isValidPassport = !newValue.equals("");
                enableConfirmButton();
            }
        });

        fxKennitalaBook.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                isValidKt = newValue.length() == 10;
                enableConfirmButton();
            }
        });
    }

    public void enableConfirmButton() {
        if (isValidKt & isValidName & isValidPassport) {
            fxConfirmBook.setDisable(false);
        } else {
            fxConfirmBook.setDisable(true);
        }
    }

    public void openFindFlightBack(ActionEvent event) throws Exception {//til baka í ChooseSeat
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ChooseSeat.fxml"));
        Parent root = loader.load();
        ChooseSeatController infoForNextScene = loader.getController();
        infoForNextScene.setFlight(f);

        Stage window = (Stage) fxBackBook.getScene().getWindow();
        window.setScene(new Scene(root,  600, 400));
    }

    public void openBookingConfirmed(ActionEvent event) throws Exception {//áfram í BookingConfirmed
        Passenger p = new Passenger(fxKennitalaBook.getText(), fxNameBook.getText(), fxPassportNoBook.getText());
        Ticket t = new Ticket(bc.getNextTicketID(), p, s, f.getFlightID(),f.getFlightNumber(), f.getFlightDeparture(), f.getFlightDestination(), f.getDepartureTime(), f.getArrivalTime(), f.getFlightTime());
        bc.book(bc.getNextBookingID(), t);
        Parent root = FXMLLoader.load(getClass().getResource("BookingConfirmed.fxml"));

        Stage window = (Stage) fxConfirmBook.getScene().getWindow();
        window.setScene(new Scene(root,  300, 200));
    }
}
