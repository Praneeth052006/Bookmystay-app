package UseCase10HotelBookingApp;

import java.util.HashMap;
import java.util.Stack;

public class CancellationService {

    private HashMap<String, BookingRecord> bookings;
    private Stack<String> releasedRooms;
    private HashMap<String, Integer> inventory;

    public CancellationService() {

        bookings = new HashMap<>();
        releasedRooms = new Stack<>();
        inventory = new HashMap<>();

        inventory.put("Single Room", 2);
        inventory.put("Double Room", 2);
        inventory.put("Suite Room", 1);
    }

    public void addBooking(BookingRecord record) {
        bookings.put(record.getReservationId(), record);
        inventory.put(record.getRoomType(), inventory.get(record.getRoomType()) - 1);
    }

    public void cancelBooking(String reservationId) {

        if (!bookings.containsKey(reservationId)) {
            System.out.println("Cancellation Failed: Reservation does not exist.");
            return;
        }

        BookingRecord record = bookings.get(reservationId);

        if (record.isCancelled()) {
            System.out.println("Cancellation Failed: Booking already cancelled.");
            return;
        }

        releasedRooms.push(record.getRoomId());

        int count = inventory.get(record.getRoomType());
        inventory.put(record.getRoomType(), count + 1);

        record.setCancelled(true);

        System.out.println("Booking Cancelled Successfully.");
        System.out.println("Released Room ID: " + record.getRoomId());
    }
}