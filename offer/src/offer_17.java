import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class offer_17 {
    /**
     * 大数越界问题，解决办法：使用string
     */
    static class Solution {
        public int[] printNumbers(int n) {
            if (n == 0) return new int[0];
            List<Integer> ans = new ArrayList<>();
            int end = (int) Math.pow(10, n);
            for (int i = 1; i < end; ++i) {
                ans.add(i);
            }
            return ans.stream().mapToInt(Integer::intValue).toArray();
        }

        /**
         * 使用string[] 作为输出
         */
        public List<String> printBigNumbers(int n) {
            if (n == 0) return null;
            List<String> ans = new ArrayList<>();
            String[] loop = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
            for (String s : loop) {
                dfs(n - 1, loop, ans, s);
            }
            return ans;
        }

        private void dfs(int level, String[] loop, List<String> ans, String curStr) {
            if (level == 0) {
                //去除前导0
                int i = 0;
                while (i < curStr.length() && curStr.charAt(i) == '0' && curStr.length() != 1) i++;
                if (i != curStr.length()) {
                    ans.add(curStr.substring(i));
                }
                return;
            }
            for (String s : loop) {
                dfs(level - 1, loop, ans, curStr + s);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().printBigNumbers(5));
    }
}
