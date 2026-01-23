package Day24;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class AddressBook {

    private List<Contact> contacts = new ArrayList<>();

    public void addContact(Contact contact) {
        // Check for duplicates using streams
        boolean duplicate = contacts.stream() .anyMatch(c -> c.equals(contact));
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
    public List<Contact> getContacts() {
        return contacts;
    }
    /* ========== UC11: SORT BY NAME USING STREAMS ========== */
    public void sortContactsByName() {
        List<Contact> sortedList = contacts.stream()
                .sorted(Comparator
                        .comparing(Contact::getFirstName, String.CASE_INSENSITIVE_ORDER)
                        .thenComparing(Contact::getLastName, String.CASE_INSENSITIVE_ORDER))
                .collect(Collectors.toList());

        System.out.println("\nSorted Contacts:");
        sortedList.forEach(System.out::println);
    }
}
