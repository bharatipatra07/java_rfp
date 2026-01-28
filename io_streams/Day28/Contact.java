package Day28;
import java.util.Objects;

class Contact {

    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phoneNumber;
    private String email;

    public Contact(String firstName, String lastName, String address,
                   String city, String state, String zip,
                   String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
    public String getCity() { return city; }
    public String getState() { return state; }
    public String getZip() { return zip; }


    @Override
    public String toString() {
        return firstName + " " + lastName +
                ", City: " + city +
                ", State: " + state +
                ", Phone: " + phoneNumber +
                ", Email: " + email;
    }
}
