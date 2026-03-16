package UseCase10HotelBookingApp;

import java.util.*;

public class AddOnServiceManager {

    private HashMap<String, List<AddOnService>> reservationServices;

    public AddOnServiceManager() {
        reservationServices = new HashMap<>();
    }

    public void addService(String reservationId, AddOnService service) {

        reservationServices.putIfAbsent(reservationId, new ArrayList<>());
        reservationServices.get(reservationId).add(service);

        System.out.println(service.getServiceName() + " added to reservation " + reservationId);
    }

    public double calculateTotalServiceCost(String reservationId) {

        double total = 0;

        List<AddOnService> services = reservationServices.get(reservationId);

        if (services != null) {
            for (AddOnService s : services) {
                total += s.getPrice();
            }
        }

        return total;
    }

    public void displayServices(String reservationId) {

        System.out.println("\nServices for Reservation " + reservationId + ":");

        List<AddOnService> services = reservationServices.get(reservationId);

        if (services != null) {
            for (AddOnService s : services) {
                System.out.println(s.getServiceName() + " - ₹" + s.getPrice());
            }
        } else {
            System.out.println("No services selected.");
        }
    }
}