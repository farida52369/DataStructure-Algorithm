#include <bits/stdc++.h>

const int N = 10e8;
bool isPrime[N];
int n;  // THE REQUIRED NUM TO HAVE PRIME UNTILL IT ..

void prime() {
  isPrime[0] = isPrime[1] = true;
  for (int i = 2; i * i <= n; i++)
    if (!isPrime[i])
      for (int j = i * i; j <= n; j += i) isPrime[j] = true;
}

int main() {
  std::cin >> n;
  prime();

  for (int i = 2; i <= n; i++)
    if (!isPrime[i]) std::cout << i << " ";
  std::cout << "\n";
  return 0;
}
