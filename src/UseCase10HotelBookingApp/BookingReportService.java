package UseCase10HotelBookingApp;

import java.util.List;

public class BookingReportService {

    public void generateReport(List<Reservation> reservations) {

        System.out.println("Booking History Report\n");

        for (Reservation r : reservations) {
            r.display();
        }

        System.out.println("\nTotal Bookings: " + reservations.size());
    }
}
