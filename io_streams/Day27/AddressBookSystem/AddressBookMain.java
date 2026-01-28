package AddressBookSystem;
import java.util.Scanner;

public class AddressBookMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();
        boolean addMore = true;
        while (addMore) {

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

            System.out.println("Do you want to add another person? (yes/no)");
            String choice = scanner.nextLine();

            if (!choice.equalsIgnoreCase("yes")) {
                addMore = false;
            }

        }
        // ---- Display All Contacts ----
        System.out.println("All Contacts in Address Book:");
        addressBook.showContacts();


        scanner.close();
    }
}
