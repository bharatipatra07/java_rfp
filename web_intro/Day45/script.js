
let employees =
    JSON.parse(localStorage.getItem("employees"));


// If localStorage empty then add default data

if (!employees) {

    employees = [

        {
            name: "Bharati Patra",
            gender: "Female",
            department: ["HR", "Finance"],
            salary: "₹50,000",
            startDate: "29 May 2026"
        },

        {
            name: "Rahul Sharma",
            gender: "Male",
            department: ["Sales"],
            salary: "₹45,000",
            startDate: "20 May 2026"
        }
    ];

    localStorage.setItem(
        "employees",
        JSON.stringify(employees)
    );
}


// Load Employees

document.addEventListener("DOMContentLoaded", () => {
    displayEmployees();
});


// Display Employees

function displayEmployees() {
    const tableBody = document.getElementById("employeeTableBody");
    let rows = "";

    for (let index = 0; index < employees.length; index++) {
        const emp = employees[index];
        const deptHtml = emp.department
            .map((dept) => `<span class="department-item">${dept}</span>`)
            .join("");

        rows += `
            <tr>
                <td>${emp.name}</td>
                <td>${emp.gender}</td>
                <td>${deptHtml}</td>
                <td>${emp.salary}</td>
                <td>${emp.startDate}</td>
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