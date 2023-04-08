import java.util.Arrays;

public class NumSquares_279 {
    static class Solution {
        public int numSquares(int n) {
            int[] dp = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                int minn = Integer.MAX_VALUE;
                for (int j = 1; j * j <= i; j++) {
                    minn = Math.min(minn, dp[i - j * j]);
                }
                dp[i] = minn + 1;
            }
            return dp[n];
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numSquares(12));
    }
}
