public class hot_221 {
    static class Solution {
        /**
         * dp(i,j)=min(dp[i-1,j],dp[i-1,j-1],dp[i,j-1])+1
         *
         * @param matrix
         * @return
         */
        public int maximalSquare(char[][] matrix) {
            int ans = 0;
            int m = matrix.length;
            int n = matrix[0].length;
            if (m == 0 || n == 0) return ans;
            int[][] dp = new int[m + 1][n + 1];
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (matrix[i - 1][j - 1] == '0') dp[i][j] = 0;
                    else dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i - 1][j - 1]), dp[i][j - 1]) + 1;
                    ans = Math.max(ans, dp[i][j]);
                }
            }
            return ans * ans;
        }
    }
}
