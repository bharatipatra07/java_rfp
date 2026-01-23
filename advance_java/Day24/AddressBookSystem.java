package Day24;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBookSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, AddressBook> addressBooks = new HashMap<>();
        boolean running = true;
        while(running){
            System.out.println("--- Address Book Menu ---");
           System.out.println("1. Create Address Book");
           System.out.println("2. Add Contact");
           System.out.println("3. Sort Contacts Alphabetically by Name");
           System.out.println("4. Exit");
           System.out.print("Choose option: ");

           String choice = scanner.nextLine();

           switch (choice) {

               case "1":
                   System.out.print("Enter Address Book name: ");
                   String name = scanner.nextLine();
                   addressBooks.putIfAbsent(name, new AddressBook());
                   System.out.println("Address Book created.");
                   break;

               case "2":
                   System.out.print("Enter Address Book name: ");
                   AddressBook book = addressBooks.get(scanner.nextLine());
                   if (book == null) {
                       System.out.println("Address Book not found.");
                       break;
                   }

                   System.out.print("First Name: ");
                   String fn = scanner.nextLine();
                   System.out.print("Last Name: ");
                   String ln = scanner.nextLine();
                   System.out.print("City: ");
                   String city = scanner.nextLine();
                   System.out.print("State: ");
                   String state = scanner.nextLine();
                   System.out.print("Zip: ");
                   String zip= scanner.nextLine();
                   System.out.print("Phone: ");
                   String phone = scanner.nextLine();
                   System.out.print("Email: ");
                   String email = scanner.nextLine();

                   Contact c = new Contact(fn, ln, city, state,zip, phone, email);

                   if (book.isDuplicate(c)) {
                       System.out.println("Duplicate contact!");
                   } else {
                       book.addContact(c);
                       System.out.println("Contact added.");
                   }
                   break;

               /* ========== SORT OPTION ========== */
               case "3":
                   System.out.print("Enter Address Book name: ");
                   AddressBook sortBook = addressBooks.get(scanner.nextLine());
                   if (sortBook == null) {
                       System.out.println("Address Book not found.");
                   } else {
                       sortBook.sortContactsByName();
                   }
                   break;

               case "4":
                   running = false;
                   System.out.println("Exiting...");
                   break;

               default:
                   System.out.println("Invalid option.");
           }
       }
        scanner.close();
       }
    }

