// Base Case When the input String becomes (one letter or empty String)
const reverseString_1 = (input) => {
    if (input.length === 0 || input.length === 1) return input;
    return input[input.length - 1] + reverseString_1(input.slice(0, input.length - 1));
}

const reverseString_2 = (input) => {
    if (input.length === 0 || input.length === 1) return input;
    return reverseString_2(input.slice(1)) + input[0];
}

console.log(reverseString_1("fareeda ragab"));
console.log(reverseString_2("fareeda ragab"));
console.log(reverseString_1(''));