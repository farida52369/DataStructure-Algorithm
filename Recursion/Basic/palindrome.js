// n (the length of the input)

// Time Complexity: O(n^2)
// (n/2) for recursion calls and slice copy the string input which takes n
// So Time Complexity: O(n * n/2)=O(n^2)
const isPalindrome_1 = (input) => {
    if(input.length === 0 || input.length === 1) return true;
    if(input[0] === input[input.length - 1]) return isPalindrome_1(input.slice(1, input.length - 1));
    return false;
}

// Time Complexity: O(n) 
const isPalindrome_2 = (input, start, end) => {
    if(start === end) return true;
    if(input[start] !== input[end]) return false;
    if(end + 1 > start) return isPalindrome_2(input, start + 1, end - 1);
    return true;
}

console.log(isPalindrome_1("fareeda"));
console.log(isPalindrome_1("akldlka"));

console.log(isPalindrome_2("fareeda", 0, 6));
console.log(isPalindrome_2("akldlka", 0, 6));