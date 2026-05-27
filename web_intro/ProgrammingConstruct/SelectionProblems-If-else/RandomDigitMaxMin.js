// Read 5 random 3-digit values and find minimum and maximum

let numbers = [];

for (let i = 0; i < 5; i++) {
    // Generate random 3-digit number (100 to 999)
    let randomNum = Math.floor(Math.random() * 900) + 100;
    numbers.push(randomNum);
}

console.log("Random Numbers:", numbers);

// Find minimum and maximum
let min = Math.min(...numbers);
let max = Math.max(...numbers);

console.log("Minimum Value:", min);
console.log("Maximum Value:", max);