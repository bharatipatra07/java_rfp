// employeeServiceCallback.js
// Demonstrates an "AJAX"-style service using callbacks (callback-hell demonstration)

const employees = [
  { id: 1, name: 'Alice', role: 'Engineer' },
  { id: 2, name: 'Bob', role: 'Designer' },
  { id: 3, name: 'Charlie', role: 'Manager' }
];

function getEmployeeById(id, callback) {
  // simulate network delay
  setTimeout(() => {
    const emp = employees.find(e => e.id === id);
    if (!emp) return callback(new Error('Employee not found'));
    callback(null, emp);
  }, 500);
}

function getAllEmployees(callback) {
  setTimeout(() => callback(null, employees.slice()), 700);
}

// Example: nested callbacks to show complexity
console.log('Starting callback demo...');
getEmployeeById(1, (err, emp) => {
  if (err) return console.error('Error fetching employee 1:', err.message);
  console.log('Employee 1:', emp);

  // Next call depends on previous result
  getEmployeeById(2, (err2, emp2) => {
    if (err2) return console.error('Error fetching employee 2:', err2.message);
    console.log('Employee 2:', emp2);

    // Then fetch all
    getAllEmployees((err3, list) => {
      if (err3) return console.error('Error fetching all employees:', err3.message);
      console.log('All employees:', list);

      // Deeply nested callback example
      getEmployeeById(999, (err4, emp4) => {
        if (err4) console.error('Final call error (expected):', err4.message);
        console.log('Callback demo finished.');
      });
    });
  });
});
