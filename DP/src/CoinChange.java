import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        /**
         * dp[i]
         *
         * {1, 2, 4}  amount=11
         * dp[11]=min(dp[11-1],dp[11-2],dp[11-4])+1
         *
         * dp[amount]=min((对所有i)dp[amount-coins[i]])+1
         */
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
