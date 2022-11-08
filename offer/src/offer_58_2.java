public class offer_58_2 {
    static class Solution {
        public String reverseLeftWords(String s, int n) {
            String substring1 = s.substring(0, n);
            String s1 = s.substring(n);
            StringBuilder sb = new StringBuilder();
            sb.append(s1).append(substring1);
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverseLeftWords("abcdefg", 2));
    }
}
