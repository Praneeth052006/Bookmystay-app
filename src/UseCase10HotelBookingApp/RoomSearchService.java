package UseCase10HotelBookingApp;


import java.util.List;

public class RoomSearchService {

    public void searchAvailableRooms(RoomInventory inventory, List<Room> rooms) {

        System.out.println("Available Rooms:\n");

        for (Room room : rooms) {

            int available = inventory.getAvailability(room.getRoomType());

            if (available > 0) {
                System.out.println("Room Type: " + room.getRoomType());
                System.out.println("Price: " + room.getPrice());
                System.out.println("Available: " + available);
                System.out.println("----------------------");
            }
        }
    }
}