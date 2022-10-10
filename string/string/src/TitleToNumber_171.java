public class TitleToNumber_171 {
    static class Solution {
        /**
         * 进制转换  26 --> 10
         *
         * @param columnTitle excel行列号
         * @return 十进制序号
         */
        public int titleToNumber(String columnTitle) {
            int ans = 0;
            int m = columnTitle.length();
            for (int i = 0; i < m; i++) {
                int num = columnTitle.charAt(i) - 'A' + 1;
                ans += num * Math.pow(26, m - 1 - i);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().titleToNumber("ZY"));
    }
}
