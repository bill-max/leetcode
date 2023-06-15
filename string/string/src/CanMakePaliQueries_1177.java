import java.util.ArrayList;
import java.util.List;

public class CanMakePaliQueries_1177 {
    static class Solution {
        public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
            int[] prefix = new int[s.length() + 1];
            for (int i = 0; i < s.length(); i++) {
                int idx = s.charAt(i) - 'a';
                prefix[i + 1] = prefix[i] ^ (1 << idx);
            }

            List<Boolean> ans = new ArrayList<>();
            for (int[] query : queries) {
                int pre = prefix[query[1] + 1] ^ prefix[query[0]];
                int cnt = 0;
                while (pre != 0) {
                    cnt += (pre & 1);
                    pre >>>= 1;
                }
                ans.add(cnt / 2 <= query[2]);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canMakePaliQueries("abcda", new int[][]{{3, 3, 0}, {0, 3, 2}, {0, 4, 1}}));
    }
}
