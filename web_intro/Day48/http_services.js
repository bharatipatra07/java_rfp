// HTTP Services for Employee Payroll using Promise
// UC1 - REST Services with JSON Server
//Install JSON Server: npm install -g json-server
//Run from Day48 folder: json-server --watch db.json

class HttpServices {
    constructor(baseURL = 'http://localhost:3000') {
        this.baseURL = baseURL;
    }

    /**
     * GET - Fetch all employees
     */
    getEmployees() {
        return fetch(`${this.baseURL}/employees`)
            .then(response => {
                if (!response.ok) {
                    throw new Error(`HTTP error! status: ${response.status}`);
                }
                return response.json();
            })
            .catch(error => {
                console.error('Error fetching employees:', error);
                throw error;
            });
    }

    /**
     * GET - Fetch employee by ID
     */
    getEmployeeById(id) {
        return fetch(`${this.baseURL}/employees/${id}`)
            .then(response => {
                if (!response.ok) {
                    throw new Error(`HTTP error! status: ${response.status}`);
                }
                return response.json();
            })
            .catch(error => {
                console.error(`Error fetching employee ${id}:`, error);
                throw error;
            });
    }

    /**
     * POST - Add new employee
     */
    addEmployee(employeeData) {
        return fetch(`${this.baseURL}/employees`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(employeeData)
        })
            .then(response => {
                if (!response.ok) {
                    throw new Error(`HTTP error! status: ${response.status}`);
                }
                return response.json();
            })
            .catch(error => {
                console.error('Error adding employee:', error);
                throw error;
            });
    }

    /**
     * DELETE - Delete employee by ID
     */
    deleteEmployee(id) {
        return fetch(`${this.baseURL}/employees/${id}`, {
            method: 'DELETE',
            headers: {
                'Content-Type': 'application/json',
            }
        })
            .then(response => {
                if (!response.ok) {
                    throw new Error(`HTTP error! status: ${response.status}`);
                }
                return response.json();
            })
            .catch(error => {
                console.error(`Error deleting employee ${id}:`, error);
                throw error;
            });
    }

    /**
     * PUT - Update employee by ID
     */
    updateEmployee(id, employeeData) {
        return fetch(`${this.baseURL}/employees/${id}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(employeeData)
        })
            .then(response => {
                if (!response.ok) {
                    throw new Error(`HTTP error! status: ${response.status}`);
                }
                return response.json();
            })
            .catch(error => {
                console.error(`Error updating employee ${id}:`, error);
                throw error;
            });
    }
}

// Export for use in HTML
const httpServices = new HttpServices();
