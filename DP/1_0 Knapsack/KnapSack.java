// Take It or Not (1/0) Problem
public class Knapsack {

    // Through Brute Force Solution
    // Decision Tree
    // Time Complexity: O(2^N)
    // Goes along the array of wts which its size: N
    // Every Time two possible cases (Take Or Not): 2
    public static int knapsack_1(int[] val, int[] wts, int w, int i) {
        // Base Case
        if (w == 0 || i == -1) return 0;

        if (w < wts[i])
            return knapsack_1(val, wts, w, i - 1);

        // Main Decision
        // Take The Item or leave it
        // Evaluate The Max__
        return Math.max(
                knapsack_1(val, wts, w - wts[i], i - 1) + val[i],
                knapsack_1(val, wts, w, i - 1)
        );
    }
  

    // Using Dynamic Programming
    // Time Complexity: O(N * W)
    // Space Complexity: O(N * W)
    public static int knapsack_2(int[] val, int[] wts, int w) {
        int n = val.length;
        int[][] dp = new int[n + 1][w + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {

                // The Same As Brute Force Solution
                // Max Between Taking The Value or Not
                if (wts[i - 1] <= j)
                    dp[i][j] = Math.max(
                            dp[i - 1][j],
                            val[i - 1] + dp[i - 1][j - wts[i - 1]]
                    );
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[n][w];
    }
}

// The End __
