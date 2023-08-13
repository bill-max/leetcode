import com.sun.source.tree.BreakTree;

import java.util.*;

public class LongestStrChain_1048 {
    static class Solution {
        public int longestStrChain(String[] words) {
            Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
            for (int i = 0, wordsLength = words.length; i < wordsLength; i++) {
                String word = words[i];
                int n = word.length();
                if (!map.containsKey(n)) {
                    map.put(n, new ArrayList<Integer>());
                }
                map.get(n).add(i);
            }

            int[] dp = new int[words.length];
            int ans = 1;
            Arrays.fill(dp, 1);
            for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
                Integer key = entry.getKey();
                List<Integer> value = entry.getValue();
                if (!map.containsKey(key - 1)) {
                    continue;
                }
                List<Integer> list = map.get(key - 1);
                for (int i = 0; i < value.size(); i++) {
                    String word = words[value.get(i)];
                    for (int j = 0; j < list.size(); j++) {
                        String subWord = words[list.get(j)];
                        if (check(word, subWord)) {
                            dp[value.get(i)] = Math.max(dp[value.get(i)], 1 + dp[list.get(j)]);
                        }
                    }
                    ans = Math.max(ans, dp[value.get(i)]);
                }
            }
            return ans;
        }

        private boolean check(String word, String subWord) {
            int cnt = 1;
            int i = 0, j = 0;
            while (i < word.length() && j < subWord.length()) {
                if (word.charAt(i) != subWord.charAt(j)) {
                    cnt--;
                } else {
                    j++;
                }
                i++;
                if (cnt < 0) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestStrChain(new String[]{"xbc", "pcxbcf", "xb", "cxbc", "pcxbc"}));
    }
}
