package Demo;
import java.util.Scanner;
public class AddressBookMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();
        while (true) {
            System.out.println("\n1.Add Contact");
            System.out.println("2.Edit Contact");
            System.out.println("3.Delete Contact");
            System.out.println("4.Show Contacts");
            System.out.println("5.Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                // Add Contact
                case 1:
                    System.out.print("First Name: ");
                    String fn = sc.nextLine();

                    System.out.print("Last Name: ");
                    String ln = sc.nextLine();

                    System.out.print("Address: ");
                    String addr = sc.nextLine();

                    System.out.print("City: ");
                    String city = sc.nextLine();

                    System.out.print("State: ");
                    String state = sc.nextLine();

                    System.out.print("Zip: ");
                    String zip = sc.nextLine();

                    System.out.print("Phone: ");
                    String phone = sc.nextLine();

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    addressBook.addContact(
                            new Contact(fn, ln, addr, city, state, zip, phone, email)
                    );
                    break;

                // UC-3 Edit Contact
                case 2:
                    System.out.print("Enter First Name to Edit: ");
                    String editName = sc.nextLine();

                    if (!addressBook.isNamePresent(editName)) {
                        System.out.println("Invalid name. Contact not found.");
                        break;
                    }

                    System.out.print("New Address: ");
                    addr = sc.nextLine();

                    System.out.print("New City: ");
                    city = sc.nextLine();

                    System.out.print("New State: ");
                    state = sc.nextLine();

                    System.out.print("New Zip: ");
                    zip = sc.nextLine();

                    System.out.print("New Phone: ");
                    phone = sc.nextLine();

                    System.out.print("New Email: ");
                    email = sc.nextLine();

                    addressBook.editContact(
                            editName,
                            new Contact(editName, "", addr, city, state, zip, phone, email)
                    );
                    break;

                // UC-4 Delete Contact
                case 3:
                    System.out.print("Enter First Name to Delete: ");
                    String delName = sc.nextLine();

                    boolean deleted = addressBook.deleteContact(delName);
                    if (deleted) {
                        System.out.println("Address Book Updated.");
                    }
                    break;

                case 4:
                    addressBook.showContacts();
                    break;

                case 5:
                    System.out.println("Program Ended.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}