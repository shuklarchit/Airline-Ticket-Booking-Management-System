package airline;

import java.util.ArrayList;
import java.util.List;

public class AirlineSystem {
    private final ArrayList<Flight> flights;
    private final ArrayList<Booking> bookings;

    @SuppressWarnings("unchecked")
    public AirlineSystem() {
        ArrayList<?>[] data = FileManager.load();
        flights = (ArrayList<Flight>) data[0];
        bookings = (ArrayList<Booking>) data[1];
        if (flights.isEmpty()) loadSampleFlights();
    }

    private void loadSampleFlights() {
        flights.add(new Flight("AI101", "Air India", "Delhi", "Mumbai", "08:30", 5200, 25));
        flights.add(new Flight("6E205", "IndiGo", "Mumbai", "Bengaluru", "11:15", 4300, 30));
        flights.add(new Flight("UK810", "Vistara", "Delhi", "Bengaluru", "16:45", 6100, 20));
        flights.add(new Flight("IX332", "Air India Exp", "Kochi", "Delhi", "19:20", 5800, 18));
    }

    public List<Flight> searchFlights(String source, String destination) {
        ArrayList<Flight> result = new ArrayList<>();
        for (Flight flight : flights) {
            if (flight.getSource().equalsIgnoreCase(source.trim())
                    && flight.getDestination().equalsIgnoreCase(destination.trim())) {
                result.add(flight);
            }
        }
        return result;
    }

    public Flight findFlight(String flightNumber) {
        for (Flight flight : flights) {
            if (flight.getFlightNumber().equalsIgnoreCase(flightNumber.trim())) return flight;
        }
        return null;
    }

    public Booking createBooking(String flightNumber, Passenger passenger) throws ValidationException {
        Flight flight = findFlight(flightNumber);
        if (flight == null) throw new ValidationException("Flight not found.");
        if (!flight.bookSeat()) throw new ValidationException("No seats available on this flight.");

        String bookingId = "B" + String.format("%04d", bookings.size() + 1);
        Booking booking = new Booking(bookingId, passenger, flight.getFlightNumber(), flight.getFare());
        bookings.add(booking);
        FileManager.save(flights, bookings);

        Thread notificationThread = new Thread(new NotificationService(bookingId, passenger.getName()));
        notificationThread.start();
        return booking;
    }

    public boolean cancelBooking(String bookingId) throws ValidationException {
        for (Booking booking : bookings) {
            if (booking.getBookingId().equalsIgnoreCase(bookingId.trim())) {
                if (booking.getStatus().equals("CANCELLED"))
                    throw new ValidationException("Booking is already cancelled.");
                booking.cancel();
                Flight flight = findFlight(booking.getFlightNumber());
                if (flight != null) flight.releaseSeat();
                FileManager.save(flights, bookings);
                return true;
            }
        }
        throw new ValidationException("Booking ID not found.");
    }

    public ArrayList<Flight> getFlights() { return flights; }
    public ArrayList<Booking> getBookings() { return bookings; }
}
