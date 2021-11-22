public class MaxProfit {
    public int maxProfit(int[] prices) {
        /**
         * 表示前i天的最大利润
         * dp[i]=max(dp[i−1],prices[i]−minprice)
         */
        int[] dp = new int[prices.length];
        dp[0]=0;
        //minprice代表历史最低价格
        int minprice=prices[0];
        // 所以i从1开始历史最低价格肯定是prices[0]
        for (int i = 1; i < prices.length; i++) {
            dp[i]=Math.max(dp[i-1],prices[i]-minprice);
            minprice=Math.min(minprice,prices[i]);
        }
        return dp[prices.length-1];
    }
}
