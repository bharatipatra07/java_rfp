import java.util.Iterator;
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
    // DELETE BY NAME
    public boolean deleteContact(String firstName) {

        Iterator<Contact> iterator = contacts.iterator();

        while (iterator.hasNext()) {
            Contact contact = iterator.next();
            if (contact.getFirstName().equalsIgnoreCase(firstName)) {
                iterator.remove();
                System.out.println("Contact deleted successfully.");
                return true;
            }
        }

        System.out.println("Invalid first name");
        return false;
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

        addressBook.addContact(new Contact(
                firstName, lastName, address,
                city, state, zip, phone, email
        ));

        System.out.println("Contact Added");
        addressBook.showContacts();

        // ---- DELETE CONTACT ----
        System.out.println("Enter First Name to Delete:");
        String nameToDelete = scanner.nextLine();

        boolean deleted=addressBook.deleteContact(nameToDelete);

        // ---- Display ----
        if(deleted) {
            System.out.println("Address Book Cleared");
            addressBook.showContacts();
        }


        scanner.close();
    }
}

