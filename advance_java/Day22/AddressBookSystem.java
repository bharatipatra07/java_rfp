import java.util.Scanner;
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
        return "Name: " + firstName + " " + lastName +
                ", Address: " + address +
                ", City: " + city +
                ", State: " + state +
                ", Zip: " + zip +
                ", Phone: " + phoneNumber +
                ", Email: " + email;
    }
}

class AddressBook {

    private List<Contact> contacts = new ArrayList<>();

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    // ✔ validation FIRST
    public boolean isFirstNamePresent(String firstName) {
        for (Contact c : contacts) {
            if (c.getFirstName().equalsIgnoreCase(firstName)) {
                return true;
            }
        }
        return false;
    }

    public void updateContact(String firstName, Contact updatedData) {
        for (Contact contact : contacts) {
            if (contact.getFirstName().equalsIgnoreCase(firstName)) {
                contact.update(updatedData);
                System.out.println("Contact updated successfully.");
                return;
            }
        }
    }

    public void showContacts() {
        for (Contact c : contacts) {
            System.out.println(c);
        }
    }
}

public class AddressBookSystem {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();

        // ---- Add Contact ----
        System.out.println("Enter First Name:");
        String firstName = scanner.nextLine();

        System.out.println("Enter Last Name:");
        String lastName = scanner.nextLine();

        System.out.println("Enter Address:");
        String address = scanner.nextLine();

        System.out.println("Enter City:");
        String city = scanner.nextLine();

        System.out.println("Enter State:");
        String state = scanner.nextLine();

        System.out.println("Enter Zip:");
        String zip = scanner.nextLine();

        System.out.println("Enter Phone:");
        String phone = scanner.nextLine();

        System.out.println("Enter Email:");
        String email = scanner.nextLine();

        Contact contact = new Contact(
                firstName, lastName, address,
                city, state, zip, phone, email
        );

        addressBook.addContact(contact);
        System.out.println("\nContact Added\n");

        // ---- Update Contact ----
        System.out.println("Enter First Name to Update:");
        String nameToUpdate = scanner.nextLine();

        // VALIDATION FIRST
        if (!addressBook.isFirstNamePresent(nameToUpdate)) {
            System.out.println("Invalid first name");
            scanner.close();
            return;
        }

        // ---- Ask new details ONLY if valid ----
        System.out.println("Enter New Address:");
        String newAddress = scanner.nextLine();

        System.out.println("Enter New City:");
        String newCity = scanner.nextLine();

        System.out.println("Enter New State:");
        String newState = scanner.nextLine();

        System.out.println("Enter New Zip:");
        String newZip = scanner.nextLine();

        System.out.println("Enter New Phone:");
        String newPhone = scanner.nextLine();

        System.out.println("Enter New Email:");
        String newEmail = scanner.nextLine();

        Contact updatedContact = new Contact(
                nameToUpdate, "", newAddress,
                newCity, newState, newZip,
                newPhone, newEmail
        );

        addressBook.updateContact(nameToUpdate, updatedContact);

        // ---- Display ----
        System.out.println("Address Book:");
        addressBook.showContacts();

        scanner.close();
    }
}
