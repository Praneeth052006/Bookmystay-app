package UseCase7HotelBookingApp;


public class UseCase7AddOnServiceSelection {

    public static void main(String[] args) {

        AddOnServiceManager manager = new AddOnServiceManager();

        String reservationId = "R101";

        AddOnService breakfast = new AddOnService("Breakfast", 500);
        AddOnService wifi = new AddOnService("Premium WiFi", 200);
        AddOnService airportPickup = new AddOnService("Airport Pickup", 800);

        manager.addService(reservationId, breakfast);
        manager.addService(reservationId, wifi);
        manager.addService(reservationId, airportPickup);

        manager.displayServices(reservationId);

        double totalCost = manager.calculateTotalServiceCost(reservationId);

        System.out.println("\nTotal Add-On Cost: ₹" + totalCost);
    }
}