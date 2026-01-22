import java.util.*;
import java.util.stream.Collectors;

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

    /* Getters for Streams */
    public String getCity() { return city; }
    public String getState() { return state; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }

    /* Duplicate check: First + Last name */
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
        return firstName + " " + lastName +
                ", City: " + city +
                ", State: " + state +
                ", Phone: " + phoneNumber +
                ", Email: " + email;
    }
}

class AddressBook {

    private List<Contact> contacts = new ArrayList<>();

    public boolean isDuplicate(Contact contact) {
        return contacts.stream().anyMatch(c -> c.equals(contact));
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
        System.out.println("Contact added successfully.");
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void showContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
            return;
        }
        contacts.forEach(System.out::println);
    }
}

public class AddressBookSystem {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Map<String, AddressBook> addressBooks = new HashMap<>();
        boolean running = true;

        while (running) {

            System.out.println("--- Address Book System ---");
            System.out.println("1. Create Address Book");
            System.out.println("2. Add Contact");
            System.out.println("3. Show Contacts");
            System.out.println("4. Search Person by City");
            System.out.println("5. Search Person by State");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");

            String choice = scanner.nextLine();

            switch (choice) {

                /* ================= CREATE BOOK ================= */
                case "1":
                    System.out.print("Enter Address Book name: ");
                    String bookName = scanner.nextLine();

                    if (addressBooks.containsKey(bookName)) {
                        System.out.println("Address Book already exists.");
                    } else {
                        addressBooks.put(bookName, new AddressBook());
                        System.out.println("Address Book created.");
                    }
                    break;

                /* ================= ADD CONTACT ================= */
                case "2":
                    System.out.print("Enter Address Book name: ");
                    String addBookName = scanner.nextLine();
                    AddressBook addBook = addressBooks.get(addBookName);

                    if (addBook == null) {
                        System.out.println("Address Book not found.");
                        break;
                    }

                    System.out.print("Enter First Name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Enter Last Name: ");
                    String lastName = scanner.nextLine();

                    Contact temp = new Contact(firstName, lastName,
                            "", "", "", "", "", "");

                    if (addBook.isDuplicate(temp)) {
                        System.out.println("Duplicate entry! Contact already exists.");
                        break;
                    }

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

                    Contact contact = new Contact(firstName, lastName,
                            address, city, state, zip, phone, email);
                    addBook.addContact(contact);
                    break;

                /* ================= SHOW CONTACTS ================= */
                case "3":
                    System.out.print("Enter Address Book name: ");
                    String viewBook = scanner.nextLine();
                    AddressBook book = addressBooks.get(viewBook);

                    if (book == null) {
                        System.out.println("Address Book not found.");
                    } else {
                        book.showContacts();
                    }
                    break;

                /* ================= UC-8 SEARCH BY CITY ================= */
                case "4":
                    System.out.print("Enter City: ");
                    String searchCity = scanner.nextLine();

                    List<Contact> cityResult = addressBooks.values().stream()
                            .flatMap(b -> b.getContacts().stream())
                            .filter(c -> c.getCity().equalsIgnoreCase(searchCity))
                            .collect(Collectors.toList());

                    if (cityResult.isEmpty()) {
                        System.out.println("No contacts found in city: " + searchCity);
                    } else {
                        cityResult.forEach(System.out::println);
                    }
                    break;

                /* ================= UC-8 SEARCH BY STATE ================= */
                case "5":
                    System.out.print("Enter State: ");
                    String searchState = scanner.nextLine();

                    List<Contact> stateResult = addressBooks.values().stream()
                            .flatMap(b -> b.getContacts().stream())
                            .filter(c -> c.getState().equalsIgnoreCase(searchState))
                            .collect(Collectors.toList());

                    if (stateResult.isEmpty()) {
                        System.out.println("No contacts found in state: " + searchState);
                    } else {
                        stateResult.forEach(System.out::println);
                    }
                    break;

                case "6":
                    running = false;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }
        scanner.close();
    }
}
