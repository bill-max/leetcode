public class MaxProfit_309 {
    static class Solution {
        /**
         * 1 2 3 0 2
         * dp[1]=0
         * dp[j]=max(dp[1~(j-2)]+prices[j]-prices[i+2])
         * todo 没做完
         */
        public int maxProfit(int[] prices) {
            int n = prices.length;
            if (n < 2) return 0;
            int[] dp = new int[n];
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < i - 2; j++) {
                    dp[i] = Math.max(dp[i], dp[j] + prices[i] - prices[j + 2]);
                }
            }
            return dp[n - 1];
        }
    }
}
