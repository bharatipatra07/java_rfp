// Program to store prime factors in array

let number = 84;
let factors = [];

for (let i = 2; i * i <= number; i++) {

    while (number % i === 0) {
        factors.push(i);
        number = number / i;
    }
}

if (number > 1) {
    factors.push(number);
}

console.log("Prime Factors Array:", factors);