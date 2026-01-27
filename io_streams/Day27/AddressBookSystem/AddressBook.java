package Day27.AddressBookSystem
import java.util.ArrayList;
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
    public void updateContact(String firstName, Contact updatedData) {
        for (Contact contact : contacts) {
            if (contact.getFirstName().equalsIgnoreCase(firstName)) {
                contact.update(updatedData);
                System.out.println("Contact updated successfully.");
                return;
            }
        }
    }

    public void showContacts() {
        for (Contact c : contacts) {
            System.out.println(c);
        }
    }
}
