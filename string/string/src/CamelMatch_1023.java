import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CamelMatch_1023 {
    static class Solution {
        public List<Boolean> camelMatch(String[] queries, String pattern) {
            List<Boolean> ans = new ArrayList<>();
            for (String query : queries) {
                ans.add(matches(query, pattern));
            }
            return ans;
        }

        private static boolean matches(String query, String pattern) {
            int m = query.length(), n = pattern.length();

            int j = 0;// j 代表 query 被匹配到的位置
            for (int i = 0; i < m; i++) { // 遍历 pattern，i 代表被遍历到的位置
                char c = query.charAt(i);
                if (j < n && c == pattern.charAt(j)) j++;
                else if (c >= 'A' && c <= 'Z') {
                    return false;
                }
            }
            return j == n;
        }

        public List<Boolean> camelMatch2(String[] queries, String pattern) {
            StringBuilder regexp = new StringBuilder("[a-z]*");
            for (int i = 0; i < pattern.length(); i++) {
                regexp.append(pattern.charAt(i)).append("[a-z]*");
            }
            return Arrays.stream(queries).map(query -> query.matches(regexp.toString())).collect(Collectors.toList());
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().camelMatch(new String[]{"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"}, "FoBa"));
    }
}
