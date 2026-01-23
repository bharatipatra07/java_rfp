package Day24;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AddressBookSystem {

    public static void main(String[] args) {
        Map<String, AddressBook> addressBooks = new HashMap<>();

        // Sample Data
        AddressBook book1 = new AddressBook();
        book1.addContact(new Contact("Amit", "Shah", "Mumbai", "MH"));
        book1.addContact(new Contact("Neha", "Verma", "Mumbai", "MH"));

        AddressBook book2 = new AddressBook();
        book2.addContact(new Contact("Ravi", "Kumar", "Delhi", "DL"));
        book2.addContact(new Contact("Sita", "Rao", "Mumbai", "MH"));

        addressBooks.put("Book1", book1);
        addressBooks.put("Book2", book2);

        /* ========== UC-10 COUNT BY CITY ========== */
        Map<String, Long> countByCity =
                addressBooks.values().stream()
                        .flatMap(book -> book.getContacts().stream())
                        .collect(Collectors.groupingBy(
                                Contact::getCity,
                                Collectors.counting()
                        ));

        System.out.println("Contact Count by City:");
        countByCity.forEach((city, count) ->
                System.out.println(city + " -> " + count)
        );

        /* ========== UC-10 COUNT BY STATE ========== */
        Map<String, Long> countByState =
                addressBooks.values().stream()
                        .flatMap(book -> book.getContacts().stream())
                        .collect(Collectors.groupingBy(
                                Contact::getState,
                                Collectors.counting()
                        ));

        System.out.println("Contact Count by State:");
        countByState.forEach((state, count) ->
                System.out.println(state + " -> " + count)
        );
    }
}
