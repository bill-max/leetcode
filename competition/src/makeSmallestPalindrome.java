public class makeSmallestPalindrome {
    class Solution {
        public String makeSmallestPalindrome(String s) {
            int l = 0, r = s.length() - 1;
            StringBuilder sb = new StringBuilder();
            while (l < r) {
                char c = s.charAt(l) < s.charAt(r) ? s.charAt(l) : s.charAt(r);
                sb.append(c);
                l++;
                r--;
            }
            if (l == r) {
                return sb.toString() + s.charAt(l) + sb.reverse();
            } else {
                return sb.toString() + sb.reverse();
            }
        }
    }
}
