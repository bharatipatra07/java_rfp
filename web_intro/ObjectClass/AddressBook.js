// UC12: Sort Address Book by City, State, or ZIP

class Contact {

    constructor(firstName, lastName, address,
                city, state, zip, phoneNumber, email) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    // Display Contact
    display() {

        return `
First Name : ${this.firstName}
Last Name  : ${this.lastName}
City       : ${this.city}
State      : ${this.state}
ZIP        : ${this.zip}
`;
    }
}

// Address Book Array
let addressBook = [];

// Add Contacts
addressBook.push(
    new Contact(
        "Rahul",
        "Sharma",
        "45 Nehru Road",
        "Mumbai",
        "Maharashtra",
        "400088",
        "9876541230",
        "rahul@bridgelabz.co"
    )
);

addressBook.push(
    new Contact(
        "Bharati",
        "Patra",
        "12 Gandhi Street",
        "Chennai",
        "TamilNadu",
        "600001",
        "9876543210",
        "abc.xyz@bridgelabz.co.in"
    )
);

addressBook.push(
    new Contact(
        "Ankit",
        "Verma",
        "78 Lake View",
        "Delhi",
        "Delhi",
        "110001",
        "9876501234",
        "ankit@bridgelabz.co.in"
    )
);

// Function to Sort by City
function sortByCity() {

    return [...addressBook].sort((a, b) =>
        a.city.localeCompare(b.city)
    );
}

// Function to Sort by State
function sortByState() {

    return [...addressBook].sort((a, b) =>
        a.state.localeCompare(b.state)
    );
}

// Function to Sort by ZIP
function sortByZip() {

    return [...addressBook].sort((a, b) =>
        a.zip.localeCompare(b.zip)
    );
}

// Display Sorted by City
console.log("Sorted By City:");

sortByCity().forEach(contact => {
    console.log(contact.display());
});

// Display Sorted by State
console.log("Sorted By State:");

sortByState().forEach(contact => {
    console.log(contact.display());
});

// Display Sorted by ZIP
console.log("Sorted By ZIP:");

sortByZip().forEach(contact => {
    console.log(contact.display());
});