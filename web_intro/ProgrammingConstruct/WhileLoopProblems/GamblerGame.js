// Gambler starts with Rs 100
// Goal is Rs 200

let money = 100;
let goal = 200;

let bets = 0;
let wins = 0;

while (money > 0 && money < goal) {

    let gamble = Math.floor(Math.random() * 2);

    bets++;

    // Win
    if (gamble === 1) {
        money++;
        wins++;
    }
    // Lose
    else {
        money--;
    }
}

console.log("Final Money:", money);
console.log("Total Bets Made:", bets);
console.log("Total Wins:", wins);

if (money === goal) {
    console.log("Gambler Reached Goal!");
}
else {
    console.log("Gambler Went Broke!");
}