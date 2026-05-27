// UC8: Search Person by City or State

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
`;
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

// Search by City
let cityName = "Chennai";

let personsInCity = addressBook.filter(
    person => person.city === cityName
);

console.log(`Persons in City: ${cityName}`);

personsInCity.forEach(person => {
    console.log(person.display());
});

// Search by State
let stateName = "Maharashtra";

let personsInState = addressBook.filter(
    person => person.state === stateName
);

console.log(`Persons in State: ${stateName}`);

personsInState.forEach(person => {
    console.log(person.display());
});