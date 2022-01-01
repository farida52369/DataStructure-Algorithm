
// Tabulation -- Find trivial bound and start from it.
// Time Complexity: O(n)
// Space: O(n)

const fib = (n) => {
    const table = Array(n + 1).fill(0);
    table[1] = 1;
    for(let i = 0; i <= n; i++) {
        if (i + 1 <= n) table[i + 1]  += table[i];
        if (i + 2  <= n) table[i + 2] += table[i];
    }
    return table[n];
}

console.log(fib(6));
console.log(fib(50));