public class LengthOfLastWord_58 {
    static class Solution {
        public int lengthOfLastWord(String s) {
            int ans = 0;
            int i = s.length() - 1;
            while (s.charAt(i) == ' ') i--;
            while (i >= 0 && s.charAt(i) != ' ') {
                ans++;
                i--;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLastWord("wor d"));
    }
}
