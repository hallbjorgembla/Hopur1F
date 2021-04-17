
package FlightReservation.model;

import java.time.LocalDateTime;

public class TicketToShow {
    String flightNumber;
    LocalDateTime departureTime;
    String passengerName;
    String passportNumber;
    String destination;
    String seatNumber;

    public TicketToShow(String flightNumber, LocalDateTime departureTime, String passengerName, String passportNumber, String destination, String seatNumber) {
        this.flightNumber = flightNumber;
        this.departureTime = departureTime;
        this.passengerName = passengerName;
        this.passportNumber = passportNumber;
        this.destination = destination;
        this.seatNumber = seatNumber;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    @Override
    public String toString() {
        return "TicketToShow{" +
                "flightNumber='" + flightNumber + '\'' +
                ", departureTime=" + departureTime +
                ", passengerName='" + passengerName + '\'' +
                ", passportNumber='" + passportNumber + '\'' +
                ", destination='" + destination + '\'' +
                ", seatNumber='" + seatNumber + '\'' +
                '}';
    }
}
