const employees = [];

document
    .getElementById("employeeForm")
    .addEventListener("submit", addEmployee);

function addEmployee(event) {

    event.preventDefault();

    const name = document.getElementById("name").value;
    const salary = document.getElementById("salary").value;

    const employee = {
        name,
        salary
    };

    employees.push(employee);

    displayEmployees();

    document.getElementById("employeeForm").reset();
}

function displayEmployees() {

    const tableBody =
        document.getElementById("employeeTableBody");

    tableBody.innerHTML = "";

    employees.forEach(employee => {

        tableBody.innerHTML += `
            <tr>
                <td>${employee.name}</td>
                <td>${employee.salary}</td>
            </tr>
        `;
    });
}