// Generate 10 random 3-digit numbers

let numbers = [];

for (let i = 0; i < 10; i++) {
    numbers.push(Math.floor(Math.random() * 900) + 100);
}

console.log("Array:", numbers);

// Initialize values
let largest = numbers[0];
let secondLargest = numbers[0];

let smallest = numbers[0];
let secondSmallest = numbers[0];

// Find largest and smallest
for (let i = 0; i < numbers.length; i++) {

    // Largest
    if (numbers[i] > largest) {
        secondLargest = largest;
        largest = numbers[i];
    }
    else if (numbers[i] > secondLargest && numbers[i] !== largest) {
        secondLargest = numbers[i];
    }

    // Smallest
    if (numbers[i] < smallest) {
        secondSmallest = smallest;
        smallest = numbers[i];
    }
    else if (numbers[i] < secondSmallest && numbers[i] !== smallest) {
        secondSmallest = numbers[i];
    }
}

console.log("Second Largest:", secondLargest);
console.log("Second Smallest:", secondSmallest);