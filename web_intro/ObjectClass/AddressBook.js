// UC3: Create Address Book and Add Contacts

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

    // Display Contact Details
    display() {

        return `
First Name  : ${this.firstName}
Last Name   : ${this.lastName}
Address     : ${this.address}
City        : ${this.city}
State       : ${this.state}
ZIP         : ${this.zip}
Phone Number: ${this.phoneNumber}
Email       : ${this.email}
`;
    }
}

// Address Book Array
let addressBook = [];

// Create Contacts
let contact1 = new Contact(
    "Bharati",
    "Patra",
    "12 Gandhi Street",
    "Chennai",
    "TamilNadu",
    "600001",
    "9876543210",
    "abc.xyz@bridgelabz.co.in"
);

let contact2 = new Contact(
    "Rahul",
    "Sharma",
    "45 Nehru Road",
    "Mumbai",
    "Maharashtra",
    "400088",
    "9876541230",
    "rahul@bridgelabz.co"
);

// Add Contacts to Address Book
addressBook.push(contact1);
addressBook.push(contact2);

// Display All Contacts
addressBook.forEach(contact => {
    console.log(contact.display());
});