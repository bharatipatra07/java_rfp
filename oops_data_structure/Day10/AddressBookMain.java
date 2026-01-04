import java.util.Scanner;
import java.util.ArrayList;
public class ContactPerson {

    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phone;
    private String email;

    public ContactPerson(String firstName, String lastName, String address,
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

    public String getFirstName() {
        return firstName;
    }

    public void display() {
        System.out.println(firstName + " " + lastName + ", " + address + ", "
                + city + ", " + state + " - " + zip
                + ", Phone: " + phone
                + ", Email: " + email);
    }
}

public class AddressBook {

    private ArrayList<ContactPerson> contacts = new ArrayList<>();

    public void addContact(ContactPerson person) {
        contacts.add(person);
    }

    public ContactPerson getContactByName(String firstName) {
        for (ContactPerson person : contacts) {
            if (person.getFirstName().equalsIgnoreCase(firstName)) {
                return person;
            }
        }
        return null;
    }

    public boolean deleteContact(ContactPerson person) {
        return contacts.remove(person);
    }

    public void displayContacts() {
        for (ContactPerson person : contacts) {
            person.display();
        }
    }
}




public class AddressBookMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();

        addressBook.addContact(new ContactPerson(
                "Bharati", "Patra", "MG Road",
                "Bangalore", "Karnataka", "560001",
                "9876543210", "bha@mail.com"
        ));
        addressBook.addContact(new ContactPerson(
                "Kishor", "Kumar", "MG Road",
                "Bangalore", "Karnataka", "560001",
                "9876543290", "kk@mail.com"
        ));

        System.out.println("Enter First Name to Delete:");
        String name = scanner.nextLine();

        ContactPerson person = addressBook.getContactByName(name);

        if (person != null) {
            addressBook.deleteContact(person);
            System.out.println("Contact deleted successfully.");
        } else {
            System.out.println("Contact not found.");
        }

        System.out.println("Remaining Contacts:");
        addressBook.displayContacts();

        scanner.close();
    }
}