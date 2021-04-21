package FlightReservation.view;

import FlightReservation.controller.BookingController;
import FlightReservation.model.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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

    void setFlightAndSeat(Flight flight, Seat seat){
        this.f = flight;
        this.s = seat;
    }

    public void openFindFlightBack() throws Exception {//til baka í ChooseSeat
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ChooseSeat.fxml"));
        Parent root = loader.load();
        ChooseSeatController infoForNextScene = loader.getController();
        infoForNextScene.setFlight(f);

        Stage window = (Stage) fxBackBook.getScene().getWindow();
        window.setScene(new Scene(root,  600, 400));
    }

    private Boolean isKennitala(String str, int length){
        if (length == 10) {
            for (int i = 0; i < length; i++) {
                if (!(str.charAt(i) >= '0' && str.charAt(i) <= '9')) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public void openBookingConfirmed() throws Exception {//áfram í BookingConfirmed
        boolean b = isKennitala(fxKennitalaBook.getText(), fxKennitalaBook.getText().length());
        if (b && fxNameBook.getText().length() > 0 && fxPassportNoBook.getText().length() > 0){
            FXMLLoader loader = new FXMLLoader((getClass().getResource("BookingConfirmed.fxml")));
            Parent root = loader.load();
            Passenger p = new Passenger(fxKennitalaBook.getText(), fxNameBook.getText(), fxPassportNoBook.getText());
            Ticket t = new Ticket(bc.getNextTicketID(), p, s, f.getFlightID(),f.getFlightNumber(), f.getFlightDeparture(), f.getFlightDestination(), f.getDepartureTime(), f.getArrivalTime(), f.getFlightTime());
            bc.book(bc.getNextBookingID(), t);
            Stage window = (Stage) fxConfirmBook.getScene().getWindow();
            window.setScene(new Scene(root,  300, 200));
        }
        else {
            Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setContentText("Illegal booking input\nEnter valid information");
                a.show();
        }
    }
}
