package UseCase11HotelBookingApp;

import java.util.Queue;

public class ConcurrentBookingProcessor implements Runnable {

    private Queue<BookingRequest> requestQueue;
    private InventoryService inventoryService;

    public ConcurrentBookingProcessor(Queue<BookingRequest> requestQueue, InventoryService inventoryService) {
        this.requestQueue = requestQueue;
        this.inventoryService = inventoryService;
    }

    @Override
    public void run() {

        while (true) {

            BookingRequest request;

            synchronized (requestQueue) {

                if (requestQueue.isEmpty()) {
                    return;
                }

                request = requestQueue.poll();
            }

            boolean success = inventoryService.allocateRoom(request.getRoomType());

            if (success) {
                System.out.println(Thread.currentThread().getName()
                        + " confirmed booking for "
                        + request.getGuestName()
                        + " (" + request.getRoomType() + ")");
            } else {
                System.out.println(Thread.currentThread().getName()
                        + " failed booking for "
                        + request.getGuestName()
                        + " (No rooms available)");
            }
        }
    }
}
