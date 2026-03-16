package UseCase4HotelBookingApp;

import java.util.ArrayList;
import java.util.List;

public class UseCase4RoomSearch {

    public static void main(String[] args) {

        System.out.println("Book My Stay App - Room Search\n");

        RoomInventory inventory = new RoomInventory();

        List<Room> rooms = new ArrayList<>();
        rooms.add(new SingleRoom());
        rooms.add(new DoubleRoom());
        rooms.add(new SuiteRoom());

        RoomSearchService searchService = new RoomSearchService();

        searchService.searchAvailableRooms(inventory, rooms);
    }
}