public class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        // Start by copying the first row into the dp array.
        int[] dp = grid[0].clone();
        
        // Iterate over each row starting from the second one
        for (int i = 1; i < n; ++i) {
            // Temporary array to hold the new minimum values for this row
            int[] newDp = new int[n];
            
            // Iterate over each column to update the newDp values
            for (int j = 0; j < n; ++j) {
                // Calculate minimum path sum for the current cell
                newDp[j] = Integer.MAX_VALUE;
                for (int k = 0; k < n; ++k) {
                    if (k != j) { // You cannot stay in the same column
                        newDp[j] = Math.min(newDp[j], dp[k] + grid[i][j]);
                    }
                }
            }
            
            // Copy new minimum path sums to dp array for next iteration
            dp = newDp;
        }
        
        // Find the minimum value in the last dp array, which will be our answer
        int minSum = dp[0];
        for (int i = 1; i < n; ++i) {
            minSum = Math.min(minSum, dp[i]);
        }
        
        return minSum;
    }
}
