import java.util.ArrayList;
import java.util.Scanner;

class ContactPerson {

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

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void display() {
        System.out.println(
                firstName + " " + lastName + ", " +
                        address + ", " +
                        city + ", " +
                        state + " - " + zip +
                        ", Phone: " + phone +
                        ", Email: " + email
        );
    }
}


class AddressBook {

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

    public void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
            return;
        }

        for (ContactPerson person : contacts) {
            person.display();
        }
    }
}

public class AddressBookMain {

    public static void main(String[] args) {

        System.out.println("Welcome to Address Book Program");

        Scanner scanner = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();

        addressBook.addContact(new ContactPerson(
                "Bharati", "Patra", "Old Street",
                "Bangalore", "Karnataka", "110001",
                "9999999999", "bha@mail.com"
        ));

        System.out.println("\nEnter First Name to Edit:");
        String name = scanner.nextLine();

        ContactPerson person = addressBook.getContactByName(name);

        if (person != null) {

            System.out.println("Enter New Address:");
            person.setAddress(scanner.nextLine());

            System.out.println("Enter New City:");
            person.setCity(scanner.nextLine());

            System.out.println("Enter New State:");
            person.setState(scanner.nextLine());

            System.out.println("Enter New Zip:");
            person.setZip(scanner.nextLine());

            System.out.println("Enter New Phone:");
            person.setPhone(scanner.nextLine());

            System.out.println("Enter New Email:");
            person.setEmail(scanner.nextLine());

            System.out.println("\nContact updated successfully.");

        } else {
            System.out.println("\nContact not found.");
        }

        System.out.println("\nUpdated Address Book:");
        addressBook.displayContacts();

        scanner.close();
    }
}
