package Day28;
import java.util.ArrayList;
import java.util.List;

class AddressBook {

    private List<Contact> contacts = new ArrayList<>();

    public void addContact(Contact contact) {
        // Check for duplicates using streams
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
