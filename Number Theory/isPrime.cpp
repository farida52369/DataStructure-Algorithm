#include <bits/stdc++.h>

bool isPrime(int n) {
  if (n == 0 || n == 1) return false;

  if (!(n & 1)) {
    if (n == 2) return true;
    return false;
  }

  for (int i = 2; i * i <= n; i++)
    if (n % i == 0) return false;

  return true;
}

int main() {
  int n;
  std::cout << "Enter num wanna check: ";
  std::cin >> n;

  std::cout << "Is " << n << " prime: " << std::boolalpha << isPrime(n) << "\n";
}
