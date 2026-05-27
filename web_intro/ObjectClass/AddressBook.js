// UC2: Address Book Validation using Regex

class Contact {

    constructor(firstName, lastName, address,
                city, state, zip, phoneNumber, email) {

        this.firstName = this.validateName(firstName, "First Name");
        this.lastName = this.validateName(lastName, "Last Name");

        this.address = this.validateAddress(address, "Address");
        this.city = this.validateAddress(city, "City");
        this.state = this.validateAddress(state, "State");

        this.zip = this.validateZip(zip);
        this.phoneNumber = this.validatePhone(phoneNumber);
        this.email = this.validateEmail(email);
    }

    // Validate First Name & Last Name
    validateName(name, field) {

        let nameRegex = /^[A-Z][a-z]{2,}$/;

        if (nameRegex.test(name)) {
            return name;
        }

        throw `${field} is Invalid`;
    }

    // Validate Address, City, State
    validateAddress(value, field) {

        let addressRegex = /^.{4,}$/;

        if (addressRegex.test(value)) {
            return value;
        }

        throw `${field} is Invalid`;
    }

    // Validate ZIP
    validateZip(zip) {

        let zipRegex = /^[1-9][0-9]{2}\s?[0-9]{3}$/;

        if (zipRegex.test(zip)) {
            return zip;
        }

        throw "ZIP Code is Invalid";
    }

    // Validate Phone Number
    validatePhone(phone) {

        let phoneRegex = /^[0-9]{10}$/;

        if (phoneRegex.test(phone)) {
            return phone;
        }

        throw "Phone Number is Invalid";
    }

    // Validate Email
    validateEmail(email) {

        let emailRegex =
        /^[a-z]{3}([._+-][a-z]{3,})?@[a-z]{5,}\.[a-z]{2,}(\.[a-z]{2})?$/;

        if (emailRegex.test(email)) {
            return email;
        }

        throw "Email is Invalid";
    }

    // Display Contact
    display() {

        console.log(`
        First Name  : ${this.firstName}
        Last Name   : ${this.lastName}
        Address     : ${this.address}
        City        : ${this.city}
        State       : ${this.state}
        ZIP         : ${this.zip}
        Phone Number: ${this.phoneNumber}
        Email       : ${this.email}
        `);
    }
}

// Try Catch for Error Handling

try {

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

    contact1.display();

} catch (error) {

    console.error(error);
}