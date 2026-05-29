class EmployeePayroll {

    constructor() {
        this._name = "";
        this._salary = 0;
        this._gender = "";
        this._department = [];
        this._profilePic = "";
        this._notes = "";
    }

    // Name
    get name() {
        return this._name;
    }

    set name(name) {
        this._name = name;
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

    // Profile Picture
    get profilePic() {
        return this._profilePic;
    }

    set profilePic(profilePic) {
        this._profilePic = profilePic;
    }

    // Notes
    get notes() {
        return this._notes;
    }

    set notes(notes) {
        this._notes = notes;
    }

    toString() {
        return `
Name       : ${this.name}
Salary     : ${this.salary}
Gender     : ${this.gender}
Department : ${this.department.join(", ")}
ProfilePic : ${this.profilePic}
Notes      : ${this.notes}
`;
    }
}

function saveEmployee() {

    let employee = new EmployeePayroll();

    employee.name = document.getElementById("name").value;

    employee.salary =
        document.getElementById("salary").value;

    employee.gender =
        document.querySelector(
            'input[name="gender"]:checked'
        )?.value || "";

    let departments = [];

    document
        .querySelectorAll(".department:checked")
        .forEach(dept => departments.push(dept.value));

    employee.department = departments;

    employee.profilePic =
        document.getElementById("profilePic").value;

    employee.notes =
        document.getElementById("notes").value;

    document.getElementById("output").textContent =
        employee.toString();
}