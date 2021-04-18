package FlightReservation.view;

import FlightReservation.controller.BookingController;
import FlightReservation.model.Ticket;
import FlightReservation.model.TicketToShow;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ShowBookingController {


    public TableView<TicketToShow> fxShowTickets;
    public TableColumn fxFlightNumberColTicket;
    public TableColumn fxDateColTicket;
    public TableColumn fxNameColTicket;
    public TableColumn fxPassportColTicket;
    public TableColumn fxDestinationColTicket;
    public TableColumn fxSeatColTicket;
    public Button fxShowAnother;
    public Button fxCancelButton;

    private String kennitala;
    private String passportNumber;
    private String name;

    private BookingController bookingController = new BookingController();

    public void setStrings(String kennitala, String passportNumber, String name) {
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
    /*
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setjaUppDalka();
        try {
            ArrayList<TicketToShow> tickets = bookingController.getTicketsToShow(this.name, this.passportNumber, this.kennitala);
            ObservableList<TicketToShow> ticketsToShow = FXCollections.observableArrayList(tickets);
            fxShowTickets.setItems(ticketsToShow);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

     */

    public boolean saekjaFlug() throws SQLException {
        setjaUppDalka();
        ArrayList<TicketToShow> tickets = bookingController.getTicketsToShow(this.name, this.passportNumber, this.kennitala);
        ObservableList<TicketToShow> ticketToShows = FXCollections.observableArrayList(tickets);
        fxShowTickets.setItems(ticketToShows);
        return tickets.isEmpty();
    }

    private void setjaUppDalka() {
        fxDateColTicket.setCellValueFactory(new PropertyValueFactory<TicketToShow, LocalDateTime>("departureTime"));
        fxDestinationColTicket.setCellValueFactory(new PropertyValueFactory<TicketToShow, String>("destination"));
        fxNameColTicket.setCellValueFactory(new PropertyValueFactory<TicketToShow, String>("passengerName"));
        fxPassportColTicket.setCellValueFactory(new PropertyValueFactory<TicketToShow, String>("passportNumber"));
        fxSeatColTicket.setCellValueFactory(new PropertyValueFactory<TicketToShow, String>("seatNumber"));
        fxFlightNumberColTicket.setCellValueFactory(new PropertyValueFactory<TicketToShow, String>("flightNumber"));
    }

    public void printStrings(ActionEvent event) {
        System.out.println(this.name + this.kennitala + this.passportNumber);
    }
}
