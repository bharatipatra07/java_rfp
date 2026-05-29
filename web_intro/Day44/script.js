window.addEventListener("DOMContentLoaded", () => {

    // Salary Event Listener
    const salary = document.getElementById("salary");
    const salaryOutput = document.getElementById("salaryOutput");

    salaryOutput.textContent = salary.value;

    salary.addEventListener("input", () => {
        salaryOutput.textContent = salary.value;
    });

    // Name Validation Event Listener
    const name = document.getElementById("name");

    name.addEventListener("input", () => {

        const nameRegex = /^[A-Z][a-zA-Z]{2,}$/;

        if (name.value.length === 0) {
            document.getElementById("nameError").textContent = "";
        }
        else if (!nameRegex.test(name.value)) {
            document.getElementById("nameError").textContent =
                "Name should start with a capital letter and have minimum 3 characters";
        }
        else {
            document.getElementById("nameError").textContent = "";
        }
    });

    // Date Validation Event Listener
    const startDate = document.getElementById("startDate");

    startDate.addEventListener("change", () => {

        const selectedDate = new Date(startDate.value);
        const today = new Date();

        today.setHours(0, 0, 0, 0);

        if (selectedDate > today) {
            document.getElementById("dateError").textContent =
                "Future date is not allowed";
        }
        else {
            document.getElementById("dateError").textContent = "";
        }
    });
});

function saveEmployee() {

    const nameError =
        document.getElementById("nameError").textContent;

    const dateError =
        document.getElementById("dateError").textContent;

    if (nameError || dateError) {
        alert("Please fix validation errors.");
        return;
    }

    alert("Employee Saved Successfully");
}