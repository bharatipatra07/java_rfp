package Day24;


public class AddressBookSystem {

    public static void main(String[] args) {

        AddressBook addressBook = new AddressBook();

        Contact contact = new Contact(
                "Kishor",
                "Kumar",
                "MG Road",
                "Bangalore",
                "Karnataka",
                "560001",
                "9876543210",
                "kishor@gmail.com"
        );

        addressBook.addContact(contact);
        addressBook.displayContacts();
    }
}
