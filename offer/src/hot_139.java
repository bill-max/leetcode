import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class hot_139 {
    static class Solution {
        /**
         * dp
         *
         * @param s
         * @param wordDict
         * @return
         */
        public boolean wordBreak(String s, List<String> wordDict) {
            Set<String> set = new HashSet<>();
            boolean[] dp = new boolean[s.length() + 1];
            dp[0] = true;
            for (int i = 1; i <= s.length(); i++) {
                for (int j = 0; j < i; j++) {
                    String substring = s.substring(j, i);
                    if (dp[j] && wordDict.contains(substring)) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[s.length()];
        }


    }

    public static void main(String[] args) {
        System.out.println(new Solution().wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
    }
}
