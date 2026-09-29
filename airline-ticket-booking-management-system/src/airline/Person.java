package airline;

import java.io.Serializable;

public abstract class Person implements Serializable {
    private final String name;
    private final String phone;

    protected Person(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() { return name; }
    public String getPhone() { return phone; }
}
