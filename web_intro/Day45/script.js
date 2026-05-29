const employees = [
    {
        name: "Bharati Patra",
        gender: "Female",
        department: ["HR", "Finance"],
        salary: 50000,
        startDate: "29 Oct 2019",
        image: "https://randomuser.me/api/portraits/women/1.jpg"
    },
    {
        name: "Rahul Sharma",
        gender: "Male",
        department: ["Sales", "Engineer"],
        salary: 60000,
        startDate: "15 Jan 2020",
        image: "https://randomuser.me/api/portraits/men/2.jpg"
    },
    {
        name: "Ankit Verma",
        gender: "Male",
        department: ["HR"],
        salary: 45000,
        startDate: "10 Mar 2021",
        image: "https://randomuser.me/api/portraits/men/5.jpg"
    }
];

const table = document.getElementById("employeeTable");

employees.forEach(emp => {

    const row = document.createElement("tr");

    row.innerHTML = `
        <td>
            <div class="name-cell">
                <img class="profile"
                     src="${emp.image}">
                ${emp.name}
            </div>
        </td>

        <td>${emp.gender}</td>

        <td>
            ${emp.department.map(
                d => `<span class="department">${d}</span>`
            ).join("")}
        </td>

        <td>₹ ${emp.salary.toLocaleString()}</td>

        <td>${emp.startDate}</td>

        <td>
            <i class="fa-solid fa-trash action-icon"></i>
            <i class="fa-solid fa-pen action-icon"></i>
        </td>
    `;

    table.appendChild(row);
});