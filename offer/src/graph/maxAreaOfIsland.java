package graph;

public class maxAreaOfIsland {
    static class Solution {
        int[][] positions = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        public int maxAreaOfIsland(int[][] grid) {
            int n = grid.length;
            int m = grid[0].length;
            int res = 0;
            for (int x = 0; x < m; x++) {
                for (int y = 0; y < n; y++) {
                    if (grid[y][x] == 0) continue;
                    int s = dfs(grid, x, y);
                    res = Math.max(res, s);
                }
            }
            return res;
        }

        private int dfs(int[][] grid, int x, int y) {
            int total = 1;
            grid[y][x] = 0;
            for (int[] pos : positions) {
                int xi = x + pos[0];
                int yi = y + pos[1];
                if (xi >= 0 && yi >= 0 && xi < grid[0].length && yi < grid.length && grid[yi][xi] == 1) {
                    total += dfs(grid, xi, yi);
                }
            }
            return total;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxAreaOfIsland(new int[][]{{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}}));
    }
}
