import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class groupAnagrams_2_33 {
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            List<List<String>> ans = new ArrayList<>();
            int[] vis = new int[strs.length];

            for (int i = 0; i < strs.length; i++) {
                if (vis[i] == 1) continue;

                List<String> res = new ArrayList<>();
                res.add(strs[i]);
                vis[i] = 1;
                for (int j = i + 1; j < strs.length; j++) {
                    if (vis[j] == 0 && isAnagrams(strs[j], strs[i])) {
                        res.add(strs[j]);
                        vis[j] = 1;
                    }
                }
                ans.add(res);
            }
            return ans;
        }

        private boolean isAnagrams(String str, String str2) {
            if (str.length() != str2.length()) return false;
            Map<Character, Integer> map = new HashMap<>();
            for (char c : str2.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }

            for (char ch : str.toCharArray()) {
                if (map.getOrDefault(ch, 0) <= 0) {
                    return false;
                }
                map.put(ch, map.get(ch) - 1);
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution solution = new groupAnagrams_2_33().new Solution();
        String[] strs = {"ac", "c"};
        System.out.println(solution.groupAnagrams(strs));
    }
}
