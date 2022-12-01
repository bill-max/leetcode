public class offer_62 {
    static class Solution {
        /**
         * 约瑟夫环问题
         * dp解决
         * x=(x+m%n)%n
         * 推导的关键：dp[n]移除一个数字之后变成新的dp‘[n-1]问题，=>dp[n] = dp'[n-1]
         * dp'[n-1]有n-1个数字，顺序为：m,m+1,m+2...m+x
         * dp[n-1]也有n-1个数字，顺序为：0,1,2...x
         * dp[n-1]解的位置和dp'[n-1]的解在同一列的位置, =>根据观察同一列的数字转换关系，dp[n-1]解和dp'[n-1]的解的关系为dp'[n-1] = (dp[n-1]+m)%n， => 所以 dp[n] = (dp[n-1]+m)%n
         * @param n
         * @param m
         * @return
         */
        public int lastRemaining(int n, int m) {
            int[] dp = new int[n + 1];
            dp[1] = 0;
            for (int i = 2; i <= n; i++) {
                dp[i] = (dp[i - 1] + m % i) % i;
            }
            return dp[n];
        }
    }
}
