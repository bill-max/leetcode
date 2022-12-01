import java.util.Arrays;

public class offer_60 {
    static class Solution {
        public double[] dicesProbability(int n) {
            // 抛n个骰子，点数和共有6^n种情况，共有5*n+1种不重复点数和
            double[] res = new double[5 * n + 1];
            // dp[i][j]代表当前使用i个骰子,搞定点数和为j，能有多少种方法
            int[][] dp = new int[n + 1][6 * n + 1];
            dp[0][0] = 1;
            for (int i = 1; i <= n; i++) {
                for (int j = i; j <= i * 6; j++) {
                    for (int num = 1; num <= 6 && j - num >= 0; num++) {
                        dp[i][j] += dp[i - 1][j - num];
                    }
                }
            }
            // 填完了dp表，开始填res表
            double all = Math.pow(6, n);
            int curSum = n;
            for (int i = 0; i < res.length; i++) {
                res[i] = dp[n][curSum++] / all;
            }
            return res;
        }
    }
}
