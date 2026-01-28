package AddressBookSystem;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class AddressBook {
    private List<Contact> contacts = new ArrayList<>();

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    /* ========== SORT BY CITY ========== */
    public void sortByCity() {
        sortAndPrint(
                Comparator.comparing(Contact::getCity, String.CASE_INSENSITIVE_ORDER),
                "City"
        );
    }

    /* ========== SORT BY STATE ========== */
    public void sortByState() {
        sortAndPrint(
                Comparator.comparing(Contact::getState, String.CASE_INSENSITIVE_ORDER),
                "State"
        );
    }

    /* ========== SORT BY ZIP ========== */
    public void sortByZip() {
        sortAndPrint(
                Comparator.comparing(Contact::getZip),
                "Zip"
        );
    }

    /* ========== COMMON SORT METHOD ========== */
    private void sortAndPrint(Comparator<Contact> comparator, String sortField) {
        List<Contact> sorted = contacts.stream()
                .sorted(comparator)
                .collect(Collectors.toList());

        System.out.println("\nContacts sorted by " + sortField + ":");
        sorted.forEach(System.out::println);
    }
}