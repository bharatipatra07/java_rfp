// Program to find maximum and minimum value
// from given arithmetic operations

let a = 10;
let b = 5;
let c = 2;

// Arithmetic Operations
let result1 = a + b * c;
let result2 = a % b + c;
let result3 = c + a / b;
let result4 = a * b + c;

console.log("Result 1 (a + b * c) =", result1);
console.log("Result 2 (a % b + c) =", result2);
console.log("Result 3 (c + a / b) =", result3);
console.log("Result 4 (a * b + c) =", result4);

// Find Maximum
let max = result1;

if (result2 > max) {
    max = result2;
}
if (result3 > max) {
    max = result3;
}
if (result4 > max) {
    max = result4;
}

// Find Minimum
let min = result1;

if (result2 < min) {
    min = result2;
}
if (result3 < min) {
    min = result3;
}
if (result4 < min) {
    min = result4;
}

console.log("Maximum Value =", max);
console.log("Minimum Value =", min);