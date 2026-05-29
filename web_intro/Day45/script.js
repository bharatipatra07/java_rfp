// Sample Employee Data

const employees = [
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

// Load Employees
window.onload = function () {

    const tableBody =
        document.getElementById("employeeTableBody");

    employees.forEach(emp => {

        tableBody.innerHTML += `
            <tr>
                <td>${emp.name}</td>

                <td>${emp.gender}</td>

                <td>${emp.department.join(", ")}</td>

                <td>${emp.salary}</td>

                <td>${emp.startDate}</td>

                <td>
                    <div class="action-icons">
                        <i class="fa-solid fa-trash"></i>
                        <i class="fa-solid fa-pen"></i>
                    </div>
                </td>
            </tr>
        `;
    });
};

// Add User Function
function addUser() {

    // Redirect to Add Employee Page
    window.location.href = "add-employee.html";

}