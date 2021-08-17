#include <bits/stdc++.h>

std::vector<int> primeFactorization(int n) {
  std::vector<int> res;

  while (n % 2 == 0) res.push_back(2), n /= 2;

  for (int i = 3; i * i <= n; i = i + 2)
    while (n % i == 0) res.push_back(i), n /= i;

  if (n > 2) res.push_back(n);

  return res;
}

int main() {
  int n;
  std::cout << "Num you wanna Factorize: ";
  std::cin >> n;

  std::vector<int> v = primeFactorization(n);
  for (int i = 0; i < (int)v.size(); i++) std::cout << v[i] << " ";
  std::cout << std::endl;
}
