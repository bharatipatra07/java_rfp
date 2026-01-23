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

        addressBook.addContact(new Contact(
                firstName, lastName, address,
                city, state, zip, phone, email
        ));

        System.out.println("Contact Added");

        // ---- DELETE CONTACT ----
        System.out.println("Enter First Name to Delete:");
        String nameToDelete = scanner.nextLine();
        boolean deleted = addressBook.deleteContact(nameToDelete);

       // ---- Display ----
        if (deleted) {
            System.out.println("Address Book Cleared");
            addressBook.showContacts();
        }
        scanner.close();
    }
}
