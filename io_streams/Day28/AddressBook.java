package Demo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class AddressBook {

    private List<Contact> contacts = new ArrayList<>();

    public void addContact(Contact contact) {
        contacts.add(contact);
        System.out.println("Contact added successfully.");
    }

    // Validate name FIRST
    public boolean isNamePresent(String firstName) {
        for (Contact c : contacts) {
            if (c.getFirstName().equalsIgnoreCase(firstName)) {
                return true;
            }
        }
        return false;
    }

    // UC-3 Edit Contact
    public void editContact(String firstName, Contact updated) {
        for (Contact c : contacts) {
            if (c.getFirstName().equalsIgnoreCase(firstName)) {
                c.update(updated);
                System.out.println("Contact updated successfully.");
                return;
            }
        }
    }

    // UC-4 Delete Contact
    public boolean deleteContact(String firstName) {
        Iterator<Contact> iterator = contacts.iterator();
        while (iterator.hasNext()) {
            Contact c = iterator.next();
            if (c.getFirstName().equalsIgnoreCase(firstName)) {
                iterator.remove();
                System.out.println("Contact deleted successfully.");
                return true;
            }
        }
        System.out.println("Invalid name. Contact not found.");
        return false;
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