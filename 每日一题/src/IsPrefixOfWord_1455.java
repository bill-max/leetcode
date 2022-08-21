public class IsPrefixOfWord_1455 {
    static class Solution {
        public int isPrefixOfWord(String sentence, String searchWord) {
            String[] strings = sentence.split(" ");
            int ans = -1;
            for (int i = 0; i < strings.length; ++i) {
                String str = strings[i];
               /* if (str.length() < searchWord.length()) {
                    continue;
                }
                ans = str.substring(0, searchWord.length()).equals(searchWord) ? i + 1 : -1;
                if (ans!=-1) return ans;*/
                if (str.startsWith(searchWord)) {
                    return i + 1;
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPrefixOfWord("i urg eating urger", "urg"));
    }
}
