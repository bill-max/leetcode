import java.util.Arrays;
import java.util.Comparator;

public class VideoStitching_1024 {
    static class Solution {
        /**
         * 区间dp
         */
        public int videoStitching(int[][] clips, int time) {
            Arrays.sort(clips, Comparator.comparingInt(o -> o[0]));
            System.out.println(Arrays.deepToString(clips));
            int[] dp = new int[time + 1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;
            for (var clip : clips) {
                int start = Math.min(clip[0], time);
                int end = Math.min(clip[1], time);
                if (dp[start]==Integer.MAX_VALUE) return -1;
                for (int j = start; j <= end; j++) {
                    dp[j] = Math.min(dp[start] + 1, dp[j]);
                }
            }
            return dp[time] == Integer.MAX_VALUE ? -1 : dp[time];
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().videoStitching(new int[][]{{1,2},{1,8},{2,3}},2));
    }
}
