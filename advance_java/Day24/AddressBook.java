package Day24;
import java.util.ArrayList;
import java.util.List;

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
