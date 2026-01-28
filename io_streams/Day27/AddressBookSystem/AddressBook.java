package AddressBookSystem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AddressBook {
    private List<Contact> contacts = new ArrayList<>();

    public void addContact(Contact contact) {
        contacts.add(contact);
    }
    // ✔ validation FIRST
    public boolean isFirstNamePresent(String firstName) {
        for (Contact c : contacts) {
            if (c.getFirstName().equalsIgnoreCase(firstName)) {
                return true;
            }
        }
        return false;
    }

    // DELETE BY NAME
    public boolean deleteContact(String firstName) {

        Iterator<Contact> iterator = contacts.iterator();

        while (iterator.hasNext()) {
            Contact contact = iterator.next();
            if (contact.getFirstName().equalsIgnoreCase(firstName)) {
                iterator.remove();
                System.out.println("Contact deleted successfully.");
                return true;
            }
        }

        System.out.println("Invalid first name");
        return false;
    }

    public void showContacts() {
        for (Contact c : contacts) {
            System.out.println(c);
        }
    }
}
