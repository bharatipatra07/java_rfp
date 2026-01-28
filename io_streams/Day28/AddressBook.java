package Day28;
import java.util.ArrayList;
import java.util.List;

class AddressBook {

    rivate List<Contact> contacts = new ArrayList<>();

    public boolean isDuplicate(Contact contact) {
        return contacts.stream().anyMatch(c -> c.equals(contact));
    }

    public void addContact(Contact contact) {
        if (isDuplicate(contact)) {
            System.out.println("Duplicate entry! Contact already exists.");
        } else {
            contacts.add(contact);
            System.out.println("Contact added successfully.");

        }
        public List<Contact> getContacts() {
            return contacts;
        }

}
