// Program to find the magic number using binary search logic

let low = 1;
let high = 100;
let magicNumber = 73; // Assume user thought of 73

while (low <= high) {

    let mid = Math.floor((low + high) / 2);

    console.log("Checking:", mid);

    if (mid === magicNumber) {
        console.log("Magic Number Found:", mid);
        break;
    }
    else if (magicNumber > mid) {
        low = mid + 1;
    }
    else {
        high = mid - 1;
    }
}