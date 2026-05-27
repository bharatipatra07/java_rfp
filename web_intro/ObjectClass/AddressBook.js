// UC5: Find and Delete Contact from Address Book

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

// Name to Delete
let personName = "Rahul";

// Find Index of Contact
let contactIndex = addressBook.findIndex(
    person => person.firstName === personName
);

// Delete Contact
if (contactIndex !== -1) {

    addressBook.splice(contactIndex, 1);

    console.log("Contact Deleted Successfully");

} else {

    console.log("Contact Not Found");
}

// Display Remaining Contacts
addressBook.forEach(person => {
    console.log(person.display());
});