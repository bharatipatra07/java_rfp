// UC1: Validate Indian PIN Code

let pinCode = "400088";

let pinRegex = /^[1-9][0-9]{5}$/;

if (pinRegex.test(pinCode)) {
    console.log("Valid PIN Code");
} else {
    console.log("Invalid PIN Code");
}