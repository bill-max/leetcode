public class findTheLongestBalancedSubstring {
    static class Solution {
        public int findTheLongestBalancedSubstring(String s) {
            int ans = 0;
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == '1' && s.charAt(i - 1) == '0') {
                    int idx1 = i;
                    int idx2 = i - 1;
                    while (idx1 < s.length() && idx2 >= 0 && s.charAt(idx1) == '1' && s.charAt(idx2) == '0') {
                        ans = Math.max(ans, idx1 - idx2 + 1);
                        idx1++;
                        idx2--;
                    }
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findTheLongestBalancedSubstring("01000111"));
    }
}
