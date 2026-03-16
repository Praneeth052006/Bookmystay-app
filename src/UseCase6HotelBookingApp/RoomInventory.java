package UseCase6HotelBookingApp;

import java.util.HashMap;

public class RoomInventory {

    private HashMap<String, Integer> inventory;

    // Constructor initializes room availability
    public RoomInventory() {
        inventory = new HashMap<>();

        inventory.put("Single Room", 5);
        inventory.put("Double Room", 3);
        inventory.put("Suite Room", 2);
    }

    // Get availability
    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    // Update availability
    public void updateAvailability(String roomType, int newCount) {
        inventory.put(roomType, newCount);
    }

    // Display inventory
    public void displayInventory() {
        System.out.println("Current Room Inventory:");
        for (String roomType : inventory.keySet()) {
            System.out.println(roomType + " Available: " + inventory.get(roomType));
        }
    }
}