class EmployeePayrollData {

    // Name
    get name() {
        return this._name;
    }

    set name(name) {

        let nameRegex = /^[A-Z][a-zA-Z]{2,}$/;

        if (nameRegex.test(name)) {
            this._name = name;
        } else {
            throw "Name is Incorrect!";
        }
    }

    // Salary
    get salary() {
        return this._salary;
    }

    set salary(salary) {
        this._salary = salary;
    }

    // Gender
    get gender() {
        return this._gender;
    }

    set gender(gender) {
        this._gender = gender;
    }

    // Department
    get department() {
        return this._department;
    }

    set department(department) {
        this._department = department;
    }

    // Notes
    get notes() {
        return this._notes;
    }

    set notes(notes) {
        this._notes = notes;
    }

    // Start Date
    get startDate() {
        return this._startDate;
    }

    set startDate(startDate) {

        let today = new Date();

        if (new Date(startDate) > today) {
            throw "Start Date cannot be a future date!";
        }

        this._startDate = startDate;
    }

    toString() {
        return `
Name       : ${this.name}
Salary     : ${this.salary}
Gender     : ${this.gender}
Department : ${this.department}
Notes      : ${this.notes}
Start Date : ${this.startDate}
`;
    }
}

// Event Listeners
window.addEventListener("DOMContentLoaded", () => {

    const salary = document.getElementById("salary");
    const salaryOutput = document.getElementById("salaryOutput");

    salaryOutput.textContent = salary.value;

    salary.addEventListener("input", () => {
        salaryOutput.textContent = salary.value;
    });

    // Live Name Validation
    document.getElementById("name")
        .addEventListener("input", () => {

            const name = document.getElementById("name").value;
            const error = document.getElementById("nameError");

            const regex = /^[A-Z][a-zA-Z]{2,}$/;

            error.textContent =
                regex.test(name)
                    ? ""
                    : "Name should start with Capital and have minimum 3 characters";
        });
});

// Save Employee
function saveEmployee() {

    try {

        let employeePayrollData =
            new EmployeePayrollData();

        employeePayrollData.name =
            document.getElementById("name").value;

        employeePayrollData.salary =
            document.getElementById("salary").value;

        employeePayrollData.gender =
            document.querySelector(
                'input[name="gender"]:checked'
            )?.value;

        employeePayrollData.department =
            [...document.querySelectorAll(
                'input[name="department"]:checked'
            )].map(dept => dept.value);

        employeePayrollData.notes =
            document.getElementById("notes").value;

        employeePayrollData.startDate =
            document.getElementById("startDate").value;

        console.log(employeePayrollData.toString());

        alert("Employee Payroll Object Created Successfully!");

    } catch (e) {

        if (e.includes("Name")) {
            document.getElementById("nameError")
                .textContent = e;
        }

        if (e.includes("Date")) {
            document.getElementById("dateError")
                .textContent = e;
        }
    }
}