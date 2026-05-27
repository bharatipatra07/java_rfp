// UC3: Validate PIN Code

let pinCode = "400088B";


let pinRegex = /^[1-9][0-9]{5}$/;

if (pinRegex.test(pinCode)) {
    console.log("Valid PIN Code");
} else {
    console.log("Invalid PIN Code");
}