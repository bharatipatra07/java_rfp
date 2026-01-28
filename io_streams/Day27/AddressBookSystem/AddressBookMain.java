package AddressBookSystem;
public class AddressBookMain {
    public static void main(String[] args) {

        AddressBook addressBook = new AddressBook();

        addressBook.addContact(new Contact(
                "Rahul", "Sharma", "Bangalore",
                "Karnataka", "560001",
                "9876543210", "rahul@gmail.com"));

        addressBook.addContact(new Contact(
                "Anita", "Patel", "Mumbai",
                "Maharashtra", "400001",
                "9123456789", "anita@gmail.com"));

        addressBook.writeToFile();   // Write to file
        addressBook.readFromFile();  // Read from file
        addressBook.displayContacts();
    }
}
