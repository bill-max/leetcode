public class MaxProduct_2_5 {
    class Solution {
        /**
         * 位运算模板题 用bit位存储是否出现过
         */
        public int maxProduct(String[] words) {
            int length = words.length;
            int[] mask = new int[length];
            int idx = 0;
            for (String word : words) {
                int i = 0;
                for (int j = 0; j < word.length(); j++) {
                    int u = word.charAt(j) - 'a';
                    i |= (1 << u);
                }
                mask[idx++] = i;
            }
            int ans = 0;
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < i; j++) {
                    if ((mask[i] & mask[j]) == 0) {
                        ans = Math.max(ans, words[i].length() * words[j].length());
                    }
                }
            }
            return ans;
        }
    }
}
