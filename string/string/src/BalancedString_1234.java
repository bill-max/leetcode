import java.util.ArrayList;
import java.util.List;

public class BalancedString_1234 {
    static class Solution {
        public int balancedString(String s) {
            int[] cnt = new int[26];
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                cnt[idx(c)]++;
            }

            int partial = s.length() / 4;
            int res = s.length();

            if (check(cnt, partial)) {
                return 0;
            }
            //枚举左端点
            for (int l = 0, r = 0; l < s.length(); l++) {
                while (r < s.length() && !check(cnt, partial)) {
                    cnt[idx(s.charAt(r))]--;
                    r++;
                }
                if (!check(cnt, partial)) {
                    break;
                }
                res = Math.min(res, r - l);
                cnt[idx(s.charAt(l))]++;
            }
            return res;
        }

        public int idx(char c) {
            return c - 'A';
        }

        /**
         * 判断是否满足平衡  true=>满足
         */
        public boolean check(int[] cnt, int partial) {
            if (cnt[idx('Q')] > partial || cnt[idx('W')] > partial || cnt[idx('E')] > partial || cnt[idx('R')] > partial) {
                return false;
            }
            return true;
        }
    }


    public static void main(String[] args) {

    }
}
