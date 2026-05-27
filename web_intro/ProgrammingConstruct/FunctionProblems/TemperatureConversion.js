// Program for Temperature Conversion using Functions

function celsiusToFahrenheit(degC) {

    if (degC >= 0 && degC <= 100) {

        let degF = (degC * 9 / 5) + 32;
        console.log(degC + "°C = " + degF + "°F");

    } else {
        console.log("Temperature should be between 0°C and 100°C");
    }
}

function fahrenheitToCelsius(degF) {

    if (degF >= 32 && degF <= 212) {

        let degC = (degF - 32) * 5 / 9;
        console.log(degF + "°F = " + degC + "°C");

    } else {
        console.log("Temperature should be between 32°F and 212°F");
    }
}

// Choice
let choice = 1;
let temperature = 37;

switch (choice) {

    case 1:
        celsiusToFahrenheit(temperature);
        break;

    case 2:
        fahrenheitToCelsius(temperature);
        break;

    default:
        console.log("Invalid Choice");
}