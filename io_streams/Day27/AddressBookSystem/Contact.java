package Day27.AddressBookSystem
public class Contact {
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
        this.address=address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void update(Contact updated) {
        this.address = updated.address;
        this.city = updated.city;
        this.state = updated.state;
        this.zip = updated.zip;
        this.phoneNumber = updated.phoneNumber;
        this.email = updated.email;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + ", " + city + ", " + phoneNumber;
    }
}
