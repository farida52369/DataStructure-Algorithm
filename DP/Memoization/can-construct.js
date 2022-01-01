// m = target.length
// n = wordBank.length

// Memoization
// Time Complexity = O(n * m * m) = O(n * m^2)
// Space = O(m ^ 2)
const canConstruct_dp = (target, wordBank, dp = {}) => {
    if(target in dp) return dp[target];
    if(target === '') return true;

    for(let word of wordBank) {
        // If the word is postfix 
        if(target.indexOf(word) === 0) {
            // Dealing with the Suffix
            const suffix = target.slice(word.length);
            if (canConstruct_dp(suffix, wordBank, dp)) {
                return dp[suffix] = true; 
            }
        }
    }
    return dp[target] = false;
}


// Brute Force Solution
// Time Complexity = O(n^m * m) -- Slice which copy the string
// Space = O(m ^ 2) -- Slice and call recursion
const canConstruct = (target, wordBank) => {
    if(target === '') return true;

    for(let word of wordBank) {
        // If the word is postfix 
        if(target.indexOf(word) === 0) {
            const suffix = target.slice(word.length);
            if (canConstruct(suffix, wordBank)) {
                return true;
            }
        }
    }
    return false;
}

console.log(canConstruct('abcdef', ['abc', 'bc', 'a', 'cdef', 'de', 'f']));
console.log(canConstruct_dp('eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef', [
    'e',
    'ee',
    'eeee',
    'eeeeee',
    'eeeeeeee',
    'eeeeeeeeee'
]));