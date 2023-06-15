public class HardestWorker_2432 {
    static class Solution {
        public int hardestWorker(int n, int[][] logs) {
            int t = logs.length;
            int max = logs[0][1];
            int id = logs[0][0];
            for (int i = 1; i < t; i++) {
                if (logs[i][1] - logs[i - 1][1] > max) {
                    max = logs[i][1] - logs[i - 1][1];
                    id = logs[i][0];
                } else if (logs[i][1] - logs[i - 1][1] == max) {
                    id = Math.min(id, logs[i][0]);
                }
            }
            return id;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().hardestWorker(10,new int[][]{{0,3},{2,5},{0,9},{1,15}}));
    }
}
