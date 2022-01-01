// OPTIMIZATION PROBLEM

// Memoization
// Time Complexity: O(n * m * m) = O(n * m^2)
// Space: O(m^2) -- ShortestPath takes Space in the worst case (m)
const bestSum_dp = (targetSum, arr, dp = {}) => {
    if (targetSum in dp) return dp[targetSum];
    if (targetSum === 0) return [];
    if (targetSum < 0) return null;

    let shortestPath = null;
    for(let num of arr) {
        const remainder = targetSum - num;
        const res = bestSum_dp(remainder, arr, dp);
        if(res !== null) {
            const combination = [...res, num];
            if(shortestPath === null || shortestPath.length > combination.length) {
                shortestPath = combination;
            }
        }
    }
    return dp[targetSum] = shortestPath;
}

// Brute Force
// Time Complexity: O(n ^ m * m)
// Space: O(m^2) -- ShortestPath takes Space in the worst case (m)
const bestSum = (targetSum, arr) => {
    if (targetSum === 0) return [];
    if (targetSum < 0) return null;

    let shortestPath = null;
    for(let num of arr) {
        const remainder = targetSum - num;
        const res = bestSum(remainder, arr);
        if(res !== null) {
            const combination = [...res, num];
            if(shortestPath === null || shortestPath.length > combination.length) {
                shortestPath = combination;
            }

        }
    }
    return shortestPath;
}

console.log(bestSum_dp(7, [2, 3, 2, 3]));
console.log(bestSum_dp(100, [1, 2, 5, 25]));
console.log(bestSum_dp(0, [1, 2, 5, 25]));