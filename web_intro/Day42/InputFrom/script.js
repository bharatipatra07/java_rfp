function validatePassword() {

    const password = document.getElementById("password").value;
    const message = document.getElementById("message");

    const passwordRegex =
        /^(?=.*[A-Z])(?=.*\d)(?=(?:.*[^A-Za-z0-9]){1}$).{8,}$/;

    if (passwordRegex.test(password)) {
        message.textContent = "Valid Password";
        message.style.color = "green";
    } else {
        message.textContent =
            "Password must have minimum 8 characters, 1 uppercase letter, 1 number, and exactly 1 special character.";
        message.style.color = "red";
    }
}