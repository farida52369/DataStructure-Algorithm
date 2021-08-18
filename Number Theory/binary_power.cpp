#include <bits/stdc++.h>
#define LL long long int

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
LL binary_pow2(LL a, LL b) {
  if (b == 0) return 1;
  LL res = binary_pow2(a, b / 2);
  if (res % 2)
    return res = res * res * a;
  else
    return res = res * res;
}

int main() {
  LL a, b;
  std::cout << "Enter The a & b: ";
  std::cin >> a >> b;
  std::cout << "a^b Using Loops: " << binary_pow(a, b) << "\n";
  std::cout << "a^b using Recursion: " << binary_pow2(a, b) << "\n";
}
