// UC4: Validate email with optional xyz and optional .in

let email = "abc.xyz@bridgelabz.co.in";

let emailRegex =
/^[a-z]{3}([._+-][a-z]{3})?@[a-z]{5,}\.[a-z]{2}(\.[a-z]{2})?$/;

if (emailRegex.test(email)) {
    console.log("Valid Email");
} else {
    console.log("Invalid Email");
}