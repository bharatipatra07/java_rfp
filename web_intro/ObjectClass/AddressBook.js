// UC10: Count Contacts by City and State

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
}

// Address Book Array
let addressBook = [];

// Add Contacts
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
        "Ankit",
        "Verma",
        "78 Lake View",
        "Chennai",
        "TamilNadu",
        "110001",
        "9876501234",
        "ankit@bridgelabz.co.in"
    )
);

addressBook.push(
    new Contact(
        "Priya",
        "Singh",
        "22 Park Street",
        "Mumbai",
        "Maharashtra",
        "400001",
        "9876512345",
        "priya@bridgelabz.co.in"
    )
);

// Count by City
let cityName = "Chennai";

let cityCount = addressBook
    .filter(person => person.city === cityName)
    .reduce((count, person) => count + 1, 0);

console.log(`Number of Contacts in ${cityName}: ${cityCount}`);

// Count by State
let stateName = "Maharashtra";

let stateCount = addressBook
    .filter(person => person.state === stateName)
    .reduce((count, person) => count + 1, 0);

console.log(`Number of Contacts in ${stateName}: ${stateCount}`);