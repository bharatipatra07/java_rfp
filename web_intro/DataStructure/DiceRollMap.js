// Program to roll dice and store results in a Map

let diceMap = new Map();

// Initialize count for numbers 1 to 6
for (let i = 1; i <= 6; i++) {
    diceMap.set(i, 0);
}

let maxReached = false;

while (!maxReached) {

    // Roll dice
    let dice = Math.floor(Math.random() * 6) + 1;

    // Update count
    diceMap.set(dice, diceMap.get(dice) + 1);

    // Check if any number reached 10 times
    if (diceMap.get(dice) === 10) {
        maxReached = true;
    }
}

console.log("Dice Roll Counts:");
console.log(diceMap);

// Find maximum and minimum
let maxNumber = 1;
let minNumber = 1;

for (let [key, value] of diceMap) {

    if (value > diceMap.get(maxNumber)) {
        maxNumber = key;
    }

    if (value < diceMap.get(minNumber)) {
        minNumber = key;
    }
}

console.log("Maximum times appeared:", maxNumber);
console.log("Minimum times appeared:", minNumber);