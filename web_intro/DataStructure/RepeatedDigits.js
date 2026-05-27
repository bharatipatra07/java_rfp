// Program to find repeated double digit numbers

let repeatedNumbers = [];

for (let i = 10; i < 100; i++) {

    let unit = i % 10;
    let tens = Math.floor(i / 10);

    if (unit === tens) {
        repeatedNumbers.push(i);
    }
}

console.log("Repeated Digit Numbers:", repeatedNumbers);