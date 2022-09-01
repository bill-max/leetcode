import java.util.ArrayList;
import java.util.List;

public class NumDecodings_91 {
    static class Solution {
        /*
        1 1 2 3
        11 2 3
        1 12 3
        1 1 23
        11 23

        dp[0]=1
        dp[1]=dp[0] = 1
        dp[2]=dp[1]+ dp[0] = 2

        1 6 2 0 1
        dp[0]=1
        dp[1]=2
        dp[2]=2
        dp[3]=1
         */
        public int numDecodings(String s) {
            int n = s.length();
            int[] f = new int[n + 1];
            f[0] = 1;
            for (int i = 1; i <= n; ++i) {
                if (s.charAt(i - 1) != '0') {
                    f[i] += f[i - 1];
                }
                if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
                    f[i] += f[i - 2];
                }
            }
            return f[n];
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numDecodings("11"));
    }
}
