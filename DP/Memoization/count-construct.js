// m = target.length
// n = wordBank.length

// Memoization
// Time Complexity = O(n * m * m) = O(n * m^2)
// Space = O(m ^ 2)
const countConstruct_dp = (target, wordBank, dp = {}) => {
    if(target in dp) return dp[target];
    if(target === '') return 1;

    let totalCount = 0;
    for (let word of wordBank) {
        if(target.indexOf(word) === 0) {
            const suffix = target.slice(word.length);
            totalCount += countConstruct_dp(suffix, wordBank, dp);
        }
    }
    return dp[target] = totalCount;
}


// Brute Force Solution
// Time Complexity = O(n^m * m) -- Slice which copy the string
// Space = O(m ^ 2) -- Slice and call recursion
const countConstruct = (target, wordBank) => {
    if(target === '') return 1;

    let totalCount = 0;
    for (let word of wordBank) {
        if(target.indexOf(word) === 0) {
            const suffix = target.slice(word.length);
            totalCount += countConstruct(suffix, wordBank);
        }
    }
    return totalCount;
}

console.log(countConstruct('abcdef', ['abc', 'bc', 'a', 'cdef', 'de', 'f']));
console.log(countConstruct_dp('eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef', [
    'e',
    'ee',
    'eeee',
    'eeeeee',
    'eeeeeeee',
    'eeeeeeeeee'
]));