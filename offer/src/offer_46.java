public class offer_46 {
    static class Solution {
        /**
         * 数字翻译成字符串
         * 12258
         * dp[i]= num[i]+num[i-1]<26?dp[i-1]+dp[i-2]:dp[i-1]
         * dp[0]=1
         * dp[1]=1+1=2
         * dp[2]=2+1 =3
         * dp[3]=3+2=5
         * dp[4]=dp[i-1]=5
         *
         * 12210
         * dp[3]= 5
         * dp[4]=8
         *
         * @param num
         * @return
         */
        public int translateNum(int num) {
            String s = Integer.toString(num);
            int[] dp = new int[s.length() + 1];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i <= s.length(); i++) {
                if (s.charAt(i - 2) == '0') {
                    dp[i] = dp[i - 1];
                } else {
                    dp[i] = s.substring(i - 2, i).compareTo("26") < 0 ? dp[i - 1] + dp[i - 2] : dp[i - 1];
                }
            }
            return dp[s.length()];
        }

        /**
         * 优化空间
         * @param num
         * @return
         */
        public int translateNum2(int num) {
            String s = Integer.toString(num);
            int grandFather = 1;
            int father=1;
            int cur = 0;
            for (int i = 2; i <= s.length(); i++) {
                if (s.charAt(i - 2) == '0') {
                    cur = father;
                } else {
                    cur = s.substring(i - 2, i).compareTo("26") < 0 ? father + grandFather : father;
                }
                grandFather = father;
                father = cur;
            }
            return cur;
        }
    }
}
