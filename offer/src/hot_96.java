public class hot_96 {
    static class Solution {
        /**
         * dp[1]=1
         * dp[2]=dp[1]
         *
         * @param n
         * @return
         */
        public int numTrees(int n) {
            long C = 1;
            for (int i = 0; i < n; ++i) {
                C = C * 2 * (2 * i + 1) / (i + 2);
            }
            return (int) C;
        }
    }
}
