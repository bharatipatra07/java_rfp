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

    public Contact(String firstName, String lastName,
                   String city, String state,
                   String phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.state = state;
        this.phoneNumber = phone;
        this.email = email;
    }
    public String getCity() { return city; }
    public String getState() { return state; }

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

            System.out.println("--- Address Book Menu ---");
            System.out.println("1. Create Address Book");
            System.out.println("2. Add Contact");
            System.out.println("3. View Persons by City");
            System.out.println("4. View Persons by State");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            String choice = scanner.nextLine();

            switch (choice) {

                case "1":
                    System.out.print("Enter Address Book name: ");
                    String name = scanner.nextLine();
                    addressBooks.putIfAbsent(name, new AddressBook());
                    System.out.println("Address Book created.");
                    break;

                case "2":
                    System.out.print("Enter Address Book name: ");
                    AddressBook book = addressBooks.get(scanner.nextLine());
                    if (book == null) {
                        System.out.println("Address Book not found.");
                        break;
                    }

                    System.out.print("First Name: ");
                    String fn = scanner.nextLine();
                    System.out.print("Last Name: ");
                    String ln = scanner.nextLine();
                    System.out.print("City: ");
                    String city = scanner.nextLine();
                    System.out.print("State: ");
                    String state = scanner.nextLine();
                    System.out.print("Phone: ");
                    String phone = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    Contact c = new Contact(fn, ln, city, state, phone, email);

                    if (book.isDuplicate(c)) {
                        System.out.println("Duplicate contact!");
                    } else {
                        book.addContact(c);
                        System.out.println("Contact added.");
                    }
                    break;

                /* ========== UC-9 VIEW BY CITY ========== */
                case "3":
                    Map<String, List<Contact>> cityMap =
                            addressBooks.values().stream()
                                    .flatMap(b -> b.getContacts().stream())
                                    .collect(Collectors.groupingBy(Contact::getCity));

                    cityMap.forEach((k, v) -> {
                        System.out.println("\nCity: " + k);
                        v.forEach(System.out::println);
                    });
                    break;

                /* ========== UC-9 VIEW BY STATE ========== */
                case "4":
                    Map<String, List<Contact>> stateMap =
                            addressBooks.values().stream()
                                    .flatMap(b -> b.getContacts().stream())
                                    .collect(Collectors.groupingBy(Contact::getState));

                    stateMap.forEach((k, v) -> {
                        System.out.println("\nState: " + k);
                        v.forEach(System.out::println);
                    });
                    break;

                case "5":
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
