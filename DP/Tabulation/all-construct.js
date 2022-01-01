// Tabulation
// Time and Space Complexity: O(n ^ m)
// Be careful when using this technique as the exponential complexity make the situation SO bad.
const allConstruct = (target, wordBank) => {
    // Construct 2D array
    const table = Array(target.length + 1)
                        .fill()
                        .map(() => []);

    table[0] = [[]];

    for(let i = 0; i < table.length; i++) {
        if(table[i] !== []) {
            for(let word of wordBank) {
                if(i + word.length <= table.length) {
                    if(target.slice(i, i + word.length) === word) {
                        const n_combination = table[i].map(ele => [...ele, word]);
                        table[i + word.length].push(...n_combination);
                        // table[i + word.length].push(...(table[i].map((ele) => [...ele, word])));  
                    }
                }
            }
        }
    }
    // console.log(table);
    return table[target.length];
}

console.log(allConstruct('abcdef', ['abc', 'bc', 'a', 'cdef', 'de', 'f']));
console.log(allConstruct('purple', ['purp', 'p', 'ur', 'le', 'purpl']))
console.log(allConstruct('eeeeeeeeeeeeeeef', [
    'e',
    'ee',
    'eee',
    'eeee',
    'eeeee'
]));