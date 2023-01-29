/**
 * @author 李建彤
 */
public class GetLucky_1945 {
    static class Solution {
        public int getLucky(String s, int k) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                sb.append(s.charAt(i) - 'a' + 1);
            }
            String s1 = sb.toString();
            int ans = 0;
            for (int i = 0; i < s1.length(); i++) {
                ans += s1.charAt(i) - '0';
            }
            int parseInt = ans;
            for (int i = 0; i < k - 1; i++) {
                ans = 0;
                while (parseInt != 0) {
                    ans += parseInt % 10;
                    parseInt /= 10;
                }
                parseInt = ans;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().getLucky("leetcode", 1));
    }
}
