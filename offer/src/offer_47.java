public class offer_47 {
    static class Solution {
        /**
         * dp (dfs会超时)
         * f(i,j)=max(f(i-1,j),f(i,j-1))+grid[i][j]
         *
         * @param grid
         * @return
         */
        public int maxValue(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int[][] dp = new int[m + 1][n + 1];
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
                }
            }
            return dp[m][n];
        }

    }
}
