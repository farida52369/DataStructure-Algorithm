// Tabulation
// Time Complexity: O(n * m^2)
// Space: O(m)
const canConstruct = (target, wordBank) => {
    const table = Array(target.length + 1).fill(false);

    table[0] = true;
    for(let i = 0; i < table.length; i++) {
        if(table[i]){
            for(let word of wordBank){
                if(i + word.length <= table.length) {
                    if(target.slice(i, i + word.length) === word) table[i + word.length] = true;
                }
            }
        }
    }
    // console.log(table)
    return table[target.length];
}

console.log(canConstruct('abcdef', ['abc', 'bc', 'a', 'cdef', 'de', 'f']));
console.log(canConstruct('eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef', [
    'e',
    'ee',
    'eeee',
    'eeeeee',
    'eeeeeeee',
    'eeeeeeeeee'
]));