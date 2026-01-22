import java.util.*;

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

    // Overriding equals to check duplicate based on firstName + lastName
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Contact)) return false;
        Contact other = (Contact) obj;
        return Objects.equals(this.firstName.toLowerCase(), other.firstName.toLowerCase()) &&
                Objects.equals(this.lastName.toLowerCase(), other.lastName.toLowerCase());
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName.toLowerCase(), lastName.toLowerCase());
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
        boolean duplicate = contacts.stream()
                .anyMatch(c -> c.equals(contact));
        if (duplicate) {
            System.out.println("Duplicate entry! Contact already exists.");
        } else {
            contacts.add(contact);
            System.out.println("Contact added successfully.");
        }
    }
    // New method to check duplicate
    public boolean isDuplicate(Contact contact) {
        return contacts.stream().anyMatch(c -> c.equals(contact));
    }
    public void showContacts() {
        if (contacts.isEmpty()) {
            System.out.println("Address Book is empty.");
            return;
        }
        contacts.forEach(System.out::println);
    }
}

public class AddressBookSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, AddressBook> addressBooks = new HashMap<>();
        boolean systemRunning = true;

        while (systemRunning) {

            System.out.println("\n--- Address Book System Menu ---");
            System.out.println("1. Create New Address Book");
            System.out.println("2. Add Contact to Address Book");
            System.out.println("3. Show Contacts of Address Book");
            System.out.println("4. Show All Address Books");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    System.out.print("Enter a unique name for the Address Book: ");
                    String bookName = scanner.nextLine();
                    if (addressBooks.containsKey(bookName)) {
                        System.out.println("Address Book with this name already exists.");
                    } else {
                        addressBooks.put(bookName, new AddressBook());
                        System.out.println("Address Book '" + bookName + "' created successfully.");
                    }
                    break;

                case "2":
                    System.out.print("Enter the Address Book name to add contact: ");
                    String addBookName = scanner.nextLine();
                    AddressBook addBook = addressBooks.get(addBookName);
                    if (addBook == null) {
                        System.out.println("Address Book not found.");
                        break;
                    }

                    System.out.print("Enter First Name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Enter Lat Name: ");
                    String lastName = scanner.nextLine();

                    // Create a temporary contact with only firstName & lastName to check for duplicates
                    Contact tempContact = new Contact(firstName,lastName , "", "", "", "", "", "");
                    if (addBook.isDuplicate(tempContact)) {
                        System.out.println("Duplicate entry! Contact already exists.");
                        break; // Skip asking for other details
                    }

                    // Only ask for other details if contact is not duplicate
                    System.out.print("Enter Address: ");
                    String address = scanner.nextLine();
                    System.out.print("Enter City: ");
                    String city = scanner.nextLine();
                    System.out.print("Enter State: ");
                    String state = scanner.nextLine();
                    System.out.print("Enter Zip: ");
                    String zip = scanner.nextLine();
                    System.out.print("Enter Phone: ");
                    String phone = scanner.nextLine();
                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();

                    Contact contact = new Contact(firstName, lastName, address, city, state, zip, phone, email);
                    addBook.addContact(contact);
                    break;

                case "3":
                    System.out.print("Enter the Address Book name to view contacts: ");
                    String viewBookName = scanner.nextLine();
                    AddressBook viewBook = addressBooks.get(viewBookName);
                    if (viewBook == null) {
                        System.out.println("Address Book not found.");
                    } else {
                        System.out.println("Contacts in Address Book '" + viewBookName + "':");
                        viewBook.showContacts();
                    }
                    break;

                case "4":
                    if (addressBooks.isEmpty()) {
                        System.out.println("No Address Books available.");
                    } else {
                        System.out.println("Available Address Books:");
                        addressBooks.keySet().forEach(name -> System.out.println("- " + name));
                    }
                    break;

                case "5":
                    systemRunning = false;
                    System.out.println("Exiting Address Book System...");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}

