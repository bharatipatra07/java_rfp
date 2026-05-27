// UC1: Validate basic email format

let email = "abc@bridgelabz.co";

let emailRegex = /^[a-z]{3}@[a-z]{5,}\.[a-z]{2,}$/;

if (emailRegex.test(email)) {
    console.log("Valid Email");
} else {
    console.log("Invalid Email");
}