function validateMobile() {

    const mobile = document.getElementById("mobile").value;
    const message = document.getElementById("message");

    // Format: 91 9919819801
    // Country code + space + 10 digit mobile number

    const mobileRegex = /^[0-9]{2}\s[0-9]{10}$/;

    if (mobileRegex.test(mobile)) {
        message.textContent = "Valid Mobile Number";
        message.style.color = "green";
    } else {
        message.textContent =
            "Invalid! Format should be: 91 9919819801";
        message.style.color = "red";
    }
}