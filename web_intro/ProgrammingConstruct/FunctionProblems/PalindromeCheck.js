// Program to check palindrome number

function isPalindrome(number) {

    let original = number;
    let reverse = 0;

    while (number > 0) {

        let digit = number % 10;
        reverse = reverse * 10 + digit;
        number = Math.floor(number / 10);
    }

    if (original === reverse) {
        console.log(original + " is a Palindrome");
    } else {
        console.log(original + " is NOT a Palindrome");
    }
}

isPalindrome(121);