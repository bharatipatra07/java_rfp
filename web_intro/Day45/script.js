
let employees = [];

// Load Employees

document.addEventListener("DOMContentLoaded", () => {
    const storedEmployees = JSON.parse(localStorage.getItem("employees"));

    if (Array.isArray(storedEmployees) && storedEmployees.length > 0) {
        employees = storedEmployees;
    } else {
        employees = [
            {
                _name: "Bharati Patra",
                _gender: "Female",
                _department: ["HR", "Finance"],
                _salary: "₹50,000",
                _startDate: "29 May 2026"
            },
            {
                _name: "Rahul Sharma",
                _gender: "Male",
                _department: ["Sales"],
                _salary: "₹45,000",
                _startDate: "20 May 2026"
            }
        ];
        localStorage.setItem("employees", JSON.stringify(employees));
    }

    displayEmployees();
});


// Display Employees

function displayEmployees() {
    const tableBody = document.getElementById("employeeTableBody");
    let rows = "";

    for (let index = 0; index < employees.length; index++) {
        const emp = employees[index];
        const name = emp._name || emp.name || "";
        const gender = emp._gender || emp.gender || "";
        const department = emp._department || emp.department || [];
        const salary = emp._salary || emp.salary || "";
        const startDate = emp._startDate || emp.startDate || "";

        const deptHtml = department
            .map((dept) => `<span class="department-item">${dept}</span>`)
            .join("");

        rows += `
            <tr>
                <td>${name}</td>
                <td>${gender}</td>
                <td>${deptHtml}</td>
                <td>${salary}</td>
                <td>${startDate}</td>
                <td>
                    <div class="action-icons">
                        <i class="fa-solid fa-trash" onclick="deleteEmployee(${index})"></i>
                        <i class="fa-solid fa-pen"></i>
                    </div>
                </td>
            </tr>
        `;
    }

    tableBody.innerHTML = rows;

    // Update Count
    document.querySelector(".count-badge").innerText = employees.length;
}


// Delete Employee

function deleteEmployee(index) {

    employees.splice(index, 1);

    localStorage.setItem(
        "employees",
        JSON.stringify(employees)
    );

    displayEmployees();
}


// Add User Page Redirect

function addUser() {

    window.location.href = "add-employee.html";
}