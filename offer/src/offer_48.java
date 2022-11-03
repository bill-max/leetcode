import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class offer_48 {
    static class Solution {
        /**
         * 滑动窗口  ==>  双指针 + 线性遍历
         * a b c d b
         *
         * @param s
         * @return
         */
        public int lengthOfLongestSubstring(String s) {
            if (s.length() <= 1) return s.length();
            Map<Character, Integer> map = new HashMap<>(){{put(s.charAt(0), 0);}};
            int i = 0;
            int j = 1;
            int ans = 1;
            while (j < s.length()) {
                if (!map.containsKey(s.charAt(j))) {
                    map.put(s.charAt(j), j);
                    ans = Math.max(ans, j - i + 1);
                    j++;
                } else {
                    int idx = map.get(s.charAt(j));
                    while (i < idx) {
                        map.remove(s.charAt(i));
                        i++;
                    }
                    map.put(s.charAt(j), j);
                    i++;
                    j++;
                }

            }
            return ans;
        }

        /**
         * 优化
         * @param s
         * @return
         */
        public int lengthOfLongestSubstring2(String s) {
            Map<Character, Integer> dic = new HashMap<>();
            int i = -1, res = 0;
            for(int j = 0; j < s.length(); j++) {
                if(dic.containsKey(s.charAt(j)))
                    i = Math.max(i, dic.get(s.charAt(j))); // 更新左指针 i
                dic.put(s.charAt(j), j); // 哈希表记录
                res = Math.max(res, j - i); // 更新结果
            }
            return res;
        }

    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("abcabcbb"));
    }
}
