// GIVEN WEIGHTS AND VALUES OF N ITEMS,
// FIND OUT THE MAXIMUM VALUE SUBSET OF VALUES SUCH THAT THE SUM OF THE WEIGHTS
// OF THIS SUBSET IS SMALLER THAN OR EQUAL TO W.
//

#include <bits/stdc++.h>

int KnapSack_BruteForceSolution(int val[], int weight[], int W, int n) {
  if (W == 0 || n == 0) return 0;

  // First Case: weight[n-1] > W,
  // then skip this value as it can't be in the ans
  if (weight[n - 1] > W)
    return KnapSack_BruteForceSolution(val, weight, W, n - 1);
  // Second Case: weight[n-1] <= W,
  // then Take the val[n-1] or leave it as two Options
  // That makes the time complexity (2^N)
  else
    return std::max(val[n - 1] + KnapSack_BruteForceSolution(
                                     val, weight, W - weight[n - 1], n - 1),
                    KnapSack_BruteForceSolution(val, weight, W, n - 1));
}

int KnapSack_DPSolution(int val[], int weight[], int W, int n, int **dp) {
  if (W == 0 || n == 0) return dp[n][W] = 0;

  if (dp[n][W] != -1) return dp[n][W];

  // Main Code
  if (weight[n - 1] > W)
    return dp[n][W] = KnapSack_DPSolution(val, weight, W, n - 1, dp);
  else
    return dp[n][W] = std::max(
               val[n - 1] + KnapSack_DPSolution(val, weight, W - weight[n - 1],
                                                n - 1, dp),
               KnapSack_DPSolution(val, weight, W, n - 1, dp));
}

int main() {
  int val[] = {10, 15, 20, 30, 100, 55};
  int weight[] = {1, 2, 3, 4, 5, 6};
  int W = 7, n = sizeof(val) / sizeof(val[0]);

  int **dp;
  dp = new int *[n + 1];
  for (int i = 0; i <= n; i++) dp[i] = new int[W + 1];
  for (int i = 0; i <= n; i++)
    for (int j = 0; j <= W; j++) dp[i][j] = -1;

  int resBF = KnapSack_BruteForceSolution(val, weight, W, n);
  int resDP = KnapSack_DPSolution(val, weight, W, n, dp);

  std::cout << "Brute Force Solution: " << resBF << '\n';
  std::cout << "Dynamic Programming Solution: " << resDP << '\n';
}
