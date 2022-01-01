
// Tabulation
// Time Complexity: O(n * m^2)
// Space: O(m)
const countConstruct = (target, wordBank) => {
    const table = Array(target.length + 1).fill(0);

    table[0] = 1; // if target='', then there's only one way to reach the target
    for(let i = 0; i < table.length; i++) {
        if(table[i] != 0) {
            for(let word of wordBank) {
                if(i + word.length < table.length) {
                    if(target.slice(i, i + word.length) === word) table[i + word.length] += table[i];
                }
            }
        }
    }
    return table[target.length];
}

console.log(countConstruct('abcdef', ['abc', 'bc', 'a', 'cdef', 'de', 'f']));
console.log(countConstruct('purple', ['purp', 'p', 'ur', 'le', 'purpl']))
console.log(countConstruct('eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef', [
    'e',
    'ee',
    'eeee',
    'eeeeee',
    'eeeeeeee',
    'eeeeeeeeee'
]));