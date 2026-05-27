// Program to display place value using switch case

let number = 100;

switch (number) {
    case 1:
        console.log("Unit");
        break;

    case 10:
        console.log("Ten");
        break;

    case 100:
        console.log("Hundred");
        break;

    case 1000:
        console.log("Thousand");
        break;

    case 10000:
        console.log("Ten Thousand");
        break;

    case 100000:
        console.log("Lakh");
        break;

    case 1000000:
        console.log("Ten Lakh");
        break;

    default:
        console.log("Please enter valid values like 1, 10, 100, 1000...");
}