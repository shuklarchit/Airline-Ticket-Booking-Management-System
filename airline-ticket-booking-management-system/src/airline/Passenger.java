package airline;

public class Passenger extends Person {
    private final String email;

    public Passenger(String name, String phone, String email) {
        super(name, phone);
        this.email = email;
    }

    public String getEmail() { return email; }
}
