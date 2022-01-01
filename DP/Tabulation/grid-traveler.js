// Tabulation
// Time Complexity: O(n*m)
// Space: O(n*m)
const gridTraveler = (n, m) => {
    // Construct of 2D array.
    const table = Array(n + 1).fill()
        .map(() => Array(m + 1).fill(0));

    table[1][1] = 1;
    for(let i = 1; i<= n; i++) {
        for(let j = 1; j <= m; j++) {
            if(j+1 <= m) table[i][j+1] += table[i][j];
            if(i+1 <= n) table[i+1][j] += table[i][j];  
        }
    }
    // console.log(table);
    return table[n][m];
}

console.log(gridTraveler(3, 3));
console.log(gridTraveler(5, 8));
console.log(gridTraveler(18, 18));
