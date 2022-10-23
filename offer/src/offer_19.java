public class offer_19 {
    static class Solution {
        /**
         * 正则表达式匹配
         * dp[i][j]==> s.(i) == p.(j)
         *
         * @param s 目标串
         * @param p 源串 regex
         * @return
         */
        public boolean isMatch(String s, String p) {
            int n = s.length();
            int m = p.length();
            boolean[][] dp = new boolean[n + 1][m + 1];

            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= m; j++) {
                    //如果正则表达式为空
                    if (j == 0) {
                        //空正则 只 能匹配空串
                        dp[i][j] = i == 0;
                    } else {
                        //非空正则
                        //分成两种情况 非*  和  *
                        if (p.charAt(j - 1) != '*') {
                            //正则为 . 能匹配所有情况
                            if (i > 0 && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.')) {
                                dp[i][j] = dp[i - 1][j - 1];
                            }
                        } else {
                            //正则为 *  时分为两种情况
                            //看 : 将 * 之前的字符与 s 匹配
                            if (i >= 1 && j >= 2 && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.')) {
                                dp[i][j] |= dp[i - 1][j];
                            }
                            //不看 p直接跳过两个字符
                            if (j >= 2) {
                                dp[i][j] |= dp[i][j - 2];
                            }
                            //note：关于为何用 |= ：两种情况都要判断，只要有一种情况满足即为真
                        }
                    }
                }
            }
            return dp[n][m];
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isMatch("aab", "c*a*b*"));
    }

}
