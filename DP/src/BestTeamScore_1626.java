import java.util.Arrays;

public class BestTeamScore_1626 {
    static class Solution {
        /**
         * map[i][0] > map[j][0]
         * scores = [5,5,4,6], ages = [1,1,2,2]
         * dp[1]=1
         * dp[2]=2
         */
        public int bestTeamScore(int[] scores, int[] ages) {
            var map = new int[scores.length][2];
            for (int i = 0; i < scores.length; i++) {
                map[i] = new int[]{scores[i], ages[i]};
            }
            Arrays.sort(map, ((o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1]));
//            System.out.println(Arrays.deepToString(map));
            var dp = new int[scores.length];
            int res = 0;
            for (int i = 0; i < scores.length; i++) {
                for (int j = i; j >= 0; j--) {
                    if (map[j][1] <= map[i][1]) {
                        dp[i] = Math.max(dp[i], dp[j]);
                    }
                }
                dp[i] += map[i][0];
                res = Math.max(res, dp[i]);
            }
//            System.out.println(Arrays.toString(dp));
            return res;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().bestTeamScore(new int[]{4, 6, 5, 5}, new int[]{2, 2, 1, 1}));
    }
}
