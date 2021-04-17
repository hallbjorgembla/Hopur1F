package FlightReservation.view;

import FlightReservation.controller.BookingController;
import FlightReservation.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class BookFlightController {

    public TextField fxNameBook;
    public TextField fxPassportNoBook;
    public TextField fxKennitalaBook;
    public Button fxBackBook;
    public Button fxConfirmBook;

    private BookingController bc = new BookingController();
    private Flight f;
    private Seat s;

    public  BookFlightController(){
    }

    public void setFlight(Flight flight){
        this.f = flight;
    }

    public  void setSeat(Seat seat){
        this.s = seat;
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
        Passenger p = new Passenger(Integer.parseInt(fxKennitalaBook.getText()), fxNameBook.getText(), fxPassportNoBook.getText());
        Ticket t = new Ticket(2, p, s, f.getFlightID(),f.getFlightNumber(), f.getFlightDeparture(), f.getFlightDestination(), f.getDepartureTime(), f.getArrivalTime(), f.getFlightTime());
        bc.book(2, t);
        Parent root = FXMLLoader.load(getClass().getResource("BookingConfirmed.fxml"));

        Stage window = (Stage) fxConfirmBook.getScene().getWindow();
        window.setScene(new Scene(root,  300, 200));
    }
}
