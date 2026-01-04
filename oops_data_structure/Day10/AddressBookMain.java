import java.util.Scanner;

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
}
class AddressBook {

    private ArrayList<ContactPerson> contacts = new ArrayList<>();

    public void addContact(ContactPerson person) {
        contacts.add(person);

    }
}

public class AddressBookMain {


    public static void main(String[] args) {

        System.out.println("Welcome to Address Book Program");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter First Name:");
        String firstName = scanner.nextLine();

        System.out.println("Enter Zip:");
        String zip = scanner.nextLine();

        System.out.println("Enter Phone:");
        String phone = scanner.nextLine();

        System.out.println("Enter Email:");
        ContactPerson person = new ContactPerson(
                firstName, lastName, address, city, state, zip, phone, email
        );
        ContactPerson person = new ContactPerson(
                firstName, lastName, address, city, state, zip, phone, email
        );

        AddressBook addressBook = new AddressBook();
        addressBook.addContact(person);

        scanner.close();
    }
}