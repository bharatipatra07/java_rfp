function validateName() {

    const firstName = document.getElementById("firstName").value;
    const message = document.getElementById("message");

    // First letter capital, minimum 3 characters
    const regex = /^[A-Z][a-z]{2,}$/;

    if (regex.test(firstName)) {
        message.textContent = "Valid First Name";
        message.style.color = "green";
    } else {
        message.textContent =
            "Invalid! First Name must start with a capital letter and contain at least 3 characters.";
        message.style.color = "red";
    }
}