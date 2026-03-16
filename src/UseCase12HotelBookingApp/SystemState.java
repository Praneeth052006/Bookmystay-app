package UseCase12HotelBookingApp;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public class SystemState implements Serializable {

    private HashMap<String, Integer> inventory;
    private List<Reservation> bookingHistory;

    public SystemState(HashMap<String, Integer> inventory, List<Reservation> bookingHistory) {
        this.inventory = inventory;
        this.bookingHistory = bookingHistory;
    }

    public HashMap<String, Integer> getInventory() {
        return inventory;
    }

    public List<Reservation> getBookingHistory() {
        return bookingHistory;
    }
}