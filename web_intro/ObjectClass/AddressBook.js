// UC6: Count Contacts using reduce()

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
        "Delhi",
        "Delhi",
        "110001",
        "9876501234",
        "ankit@bridgelabz.co.in"
    )
);

// Count Contacts using reduce()
let count = addressBook.reduce(
    (total, contact) => total + 1,
    0
);

console.log("Number of Contacts:", count);