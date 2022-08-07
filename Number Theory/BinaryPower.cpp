#include <bits/stdc++.h>
#define LL long long int

// USE IT WITH LARGE NUMBERS :))
int MOD = 1e9 + 7;

// Using While Loop
LL binary_pow(LL a, LL b) {
  LL res = 1;
  while (b > 0) {
    if (b & 1) res *= a;
    a *= a;
    b >>= 1;
  }
  return res;
}

// Using Recursion
LL binary_pow_recursion(LL a, LL b) {
  if (b == 0) return 1;
 
  LL res = pow(a, b / 2);
  if (b % 2) 
    return (res%MOD*res%MOD*a%MOD) % MOD;
  return (res%MOD*res%MOD) % MOD;
}

int main() {
  LL a, b;
  std::cout << "Enter The a & b: ";
  std::cin >> a >> b;
  std::cout << "a^b Using Loops: " << binary_pow(a, b) << "\n";
  std::cout << "a^b using Recursion: " << binary_pow_recursion(a, b) << "\n";
}
