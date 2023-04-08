public class hot_69 {
    static class Solution {
        /**
         * 矩阵的最小路径和  dp 问题
         *
         * @param grid
         * @return
         */
        public int minPathSum(int[][] grid) {
            int n = grid.length;
            int m = grid[0].length;
            int[][] dp = new int[n + 1][m + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (i - 1 == 0) {
                        dp[i][j] = grid[i - 1][j - 1] + dp[i][j - 1];
                    } else if (j - 1 == 0) {
                        dp[i][j] = grid[i - 1][j - 1] + dp[i - 1][j];
                    } else {
                        dp[i][j] = grid[i - 1][j - 1] + Math.min(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
            return dp[n][m];
        }
    }


    public static void main(String[] args) {
        int[][] mat = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(new Solution().minPathSum(mat));

    }
}
