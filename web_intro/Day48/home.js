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

function getDataSource() {
    const selected = document.querySelector('input[name="dataSource"]:checked');
    return selected ? selected.value : 'server';
}

function isServerMode() {
    return getDataSource() === 'server';
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

function retrieveEmployeePayrollFromServer() {
    return httpServices.getEmployees();
}

function getAllEmployeesFromLocalStorage() {
    const employees = [];
    for (let i = 0; i < localStorage.length; i++) {
        const key = localStorage.key(i);
        if (/employee|payroll/i.test(key)) {
            try {
                const value = localStorage.getItem(key);
                const parsed = JSON.parse(value);
                const normalized = normalizeEmployeeRecord(parsed);
                if (normalized && typeof normalized === 'object') {
                    if (!normalized.id && key.startsWith('employee_')) {
                        normalized.id = key.replace('employee_', '');
                    }
                    employees.push(normalized);
                }
            } catch (e) {
                console.warn(`Skipping invalid localStorage key: ${key}`);
            }
        }
    }
    return Promise.resolve(employees);
}

function getEmployeeByIdFromLocalStorage(id) {
    for (let i = 0; i < localStorage.length; i++) {
        const key = localStorage.key(i);
        if (/employee|payroll/i.test(key)) {
            try {
                const value = localStorage.getItem(key);
                const parsed = normalizeEmployeeRecord(JSON.parse(value));
                if (parsed && (String(parsed.id) === String(id) || String(parsed._id) === String(id))) {
                    return Promise.resolve(parsed);
                }
            } catch (e) {
                console.warn(`Skipping invalid localStorage key: ${key}`);
            }
        }
    }
    return Promise.reject(new Error('Employee not found in Local Storage'));
}

function deleteEmployeeFromLocalStorage(id) {
    for (let i = 0; i < localStorage.length; i++) {
        const key = localStorage.key(i);
        if (/employee|payroll/i.test(key)) {
            try {
                const value = localStorage.getItem(key);
                const parsed = normalizeEmployeeRecord(JSON.parse(value));
                if (parsed && (String(parsed.id) === String(id) || String(parsed._id) === String(id))) {
                    localStorage.removeItem(key);
                    return Promise.resolve({ success: true, removedKey: key });
                }
            } catch (e) {
                console.warn(`Skipping invalid localStorage key: ${key}`);
            }
        }
    }
    return Promise.reject(new Error('Employee not found in Local Storage'));
}

function onDataSourceChange() {
    if (isServerMode()) {
        clearEmployeeLocalStorage();
        console.log('JSON Server selected: local storage employee entries cleared.');
    } else {
        console.log('Local Storage selected: server operations will not be used for retrieval.');
    }
}

function getAllEmployees() {
    displayMessage('getAllOutput', '⏳ Loading...');

    const fetchOperation = isServerMode()
        ? retrieveEmployeePayrollFromServer()
        : getAllEmployeesFromLocalStorage();

    fetchOperation
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

    const fetchOperation = isServerMode()
        ? httpServices.getEmployeeById(id)
        : getEmployeeByIdFromLocalStorage(id);

    fetchOperation
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

    const deleteOperation = isServerMode()
        ? httpServices.deleteEmployee(id)
        : deleteEmployeeFromLocalStorage(id);

    deleteOperation
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
    if (isServerMode()) {
        clearEmployeeLocalStorage();
        console.log('Home initialized. Local storage employee entries cleared.');
    } else {
        console.log('Home initialized in Local Storage mode. Existing employee entries are available.');
    }

    document.querySelectorAll('input[name="dataSource"]').forEach(input => {
        input.addEventListener('change', onDataSourceChange);
    });
}

document.addEventListener('DOMContentLoaded', initializeHome);
