// COMBINATORIC PROBLEM

//  (m) -- target sum, (n)  -- arr.length

// Memoization
// Time Complexity = O(n * m * m) = O(n * m^2)  
// Space = O((m + m) * m) = O(2m^2) = O(m^2)
// Space increased because of the dp array which has at most m elements.
const howSum_dp = (targetSum, arr, dp = {}) => {
    if(targetSum in dp) return dp[targetSum];
    if(targetSum === 0) return [];
    if (targetSum < 0) return null;

    for(let num of arr) {
        const res = howSum_dp(targetSum - num, arr, dp);
        if(res !== null) {
            return dp[targetSum] = [...res, num]; // copying repeated m times
        }
    }
    return dp[targetSum] = null;
}

// Time Complexity = O(n ^ m * m)  
// Multiply by m because of the array copy.
// Space = O(m + m) = O(m)
const howSum = (targetSum, arr) => {
    if(targetSum === 0) return [];
    if (targetSum < 0) return null;

    for(let num of arr) {
        const res = howSum(targetSum - num, arr);
        // console.log(res);
        if(res !== null) {
            return [...res, num]; // return the result and add num to it..
        }
    }
    return null;
}

console.log(howSum(7, [3, 2, 6, 8])); // [2, 2, 3]
console.log(howSum_dp(300, [7, 14]));  // null
console.log(howSum(300, [7, 4])); // [4 and 7 ... to reach 300]