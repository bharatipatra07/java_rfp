class EmployeePayrollData {

    get name() {
        return this._name;
    }

    set name(name) {

        const nameRegex = /^[A-Z][a-zA-Z]{2,}$/;

        if (nameRegex.test(name)) {
            this._name = name;
        } else {
            throw "Name should start with a Capital letter and have minimum 3 characters";
        }
    }

    get salary() {
        return this._salary;
    }

    set salary(salary) {
        this._salary = salary;
    }

    get gender() {
        return this._gender;
    }

    set gender(gender) {
        this._gender = gender;
    }

    get department() {
        return this._department;
    }

    set department(department) {
        this._department = department;
    }

    get notes() {
        return this._notes;
    }

    set notes(notes) {
        this._notes = notes;
    }

    get startDate() {
        return this._startDate;
    }

    set startDate(startDate) {

        let today = new Date();

        if (new Date(startDate) > today) {
            throw "Start Date cannot be a future date";
        }

        this._startDate = startDate;
    }
}

// Load Page
window.addEventListener("DOMContentLoaded", () => {

    const salary = document.getElementById("salary");
    const salaryOutput = document.getElementById("salaryOutput");

    salaryOutput.textContent = salary.value;

    salary.addEventListener("input", () => {
        salaryOutput.textContent = salary.value;
    });

    displayEmployees();
});

// Save Employee
function saveEmployee() {

    document.getElementById("nameError").textContent = "";
    document.getElementById("dateError").textContent = "";

    try {

        let employee = new EmployeePayrollData();

        employee.name =
            document.getElementById("name").value;

        employee.salary =
            document.getElementById("salary").value;

        employee.gender =
            document.querySelector(
                'input[name="gender"]:checked'
            )?.value || "";

        employee.department =
            [...document.querySelectorAll(
                'input[name="department"]:checked'
            )].map(dept => dept.value);

        employee.notes =
            document.getElementById("notes").value;

        employee.startDate =
            document.getElementById("startDate").value;

        let employeeList =
            JSON.parse(
                localStorage.getItem("employeePayrollList")
            ) || [];

        employeeList.push(employee);

        localStorage.setItem(
            "employeePayrollList",
            JSON.stringify(employeeList)
        );

        alert("Employee Saved Successfully");

        displayEmployees();

        resetForm();

    } catch (error) {

        if (error.includes("Name")) {
            document.getElementById("nameError").textContent = error;
        }

        if (error.includes("Date")) {
            document.getElementById("dateError").textContent = error;
        }
    }
}

// Reset Form
function resetForm() {

    document.getElementById("employeeForm").reset();

    document.getElementById("salary").value = 40000;

    document.getElementById("salaryOutput").textContent =
        40000;

    document.getElementById("nameError").textContent = "";

    document.getElementById("dateError").textContent = "";
}

// Display Employees
function displayEmployees() {

    let employeeList =
        JSON.parse(
            localStorage.getItem("employeePayrollList")
        ) || [];

    const employeeDiv =
        document.getElementById("employeeList");

    employeeDiv.innerHTML = "";

    employeeList.forEach(employee => {

        employeeDiv.innerHTML += `
            <div class="employee-card">
                <p><strong>Name:</strong> ${employee._name}</p>
                <p><strong>Salary:</strong> ₹${employee._salary}</p>
                <p><strong>Gender:</strong> ${employee._gender}</p>
                <p><strong>Department:</strong> ${employee._department.join(", ")}</p>
                <p><strong>Notes:</strong> ${employee._notes}</p>
                <p><strong>Start Date:</strong> ${employee._startDate}</p>
            </div>
        `;
    });
}