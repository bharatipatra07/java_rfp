// Program for Unit Conversion

let choice = 2;
let value = 10;

switch (choice) {

    // Feet to Inch
    case 1:
        console.log(value + " Feet = " + (value * 12) + " Inch");
        break;

    // Feet to Meter
    case 2:
        console.log(value + " Feet = " + (value * 0.3048) + " Meter");
        break;

    // Inch to Feet
    case 3:
        console.log(value + " Inch = " + (value / 12) + " Feet");
        break;

    // Meter to Feet
    case 4:
        console.log(value + " Meter = " + (value * 3.28084) + " Feet");
        break;

    default:
        console.log("Please enter a valid choice between 1 and 4");
}