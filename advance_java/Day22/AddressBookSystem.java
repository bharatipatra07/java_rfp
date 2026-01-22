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

        Map<String, AddressBook> addressBooks = new HashMap<>();

        // Sample Data
        AddressBook book1 = new AddressBook();
        book1.addContact(new Contact("Amit", "Shah", "Mumbai", "MH","7880300074","amit@gmail.com"));
        book1.addContact(new Contact("Neha", "Verma", "Mumbai", "MH","809433393","neha@gmail.com"));

        AddressBook book2 = new AddressBook();
        book2.addContact(new Contact("Ravi", "Kumar", "Delhi", "DL","700985585","ravi@gmail.com"));
        book2.addContact(new Contact("Sita", "Rao", "Mumbai", "MH","700987789","sita@gmail.com"));

        addressBooks.put("Book1", book1);
        addressBooks.put("Book2", book2);

        /* ========== UC-10 COUNT BY CITY ========== */
        Map<String, Long> countByCity =
                addressBooks.values().stream()
                        .flatMap(book -> book.getContacts().stream())
                        .collect(Collectors.groupingBy(
                                Contact::getCity,
                                Collectors.counting()
                        ));

        System.out.println("Contact Count by City:");
        countByCity.forEach((city, count) ->
                System.out.println(city + " -> " + count)
        );

        /* ========== UC-10 COUNT BY STATE ========== */
        Map<String, Long> countByState =
                addressBooks.values().stream()
                        .flatMap(book -> book.getContacts().stream())
                        .collect(Collectors.groupingBy(
                                Contact::getState,
                                Collectors.counting()
                        ));

        System.out.println("Contact Count by State:");
        countByState.forEach((state, count) ->
                System.out.println(state + " -> " + count)
        );
    }
}
