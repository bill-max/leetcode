package graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class updateMatrix {
    static class Solution {
        static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        public int[][] updateMatrix(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            int[][] dist = new int[m][n];
            boolean[][] seen = new boolean[m][n];
            Queue<int[]> queue = new ArrayDeque<>();
            // 将所有的 0 添加进初始队列中
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (matrix[i][j] == 0) {
                        queue.offer(new int[]{i, j});
                        seen[i][j] = true;
                    }
                }
            }

            // 广度优先搜索
            while (!queue.isEmpty()) {
                int[] cell = queue.poll();
                int i = cell[0], j = cell[1];
                for (int[] dir : dirs) {
                    int ni = i + dir[0], nj = j + dir[1];
                    if (ni >= 0 && ni < m && nj >= 0 && nj < n && !seen[ni][nj]) {
                        dist[ni][nj] = dist[i][j] + 1;
                        queue.offer(new int[]{ni, nj});
                        seen[ni][nj] = true;
                    }
                }
            }

            return dist;
        }
    }


    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Solution().updateMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}})));
    }
}
