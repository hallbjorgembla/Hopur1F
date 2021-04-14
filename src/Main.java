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
    }
}
