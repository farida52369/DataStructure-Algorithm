// Memoization
// JS object 
const fib_dp = (n, dp = {}) => {
    // If the value of n is calculated before, return it ...
    if (n in dp) return dp[n];
    if (n <= 2) return 1; // Base Case
    return dp[n] = fib_dp(n -1, dp) + fib_dp(n - 2, dp);  // The main logic of fib
}

const fib = (n) => {
    if (n <= 2) return 1;
    return fib(n -1) + fib(n - 2);
}

console.log(fib(40));
console.log(fib_dp(40));

