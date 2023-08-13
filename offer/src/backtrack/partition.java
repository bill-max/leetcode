package backtrack;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class partition {
    static class Solution {
        int[][] f;
        private final List<List<String>> ans = new ArrayList<>();

        public String[][] partition(String s) {
            int n = s.length();
            f = new int[n][n];
            List<String> subset = new ArrayList<>();
            dfs(s, 0, subset);
            return ans.stream().map(a -> a.toArray(new String[0])).toList().toArray(new String[0][0]);
        }

        private void dfs(String s, int cur, List<String> subset) {
            if (cur == s.length()) {
                ans.add(new ArrayList<>(subset));
                return;
            }
            for (int i = cur; i < s.length(); i++) {
                if (isPalindrome(s, cur, i)==1) {
                    subset.add(s.substring(cur, i + 1));
                    dfs(s, i + 1, subset);
                    subset.remove(subset.size() - 1);
                }
            }
        }

        public int isPalindrome(String s, int i, int j) {
            if (f[i][j] != 0) {
                return f[i][j];
            }
            if (i >= j) {
                f[i][j] = 1;
            } else if (s.charAt(i) == s.charAt(j)) {
                f[i][j] = isPalindrome(s, i + 1, j - 1);
            } else
                f[i][j] = -1;

            return f[i][j];
        }
    }
}
