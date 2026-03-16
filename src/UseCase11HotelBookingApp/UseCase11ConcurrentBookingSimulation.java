package UseCase11HotelBookingApp;

import java.util.LinkedList;
import java.util.Queue;

public class UseCase11ConcurrentBookingSimulation {

    public static void main(String[] args) {

        Queue<BookingRequest> bookingQueue = new LinkedList<>();

        bookingQueue.add(new BookingRequest("Guest1", "Single Room"));
        bookingQueue.add(new BookingRequest("Guest2", "Single Room"));
        bookingQueue.add(new BookingRequest("Guest3", "Single Room"));
        bookingQueue.add(new BookingRequest("Guest4", "Double Room"));
        bookingQueue.add(new BookingRequest("Guest5", "Suite Room"));

        InventoryService inventoryService = new InventoryService();

        Thread t1 = new Thread(new ConcurrentBookingProcessor(bookingQueue, inventoryService));
        Thread t2 = new Thread(new ConcurrentBookingProcessor(bookingQueue, inventoryService));
        Thread t3 = new Thread(new ConcurrentBookingProcessor(bookingQueue, inventoryService));

        t1.start();
        t2.start();
        t3.start();
    }
}