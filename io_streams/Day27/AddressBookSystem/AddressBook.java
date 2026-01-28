package AddressBookSystem;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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