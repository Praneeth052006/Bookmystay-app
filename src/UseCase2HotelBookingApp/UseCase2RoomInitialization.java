package UseCase2HotelBookingApp;

public class UseCase2RoomInitialization {

    public static void main(String[] args) {

        System.out.println("Welcome to Book My Stay App");
        System.out.println("Displaying Room Types and Availability\n");

        // Create Room Objects
        Room singleRoom = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suiteRoom = new SuiteRoom();

        // Static availability variables
        int singleRoomAvailable = 5;
        int doubleRoomAvailable = 3;
        int suiteRoomAvailable = 2;

        // Display room details
        singleRoom.displayRoomDetails();
        System.out.println("Available: " + singleRoomAvailable);
        System.out.println();

        doubleRoom.displayRoomDetails();
        System.out.println("Available: " + doubleRoomAvailable);
        System.out.println();

        suiteRoom.displayRoomDetails();
        System.out.println("Available: " + suiteRoomAvailable);
    }
}