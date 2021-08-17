// CODEFORCES PROBLEM: https://codeforces.com/problemset/problem/17/A

#include <bits/stdc++.h>

bool arr[1001];
int sum[1001] = {0};
int n, k;

void prime() {
  arr[0] = arr[1] = true;
  for (int i = 2; i * i <= n; i++) {
    if (!arr[i])
      for (int j = i * i; j <= n; j += i) arr[j] = true;
  }
}

int main() {
  std::cin >> n >> k;
  prime();  // If Num is prime, then its value equal false

  int prev = 2, counter = 0;
  for (int i = 3; i <= n; i++) {
    if (!arr[i]) sum[counter++] = prev + i, prev = i;
  }

  int ans = 0;
  for (int i = 0; i < counter; i++) {
    if (!arr[sum[i] + 1] && sum[i] + 1 <= n) {
      ans += 1;
    }
  }

  if (ans >= k)
    std::cout << "YES\n";
  else
    std::cout << "NO\n";
}

// THE END :""))))
