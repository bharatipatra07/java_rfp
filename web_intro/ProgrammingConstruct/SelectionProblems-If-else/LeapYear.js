// Program to check whether a year is a Leap Year or not

let year = 2024;

// Check if it is a 4-digit year
if (year >= 1000 && year <= 9999) {

    // Leap year condition
    if ((year % 4 === 0 && year % 100 !== 0) || (year % 400 === 0)) {
        console.log(year + " is a Leap Year");
    } else {
        console.log(year + " is NOT a Leap Year");
    }

} else {
    console.log("Please enter a valid 4-digit year");
}