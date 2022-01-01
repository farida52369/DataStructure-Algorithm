// Tabulation
// Time Complexity: O(m^2 * n)
// Space: O(m^2)
const howSum = (targetSum, arr) => {
    const table = Array(targetSum + 1).fill(null);

    table[0] = [];
    for(let i = 0; i < table.length; i++) {
        if(table[i] !== null) {
            for(let num of arr) {
                if(num + i < table.length) {
                    table[num + i] = [...table[i], num];
                }
            }
        }
    }
    return table[targetSum];
}

console.log(howSum(7, [5, 3, 4]));
console.log(howSum(300, [7, 14]));
