// UC4: Validate PIN Code with optional space

let pinCode = "400 088";

let pinRegex = /^[1-9][0-9]{2}\s?[0-9]{3}$/;

if (pinRegex.test(pinCode)) {
    console.log("Valid PIN Code");
} else {
    console.log("Invalid PIN Code");
}