public class addMinimum {
    static class Solution {
        /**
         * ac    c  b  ab c
         * abc abc abc abc = 7
         *
         * @param word
         * @return
         */
        public int addMinimum(String word) {
            int[] pattern = new int[]{'a', 'b', 'c'};
            int idx = 0, i = 0;
            while (i < word.length()) {
                char ch = word.charAt(i);
                while (ch != pattern[idx % 3]) {
                    idx++;
                }
                idx++;
                i++;
            }
            idx = idx % 3 == 0 ? idx : (idx / 3 + 1) * 3;
            return idx - word.length();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().addMinimum("abc"));
    }
}
