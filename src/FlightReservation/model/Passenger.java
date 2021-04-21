package FlightReservation.model;

public class Passenger {
    private String passengerKT;
    private String name;
    private String passportNumber;

    public Passenger(String passengerKT, String name, String passportNumber) {
        this.passengerKT = passengerKT;
        this.name = name;
        this.passportNumber = passportNumber;
    }

    public String getPassengerKT() {
        return passengerKT;
    }

    public void setPassengerKT(String passengerKT) {
        this.passengerKT = passengerKT;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }
}
