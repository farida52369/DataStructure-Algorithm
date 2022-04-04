
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PartitionEqualSubsetSum {

    // My Solution: faster 38%
    // Time Complexity: O(N * Target)
    // Space Complexity: O(N * Target)
    public boolean canPartition_1(int[] nums) {
        int target, n = nums.length;

        // Getting The target value
        target = Arrays.stream(nums).sum();

        // odd value -> can't be partitioned
        if(target % 2 == 1) return false;

        target /= 2;
        boolean[][] dp = new boolean[n + 1][target + 1];

        for(int i = 0; i <= n; i++) dp[i][0] = true;

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= target; j++) {
                if(nums[i - 1] == j)
                    dp[i][j] = true;
                else if(nums[i - 1] < j) {
                    dp[i][j] = (dp[i][nums[i - 1]] && dp[i - 1][j - nums[i - 1]]) ||
                            dp[i - 1][j];
                } else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][target];
    }

    // Solution From My Favorite Channel for PS
    // Believe me my Solution is faster :)
    // Time Complexity: O(N * Target)
    public boolean canPartition_2(int[] nums) {
        int target, n = nums.length;

        // Getting The target value
        target = Arrays.stream(nums).sum();

        // odd value -> can't be partitioned
        if(target % 2 == 1) return false;

        target /= 2;

        Set<Integer> dp = new HashSet<>();
        dp.add(0);

        Set<Integer> next;
        for (int i = n - 1; i >= 0; i--) {
            next = new HashSet<>();
            for (int j : dp) {
                next.add(j + nums[i]);
                next.add(j);
            }
            dp = next;
        }
        return dp.contains(target);
    }
    
    // Faster than: 99%
    // Updated Version of Brute Force Solution
    // As Without DP array The solution is Time Limit Exceed
    private boolean knapsack(int[] nums, int index, int target, boolean[] dp) {

        if(index == -1) return false;
        if(target == nums[index]) return true;

        int num = target - nums[index];
        // when nums[index] < target:
        if(num > 0 && !dp[num]){
            dp[num] = true;
            return knapsack(nums, index - 1, num, dp) ||
                    knapsack(nums, index - 1, target, dp); 
        } 
        
        // when nums[index] > target:
        return knapsack(nums, index - 1, target, dp);
    }

    public boolean canPartition_3(int[] nums) {
        int target, n = nums.length;

        // Getting The target value
        target = Arrays.stream(nums).sum();

        // odd value -> can't be partitioned
        if(target % 2 == 1) return false;

        target /= 2;
        return knapsack(nums, n - 1, target, new boolean[target + 1]);
    }
}

// Problem Link: https://leetcode.com/problems/partition-equal-subset-sum/
// The End __
