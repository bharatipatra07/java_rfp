// Program to find prime factors using while loop

let number = 84;
let i = 2;

console.log("Prime Factors of 84 are:");

while (i * i <= number) {

    if (number % i === 0) {
        console.log(i);
        number = number / i;
    } else {
        i++;
    }
}

// If number becomes greater than 1
if (number > 1) {
    console.log(number);
}