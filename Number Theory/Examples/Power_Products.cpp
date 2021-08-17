// CODEFORCES PROBLEM: https://codeforces.com/contest/1225/problem/D

#include <bits/stdc++.h>
#define LL long long int
#define vec std::vector<std::pair<int, int>>
#define mp std::make_pair
#define pb push_back

vec primeFactors(int n, int k) {
  vec res;
  // GETTING THE PRIME FACTORS FROM 2 TO SQRT(N)
  for (int i = 2; i * i <= n; i++) {
    int pow = 0;
    // THE POWER OF A SPECIFIC NUMBER IN THE PRIME FACTORS
    while (n % i == 0) {
      pow += 1;
      n /= i;
    }
    // IF THE POW NOT EQULA ZERO THEN PUSH IT IN RES VECTOR
    if (pow % k) res.pb(mp(i, pow % k));
  }
  // IF THERE'S A REMAINDER THEN PUSH IT TO THE RES VECTOR
  if (n > 1) res.pb(mp(n, 1));
  return res;
}

vec whatWeNeed(vec v, int k) {
  vec res;
  int len = (int)v.size();
  for (int i = 0; i < len; i++) res.pb(mp(v[i].first, k - v[i].second));
  return res;
}

int main() {
  int n, k, x;
  std::cin >> n >> k;

  LL ans = 0;
  // map <<num, power>, counter>
  std::map<vec, int> m;
  for (int i = 0; i < n; i++) {
    std::cin >> x;

    vec v1 = primeFactors(x, k);
    vec v2 = whatWeNeed(v1, k);

    ans += m[v2];
    m[v1]++;
  }

  std::cout << ans << "\n";
}

// THE END :""))))
