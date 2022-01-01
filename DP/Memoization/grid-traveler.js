// Memoization
// Possible combination of m and n = m*n

// Memoization Solution
// Worst Case Time Complexity = O(n*m)  -- All the combination
// Space = O(n + m)
const gridTraveler_dp = (m, n, dp = {}) => {
    const key = m + ',' + n;
    if(key in dp) return dp[key];
    // Base Case
    if(m <= 0 || n <= 0) return 0;
    if(m === 1 && n === 1) return 1;
    // Main Logic -- Travel right or down
    return dp[key] = gridTraveler_dp(m - 1, n, dp) + gridTraveler_dp(m, n - 1, dp);
}

// Brute Force Solution 
// Time Complexity = O(2 ^ (n+m))
// Space = O(n + m)
const gridTraveler = (m, n) => {
    // Base Case
    if(m <= 0 || n <= 0) return 0;
    if(m === 1 && n === 1) return 1;
    // Main Logic -- Travel right or down
    return gridTraveler(m - 1, n) + gridTraveler(m, n - 1);
}

console.log(gridTraveler_dp(18, 18));