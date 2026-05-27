// UC2: Validate email with mandatory @ and domain name

let email = "abc@bridgelabz";


let emailRegex = /^[a-z]{3}@[a-z]{5,}$/;

if (emailRegex.test(email)) {
    console.log("Valid Email");
} else {
    console.log("Invalid Email");
}