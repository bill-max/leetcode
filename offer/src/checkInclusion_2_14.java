import java.util.HashMap;
import java.util.Map;

public class checkInclusion_2_14 {
    static class Solution {
        public boolean checkInclusion(String s1, String s2) {
            int n = s1.length(), m = s2.length();
            if (n > m) {
                return false;
            }
            int[] cnt = new int[26];
            for (int i = 0; i < n; ++i) {
                --cnt[s1.charAt(i) - 'a'];
            }
            int l = 0;
            for (int r = 0; r < m; ++r) {
                int x = s2.charAt(r) - 'a';
                ++cnt[x];
                while (cnt[x] > 0) {
                    --cnt[s2.charAt(l) - 'a'];
                    l++;
                }
                if (r - l + 1 == n) {
                    return true;
                }
            }
            return false;
        }
    }
}
