function validatePassword() {

    const password = document.getElementById("password").value;
    const message = document.getElementById("message");

    // Rule 1: Minimum 8 Characters

    const passwordRegex = /^.{8,}$/;

    if (passwordRegex.test(password)) {
        message.textContent = "Valid Password";
        message.style.color = "green";
    } else {
        message.textContent =
            "Invalid! Password must contain at least 8 characters.";
        message.style.color = "red";
    }
}