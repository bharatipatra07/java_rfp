// Employee Management System
class EmployeePayrollApp {
    constructor() {
        this.employees = this.loadFromLocalStorage();
        this.currentEditId = null;
        this.initializeEventListeners();
        this.displayEmployees();
    }

    // Load employees from localStorage
    loadFromLocalStorage() {
        const data = localStorage.getItem('employees');
        if (!data) return [];
        
        const employees = JSON.parse(data);
        // Ensure numeric values are properly converted
        return employees.map(emp => ({
            ...emp,
            baseSalary: Number(emp.baseSalary) || 0,
            deductions: Number(emp.deductions) || 0,
            bonus: Number(emp.bonus) || 0,
            netSalary: Number(emp.netSalary) || 0
        }));
    }

    // Save employees to localStorage
    saveToLocalStorage() {
        localStorage.setItem('employees', JSON.stringify(this.employees));
    }

    // Initialize Event Listeners
    initializeEventListeners() {
        // Form submission
        document.getElementById('employeeForm').addEventListener('submit', (e) => {
            e.preventDefault();
            this.addEmployee();
        });

        // Search functionality
        document.getElementById('searchInput').addEventListener('input', (e) => {
            this.searchEmployees(e.target.value);
        });

        // Modal controls
        const modal = document.getElementById('editModal');
        const closeBtn = document.querySelector('.close');
        const cancelBtn = document.getElementById('cancelBtn');

        closeBtn.addEventListener('click', () => {
            modal.style.display = 'none';
        });

        cancelBtn.addEventListener('click', () => {
            modal.style.display = 'none';
        });

        window.addEventListener('click', (e) => {
            if (e.target === modal) {
                modal.style.display = 'none';
            }
        });

        // Edit form submission
        document.getElementById('editForm').addEventListener('submit', (e) => {
            e.preventDefault();
            this.updateEmployee();
        });
    }

    // Generate unique ID
    generateId() {
        return '_' + Math.random().toString(36).substr(2, 9);
    }

    // Add Employee (CREATE)
    addEmployee() {
        const name = document.getElementById('empName').value.trim();
        const empId = document.getElementById('empId').value.trim();
        const department = document.getElementById('department').value.trim();
        const baseSalary = parseFloat(document.getElementById('baseSalary').value);
        const deductions = parseFloat(document.getElementById('deductions').value) || 0;
        const bonus = parseFloat(document.getElementById('bonus').value) || 0;
        const joiningDate = document.getElementById('joiningDate').value;

        // Validate
        if (!name || !empId || !department || !baseSalary || !joiningDate) {
            alert('Please fill all required fields!');
            return;
        }

        // Check if employee ID already exists
        if (this.employees.some(emp => emp.empId === empId)) {
            alert('Employee ID already exists!');
            return;
        }

        // Create employee object
        const employee = {
            id: this.generateId(),
            name,
            empId,
            department,
            baseSalary,
            deductions,
            bonus,
            joiningDate,
            netSalary: baseSalary - deductions + bonus
        };

        this.employees.push(employee);
        this.saveToLocalStorage();
        this.displayEmployees();
        document.getElementById('employeeForm').reset();
        alert('Employee added successfully!');
    }

    // Read and Display Employees (READ)
    displayEmployees(employeesToDisplay = null) {
        const container = document.getElementById('employeeContainer');
        const data = employeesToDisplay || this.employees;

        if (data.length === 0) {
            container.innerHTML = '<p class="no-data">No employees found.</p>';
            return;
        }

        container.innerHTML = data.map(emp => `
            <div class="employee-card">
                <div class="employee-info">
                    <div class="info-item">
                        <span class="info-label">Name:</span>
                        <span class="info-value">${emp.name}</span>
                    </div>
                    <div class="info-item">
                        <span class="info-label">Employee ID:</span>
                        <span class="info-value">${emp.empId}</span>
                    </div>
                    <div class="info-item">
                        <span class="info-label">Base Salary:</span>
                        <span class="info-value">₹${(Number(emp.baseSalary) || 0).toFixed(2)}</span>
                    </div>
                    <div class="info-item">
                        <span class="info-label">Joining Date:</span>
                        <span class="info-value">${new Date(emp.joiningDate).toLocaleDateString()}</span>
                    </div>
                </div>
                <div class="salary-info">
                    <p><span class="info-label">Base Salary:</span> ₹${emp.baseSalary.toFixed(2)}</p>
                    <p><span class="info-label">Deductions:</span> ₹${emp.deductions.toFixed(2)}</p>
                    <p><span class="info-label">Bonus:</span> ₹${emp.bonus.toFixed(2)}</p>
                    <p class="net-salary"><span class="info-label">Net Salary:</span> ₹${emp.netSalary.toFixed(2)}</p>
                </div>
                <div class="card-actions">
                    <button class="edit-btn" onclick="app.openEditModal('${emp.id}')">Edit</button>
                    <button class="delete-btn" onclick="app.deleteEmployee('${emp.id}')">Delete</button>
                </div>
                
            </div>
                
        `).join('');
    }
                

    // Update Employee (UPDATE)
    openEditModal(id) {
        const employee = this.employees.find(emp => emp.id === id);
        if (!employee) return;

        this.currentEditId = id;

        // Populate modal form
        document.getElementById('editName').value = employee.name;
        document.getElementById('editDepartment').value = employee.department;
        document.getElementById('editBaseSalary').value = employee.baseSalary;
        document.getElementById('editDeductions').value = employee.deductions;
        document.getElementById('editBonus').value = employee.bonus;
        document.getElementById('editJoiningDate').value = employee.joiningDate;

        // Show modal
        document.getElementById('editModal').style.display = 'block';
    }

    updateEmployee() {
        const employee = this.employees.find(emp => emp.id === this.currentEditId);
        if (!employee) return;

        employee.name = document.getElementById('editName').value.trim();
        employee.department = document.getElementById('editDepartment').value.trim();
        employee.baseSalary = parseFloat(document.getElementById('editBaseSalary').value);
        employee.deductions = parseFloat(document.getElementById('editDeductions').value) || 0;
        employee.bonus = parseFloat(document.getElementById('editBonus').value) || 0;
        employee.joiningDate = document.getElementById('editJoiningDate').value;
        employee.netSalary = employee.baseSalary - employee.deductions + employee.bonus;

        this.saveToLocalStorage();
        this.displayEmployees();
        document.getElementById('editModal').style.display = 'none';
        alert('Employee updated successfully!');
    }

    // Delete Employee (DELETE)
    deleteEmployee(id) {
        if (confirm('Are you sure you want to delete this employee?')) {
            this.employees = this.employees.filter(emp => emp.id !== id);
            this.saveToLocalStorage();
            this.displayEmployees();
            alert('Employee deleted successfully!');
        }
    }

    // Search Employees
    searchEmployees(query) {
        if (!query.trim()) {
            this.displayEmployees();
            return;
        }

        const filtered = this.employees.filter(emp =>
            emp.name.toLowerCase().includes(query.toLowerCase()) ||
            emp.empId.toLowerCase().includes(query.toLowerCase())
        );

        this.displayEmployees(filtered);
    }
}

// Initialize app when DOM is loaded
let app;
document.addEventListener('DOMContentLoaded', () => {
    app = new EmployeePayrollApp();
});
