package model;

public class Passenger {
    private int passengerID;
    private String name;
    private String passportNumber;

    public Passenger(int passengerID, String name, String passportNumber) {
        this.passengerID = passengerID;
        this.name = name;
        this.passportNumber = passportNumber;
    }

    public int getPassengerID() {
        return passengerID;
    }

    public void setPassengerID(int passengerID) {
        this.passengerID = passengerID;
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
