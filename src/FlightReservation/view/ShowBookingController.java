package FlightReservation.view;

import FlightReservation.controller.BookingController;
import FlightReservation.model.TicketToShow;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ShowBookingController {


    public TableView<TicketToShow> fxShowTickets;
    public TableColumn<TicketToShow, String> fxFlightNumberColTicket;
    public TableColumn<TicketToShow, LocalDateTime> fxDateColTicket;
    public TableColumn<TicketToShow, String> fxNameColTicket;
    public TableColumn<TicketToShow, String> fxPassportColTicket;
    public TableColumn<TicketToShow, String> fxDestinationColTicket;
    public TableColumn<TicketToShow, String> fxSeatColTicket;
    public Button fxShowAnother;
    public Button fxBackToMain;

    private String kennitala;
    private String passportNumber;
    private String name;

    private BookingController bookingController = new BookingController();

    void setStrings(String kennitala, String passportNumber, String name) {
        this.kennitala = kennitala;
        this.passportNumber = passportNumber;
        this.name = name;
    }

    public void openCheckBooking(ActionEvent event) throws Exception {
        Button button = (Button) event.getSource();
        Parent root = FXMLLoader.load(getClass().getResource("CheckBooking.fxml"));

        Stage window = (Stage) button.getScene().getWindow();
        window.setScene(new Scene(root,  430, 400));
    }

    boolean saekjaFlug() throws SQLException {
        setjaUppDalka();
        ArrayList<TicketToShow> tickets = bookingController.getTicketsToShow(this.name, this.passportNumber, this.kennitala);
        ObservableList<TicketToShow> ticketToShows = FXCollections.observableArrayList(tickets);
        fxShowTickets.setItems(ticketToShows);
        return tickets.isEmpty();
    }

    private void setjaUppDalka() {
        fxDateColTicket.setCellValueFactory(new PropertyValueFactory<>("departureTime"));
        fxDestinationColTicket.setCellValueFactory(new PropertyValueFactory<>("destination"));
        fxNameColTicket.setCellValueFactory(new PropertyValueFactory<>("passengerName"));
        fxPassportColTicket.setCellValueFactory(new PropertyValueFactory<>("passportNumber"));
        fxSeatColTicket.setCellValueFactory(new PropertyValueFactory<>("seatNumber"));
        fxFlightNumberColTicket.setCellValueFactory(new PropertyValueFactory<>("flightNumber"));
    }

    public void openStart() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Start.fxml"));

        Stage window = (Stage) fxBackToMain.getScene().getWindow();
        window.setScene(new Scene(root,  430, 400));
    }
}
