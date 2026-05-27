// Function to check prime number

function isPrime(number) {

    if (number <= 1) {
        return false;
    }

    for (let i = 2; i * i <= number; i++) {

        if (number % i === 0) {
            return false;
        }
    }

    return true;
}

// Function to get palindrome

function getPalindrome(number) {

    let reverse = 0;

    while (number > 0) {

        let digit = number % 10;
        reverse = reverse * 10 + digit;
        number = Math.floor(number / 10);
    }

    return reverse;
}

// Main Program

let number = 131;

if (isPrime(number)) {

    console.log(number + " is a Prime Number");

    let palindrome = getPalindrome(number);

    console.log("Palindrome is:", palindrome);

    if (isPrime(palindrome)) {
        console.log(palindrome + " is also a Prime Number");
    }
    else {
        console.log(palindrome + " is NOT a Prime Number");
    }

} else {
    console.log(number + " is NOT a Prime Number");
}