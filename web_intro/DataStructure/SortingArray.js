// Generate 10 random 3-digit numbers

let numbers = [];

for (let i = 0; i < 10; i++) {
    numbers.push(Math.floor(Math.random() * 900) + 100);
}

console.log("Original Array:", numbers);

// Sort array
numbers.sort((a, b) => a - b);

console.log("Sorted Array:", numbers);

console.log("Second Smallest:", numbers[1]);
console.log("Second Largest:", numbers[numbers.length - 2]);