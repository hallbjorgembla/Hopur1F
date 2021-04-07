package FlightReservation.controller;

import FlightReservation.model.Flight;

import java.time.LocalDateTime;

public interface Comparable {

    //Notkun: Collection.sort(list, Comparable::comparePrice);
    static int comparePrice(Flight o1, Flight o2) {
        return Double.compare(o1.getPriceEconomy(), o2.getPriceEconomy());
    }

    //Notkun: Collection.sort(list, Comparable::compareDepartureTime);
    static int compareDepartureTime(Flight o1, Flight o2) {
        LocalDateTime time1 = o1.getDepartureTime();
        LocalDateTime time2 = o2.getDepartureTime();
        return time1.isBefore(time2) ? -1: time1.isEqual(time2) ? 0 : 1;
    }
    //Notkun: Collection.sort(list, Comparable::compareArrivalTime);
    static int compareArrivalTime(Flight o1, Flight o2) {
        LocalDateTime time1 = o1.getArrivalTime();
        LocalDateTime time2 = o2.getArrivalTime();

        return time1.isBefore(time2) ? -1: time1.isEqual(time2) ? 0 : 1;
    }
}
