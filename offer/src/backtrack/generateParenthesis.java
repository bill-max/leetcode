package backtrack;

import java.util.ArrayList;
import java.util.List;

public class generateParenthesis {
    static class Solution {

        private final List<String> result = new ArrayList<>();
        private final int[] cnt = new int[2];
        private final char[] c = new char[]{'(', ')'};

        public List<String> generateParenthesis(int n) {
            StringBuilder sb = new StringBuilder();
            dfs(n, sb);
            return result;
        }

        /**
         * [(()), ()()]
         * [(-()),((-)),(()-)]
         */
        private void dfs(int n, StringBuilder sb) {
            if (cnt[0] > n || cnt[1] > cnt[0]) return;
            if (sb.length() == 2 * n) {
                result.add(sb.toString());
                return;
            }
            for (int i = 0; i < 2; i++) {
                sb.append(c[i]);
                cnt[i]++;
                dfs(n, sb);
                sb.deleteCharAt(sb.length() - 1);
                cnt[i]--;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().generateParenthesis(3));
    }
}
