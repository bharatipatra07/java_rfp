import java.util.Scanner;
import java.util.ArrayList;
 class ContactPerson {

    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phone;
    private String email;

    public ContactPerson(String firstName, String lastName, String address,
                         String city, String state, String zip,
                         String phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void display() {
        System.out.println(firstName + " " + lastName + ", " + address + ", "
                + city + ", " + state + " - " + zip
                + ", Phone: " + phone
                + ", Email: " + email);
    }
}

class AddressBook {

    private ArrayList<ContactPerson> contacts = new ArrayList<>();

    public void addContact(ContactPerson person) {
        contacts.add(person);
        System.out.println("Contact added successfully.\n");
    }

    public void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
            return;
        }

        for (ContactPerson person : contacts) {
            person.display();
        }
    }
}


 public class AddressBookMain {

     public static void main(String[] args) {

         Scanner scanner = new Scanner(System.in);
         AddressBook addressBook = new AddressBook();

         System.out.println("Welcome to Address Book Program");

         boolean addMore = true;

         while (addMore) {

             System.out.println("\nEnter Contact Details");

             System.out.print("First Name: ");
             String firstName = scanner.nextLine();

             System.out.print("Last Name: ");
             String lastName = scanner.nextLine();

             System.out.print("Address: ");
             String address = scanner.nextLine();

             System.out.print("City: ");
             String city = scanner.nextLine();

             System.out.print("State: ");
             String state = scanner.nextLine();

             System.out.print("ZIP: ");
             String zip = scanner.nextLine();

             System.out.print("Phone: ");
             String phone = scanner.nextLine();

             System.out.print("Email: ");
             String email = scanner.nextLine();

             ContactPerson person = new ContactPerson(
                     firstName, lastName, address,
                     city, state, zip, phone, email
             );

             addressBook.addContact(person);

             System.out.print("Add another contact? (yes/no): ");
             String choice = scanner.nextLine();

             if (!choice.equalsIgnoreCase("yes")) {
                 addMore = false;
             }
         }

         System.out.println("\nAddress Book Contacts:");
         addressBook.displayContacts();

         scanner.close();
     }
 }
