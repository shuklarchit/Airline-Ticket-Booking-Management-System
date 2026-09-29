package airline;

import java.io.*;
import java.util.ArrayList;

public class FileManager {
    private static final String FILE_NAME = "data/airline_data.dat";

    public static void save(ArrayList<Flight> flights, ArrayList<Booking> bookings) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(flights);
            out.writeObject(bookings);
        } catch (IOException e) {
            System.out.println("Warning: Could not save data: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<?>[] load() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return new ArrayList<?>[]{new ArrayList<Flight>(), new ArrayList<Booking>()};

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            ArrayList<Flight> flights = (ArrayList<Flight>) in.readObject();
            ArrayList<Booking> bookings = (ArrayList<Booking>) in.readObject();
            return new ArrayList<?>[]{flights, bookings};
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Warning: Starting with fresh data: " + e.getMessage());
            return new ArrayList<?>[]{new ArrayList<Flight>(), new ArrayList<Booking>()};
        }
    }
}
