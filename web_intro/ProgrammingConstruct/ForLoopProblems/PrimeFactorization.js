// Program to find prime factors of a number

let number = 84;

console.log("Prime Factors of " + number + " are:");

for (let i = 2; i * i <= number; i++) {

    // Print factor multiple times if divisible
    while (number % i === 0) {
        console.log(i);
        number = number / i;
    }
}

// If number is still greater than 1
// then it is a prime factor
if (number > 1) {
    console.log(number);
}