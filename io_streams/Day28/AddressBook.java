package Day28;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddressBook {
    private List<Contact> contacts = new ArrayList<>();
    private static final String CSV_FILE = "addressbook.csv";

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

    // Write contacts to CSV
    public void writeToCSV() {
        try (CSVWriter writer = new CSVWriter(new FileWriter(CSV_FILE))) {
            // Write header
            writer.writeNext(new String[]{"FirstName","LastName","Address","City","State","Zip","Phone","Email"});
            // Write rows
            for (Contact c : contacts) {
                writer.writeNext(c.toCSVRow());
            }
            System.out.println("Contacts written to CSV successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Read contacts from CSV
    public void readFromCSV() {
        contacts.clear();
        try (CSVReader reader = new CSVReader(new FileReader(CSV_FILE))) {
            String[] nextLine;
            boolean firstLine = true;
            while ((nextLine = reader.readNext()) != null) {
                if (firstLine) { // skip header
                    firstLine = false;
                    continue;
                }
                Contact c = new Contact(
                        nextLine[0], nextLine[1], nextLine[2],
                        nextLine[3], nextLine[4], nextLine[5],
                        nextLine[6], nextLine[7]
                );
                contacts.add(c);
            }
            System.out.println("Contacts read from CSV successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
