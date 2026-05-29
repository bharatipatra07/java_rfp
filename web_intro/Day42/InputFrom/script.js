function validateEmail() {

    const email = document.getElementById("email").value;
    const message = document.getElementById("message");
    const emailRegex =
        /^[a-z]{3}([._+-][a-z]{3,})?@[a-z]{2,}\.[a-z]{2,}(\.[a-z]{2})?$/;

    if (emailRegex.test(email)) {
        message.textContent = "Valid Email Address";
        message.style.color = "green";
    } else {
        message.textContent = "Invalid Email Address";
        message.style.color = "red";
    }
}