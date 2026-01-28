package Day28;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBookMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Map<String, AddressBook> addressBooks = new HashMap<>();
        boolean running = true;

        while (running) {

            System.out.println("\n--- Address Book Menu ---");
            System.out.println("1. Create Address Book");
            System.out.println("2. Add Contact");
            System.out.println("3. View Persons by City");
            System.out.println("4. View Persons by State");
            System.out.println("5. Exit");
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
                    System.out.print("Phone: ");
                    String phone = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    Contact c = new Contact(fn, ln, city, state, phone, email);

                    if (book.isDuplicate(c)) {
                        System.out.println("Duplicate contact!");
                    } else {
                        book.addContact(c);
                        System.out.println("Contact added.");
                    }
                    break;

                /* ========== UC-9 VIEW BY CITY ========== */
                case "3":
                    Map<String, List<Contact>> cityMap =
                            addressBooks.values().stream()
                                    .flatMap(b -> b.getContacts().stream())
                                    .collect(Collectors.groupingBy(Contact::getCity));

                    cityMap.forEach((k, v) -> {
                        System.out.println("\nCity: " + k);
                        v.forEach(System.out::println);
                    });
                    break;

                /* ========== UC-9 VIEW BY STATE ========== */
                case "4":
                    Map<String, List<Contact>> stateMap =
                            addressBooks.values().stream()
                                    .flatMap(b -> b.getContacts().stream())
                                    .collect(Collectors.groupingBy(Contact::getState));

                    stateMap.forEach((k, v) -> {
                        System.out.println("\nState: " + k);
                        v.forEach(System.out::println);
                    });
                    break;

                case "5":
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
