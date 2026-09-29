package airline;

import java.io.Serializable;

public class Flight implements Serializable {
    private final String flightNumber;
    private final String airlineName;
    private final String source;
    private final String destination;
    private final String departureTime;
    private final double fare;
    private int availableSeats;

    public Flight(String flightNumber, String airlineName, String source, String destination,
                  String departureTime, double fare, int availableSeats) {
        this.flightNumber = flightNumber;
        this.airlineName = airlineName;
        this.source = source;
        this.destination = destination;
        this.departureTime = departureTime;
        this.fare = fare;
        this.availableSeats = availableSeats;
    }

    public String getFlightNumber() { return flightNumber; }
    public String getAirlineName() { return airlineName; }
    public String getSource() { return source; }
    public String getDestination() { return destination; }
    public String getDepartureTime() { return departureTime; }
    public double getFare() { return fare; }
    public int getAvailableSeats() { return availableSeats; }

    public boolean bookSeat() {
        if (availableSeats <= 0) return false;
        availableSeats--;
        return true;
    }

    public void releaseSeat() {
        availableSeats++;
    }

    @Override
    public String toString() {
        return String.format("%-8s %-16s %-12s -> %-12s %-16s Rs.%-8.2f %d seats",
                flightNumber, airlineName, source, destination, departureTime, fare, availableSeats);
    }
}
