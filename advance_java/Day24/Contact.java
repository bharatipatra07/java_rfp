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

    public String getFirstName(){return firstName;}
    public String getLastName(){return lastName;}

    //DUPLICATE LOGIC
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Contact)) return false;
        Contact other = (Contact) obj;
        return firstName.equalsIgnoreCase(other.firstName)
                && lastName.equalsIgnoreCase(other.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName.toLowerCase(), lastName.toLowerCase());
    }

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