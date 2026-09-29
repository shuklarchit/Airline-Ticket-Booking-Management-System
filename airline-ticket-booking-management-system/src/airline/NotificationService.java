package airline;

public class NotificationService implements Runnable {
    private final String bookingId;
    private final String passengerName;

    public NotificationService(String bookingId, String passengerName) {
        this.bookingId = bookingId;
        this.passengerName = passengerName;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(400);
            System.out.println("[Notification Thread] Confirmation sent to " + passengerName
                    + " for booking " + bookingId + ".");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
