// Program to store birth months of 50 individuals

let birthMonthMap = new Map();

// Initialize months
for (let month = 1; month <= 12; month++) {
    birthMonthMap.set(month, []);
}

// Generate 50 individuals
for (let person = 1; person <= 50; person++) {

    // Random month between 1 and 12
    let month = Math.floor(Math.random() * 12) + 1;

    // Store person in that month
    birthMonthMap.get(month).push("Person" + person);
}

// Display result
for (let [month, persons] of birthMonthMap) {

    console.log("Month " + month + ":");

    console.log(persons);
}