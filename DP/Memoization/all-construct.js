// m = target.length
// n = wordBank.length

// Time Complexity: O(n^m)
// Space: O(m)
const allConstruct_dp = (target, wordBank, dp = {}) => {
    if(target in dp) return dp[target];
    if(target === '') return [[]];

    let result = [];
    for(let word of wordBank) {
        if(target.indexOf(word) === 0) {
            const suffix = target.slice(word.length);
            const temp = allConstruct_dp(suffix, wordBank, dp);  // when return [[]], target ways hitted
            const targetWays = temp.map((way) => [word, ...way]);
            result.push(...targetWays);
        }
    }
    // console.log(result);
    return dp[target] = result;
}

const allConstruct = (target, wordBank) => {
    if(target === '') return [[]];

    let result = [];
    for(let word of wordBank) {
        if(target.indexOf(word) === 0) {
            const suffix = target.slice(word.length);
            const temp = allConstruct(suffix, wordBank);  // when return [[]], target ways hitted
            const targetWays = temp.map((way) => [word, ...way]);
            result.push(...targetWays);
        }
    }
    // console.log(result);
    return result;
}


console.log(allConstruct('abcdef', ['abc', 'bc', 'a', 'cdef', 'de', 'f']));
console.log(allConstruct('', ['abc', 'bc', 'a', 'cdef', 'de', 'f']));
/*console.log(allConstruct('eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef', [
    'e',
    'ee',
    'eeee',
    'eeeeee',
    'eeeeeeee',
    'eeeeeeeeee'
]));*/
console.log(allConstruct_dp('eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef', [
    'e',
    'ee',
    'eeee',
    'eeeeee',
    'eeeeeeee',
    'eeeeeeeeee'
]));
