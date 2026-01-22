
import java.util.ArrayList;
import java.util.List;
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

    @Override
    public String toString() {
        return "Name: "+ firstName + " " + lastName +
                ", " +"City: " +city + ", " +"State: "+ state+" "+","+"Zip: "+zip+","
                +"MobileNumber: "+phoneNumber+" ,"+"Email: "+email;
    }
}

class AddressBook {

    private final List<Contact> contacts = new ArrayList<>();

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void displayContacts() {
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }
}

public class AddressBookSystem {

    public static void main(String[] args) {

        AddressBook addressBook = new AddressBook();

        Contact contact = new Contact(
                "Bharati",
                "Patra",
                "MG Road",
                "Bangalore",
                "Karnataka",
                "560001",
                "9876543210",
                "bharati@gmail.com"
        );

        addressBook.addContact(contact);
        addressBook.displayContacts();
    }
}
