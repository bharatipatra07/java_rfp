// Program to check whether a number is prime or not

let number = 17;
let isPrime = true;

if (number <= 1) {
    isPrime = false;
}
else {
    for (let i = 2; i < number; i++) {

        if (number % i === 0) {
            isPrime = false;
            break;
        }
    }
}

// Display Result
if (isPrime) {
    console.log(number + " is a Prime Number");
}
else {
    console.log(number + " is NOT a Prime Number");
}