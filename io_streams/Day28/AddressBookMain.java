package Day28;

import java.util.Scanner;

public class AddressBookMain {
    public static void main(String[] args) {

        AddressBook book = new AddressBook();
        book.readFromJSON(); 

        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Address Book Menu (JSON) ---");
            System.out.println("1. Add Contact and write Contacts to JSON");
            System.out.println("2. Display Contacts from JSON");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");

            switch (sc.nextLine()) {
                case "1":
                    System.out.print("First Name: "); String fn = sc.nextLine();
                    System.out.print("Last Name: "); String ln = sc.nextLine();
                    System.out.print("Address: "); String addr = sc.nextLine();
                    System.out.print("City: "); String city = sc.nextLine();
                    System.out.print("State: "); String state = sc.nextLine();
                    System.out.print("Zip: "); String zip = sc.nextLine();
                    System.out.print("Phone: "); String phone = sc.nextLine();
                    System.out.print("Email: "); String email = sc.nextLine();

                    book.addContact(new Contact(fn, ln, addr, city, state, zip, phone, email));
                    book.writeToJSON();
                    System.out.println("Contact added!");
                    break;

              
                case "2":
                    book.readFromJSON();
                    book.displayContacts();
                    break;

                case "3":
                    running = false;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
        sc.close();
    }
}
