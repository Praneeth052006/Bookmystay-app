package UseCase10HotelBookingApp;

import java.util.Arrays;
import java.util.List;

public class InvalidBookingValidator {

    private List<String> validRoomTypes =
            Arrays.asList("Single Room", "Double Room", "Suite Room");

    public void validateBooking(String guestName, String roomType, int availableRooms)
            throws InvalidBookingException {

        if (guestName == null || guestName.trim().isEmpty()) {
            throw new InvalidBookingException("Guest name cannot be empty.");
        }

        if (!validRoomTypes.contains(roomType)) {
            throw new InvalidBookingException("Invalid room type selected.");
        }

        if (availableRooms <= 0) {
            throw new InvalidBookingException("No rooms available for " + roomType);
        }
    }
}
