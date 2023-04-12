public class LongestDecomposition_1147 {
    static class Solution {
        public int longestDecomposition(String text) {
            int l = 0, r = text.length() - 1;
            while (l < r) {
                if (text.substring(0, l + 1).equals(text.substring(r))) {
                    return 2 + longestDecomposition(text.substring(l + 1, r));
                } else {
                    l++;
                    r--;
                }
            }
            return text.length() == 0 ? 0 : 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestDecomposition("elvtoelvto"));
    }
}
