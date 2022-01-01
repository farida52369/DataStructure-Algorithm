// DECISION PROBLEM

// Memoization
// Time Complexity = O(n * m)
// Space = O(m)
const canSum_dp = (targetSum, arr, dp = {}) => {
    if(targetSum in dp) return dp[targetSum];
    if(targetSum === 0) return true;
    if(targetSum < 0) return false;

    for(let num of arr) {
        // console.log(targetSum - num);
        const temp = targetSum - num;
        if (dp[temp] = canSum_dp(temp, arr, dp)) {
            return true;
        }
    }
    return dp[targetSum] = false;
}

// Time Complexity = O(n ^ m) 
// As the height of the tree is m (m is the target sum)
// and we try each num in the array which is n (n is the size of the array)
// Space = O(m)
const canSum = (targetSum, arr) => {
    if (targetSum === 0) return true;
    if(targetSum < 0) return false;

    for(let num of arr) {
        // console.log(targetSum - num);
        if (canSum(targetSum - num, arr)) {
            return true;
        }
    }
    return false;
}

console.log(canSum_dp(300, [7, 14]));