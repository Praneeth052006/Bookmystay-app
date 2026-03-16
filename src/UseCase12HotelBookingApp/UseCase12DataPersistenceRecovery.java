package UseCase12HotelBookingApp;

import java.util.*;

public class UseCase12DataPersistenceRecovery {

    public static void main(String[] args) {

        PersistenceService persistenceService = new PersistenceService();

        SystemState loadedState = persistenceService.loadState();

        HashMap<String, Integer> inventory;
        List<Reservation> history;

        if (loadedState == null) {

            inventory = new HashMap<>();
            history = new ArrayList<>();

            inventory.put("Single Room", 2);
            inventory.put("Double Room", 2);
            inventory.put("Suite Room", 1);

            System.out.println("Initialized new system state.");

        } else {

            inventory = loadedState.getInventory();
            history = loadedState.getBookingHistory();

            System.out.println("Recovered Bookings: " + history.size());
        }

        Reservation r1 = new Reservation("R201", "Alice", "Single Room");

        history.add(r1);

        inventory.put("Single Room", inventory.get("Single Room") - 1);

        System.out.println("Booking added for " + r1.getGuestName());

        SystemState currentState = new SystemState(inventory, history);

        persistenceService.saveState(currentState);
    }
}