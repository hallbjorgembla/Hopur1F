import FlightReservation.controller.BookingController;
import FlightReservation.controller.BookingDBManager;
import FlightReservation.controller.BookingService;
import FlightReservation.model.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.security.KeyStore;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    public static void main(String[] args) throws SQLException {
        launch(args);
        BookingController bc = new BookingController();
        BookingDBManager bdm = new BookingDBManager();
        BookingService bs = new BookingService();
        Passenger p = new Passenger(807982299, "Katja", "passportnr");
        Seat s = new Seat(1, "s1", true, true);
        Ticket t = new Ticket(5, p, s, 1, "Flug 1", "Reykjavík", "Akureyri",
                LocalDateTime.of(2021, 6, 10, 10, 30), LocalDateTime.of(2021, 6, 10, 10, 30), 65);
        Booking b = new Booking(1,t);
        // test method fyrir manager
        bdm.insertToDB(b);
        ResultSet rs =  bdm.getTicketByBookingID(1);
        while(rs.next()) {
            int ticketID = rs.getInt(1);
            int passengerID = rs.getInt(2);
            String name = rs.getString(3);
            String passportNumber = rs.getString(4);
            System.out.println(ticketID);
            System.out.println(passengerID);
            System.out.println(name);
            System.out.println(passportNumber);
        }

    }
}
