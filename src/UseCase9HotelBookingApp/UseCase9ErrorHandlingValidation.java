package UseCase9HotelBookingApp;

public class UseCase9ErrorHandlingValidation {

    public static void main(String[] args) {

        InvalidBookingValidator validator = new InvalidBookingValidator();

        String guestName = "Alice";
        String roomType = "Luxury Room";   // invalid room type
        int availableRooms = 2;

        try {

            validator.validateBooking(guestName, roomType, availableRooms);

            System.out.println("Booking input is valid. Proceeding with booking...");

        } catch (InvalidBookingException e) {

            System.out.println("Booking Failed: " + e.getMessage());
        }

        System.out.println("System continues running safely.");
    }
}
