package AddressBookSystem;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AddressBook {

    private List<Contact> contacts = new ArrayList<>();
    private static final String FILE_PATH = "addressbook.txt";

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    // UC 13 – Write contacts to file
    public void writeToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Contact contact : contacts) {
                writer.write(contact.toString());
                writer.newLine();
            }
            System.out.println("Address Book written to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // UC 13 – Read contacts from file
    public void readFromFile() {
        contacts.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                contacts.add(Contact.fromString(line));
            }
            System.out.println("Address Book read from file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void displayContacts() {
        contacts.forEach(System.out::println);
    }
}
