import java.util.HashMap;
import java.util.Map;

public class lengthOfLongestSubstring {
    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            Map<Character, Integer> map = new HashMap<>();
            int ans = 0;
            int left = 0;
            for (int i = 0; i < s.length(); i++) {
                if (map.containsKey(s.charAt(i))) {
                    left = Math.max(left, map.get(s.charAt(i)) + 1);
                }
                map.put(s.charAt(i), i);
                ans = Math.max(ans, i - left + 1);
            }
            return ans;
        }
    }
}
