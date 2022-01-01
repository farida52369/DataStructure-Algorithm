
// Tabulation
// Time Complexity: O(n*m)
// Space: O(m) 
const canSum = (targetSum, arr) => {
    const table = Array(targetSum + 1).fill(false);

    table[0] = true;
    for(let i = 0; i < table.length; i++) {
        if(table[i] === true){
            for(let num of arr) {
                if(num + i < table.length) {
                    table[num + i] = true;
                }
            }
        }
    }
    return table[targetSum];
}

console.log(canSum(7, [1, 2, 4, 14]));
console.log(canSum(300, [7, 14]));