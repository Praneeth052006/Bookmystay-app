package UseCase12HotelBookingApp;

import java.io.*;

public class PersistenceService {

    private static final String FILE_NAME = "system_state.dat";

    public void saveState(SystemState state) {

        try (ObjectOutputStream out =
                     new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {

            out.writeObject(state);
            System.out.println("System state saved successfully.");

        } catch (IOException e) {
            System.out.println("Error saving system state.");
        }
    }

    public SystemState loadState() {

        try (ObjectInputStream in =
                     new ObjectInputStream(new FileInputStream(FILE_NAME))) {

            System.out.println("System state restored successfully.");
            return (SystemState) in.readObject();

        } catch (Exception e) {

            System.out.println("No previous state found. Starting fresh.");
            return null;
        }
    }
}