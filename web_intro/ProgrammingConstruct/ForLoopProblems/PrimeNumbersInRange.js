// Program to print prime numbers in a given range

let start = 10;
let end = 50;

console.log("Prime Numbers between " + start + " and " + end + " are:");

for (let number = start; number <= end; number++) {

    let isPrime = true;

    // Numbers less than 2 are not prime
    if (number < 2) {
        isPrime = false;
    }
    else {

        // Check divisibility
        for (let i = 2; i < number; i++) {

            if (number % i === 0) {
                isPrime = false;
                break;
            }
        }
    }

    // Print prime number
    if (isPrime) {
        console.log(number);
    }
}