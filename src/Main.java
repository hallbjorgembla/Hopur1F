import FlightReservation.controller.BookingController;
import FlightReservation.controller.BookingDBManager;
import FlightReservation.model.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.security.KeyStore;
import java.sql.ResultSet;
import java.time.LocalDateTime;

// Þetta er main skjalið okkar
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Start.fxml"));
        primaryStage.setTitle("Welcome to flightSearch");
        primaryStage.setScene(new Scene(root, 400, 200));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
        BookingController bc = new BookingController();
        Passenger p = new Passenger(807982299, "Katja", "passportnr");
        Seat s = new Seat(1, "s1", true, true);
        Ticket tInn = new Ticket(5, p, s, 1, "f1", "departure", "destination",
                LocalDateTime.of(2019, 03, 28, 14, 33, 48, 123456789),LocalDateTime.of(2019, 03, 28, 14, 33, 48, 123456789), 65);
        bc.book(1, tInn);
        Booking b  = bc.showTicketInBooking(1);
        System.out.print(b.getBookingID());
        System.out.print(b.getTicket().getTicketID());
        System.out.print(b.getTicket().getFlightID());
        System.out.print(b.getTicket().getPassenger().getPassengerID());
    }
}
