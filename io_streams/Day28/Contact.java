package Day28;
public class Contact {
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phone;
    private String email;

    public Contact(String firstName, String lastName, String address,
                   String city, String state, String zip,
                   String phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.email = email;
    }

    public String[] toCSVRow() {
        return new String[] { firstName, lastName, address, city, state, zip, phone, email };
    }

    @Override
    public String toString() {
        return firstName + " " + lastName +
                " | " + address +
                " | " + city +
                " | " + state +
                " | " + zip +
                " | " + phone +
                " | " + email;
    }
}
