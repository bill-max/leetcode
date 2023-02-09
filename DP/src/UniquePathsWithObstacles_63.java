public class UniquePathsWithObstacles_63 {
    static class Solution {
        /**
         * 经典dp  滚动数组优化
         */
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;
            int[][] dp = new int[m + 1][n + 1];
            dp[0][1] = 1;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (obstacleGrid[i][j] == 1) {
                        dp[i + 1][j + 1] = 0;
                    } else {
                        dp[i + 1][j + 1] = dp[i][j + 1] + dp[i + 1][j];
                    }
                }
            }

            return dp[m][n];
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
    }
}
