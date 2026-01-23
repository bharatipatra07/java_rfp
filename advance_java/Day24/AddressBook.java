package Day24;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class AddressBook {

    private List<Contact> contacts = new ArrayList<>();

    public void addContact(Contact contact) {
        contacts.add(contact);
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
        if (contacts.isEmpty()) {
            System.out.println("Address Book is empty.");
            return;
        }
        for (Contact c : contacts) {
            System.out.println(c);
        }
    }
}
