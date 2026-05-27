// Program to find factorial of a number

let number = 5;
let factorial = 1;

for (let i = 1; i <= number; i++) {
    factorial = factorial * i;
}

console.log(number + "! = " + factorial);