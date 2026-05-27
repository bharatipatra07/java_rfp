// UC7: Prevent Duplicate Contacts in Address Book

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
First Name  : ${this.firstName}
Last Name   : ${this.lastName}
City        : ${this.city}
Phone Number: ${this.phoneNumber}
Email       : ${this.email}
`;
    }
}

// Address Book Array
let addressBook = [];

// Function to Add Contact
function addContact(contact) {

    // Check Duplicate using some()
    let isDuplicate = addressBook.some(person =>
        person.firstName === contact.firstName &&
        person.lastName === contact.lastName
    );

    if (isDuplicate) {

        console.log(
            `Duplicate Entry Found for ${contact.firstName} ${contact.lastName}`
        );

    } else {

        addressBook.push(contact);

        console.log("Contact Added Successfully");
    }
}

// Add Contacts
addContact(
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

addContact(
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

// Duplicate Contact
addContact(
    new Contact(
        "Rahul",
        "Sharma",
        "New Address",
        "Pune",
        "Maharashtra",
        "411001",
        "9999999999",
        "rahul@bridgelabz.co.in"
    )
);

// Display Address Book
console.log("\nAll Contacts:");

addressBook.forEach(contact => {
    console.log(contact.display());
});

// Count Contacts using reduce()
let count = addressBook.reduce(
    (total, contact) => total + 1,
    0
);

console.log("Total Contacts:", count);