import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

public class Largest1BorderedSquare_1139 {
    static class Solution {
        /**
         * 1  1  1  0
         * 1  1  1  0
         * 1  1  1  0
         * 1  0  0  1
         * <p>
         * 0  1  1  1
         * 0  1  1  1
         * 0  1  1  1
         * 1  0  0  1
         */
        public int largest1BorderedSquare(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int[][] dp = new int[m][n];
            dp[0][0] = grid[0][0] == 1 ? 1 : 0;
            for (int i = 1; i < m; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], grid[i][0]);
            }
            for (int i = 1; i < n; i++) {
                dp[0][i] = Math.max(dp[0][i - 1], grid[0][i]);
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (i != j) {
                        dp[i][j] = i > j ?
                                Math.max(dp[i - 1][j], grid[i][j] == 1 && check(grid, j + 1, i, j) ? j + 1 : grid[i][j]) :
                                Math.max(dp[i][j - 1], grid[i][j] == 1 && check(grid, i + 1, i, j) ? i + 1 : grid[i][j]);
                    } else {
                        dp[i][j] = Math.max(Math.max(dp[i - 1][j], dp[i][j - 1]), grid[i][j] == 1 && check(grid, i + 1, i, j) ? i + 1 : grid[i][j]);
                    }
                }
            }
            return dp[m - 1][n - 1] * dp[m - 1][n - 1];
        }

        private boolean check(int[][] grid, int len, int y, int x) {
            for (int i = y; i >= y - len + 1; i--) {
                if (grid[i][x] == 0 || grid[i][x - len + 1] == 0) {
                    return false;
                }
            }
            for (int i = x; i >= x - len + 1; i--) {
                if (grid[y][i] == 0 || grid[y - len + 1][i] == 0) {
                    return false;
                }
            }
            return grid[y - len + 1][x - len + 1] == 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().largest1BorderedSquare(new int[][]{
                {1, 1, 1},
                {1, 1, 0},
                {1, 1, 1},
                {0, 1, 1},
                {1, 1, 1}
        }));
        System.out.println(new Solution().check(new int[][]{
                {1, 1, 1},
                {1, 1, 0},
                {1, 1, 1},
                {0, 1, 1},
                {1, 1, 1}
        }, 3, 4, 2));
    }

    static class Solution2 {
        public int largest1BorderedSquare(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            int[][] left = new int[m + 1][n + 1];
            int[][] up = new int[m + 1][n + 1];
            int maxBorder = 0;
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (grid[i - 1][j - 1] == 1) {
                        left[i][j] = left[i][j - 1] + 1;
                        up[i][j] = up[i - 1][j] + 1;
                        int border = Math.min(left[i][j], up[i][j]);
                        while (left[i - border + 1][j] < border || up[i][j - border + 1] < border) {
                            border--;
                        }
                        maxBorder = Math.max(maxBorder, border);
                    }
                }
            }

            return maxBorder * maxBorder;
        }

    }
}
