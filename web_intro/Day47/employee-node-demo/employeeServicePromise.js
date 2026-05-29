// employeeServicePromise.js
// Demonstrates the same employee service using Promises and async/await

const employees = [
  { id: 1, name: 'Alice', role: 'Engineer' },
  { id: 2, name: 'Bob', role: 'Designer' },
  { id: 3, name: 'Charlie', role: 'Manager' }
];

function getEmployeeByIdPromise(id) {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      const emp = employees.find(e => e.id === id);
      if (!emp) return reject(new Error('Employee not found'));
      resolve(emp);
    }, 500);
  });
}

function getAllEmployeesPromise() {
  return new Promise(resolve => setTimeout(() => resolve(employees.slice()), 700));
}

// Promise chain example
console.log('Starting Promise chain demo...');
getEmployeeByIdPromise(1)
  .then(emp => {
    console.log('Employee 1:', emp);
    return getEmployeeByIdPromise(2);
  })
  .then(emp2 => {
    console.log('Employee 2:', emp2);
    return getAllEmployeesPromise();
  })
  .then(list => {
    console.log('All employees:', list);
  })
  .catch(err => console.error('Promise chain error:', err.message))
  .finally(() => console.log('Promise chain finished.'));

// async/await example
(async function runAsyncDemo() {
  try {
    console.log('\nStarting async/await demo...');
    const a = await getEmployeeByIdPromise(3);
    console.log('Employee 3:', a);
    const all = await getAllEmployeesPromise();
    console.log('All employees (async):', all);
  } catch (err) {
    console.error('Async demo error:', err.message);
  }
})();
