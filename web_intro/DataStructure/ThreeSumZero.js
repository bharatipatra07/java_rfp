// Program to find three integers whose sum is zero

let numbers = [0, -1, 2, -3, 1];

for (let i = 0; i < numbers.length - 2; i++) {

    for (let j = i + 1; j < numbers.length - 1; j++) {

        for (let k = j + 1; k < numbers.length; k++) {

            if (numbers[i] + numbers[j] + numbers[k] === 0) {

                console.log(
                    numbers[i],
                    numbers[j],
                    numbers[k]
                );
            }
        }
    }
}