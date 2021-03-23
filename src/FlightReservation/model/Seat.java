package FlightReservation.model;

public class Seat {
    private int seatID;
    private String seatNumber;
    private boolean seatOccupation;
    private boolean classEconomy;

    public Seat(int seatID, String seatNumber, boolean seatOccupation, boolean classEconomy) {
        this.seatID = seatID;
        this.seatNumber = seatNumber;
        this.seatOccupation = seatOccupation;
        this.classEconomy = classEconomy;
    }

    public int getSeatID() {
        return seatID;
    }

    public void setSeatID(int seatID) {
        this.seatID = seatID;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public boolean isSeatOccupation() {
        return seatOccupation;
    }

    public void setSeatOccupation(boolean seatOccupation) {
        this.seatOccupation = seatOccupation;
    }

    public boolean isClassEconomy() {
        return classEconomy;
    }

    public void setClassEconomy(boolean classEconomy) {
        this.classEconomy = classEconomy;
    }
}

