package Day28;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class AddressBook {

    private List<Contact> contacts = new ArrayList<>();
    private static final String JSON_FILE = "addressbook.json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("Address Book is empty.");
            return;
        }
        contacts.forEach(System.out::println);
    }

    // Write to JSON
    public void writeToJSON() {
        try (FileWriter writer = new FileWriter(JSON_FILE)) {
            gson.toJson(contacts, writer);
            System.out.println("Contacts written to JSON successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Read from JSON
    public void readFromJSON() {
        try (FileReader reader = new FileReader(JSON_FILE)) {
            Type listType = new TypeToken<List<Contact>>() {}.getType();
            List<Contact> data = gson.fromJson(reader, listType);

            if (data != null) {
                contacts.clear();
                contacts.addAll(data);
            }

            System.out.println("Contacts read from JSON successfully.");
        } catch (IOException e) {
            System.out.println("JSON file not found. Starting with empty address book.");
        }
    }
}
