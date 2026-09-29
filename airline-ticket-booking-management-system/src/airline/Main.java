package airline;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final AirlineSystem system = new AirlineSystem();

    public static void main(String[] args) {
        System.out.println("====================================================");
        System.out.println("       AIRLINE TICKET BOOKING MANAGEMENT SYSTEM");
        System.out.println("====================================================");

        boolean running = true;
        while (running) {
            printMenu();
            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> listFlights();
                case "2" -> searchFlights();
                case "3" -> bookTicket();
                case "4" -> viewBookings();
                case "5" -> cancelTicket();
                case "6" -> {
                    FileManager.save(system.getFlights(), system.getBookings());
                    System.out.println("Data saved. Thank you for using the system!");
                    running = false;
                }
                default -> System.out.println("Invalid choice. Please select 1-6.");
            }
        }
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n---------------- MAIN MENU ----------------");
        System.out.println("1. View all flights");
        System.out.println("2. Search flights");
        System.out.println("3. Book ticket");
        System.out.println("4. View bookings");
        System.out.println("5. Cancel ticket");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void listFlights() {
        System.out.println("\n---------------- AVAILABLE FLIGHTS ----------------");
        System.out.printf("%-8s %-16s %-12s %-15s %-16s %-12s %s%n",
                "Flight", "Airline", "From", "To", "Departure", "Fare", "Seats");
        for (Flight f : system.getFlights()) System.out.println(f);
    }

    private static void searchFlights() {
        System.out.print("Enter source: ");
        String source = scanner.nextLine();
        System.out.print("Enter destination: ");
        String destination = scanner.nextLine();
        try {
            InputValidator.required(source, "Source");
            InputValidator.required(destination, "Destination");
            List<Flight> result = system.searchFlights(source, destination);
            System.out.println("\nSearch results:");
            if (result.isEmpty()) {
                System.out.println("No matching flights found.");
            } else {
                for (Flight f : result) System.out.println(f);
            }
        } catch (ValidationException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void bookTicket() {
        System.out.print("Enter flight number: ");
        String flightNumber = scanner.nextLine();
        System.out.print("Passenger name: ");
        String name = scanner.nextLine();
        System.out.print("Phone: ");
        String phone = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        try {
            InputValidator.required(flightNumber, "Flight number");
            InputValidator.required(name, "Passenger name");
            InputValidator.required(phone, "Phone");
            InputValidator.required(email, "Email");
            Passenger passenger = new Passenger(name, phone, email);
            Booking booking = system.createBooking(flightNumber, passenger);
            System.out.println("\nTicket booked successfully!");
            System.out.println("Booking ID : " + booking.getBookingId());
            System.out.println("Passenger  : " + booking.getPassenger().getName());
            System.out.println("Flight     : " + booking.getFlightNumber());
            System.out.printf("Amount     : Rs. %.2f%n", booking.getAmount());
            System.out.println("Status     : " + booking.getStatus());
        } catch (ValidationException e) {
            System.out.println("Booking failed: " + e.getMessage());
        }
    }

    private static void viewBookings() {
        System.out.println("\n---------------- BOOKING HISTORY ----------------");
        if (system.getBookings().isEmpty()) {
            System.out.println("No bookings available.");
            return;
        }
        System.out.printf("%-10s %-20s %-10s %-12s %-10s %s%n",
                "Booking", "Passenger", "Flight", "Amount", "Status", "Booked At");
        for (Booking b : system.getBookings()) System.out.println(b);
    }

    private static void cancelTicket() {
        System.out.print("Enter booking ID to cancel: ");
        String bookingId = scanner.nextLine();
        try {
            system.cancelBooking(bookingId);
            System.out.println("Booking cancelled successfully.");
        } catch (ValidationException e) {
            System.out.println("Cancellation failed: " + e.getMessage());
        }
    }
}
