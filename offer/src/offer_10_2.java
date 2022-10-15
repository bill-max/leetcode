import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class offer_10_2 {
    static class Solution {
        /**
         * dp问题
         * 0->1 dp[0]=1
         * 1->1 dp[1]=1
         * 2-> 2  dp[0]+dp[1]
         * 3-> 3   3
         * @param n
         * @return
         */
        public int numWays(int n) {
            if (n <= 1) return 1;
            final int MOD = (int) (1e9 + 7);
/*            int[] dp = new int[n + 1];
            dp[0] = dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                dp[i] = (dp[i - 2] + dp[i - 1]) % MOD;
            }
            List<Integer> collect = Arrays.stream(dp).boxed().collect(Collectors.toList());
            System.out.println(collect);
            return dp[n];*/
            //优化
            int p = 1, q = 1, sum = 0;
            for (int i = 0; i < n; i++) {
                sum = (p + q) % MOD;
                p = q;
                q = sum;
            }
            return p;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numWays(7));
    }
}
