// payroll_form.js
// Payroll form utilities and JSON Server client-side validation

function isValidEmployeeName(name) {
    if (!name) {
        return false;
    }
    const trimmed = name.trim();
    return /^[A-Za-z][A-Za-z .'-]{2,}$/.test(trimmed);
}

function isValidStartDate(startDate) {
    if (!startDate) {
        return false;
    }
    const date = new Date(startDate);
    if (Number.isNaN(date.getTime())) {
        return false;
    }
    const today = new Date();
    today.setHours(0, 0, 0, 0);
    return date <= today;
}

function normalizeEmployeeRecord(employee) {
    if (!employee || typeof employee !== 'object') {
        return employee;
    }
    const normalized = { ...employee };
    if (!normalized.id && normalized._id) {
        normalized.id = normalized._id;
    }
    return normalized;
}

function buildEmployeeData() {
    const name = document.getElementById('empName').value.trim();
    const department = document.getElementById('empDept').value.trim();
    const salaryValue = document.getElementById('empSalary').value.trim();
    const designation = document.getElementById('empDesignation').value.trim();
    const startDate = document.getElementById('empStartDate').value.trim();

    const salary = salaryValue ? parseFloat(salaryValue) : null;

    return {
        name,
        department,
        salary,
        designation,
        startDate
    };
}

function clearPayrollForm() {
    document.getElementById('empName').value = '';
    document.getElementById('empDept').value = '';
    document.getElementById('empSalary').value = '';
    document.getElementById('empDesignation').value = '';
    document.getElementById('empStartDate').value = '';
}

function addEmployee() {
    const employeeData = buildEmployeeData();
    const { name, department, salary, designation, startDate } = employeeData;

    if (!isValidEmployeeName(name)) {
        displayMessage('postOutput', '❌ Please enter a valid employee name (at least 3 characters).', 'error');
        return;
    }

    if (!isValidStartDate(startDate)) {
        displayMessage('postOutput', '❌ Please enter a valid Start Date that is not in the future.', 'error');
        return;
    }

    if (!department || !salary || !designation) {
        displayMessage('postOutput', '❌ Please fill in all required fields.', 'error');
        return;
    }

    const employeePayload = {
        name,
        department,
        salary,
        designation,
        startDate
    };

    displayMessage('postOutput', '⏳ Adding employee...');

    httpServices.addEmployee(employeePayload)
        .then(newEmployee => {
            const normalized = normalizeEmployeeRecord(newEmployee);
            console.log('New Employee Added:', normalized);
            displayMessage('postOutput', `✅ Employee added successfully!\n\n${formatJSON(normalized)}`, 'success');
            clearPayrollForm();
        })
        .catch(error => {
            console.error('Error:', error);
            displayMessage('postOutput', `❌ Error: ${error.message}`, 'error');
        });
}
