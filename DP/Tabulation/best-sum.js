
// Tabulation
// Time Complexity: O(m^2 * n)
// Space: O(m^2)
const bestSum = (targetSum, arr) => {
    const table = Array(targetSum + 1).fill(null);

    table[0] = [];
    for(let i = 0; i < table.length; i++) {
        if(table[i] !== null) {
            for(let num of arr) {
                if(num + i < table.length) {
                    const combination = [...table[i], num];
                    // if the combination is null or the length of the combination is less than the length of the table..
                    if(!table[num + i] || combination.length < table[num + i].length) table[num + i] = combination;
                }
            }
        }
    }
    // console.log(table);
    return table[targetSum];
}

console.log(bestSum(8, [2, 3, 5, 8]));
console.log(bestSum(8, [2, 3, 5, 10]));
console.log(bestSum(100, [1, 5, 2, 25]));