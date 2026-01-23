package Day24;

import java.util.Objects;

class Contact {
    private String firstName;
    private String lastName;
    private String city;
    private String state;
    private String zip;
    private String phone;
    private String email;

    public Contact(String firstName, String lastName,
                   String city, String state,String zip,
                   String phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.state = state;
        this.zip=zip;
        this.phone = phone;
        this.email = email;
    }

    public String getCity() { return city; }
    public String getState() { return state; }
    public String getZip() { return zip; }

    @Override
    public String toString() {
        return "Name: " + firstName + " " + lastName +
                ", City: " + city +
                ", State: " + state +
                ", Zip: " + zip +
                ", Phone: " + phone +
                ", Email: " + email;
    }
}