import java.util.*;

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

    public void display() {
        System.out.println(
                firstName + " " + lastName + ", " +
                        address + ", " + city + ", " +
                        state + " - " + zip +
                        ", Phone: " + phone +
                        ", Email: " + email
        );
    }
}


class AddressBook {

    private List<ContactPerson> contacts = new ArrayList<>();

    public void addContact(ContactPerson person) {
        contacts.add(person);
        System.out.println("Contact added successfully.");
    }

    public void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts in this address book.");
            return;
        }

        for (ContactPerson person : contacts) {
            person.display();
        }
    }
}


public class AddressBookMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, AddressBook> addressBookMap = new HashMap<>();

        System.out.println("Welcome to Address Book System");

        boolean addMoreBooks = true;

        while (addMoreBooks) {

            System.out.print("\nEnter Address Book Name: ");
            String bookName = scanner.nextLine();

            if (addressBookMap.containsKey(bookName)) {
                System.out.println("Address Book already exists.");
                continue;
            }

            AddressBook addressBook = new AddressBook();
            addressBookMap.put(bookName, addressBook);

            System.out.println("Address Book '" + bookName + "' created.");

            boolean addMoreContacts = true;

            while (addMoreContacts) {

                System.out.println("\nEnter Contact Details");

                System.out.print("First Name: ");
                String firstName = scanner.nextLine();

                System.out.print("Last Name: ");
                String lastName = scanner.nextLine();

                System.out.print("Address: ");
                String address = scanner.nextLine();

                System.out.print("City: ");
                String city = scanner.nextLine();

                System.out.print("State: ");
                String state = scanner.nextLine();

                System.out.print("ZIP: ");
                String zip = scanner.nextLine();

                System.out.print("Phone: ");
                String phone = scanner.nextLine();

                System.out.print("Email: ");
                String email = scanner.nextLine();

                ContactPerson person = new ContactPerson(
                        firstName, lastName, address,
                        city, state, zip, phone, email
                );

                addressBook.addContact(person);

                System.out.print("Add another contact to this Address Book? (yes/no): ");
                if (!scanner.nextLine().equalsIgnoreCase("yes")) {
                    addMoreContacts = false;
                }
            }

            System.out.print("\nAdd another Address Book? (yes/no): ");
            if (!scanner.nextLine().equalsIgnoreCase("yes")) {
                addMoreBooks = false;
            }
        }

        System.out.println("\n----- Address Book System -----");
        for (String name : addressBookMap.keySet()) {
            System.out.println("\nAddress Book: " + name);
            addressBookMap.get(name).displayContacts();
        }

        scanner.close();
    }
}
