import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindLongestSubarray_17_05 {
    static class Solution {
        public String[] findLongestSubarray(String[] array) {
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, -1);
            int count = 0;
            int idx = 0;
            int maxLen = 0;
            int ans = 0;
            for (int i = 0; i < array.length; i++) {
                if (Character.isLetter(array[i].charAt(0))) {
                    count++;
                } else {
                    count--;
                }
                if (map.containsKey(count)) {
                    idx = map.get(count);
                    if (i - idx  > maxLen) {
                        ans = idx + 1;
                        maxLen = i - idx;
                    }
                } else {
                    map.put(count, i);
                }
            }
            if (maxLen == 0) {
                return new String[0];
            }
            String[] res = new String[maxLen];
            System.arraycopy(array, ans, res, 0, maxLen);
            return res;
        }
    }
}
