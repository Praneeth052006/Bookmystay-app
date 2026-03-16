package UseCase6HotelBookingApp;

public class UseCase6RoomAllocationService {

    public static void main(String[] args) {

        BookingRequestQueue queue = new BookingRequestQueue();
        InventoryService inventory = new InventoryService();
        BookingService bookingService = new BookingService();

        queue.addRequest(new Reservation("Alice", "Single Room"));
        queue.addRequest(new Reservation("Bob", "Double Room"));
        queue.addRequest(new Reservation("Charlie", "Suite Room"));
        queue.addRequest(new Reservation("David", "Single Room"));

        bookingService.processBookings(queue, inventory);
    }
}
