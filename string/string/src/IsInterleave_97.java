public class IsInterleave_97 {
    static class Solution {
        /**
         * dp解决问题
         * s(p)为真的条件为：s(p-1)为真，且当前字符存在s1或s2中
         *
         * @param s1
         * @param s2
         * @param s3
         * @return
         */
        public boolean isInterleave(String s1, String s2, String s3) {
            int n = s1.length(), m = s2.length(), t = s3.length();

            if (n + m != t) {
                return false;
            }

            /*
            boolean[][] f = new boolean[n + 1][m + 1];
            f[0][0] = true;
            for (int i = 0; i <= n; ++i) {
                for (int j = 0; j <= m; ++j) {
                    int p = i + j - 1;
                    if (i > 0) {
                        // 使用 || 是为了防止s1的计算结果影响s2
                        f[i][j] = f[i][j] || (f[i - 1][j] && s1.charAt(i - 1) == s3.charAt(p));
                    }
                    if (j > 0) {
                        f[i][j] = f[i][j] || (f[i][j - 1] && s2.charAt(j - 1) == s3.charAt(p));
                    }
                }
            }
            return f[n][m];
            */

            //使用滚动数组优化
            boolean[][] f = new boolean[2][m + 1];
            f[0][0] = true;
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= m; j++) {
                    int p = i + j - 1;
                    if (i > 0) {
                        f[i % 2][j] = (f[(i - 1) % 2][j] && s1.charAt(i - 1) == s3.charAt(p));
                    }
                    if (j > 0) {
                        f[i % 2][j] = f[i % 2][j] || (f[i % 2][j - 1] && s2.charAt(j - 1) == s3.charAt(p));
                    }
                }
            }
            return f[n % 2][m];
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isInterleave("db", "b", "cbb"));
    }
}
