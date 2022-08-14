public class MaxScore_1422 {
    static class Solution {
        public int maxScore(String s) {
            int[] count = new int[]{0, 0};
            for (int i = 0; i < s.length(); ++i) {
                if (s.charAt(i) != '0')
                    count[1]++;
            }

            int ans = 0;
            for (int i = 1; i < s.length(); i++) {
                int score = 0;
                if (s.charAt(i - 1) == '0') {
                    count[0]++;
                } else {
                    count[1]--;
                }
                score = count[1] + count[0];
                ans = Math.max(score, ans);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxScore("1111"));
    }
}
