
const decimalToBinary = (input, result = '') => {
    // Base Case the input=0
    if(input == 0) return result;
    result = input % 2 + result;
    // console.log("RESULT: " + result)
    return decimalToBinary(parseInt(input / 2), result);
}

console.log(decimalToBinary(5));
console.log(decimalToBinary(100));
console.log(decimalToBinary(34567));