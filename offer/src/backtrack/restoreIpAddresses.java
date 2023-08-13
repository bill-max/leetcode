package backtrack;

import java.util.ArrayList;
import java.util.List;

public class restoreIpAddresses {
    static class Solution {
        List<List<String>> ans = new ArrayList<>();

        public List<String> restoreIpAddresses(String s) {
            List<String> list = new ArrayList<>();
            dfs(s, 0, list);
            return ans.stream().map(str -> {
                StringBuilder sb = new StringBuilder();
                str.forEach(s1 -> sb.append(s1).append("."));
                return sb.substring(0, sb.length() - 1);
            }).toList();
        }

        private void dfs(String s, int cur, List<String> list) {
            if (list.size() == 4 && cur != s.length()) return;
            if (cur == s.length() && list.size() == 4) {
                ans.add(new ArrayList<>(list));
                return;
            }
            for (int i = cur; i < Math.min(cur + 3, s.length()); i++) {
                int num = Integer.parseInt(s.substring(cur, i + 1));
                if (num > 255 || num < 10 && i + 1 - cur != 1)
                    break;
                list.add(s.substring(cur, i + 1));
                dfs(s, i + 1, list);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().restoreIpAddresses("010010"));
    }
}
