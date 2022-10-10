public class offer_05 {
    static class Solution {
        public String replaceSpace(String s) {
            return s.replace(" ", "%20");
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().replaceSpace("we are the world!"));
    }
}
