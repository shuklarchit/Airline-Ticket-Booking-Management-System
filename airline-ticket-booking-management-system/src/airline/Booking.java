package airline;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Booking implements Serializable {
    private final String bookingId;
    private final Passenger passenger;
    private final String flightNumber;
    private final double amount;
    private final LocalDateTime bookedAt;
    private String status;

    public Booking(String bookingId, Passenger passenger, String flightNumber, double amount) {
        this.bookingId = bookingId;
        this.passenger = passenger;
        this.flightNumber = flightNumber;
        this.amount = amount;
        this.bookedAt = LocalDateTime.now();
        this.status = "CONFIRMED";
    }

    public String getBookingId() { return bookingId; }
    public Passenger getPassenger() { return passenger; }
    public String getFlightNumber() { return flightNumber; }
    public double getAmount() { return amount; }
    public String getStatus() { return status; }
    public void cancel() { status = "CANCELLED"; }

    @Override
    public String toString() {
        return String.format("%-10s %-20s %-10s Rs.%-9.2f %-10s %s",
                bookingId, passenger.getName(), flightNumber, amount, status, bookedAt);
    }
}
