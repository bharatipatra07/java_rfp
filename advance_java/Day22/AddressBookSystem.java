
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
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
        System.out.println("Contact added successfully.\n");
    }

    public void showContacts() {
        if (contacts.isEmpty()) {
            System.out.println("Address Book is empty.");
            return;
        }
        for (Contact c : contacts) {
            System.out.println(c);
        }
    }
}

public class AddressBookSystem {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();

        boolean addMore = true;

        while (addMore) {

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

            System.out.println("Do you want to add another person? (yes/no)");
            String choice = scanner.nextLine();

            if (!choice.equalsIgnoreCase("yes")) {
                addMore = false;
            }
        }

        // ---- Display All Contacts ----
        System.out.println("All Contacts in Address Book:");
        addressBook.showContacts();

        scanner.close();
    }
}
