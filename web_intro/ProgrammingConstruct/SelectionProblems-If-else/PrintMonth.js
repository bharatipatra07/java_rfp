// Take month and day from command line
let month = process.argv[2];
let day = parseInt(process.argv[3]);

let result = false;

// Check condition
if (
    (month === "March" && day >= 20) ||
    (month === "April") ||
    (month === "May") ||
    (month === "June" && day <= 20)
) {
    result = true;
}

console.log(result);