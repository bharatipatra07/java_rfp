package Day24;
import java.util.Scanner;

public class AddressBookSystem {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();

        // ---- Add Contact ----
        System.out.println("Enter First Name:");
        String firstName = scanner.nextLine();

        System.out.println("Enter Last Name:");
        String lastName = scanner.nextLine();

        System.out.println("Enter Address:");
        String address = scanner.nextLine();

        System.out.println("Enter City:");
        String city = scanner.nextLine();

        System.out.println("Enter State:");
        String state = scanner.nextLine();

        System.out.println("Enter Zip:");
        String zip = scanner.nextLine();

        System.out.println("Enter Phone:");
        String phone = scanner.nextLine();

        System.out.println("Enter Email:");
        String email = scanner.nextLine();

        Contact contact = new Contact(
                firstName, lastName, address,
                city, state, zip, phone, email
        );

        addressBook.addContact(contact);
        System.out.println("\nContact Added\n");

        // ---- Update Contact ----
        System.out.println("Enter First Name to Update:");
        String nameToUpdate = scanner.nextLine();

        if (!addressBook.isFirstNamePresent(nameToUpdate)) {
            System.out.println("Enter valid first name");
        } else {

            System.out.println("Enter New Address:");
            String newAddress = scanner.nextLine();

            System.out.println("Enter New City:");
            String newCity = scanner.nextLine();

            System.out.println("Enter New State:");
            String newState = scanner.nextLine();

            System.out.println("Enter New Zip:");
            String newZip = scanner.nextLine();

            System.out.println("Enter New Phone:");
            String newPhone = scanner.nextLine();

            System.out.println("Enter New Email:");
            String newEmail = scanner.nextLine();

            Contact updatedContact = new Contact(
                    nameToUpdate, "", newAddress,
                    newCity, newState, newZip,
                    newPhone, newEmail
            );

            addressBook.updateContact(nameToUpdate, updatedContact);
        }

        // ---- Display ----
        System.out.println("Address Book:");
        addressBook.showContacts();

        scanner.close();
    }
}
