public class offer_63 {
    static class Solution {
        /**
         * dp[1]=0
         * dp[2]=max(dp[i-1],prices[i]-minPrice)
         * @param prices
         * @return
         */
        public int maxProfit(int[] prices) {
            if (prices.length == 0) {
                return 0;
            }
            int[] dp = new int[prices.length];
            dp[0] = 0;
            int minPrice = prices[0];
            for (int i = 1; i < prices.length; i++) {
                dp[i] = Math.max(dp[i - 1], prices[i]-minPrice);
                minPrice = Math.min(minPrice, prices[i]);
            }
            return dp[prices.length - 1];
        }
    }
}
