import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinTaps_1326 {
    static class Solution {

        public int minTaps(int n, int[] ranges) {
            int[][] intervals = new int[n + 1][];
            for (int i = 0; i <= n; i++) {
                int start = Math.max(0, i - ranges[i]);
                int end = Math.min(n, i + ranges[i]);
                intervals[i] = new int[]{start, end};
            }
            Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
            int[] dp = new int[n + 1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;
            for (int[] interval : intervals) {
                int start = interval[0], end = interval[1];
                if (dp[start] == Integer.MAX_VALUE) {
                    return -1;
                }
                for (int j = start; j <= end; j++) {
                    dp[j] = Math.min(dp[j], dp[start] + 1);
                }
            }
            return dp[n];
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minTaps(5, new int[]{3, 2, 1, 1, 0, 5}));
    }
}
