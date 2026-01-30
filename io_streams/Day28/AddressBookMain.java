package Day28;

import java.util.Scanner;

import com.opencsv.exceptions.CsvValidationException;

public class AddressBookMain {
    public static void main(String[] args) {
        AddressBook book = new AddressBook();
        try {
			book.readFromCSV();
		} catch (CsvValidationException e) {
			e.printStackTrace();
		}
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Address Book Menu ---");
            System.out.println("1. Add Contact");
            System.out.println("2. Display Contacts");
            System.out.println("3. Write Contacts to CSV");
            System.out.println("4. Read Contacts from CSV");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            String choice = sc.nextLine();

            switch (choice) {
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
                    System.out.println("Contact added!");
                    break;

                case "2":
                    book.displayContacts();
                    break;

                case "3":
                    book.writeToCSV();
                    break;

                case "4":
				try {
					book.readFromCSV();
					book.displayContacts();
				} catch (CsvValidationException e) {
					e.printStackTrace();
				}
                    break;

                case "5":
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
