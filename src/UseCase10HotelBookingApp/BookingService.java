package UseCase10HotelBookingApp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class BookingService {

    private HashMap<String, Set<String>> allocatedRooms = new HashMap<>();
    private Set<String> usedRoomIds = new HashSet<>();

    public void processBookings(BookingRequestQueue queue, InventoryService inventory) {

        int idCounter = 1;

        while (queue.hasRequests()) {

            Reservation request = queue.getNextRequest();
            String roomType = request.getRoomType();

            if (inventory.isAvailable(roomType)) {

                String roomId = roomType.substring(0,1).toUpperCase() + idCounter++;

                if (!usedRoomIds.contains(roomId)) {

                    usedRoomIds.add(roomId);

                    allocatedRooms.putIfAbsent(roomType, new HashSet<>());
                    allocatedRooms.get(roomType).add(roomId);

                    inventory.decrementRoom(roomType);

                    System.out.println("Reservation Confirmed:");
                    System.out.println(request.getGuestName() + " -> " + roomType + " | Room ID: " + roomId);
                    System.out.println();
                }

            } else {

                System.out.println("No rooms available for " + roomType + " for guest " + request.getGuestName());
            }
        }
    }
}