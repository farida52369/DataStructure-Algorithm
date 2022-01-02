
const sumNumbers = (input) => {
    if(input == 1) return 1;
    return input + sumNumbers(input - 1);
}

console.log(sumNumbers(5));
console.log(sumNumbers(100));
console.log(sumNumbers(10000));