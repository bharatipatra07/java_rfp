package Day24;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBookSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, AddressBook> addressBooks = new HashMap<>();
        boolean systemRunning = true;

        while (systemRunning) {
            System.out.println("--- Address Book System ---");
            System.out.println("1. Create Address Book");
            System.out.println("2. Add Contact");
            System.out.println("3. Show Contacts");
            System.out.println("4. Search Person by City");
            System.out.println("5. Search Person by State");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");
            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    System.out.print("Enter a unique name for the Address Book: ");
                    String bookName = scanner.nextLine();
                    if (addressBooks.containsKey(bookName)) {
                        System.out.println("Address Book with this name already exists.");
                    } else {
                        addressBooks.put(bookName, new AddressBook());
                        System.out.println("Address Book '" + bookName + "' created successfully.");
                    }
                    break;

                case "2":
                    System.out.print("Enter the Address Book name to add contact: ");
                    String addBookName = scanner.nextLine();
                    AddressBook addBook = addressBooks.get(addBookName);
                    if (addBook == null) {
                        System.out.println("Address Book not found.");
                        break;
                    }

                    System.out.print("Enter First Name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Enter Last Name: ");
                    String lastName = scanner.nextLine();

                    // Create a temporary contact with only firstName & lastName to check for duplicates
                    Contact tempContact = new Contact(firstName, lastName, "", "", "", "", "", "");

                    if (addBook.isDuplicate(tempContact)) {
                        System.out.println("Duplicate entry! Contact already exists.");
                        break; // Stop here, do not ask for other details
                    }

                    // Only ask for other details if contact is not duplicate
                    System.out.print("Enter Address: ");
                    String address = scanner.nextLine();
                    System.out.print("Enter City: ");
                    String city = scanner.nextLine();
                    System.out.print("Enter State: ");
                    String state = scanner.nextLine();
                    System.out.print("Enter Zip: ");
                    String zip = scanner.nextLine();
                    System.out.print("Enter Phone: ");
                    String phone = scanner.nextLine();
                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();

                    Contact contact = new Contact(firstName, lastName, address, city, state, zip, phone, email);
                    addBook.addContact(contact);
                    break;


                case "3":
                    System.out.print("Enter the Address Book name to view contacts: ");
                    String viewBookName = scanner.nextLine();
                    AddressBook viewBook = addressBooks.get(viewBookName);
                    if (viewBook == null) {
                        System.out.println("Address Book not found.");
                    } else {
                        System.out.println("Contacts in Address Book '" + viewBookName + "':");
                        viewBook.showContacts();
                    }
                    break;

                /* ================= UC-8 SEARCH BY CITY ================= */
                case "4":
                    System.out.print("Enter City: ");
                    String searchCity = scanner.nextLine();

                    List<Contact> cityResult = addressBooks.values().stream()
                            .flatMap(b -> b.getContacts().stream())
                            .filter(c -> c.getCity().equalsIgnoreCase(searchCity))
                            .collect(Collectors.toList());

                    if (cityResult.isEmpty()) {
                        System.out.println("No contacts found in city: " + searchCity);
                    } else {
                        cityResult.forEach(System.out::println);
                    }
                    break;


                /* ================= UC-8 SEARCH BY STATE ================= */
                case "5":
                    System.out.print("Enter State: ");
                    String searchState = scanner.nextLine();

                    List<Contact> stateResult = addressBooks.values().stream()
                            .flatMap(b -> b.getContacts().stream())
                            .filter(c -> c.getState().equalsIgnoreCase(searchState))
                            .collect(Collectors.toList());

                    if (stateResult.isEmpty()) {
                        System.out.println("No contacts found in state: " + searchState);
                    } else {
                        stateResult.forEach(System.out::println);
                    }
                    break;

                case "6":
                    running = false;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}
