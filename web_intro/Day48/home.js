// home.js
// Client-side logic for Employee Payroll REST service operations

function displayMessage(elementId, message, type = 'info') {
    const output = document.getElementById(elementId);
    if (!output) return;
    output.style.display = 'block';
    const result = document.getElementById(elementId.replace('Output', 'Result'));
    if (result) {
        result.textContent = message;
    }
}

function formatJSON(data) {
    return JSON.stringify(data, null, 2);
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

function clearEmployeeLocalStorage() {
    const keysToRemove = [];
    for (let i = 0; i < localStorage.length; i++) {
        const key = localStorage.key(i);
        if (/employee|payroll/i.test(key)) {
            keysToRemove.push(key);
        }
    }
    keysToRemove.forEach(key => {
        localStorage.removeItem(key);
        console.log(`Removed local storage key: ${key}`);
    });
}

function getAllEmployees() {
    displayMessage('getAllOutput', '⏳ Loading...');

    httpServices.getEmployees()
        .then(employees => {
            const normalized = Array.isArray(employees)
                ? employees.map(normalizeEmployeeRecord)
                : [normalizeEmployeeRecord(employees)];
            console.log('All Employees:', normalized);
            displayMessage('getAllOutput', formatJSON(normalized), 'success');
        })
        .catch(error => {
            console.error('Error:', error);
            displayMessage('getAllOutput', `❌ Error: ${error.message}`, 'error');
        });
}

function getEmployeeById() {
    const id = document.getElementById('getEmployeeId').value.trim();
    if (!id) {
        displayMessage('getByIdOutput', '❌ Please enter an Employee ID', 'error');
        return;
    }

    displayMessage('getByIdOutput', '⏳ Loading...');

    httpServices.getEmployeeById(id)
        .then(employee => {
            const normalized = normalizeEmployeeRecord(employee);
            console.log('Employee:', normalized);
            displayMessage('getByIdOutput', formatJSON(normalized), 'success');
        })
        .catch(error => {
            console.error('Error:', error);
            displayMessage('getByIdOutput', `❌ Error: ${error.message}`, 'error');
        });
}

function deleteEmployee() {
    const id = document.getElementById('deleteEmployeeId').value.trim();
    if (!id) {
        displayMessage('deleteOutput', '❌ Please enter an Employee ID', 'error');
        return;
    }

    if (!confirm(`Are you sure you want to delete employee with ID ${id}?`)) {
        return;
    }

    displayMessage('deleteOutput', '⏳ Deleting employee...');

    httpServices.deleteEmployee(id)
        .then(response => {
            console.log('Employee Deleted:', response);
            displayMessage('deleteOutput', `✅ Employee with ID ${id} deleted successfully!`, 'success');
            document.getElementById('deleteEmployeeId').value = '';
        })
        .catch(error => {
            console.error('Error:', error);
            displayMessage('deleteOutput', `❌ Error: ${error.message}`, 'error');
        });
}

function initializeHome() {
    clearEmployeeLocalStorage();
    console.log('Home initialized. Local storage employee entries cleared.');
}

document.addEventListener('DOMContentLoaded', initializeHome);
