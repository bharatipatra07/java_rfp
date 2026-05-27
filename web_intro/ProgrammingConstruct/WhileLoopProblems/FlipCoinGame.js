// Program to flip coin until Heads or Tails wins 11 times

let heads = 0;
let tails = 0;

while (heads < 11 && tails < 11) {

    let coin = Math.floor(Math.random() * 2);

    if (coin === 0) {
        heads++;
        console.log("Heads");
    }
    else {
        tails++;
        console.log("Tails");
    }
}

console.log("Heads Count:", heads);
console.log("Tails Count:", tails);

if (heads === 11) {
    console.log("Heads Wins!");
}
else {
    console.log("Tails Wins!");
}